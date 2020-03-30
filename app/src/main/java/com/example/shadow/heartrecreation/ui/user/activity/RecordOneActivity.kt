package com.example.shadow.heartrecreation.ui.user.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.user.adapter.RecordAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.StorageRecordBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.StorageRecordBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.RecordOnePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.RecordOneView
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_record_one.*
import kotlinx.android.synthetic.main.layout_title.*

class RecordOneActivity : BaseActivity(), RecordOneView {
    override fun getStorageRecordRequest(data: StorageRecordBean) {
        dismissLoading()
        oneRefresh.isRefreshing = false
        if (pageIndex == 1) {
            recordAdapter = RecordAdapter(data.data)
            var manager = LinearLayoutManager(this)
            manager.orientation = LinearLayout.VERTICAL
            oneList.adapter = recordAdapter
            oneList.layoutManager = manager
        } else {
            recordAdapter.addData(data.data)
        }
        recordAdapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                when (type) {
                    1 -> presenter.getStorageRecord(StorageRecordBody(getUserToken(), businessId, 10, pageIndex))
                    2 -> presenter.getTakeRecord(StorageRecordBody(getUserToken(), businessId, 10, pageIndex))
                }
            }
        }, oneList)
//        if (recordAdapter != null) {
//            recordAdapter!!.disableLoadMoreIfNotFullPage()
//            recordAdapter!!.setPreLoadNumber(2)
//        }
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                recordAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                recordAdapter!!.loadMoreComplete()
            }
        }else{
            recordAdapter!!.loadMoreComplete()
        }

        recordAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.oneLayout -> {
                    recordAdapter.data.forEachIndexed { index, dataBean ->
                        if (index == position) {
                            dataBean.isExpanded = true
                        } else {
                            dataBean.isExpanded = false
                        }
                    }
                }
            }
            recordAdapter.notifyDataSetChanged()
        }
    }

    override fun getStorageRecordError() {
        dismissLoading()
        oneRefresh.isRefreshing = false
    }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_record_one
    private var businessId = 0
    private var type = 0
    private var pageIndex = 1
    private lateinit var recordAdapter: RecordAdapter
    private val presenter by lazy { RecordOnePresenter(this, this, this) }
    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        oneRefresh.isRefreshing = true
        businessId = intent.getIntExtra("businessId", 0)
        type = intent.getIntExtra("type", 0)
        showLoading()
        when (type) {
            1 -> {
                titleText.text = "存酒记录"
                presenter.getStorageRecord(StorageRecordBody(getUserToken(), businessId, 10, pageIndex))
            }
            2 -> {
                titleText.text = "取酒记录"
                presenter.getTakeRecord(StorageRecordBody(getUserToken(), businessId, 10, pageIndex))
            }
        }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        oneRefresh.setOnRefreshListener {
            pageIndex = 1
            when (type) {
                1 -> presenter.getStorageRecord(StorageRecordBody(getUserToken(), businessId, 10, pageIndex))
                2 -> presenter.getTakeRecord(StorageRecordBody(getUserToken(), businessId, 10, pageIndex))
            }
        }
    }
}