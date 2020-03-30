package com.example.shadow.heartrecreation.ui.user.fragment

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.db.user.getlat
import com.example.shadow.heartrecreation.db.user.getlng
import com.example.shadow.heartrecreation.ui.layoutUtils
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.user.adapter.AttertionServeAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionServeBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.AttertionServeBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.AttertionServePresnter
import com.example.shadow.heartrecreation.ui.user.mvp.view.AttertionServeView
import kotlinx.android.synthetic.main.fragment_attertion_serve.*
import kotlinx.android.synthetic.main.layout_error_network.*

class AttertionServeFragment : BaseFragment(), AttertionServeView {

    override fun openEventBus(): Boolean = false
    override fun layoutID(): Int = R.layout.fragment_attertion_serve
    private val presenter by lazy { AttertionServePresnter(this, this, activity!!) }
    private val token = getUserToken()
    private val lng = getlng()
    private val lat = getlat()
    private val pageSize = 10
    private var pageIndex = 1
    private lateinit var serveAdapter: AttertionServeAdapter

    override fun setLayoutTitle() {
    }

    override fun initFragmentData() {
        show()
        presenter.getAttertionServe(AttertionServeBody(token, lng, lat, "$pageIndex", "$pageSize"))
    }

    override fun setFragmentListener() {
        serveRefresh.setOnRefreshListener {
            pageIndex = 1
            presenter.getAttertionServe(AttertionServeBody(token, lng, lat, "$pageIndex", "$pageSize"))
        }
    }

    //获取数据成功
    override fun getAttertionServeRequest(data: AttertionServeBean) {
        try {
            dismiss()
        }catch (e:Exception){
            e.printStackTrace()
        }
        serveRefresh.isRefreshing = false
        errorLayout.visibility = View.GONE
        serveRefresh.visibility=View.VISIBLE
        if (pageIndex == 1) {
            serveAdapter = AttertionServeAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            serveList.layoutManager = manager
            serveList.adapter = serveAdapter
            serveAdapter.setEmptyView(layoutUtils.getAttentionNull())
        } else {
            serveAdapter.addData(data.data)
        }
//        serveAdapter.setOnItemClickListener { adapter, view, position ->
//            intentUsils.intentServeDetails(data.data[position].userId,data.data[position].businessId.toString(),user.getYueID().toInt())
//        }

        serveAdapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getAttertionServe(AttertionServeBody(token, lng, lat, "$pageIndex", "$pageSize"))
            }
        }, serveList)
//        if (serveAdapter != null) {
//            serveAdapter.disableLoadMoreIfNotFullPage()
//            serveAdapter.setPreLoadNumber(2)
//        }
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                serveAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                serveAdapter!!.loadMoreComplete()
            }
        }else{
            serveAdapter!!.loadMoreComplete()
        }
    }

    //获取数据失败
    override fun getAttertionServeError() {
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
        serveRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        serveRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            pageIndex = 1
            show()
            presenter.getAttertionServe(AttertionServeBody(token, lng, lat, "$pageIndex", "$pageSize"))
        }
    }
}