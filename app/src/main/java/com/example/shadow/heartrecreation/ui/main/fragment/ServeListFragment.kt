package com.example.shadow.heartrecreation.ui.main.fragment

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.AppProject
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.OrderServeUtils.setOrder
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getCityID
import com.example.shadow.heartrecreation.db.user.getType
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.db.user.getlat
import com.example.shadow.heartrecreation.db.user.getlng
import com.example.shadow.heartrecreation.ui.main.adapter.ServeListAdapter
import com.example.shadow.heartrecreation.ui.main.dialog.AddsListSelectDialog
//import com.example.shadow.heartrecreation.ui.main.dialog.ServeYueDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeListBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.ServeListPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.ServeListView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentServeDetails
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_serve_list.*
import kotlinx.android.synthetic.main.layout_error_network.*
//import com.squareup.leakcanary.RefWatcher



@SuppressLint("ValidFragment")
class ServeListFragment(val it: String, val servelist: ServeList) : BaseFragment(), ServeListView,AddsListSelectDialog.AddsListSelect,ServeListAdapter.ClickBack {
    override fun click(userId:Int) {
        intentServeDetails(userId, businessId, ids)
    }

    override fun dialog() {
        activity!!.finish()
    }

    //    private val serveYueDialog = ServeYueDialog()
    private val addsselectdialog = AddsListSelectDialog(this)
    private val lng = user.getlng()
    private val lat = user.getlat()
    private var useID=""
    //获取列表成功
    override fun getServeListRequest(data: ServeListBean) {
        errorLayout.visibility = View.GONE
        serveRefresh.isRefreshing = false
        serveRefresh.visibility=View.VISIBLE
        if (pageIndex == 1) {
            if(serveListAdapter!=null){
                serveListAdapter!!.setNewData(data.data)
            }else {
                serveListAdapter = ServeListAdapter(data.data)
                var manager = LinearLayoutManager(mContext)
                manager.orientation = LinearLayout.VERTICAL
                serveList.layoutManager = manager
                serveList.adapter = serveListAdapter
                serveListAdapter!!.setCallBack(this)
//                serveListAdapter!!.notifyDataSetChanged()
            }
        } else {
            serveListAdapter!!.addData(data.data)
        }
//        Handler().postDelayed()


        serveListAdapter!!.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getServeList(ServeListBody(sort, token,  age, state, sex, occupations, businessId, pageIndex, pageSize, "${ids}", cityId, lat, lng))
            }
        }, serveList)

        if (serveListAdapter != null) {
//            serveListAdapter!!.disableLoadMoreIfNotFullPage()
            serveListAdapter!!.setPreLoadNumber(2)
        }

        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                serveListAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                serveListAdapter!!.loadMoreComplete()
            }
        }else{
            serveListAdapter!!.loadMoreComplete()
        }
        serveListAdapter!!.setOnItemClickListener { adapter, view, position ->
            intentServeDetails(serveListAdapter!!.data.get(position).userId, businessId, ids)
        }
        serveListAdapter!!.setOnItemChildClickListener { adapter, view, position ->
            var data = serveListAdapter!!.data.get(position)
            when (view.id) {
                R.id.yue -> {
                    //在线才可以点
                    if (data.isOnline == 1) {
                        //是否在黑名单  1不在
//                        if (data.is==1) {
                            if (data.isInOrder == 0) {
//                                var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//                                if (merchat != null && merchat.loadAll() != null && merchat.loadAll().size > 0) {
//                                    setOrder(OrderServeDB(null, "${data.userId}", data.nickname, data.avatar))
                                    ServeUtils.setServe(ServePersonnelDB(null, "${data.userId}", data.nickname, data.avatar,
                                            "${data.skillPrice}", "", "", "${data.age}", "${data.sex}", data.km, data.occupationName))
                                    servelist.setHaveSere()
//                                    if (ServeUtils.getServeData()[ServeUtils.getServeData().lastIndex].serveID=="${data.userId}"){
//                                        Toast.Tips("添加成功")
//                                    }

//                                } else {
//                                    setAddData(data)
//                                }
                            }else{
                                Toast.Tips("接单中")
                            }
//                        }else{
//                            Toast.Tips("繁忙中")
//                        }
                    }else{
                        Toast.Tips("不在线")
                    }
                    serveListAdapter!!.notifyDataSetChanged()
                }

//                R.id.brokerList->{
//                    Log.e("测试","点击了列表")
//                    intentServeDetails(serveListAdapter!!.data.get(position).userId, businessId, ids)
//                }
            }

        }
        try {
//            dismissLoading(mContext!!)
            dismiss()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun setAddData(data: ServeListBean.DataBean) {
        if (data.businessInfo != null && data.businessInfo.size > 0) {
            try {
                addsselectdialog.setAddsData(data)
                if (addsselectdialog.isAdded){

                }else {
                    addsselectdialog.show(activity!!.supportFragmentManager, "")
                }
            }catch (e:Exception){
                e.printStackTrace()
            }

        }else{
            Toast.Tips("该达人未开启商家服务，请邀约其他达人")
        }
//        else {
//            ShowDialog.showCustomDialog(activity, "提示", "请先设置约玩地址", "取消", "去设置", object : DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface, which: Int) {
//
//                }
//            })
//        }
    }

    //获取列表失败
    override fun getServeListError() {
        try {
//            dismissLoading(mContext!!)
//            Log.e("点击","dismiss了")
            var h=Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismiss()
                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        serveRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        serveRefresh.visibility=View.GONE
//        Click.viewClick(anewClick).subscribe {
//            //            showLoading(mContext!!)
//            show()
//            var h=Handler()
//            h.postDelayed(object :Runnable{
//                override fun run() {
//                    dismiss()
//                    h.removeCallbacksAndMessages(null)
//                }
//
//            },1000)
//            pageIndex = 1
//            presenter.getServeList(ServeListBody(sort, token,  age, state, sex, occupations, businessId, pageIndex, pageSize, "${ids}", cityId, lat, lng))
//        }
    }

    private var sort = 1
    private val token = getUserToken()
//    private var height = "140cm-200cm"//身高
    private var age = "0-100"//年龄
    private var sex = 0//性别
    private var state = 0//状态
    private var occupations = ""//职业
    private var businessId = "" //商家
    private var pageIndex = 1
    private val pageSize = 30
    private val cityId = getCityID()
    private val presenter by lazy { ServeListPresenter(this, this, activity!!) }
    private var serveListAdapter: ServeListAdapter? = null
    private var ids = 0
    private var isCreate=false

    fun setScreen(sort:Int,height: String, age: String, sex: Int, state: Int, occupations: String) {
//        this.height = height
        this.age = age
        this.sex = sex
        this.state = state
        this.occupations = occupations
        this.sort=sort
        pageIndex = 1
        presenter.getServeList(ServeListBody(sort, token,  age, state, sex, occupations, businessId, pageIndex, pageSize, "${ids}", cityId, lat, lng))
    }

    fun setID(id: Int) {
        this.ids = id
    }

    fun setBusinessId(businessID:String){
        this.businessId=businessID
    }

    override fun openEventBus(): Boolean = false
    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {
//        showLoading(mContext!!)
        show()
        init()
    }

    override fun setFragmentListener() {
        serveRefresh.setOnRefreshListener {
            pageIndex = 1
            presenter.getServeList(ServeListBody(sort, token,  age, state, sex, occupations, businessId, pageIndex, pageSize, "${ids}", cityId, lat, lng))
        }

        Click.viewClick(anewClick).subscribe {
//            showLoading(mContext!!)
            Log.e("点击","点击了")
            show()

            pageIndex = 1
            presenter.getServeList(ServeListBody(sort, token,  age, state, sex, occupations, businessId, pageIndex, pageSize, "${ids}", cityId, lat, lng))
        }
    }

    override fun layoutID(): Int = R.layout.fragment_serve_list


    interface ServeList {
        fun setHaveSere()
    }

    public fun init(){

        when (it) {
            "距离最近" -> sort = 1
//            "评分最高" -> sort = 2
            "附近的人"->sort=1
            "我的关注" -> sort = 3
        }

//        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//        if (merchat != null) {
//            if (merchat.loadAll() != null && merchat.loadAll().size > 0) {
//                businessId = merchat.loadAll().get(0).merchantID
//            } else {
////                if (sort == 1) {
////                    sort = 2
////                }
//            }
//        }

//        else {
//            if (sort == 1) {
//                sort = 2
//            }
//        }
        if ("1".equals(getType())) {

        } else {
//            businessId = ids.toString()
            ids = 1
        }
        var data = ServeListBody(sort, token,  age, state, sex, occupations, businessId, pageIndex, pageSize, "${ids}", cityId, lat, lng)
        LogUtils.a("数据" + Gson().toJson(data))
        presenter.getServeList(ServeListBody(sort, token,  age, state, sex, occupations, businessId, pageIndex, pageSize, "${ids}", cityId, lat, lng))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCreate=true
    }

    override fun onResume() {
        super.onResume()
        updata()
    }

    public fun updata(){
        if (serveListAdapter!=null){
            serveListAdapter!!.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

//        val refWatcher = AppProject.getRefWatcher(context!!)
//        refWatcher.watch(this)
        GlideCacheUtil.getInstance().clearImageAllCache(context!!)//清除图片所有缓存
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden){
            GlideCacheUtil.getInstance().clearImageAllCache(context!!)//清除图片所有缓存
        }
    }



//    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
//        super.setUserVisibleHint(isVisibleToUser)
//
//        if (!isCreate){
//            return
//        }
//
//        if (isVisibleToUser){
//            init()
//        }
//    }
}