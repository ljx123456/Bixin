package com.example.shadow.heartrecreation.ui.main.activity

import android.content.ComponentCallbacks2
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
//import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.OrderServeUtils.deleteAllOrder
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getOrderID
import com.example.shadow.heartrecreation.db.user.getType
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.dialog.ScreenDialog
import com.example.shadow.heartrecreation.ui.main.dialog.ServeListDialog
import com.example.shadow.heartrecreation.ui.main.fragment.ServeListFragment
import com.example.shadow.heartrecreation.ui.main.pop.PopupWindowHelper
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMain
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentServeListSearch
import com.example.shadow.heartrecreation.ui.order.mvp.bean.MoreInviteBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.MoreInviteBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.MoreInvitePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.MoreInviteView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOrder
import com.example.shadow.heartrecreation.utils.dialog.ServeTimeDialog
import com.example.shadow.heartrecreation.utils.utils.DataCleanManager
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import com.myproject.myproject.material_design.tablayout.FragmentAdapter
import kotlinx.android.synthetic.main.activity_serve_list.*

class ServeListActivity : BaseActivity(), ScreenDialog.Screen, ServeListDialog.ServeList, ServeListFragment.ServeList, MoreInviteView {

    override fun setServeOver() {
        haveServe()
        if (fragments!=null&&fragments.size>0) {
            (fragments[serveListPager.currentItem] as ServeListFragment).updata()
        }
    }

    override fun getMoreInviteRequest(data: MoreInviteBean) {
        finish()
        user.setNum("0")
    }

    override fun setServeGoYue() {
        if ("1".equals(getType())) {
            finish()
        } else {
            var serveData = ServeUtils.getServeData()
            if (serveData != null && serveData.size >= 1 && serveData.get(0).image != null) {
                var serveList = ArrayList<MoreInviteBody.ServiceUsersBean>()
                serveData.forEachIndexed { index, servePersonnelDB ->
                    serveList.add(MoreInviteBody.ServiceUsersBean(servePersonnelDB.serveID, "1"))
                }
                LogUtils.a(Gson().toJson(serveData))
                serveNum.text = "${serveData.size}"
                moreInvite.getMoreInvite(MoreInviteBody(getOrderID(), "${user.getNum().toInt()/2}", serveList))
            } else {
                Toast.Tips("请选择需要添加的达人")
            }
        }
    }

    override fun setScreenData(sex: Int, selectedItemText: String, age: String, join: String, state: Int) {
        var sort=1
        when (titles[serveListTab.selectedTabPosition]){
            "距离最近"->sort=1
            "附近的人"->sort=1
            "我的关注"->sort=3
        }
        if (fragments!=null&&fragments.size>0) {
            (fragments[serveListTab.selectedTabPosition ] as ServeListFragment).setScreen(sort,selectedItemText, age, sex, state, join)
        }
    }

    private val servelistdialog = ServeListDialog(this)

    private var mFragmentAdapter: FragmentAdapter? = null
    private var screenDialog = ScreenDialog(this)
    private var fragments = ArrayList<Fragment>()
    private var titles = ArrayList<String>()
    private var servelistfragment: ServeListFragment? = null
    private lateinit var pop: PopupWindowHelper
    private lateinit var popView: View
    private var id = 0//类型ID
    private var businessID=""//商家id
    private val moreInvite by lazy { MoreInvitePresenter(this, this, this) }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_serve_list

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        id = intent.getIntExtra("id", 1)
        if (intent.getStringExtra("businessID")!=null&&!intent.getStringExtra("businessID").equals("")&&!intent.getStringExtra("businessID").equals("-1")) {
            businessID = intent.getStringExtra("businessID")
        }
        LogUtils.a("businessID:"+businessID)
        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
        if (merchat != null) {
            if (merchat.loadAll() != null && merchat.loadAll().size > 0) {
                titles.add("距离最近")
                serveListHint.visibility=View.VISIBLE
            } else {
                titles.add("附近的人")
                serveListHint.visibility=View.GONE
            }
        } else {
            titles.add("附近的人")
            serveListHint.visibility=View.GONE
        }
//        titles.add("距离最近")
//        titles.add("评分最高")
        titles.add("我的关注")



