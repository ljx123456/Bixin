package com.example.shadow.heartrecreation.ui.user.activity

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.layoutUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.BlackChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.BlackChangePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.BlackChangeView
import com.example.shadow.heartrecreation.ui.user.adapter.BlackListAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BlackListBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BlackListBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.BlackListPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.BlackListView
import kotlinx.android.synthetic.main.activity_black_list.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class BlackListActivity : BaseActivity(), BlackListView, BlackChangeView {
    override fun getBlackChangeRequest() {
        pageIndex = 1
        presenter.getBlackList(BlackListBody(token, lng, lat, pageIndex, pageSize))
    }

    override fun getBlackChangeError() {
        pageIndex = 1
        presenter.getBlackList(BlackListBody(token, lng, lat, pageIndex, pageSize))
    }

    override fun getBlackListRequest(data: BlackListBean) {
        dismissLoading()
        errorLayout.visibility = View.GONE
        black_list_refesh.isRefreshing = false
        if (pageIndex == 1) {
            blackListAdapter = BlackListAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayoutManager.VERTICAL
            black_list.layoutManager = manager
            black_list.adapter = blackListAdapter
            blackListAdapter.setEmptyView(layoutUtils.getBlackNull())
        } else {
            blackListAdapter!!.addData(data.data)
        }
        blackListAdapter!!.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getBlackList(BlackListBody(token, lng, lat, pageIndex, pageSize))
            }
        }, black_list)
//        if (blackListAdapter != null) {
//            blackListAdapter!!.disableLoadMoreIfNotFullPage()
//            blackListAdapter!!.setPreLoadNumber(2)
//        }
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                blackListAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                blackListAdapter!!.loadMoreComplete()
            }
        }else{
            blackListAdapter!!.loadMoreComplete()
        }
        blackListAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.black_list_btn -> {
                    blackPresenter.getBlackChange(BlackChangeBean(getUserToken(), blackListAdapter.data.get(position).userId))
                }
            }
        }
    }

    override fun getBlackListError() {
        try {
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismissLoading()
//                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        black_list_refesh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            pageIndex = 1
            showLoading()
            presenter.getBlackList(BlackListBody(token, lng, lat, pageIndex, pageSize))
        }
    }

    private lateinit var blackListAdapter: BlackListAdapter
    private val token = user.getUserToken()
    private val lng = user.getlng()
    private val lat = user.getlat()
    private val pageSize = 10
    private var pageIndex = 1

    private val presenter by lazy { BlackListPresenter(this, this, this) }
    private val blackPresenter by lazy { BlackChangePresenter(this, this, this) }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_black_list

    override fun setActivityTitle() {
        titleText.setText("黑名单")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        showLoading()
        presenter.getBlackList(BlackListBody(token, lng, lat, pageIndex, pageSize))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        black_list_refesh.setOnRefreshListener {
            pageIndex = 1
            presenter.getBlackList(BlackListBody(token, lng, lat, pageIndex, pageSize))
        }
    }
}