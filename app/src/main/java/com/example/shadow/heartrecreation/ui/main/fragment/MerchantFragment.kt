package com.example.shadow.heartrecreation.ui.main.fragment

import android.annotation.SuppressLint
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.AppProject
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.db.user.getCityID
import com.example.shadow.heartrecreation.db.user.getlat
import com.example.shadow.heartrecreation.db.user.getlng
import com.example.shadow.heartrecreation.ui.layoutUtils
import com.example.shadow.heartrecreation.ui.main.adapter.MerchantAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.MerchantPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.MerchantView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMerchantDetails
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import kotlinx.android.synthetic.main.fragment_merchant.*
import kotlinx.android.synthetic.main.layout_error_network.*

@SuppressLint("ValidFragment")
class MerchantFragment(val it: String) : BaseFragment(), MerchantView {

    private val presenter by lazy { MerchantPresenter(this, this, activity!!) }
    private var pageIndex = 1
    private var pageSize = "10"
    private var type = 0
    private val cityID = getCityID()
    private var merchantAdapter: MerchantAdapter? = null

    override fun layoutID(): Int = R.layout.fragment_merchant

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {
        when (it) {
            "距离最近" -> type = 0
            else -> type = 1
        }
        show()
        presenter.getMerchant(MerchantBody(getlng(), getlat(), type, "${pageIndex}", pageSize, cityID))
    }

    //获取列表成功
    override fun getMerchantRequest(data: MerchantBean) {

        errorLayout.visibility = View.GONE
        merchantRefresh.visibility=View.VISIBLE
        merchantRefresh.isRefreshing = false
        if (pageIndex == 1) {
            if (merchantAdapter!=null){
                merchantAdapter!!.setNewData(data.data)
            }else {
                merchantAdapter = MerchantAdapter(data.data)
                var manager = LinearLayoutManager(mContext)
                manager.orientation = LinearLayout.VERTICAL
                merchantList.layoutManager = manager
                merchantList.adapter = merchantAdapter
            }
        } else {
            merchantAdapter!!.addData(data.data)
        }

        try {
            dismiss()
        }catch (e:Exception){
            e.printStackTrace()
        }
//        getCity()

        merchantAdapter!!.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getMerchant(MerchantBody(getlng(), getlat(), type, "${pageIndex}", pageSize, cityID))
            }
        }, merchantList)

//        if (merchantAdapter != null) {
//            merchantAdapter!!.disableLoadMoreIfNotFullPage()
//            merchantAdapter!!.setPreLoadNumber(1)
//        }

        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                merchantAdapter!!.loadMoreEnd()
//                merchantAdapter!!.addFooterView(layoutUtils.getNoMore())
            }else{
                merchantAdapter!!.loadMoreComplete()
            }
        }else{
            merchantAdapter!!.loadMoreComplete()
        }

        merchantAdapter!!.setOnItemClickListener { adapter, view, position ->
            var businessId = merchantAdapter!!.data.get(position).businessId
            intentMerchantDetails("$businessId",0)
        }

    }

    //获取列表失败
    override fun getMerchantError() {
        try {
            var h= Handler()
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
        merchantRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        merchantRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            pageIndex = 1
            show()
            presenter.getMerchant(MerchantBody(getlng(), getlat(), type, "${pageIndex}", pageSize, cityID))
        }
    }

    override fun setFragmentListener() {
        merchantRefresh.setOnRefreshListener {
            pageIndex = 1
            presenter.getMerchant(MerchantBody(getlng(), getlat(), type, "${pageIndex}", pageSize, cityID))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("测试","销毁了商家")
//        val refWatcher = AppProject.getRefWatcher(context!!)
//        refWatcher.watch(this)
        GlideCacheUtil.getInstance().clearImageAllCache(context!!)//清除图片所有缓存
    }
}