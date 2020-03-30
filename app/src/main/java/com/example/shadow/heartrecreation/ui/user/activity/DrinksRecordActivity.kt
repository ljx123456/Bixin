package com.example.shadow.heartrecreation.ui.user.activity

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.layoutUtils
import com.example.shadow.heartrecreation.ui.user.adapter.DrinksRecordOneAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.TakeRecordListBean
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.DrinksRecordPresnter
import com.example.shadow.heartrecreation.ui.user.mvp.view.DrinksRecordView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRecordDetails
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRecordDetailsOne
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_drinks_record.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class DrinksRecordActivity : BaseActivity(), DrinksRecordView {
    //取酒列表
    override fun getTakeRecordListRequest(data: TakeRecordListBean) {
        dismissLoading()
        drinksRecordRefresh.isRefreshing = false
        drinksRecordRefresh.visibility=View.VISIBLE
        errorLayout.visibility = View.GONE
        if (pageIndex == 1) {
            oneAdapter = DrinksRecordOneAdapter(type,data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            drinksRecordList.layoutManager = manager
            drinksRecordList.adapter = oneAdapter
            oneAdapter.setEmptyView(layoutUtils.getWineNull())
        } else {
            oneAdapter.addData(data.data)
        }

        oneAdapter!!.setOnItemClickListener { adapter, view, position ->
            when (type) {
                1 -> intentRecordDetailsOne(type, oneAdapter!!.data.get(position).userStorageWineId)
                2 -> intentRecordDetailsOne(type, oneAdapter!!.data.get(position).userTakeWineId)
                3 -> intentRecordDetails(oneAdapter!!.data.get(position).userExpireWineId)
            }
        }

        oneAdapter!!.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getTakeRecordList(pageIndex)
            }
        }, drinksRecordList)

//        if (oneAdapter != null) {
//            oneAdapter!!.disableLoadMoreIfNotFullPage()
//            oneAdapter!!.setPreLoadNumber(2)
//        }
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                oneAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                oneAdapter!!.loadMoreComplete()
            }
        }else{
            oneAdapter!!.loadMoreComplete()
        }
    }

    //获取数据失败
    override fun DrinksRecordError() {
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
        drinksRecordRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        drinksRecordRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            when (type) {
                1 -> presenter.getTakeRecordList(pageIndex)
                2 -> presenter.getRecordList(pageIndex)
                3 -> presenter.getExpireRecordList(pageIndex)
            }
        }
    }

    override fun openEventBus(): Boolean = false
    private lateinit var oneAdapter: DrinksRecordOneAdapter
    private val presenter by lazy { DrinksRecordPresnter(this, this, this) }
    private var type = 0
    private var pageIndex = 1
    override fun getActivityLayout(): Int = R.layout.activity_drinks_record

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
        type = intent.getIntExtra("type", 0)
        showLoading()
        when (type) {
            1 -> {
                titleText.text = "存酒记录"
                presenter.getTakeRecordList(pageIndex)
            }
            2 -> {
                titleText.text = "取酒记录"
                presenter.getRecordList(pageIndex)
            }
            3 -> {
                titleText.text = "过期记录"
                presenter.getExpireRecordList(pageIndex)
            }
        }
        drinksRecordRefresh.isRefreshing = false
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        drinksRecordRefresh.setOnRefreshListener {
            pageIndex = 1
            when (type) {
                1 -> presenter.getTakeRecordList(pageIndex)
                2 -> presenter.getRecordList(pageIndex)
                3 -> presenter.getExpireRecordList(pageIndex)
            }
        }
    }
}