        titles.forEach {
            serveListTab.addTab(serveListTab.newTab().setText(it))
            servelistfragment = ServeListFragment(it, this)
            servelistfragment!!.setID(id)
            if (!businessID.equals("-1")||!businessID.equals("")){
                servelistfragment!!.setBusinessId(businessID)
            }
            fragments.add(servelistfragment!!)
        }
        mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
        serveListPager.adapter = mFragmentAdapter
        serveListTab.setupWithViewPager(serveListPager)
        serveListTab.setTabsFromPagerAdapter(mFragmentAdapter)
        serveListPager.setOffscreenPageLimit(1)
        popView = LayoutInflater.from(mContext).inflate(R.layout.pop_servelist, null)
        pop = PopupWindowHelper(popView)
        val timeDialog=ServeTimeDialog(this)
        timeDialog.showDialog()
    }

    //有服务人员
    fun haveServe() {
        var serveData = ServeUtils.getServeData()
        if (serveData != null && serveData.size >= 1 && serveData.get(0).image != null) {
            serveNum.text = "${serveData.size}"
            if ("1".equals(getType())) {
//                dasngqianshuju.text = "已邀请${serveData.size}人，还可邀请${user.getNum().toInt() - serveData.size}人"
                dasngqianshuju.text = "已邀请${serveData.size}人"
                serveNum.text = "${serveData.size}"
            } else {
                dasngqianshuju.text = "已邀请${serveData.size}人"
                serveNum.text = "${serveData.size}"
            }
        } else {
            if ("1".equals(getType())) {
                dasngqianshuju.text = "已邀请${0}人"
                serveNum.text = "${0}"
            } else {
                dasngqianshuju.text = "已邀请${0}人"
                serveNum.text = "${0}"
            }
        }
    }

    override fun onResume() {
        super.onResume()
        haveServe()
        if (fragments!=null&&fragments.size>0) {
            (fragments[serveListPager.currentItem] as ServeListFragment).updata()
        }
    }

    override fun setHaveSere() {
        haveServe()
    }


    override fun clickListener() {
        Click.viewClick(serveListHint).subscribe { serveListHint.visibility = View.GONE }
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(serveListGo).subscribe {
            if ("1".equals(getType())) {
                finish()
            } else {
                var serveData = ServeUtils.getServeData()
                if (serveData != null && serveData.size >= 1 && serveData.get(0).image != null) {
                    var serveList = ArrayList<MoreInviteBody.ServiceUsersBean>()
                    serveData.forEachIndexed { index, servePersonnelDB ->
                        serveList.add(MoreInviteBody.ServiceUsersBean(servePersonnelDB.serveID, "1"))
                    }
                    LogUtils.a(Gson().toJson(serveData))
                    serveNum.text = "${serveData.size}"
                    moreInvite.getMoreInvite(MoreInviteBody(getOrderID(), "${serveData.size}", serveList))
                } else {
                    Toast.Tips("请选择需要添加的达人")
                }

            }
        }
        Click.viewClick(serveListScreen).subscribe {
            if (screenDialog.isAdded){
                screenDialog.dismiss()
            }else {
                screenDialog.show(supportFragmentManager, "")
            }
        }
//        Handler().postDelayed({
//            serveListHint.visibility = View.GONE
//        }, 3000)

        Click.viewClick(imageview).subscribe {
            servelistdialog.show(supportFragmentManager, "")
        }

        //右上角更多
        Click.viewClick(titleMone).subscribe {
            pop.showAsDropDown(titleMone, 0, 0)
        }
        //右上角搜索
        Click.viewClick(titleRight).subscribe { intentServeListSearch(id) }
        //返回首页
        Click.viewClick(popView.findViewById(R.id.goHome)).subscribe {
            pop.dismiss()
            intentMain()
            ActivityUtils.finishAllActivities()
        }
        //消息中心
        Click.viewClick(popView.findViewById(R.id.goMessage)).subscribe {

        }
        //订单中心
        Click.viewClick(popView.findViewById(R.id.goOrder)).subscribe {
            pop.dismiss()
            intentOrder()
        }
        //分享
        Click.viewClick(popView.findViewById(R.id.goShare)).subscribe {
            Toast.Tips("分享")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if ("1".equals(getType())) {

        } else {
            ServeUtils.deleteALLServe()//删除所有服务人员
            deleteAllOrder()
        }
//        servelistdialog.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
    }

    override fun finish() {
        super.finish()
        Log.e("测试","finish了")
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level== TRIM_MEMORY_RUNNING_LOW){
            GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
        }
        if (level== ComponentCallbacks2.TRIM_MEMORY_BACKGROUND){
            GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
            DataCleanManager.cleanInternalCache(mContext)//清除本应用内部缓存
        }
    }
}