package com.example.shadow.heartrecreation.ui.user.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.user.adapter.ExpireAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ExpireRecordBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.ExpireRecordPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.ExpireRecordView
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_expire.*
import kotlinx.android.synthetic.main.layout_title.*

class ExpireActivity : BaseActivity(), ExpireRecordView {

    override fun getExpireRecordRequest(data: ExpireRecordBean) {
        expireRefresh.isRefreshing = false
        if (pageIndex == 1) {
            expireadapter = ExpireAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            expireList.layoutManager = manager
            expireList.adapter = expireadapter
        } else {
            expireadapter.addData(data.data)
        }
        expireadapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getExpireRecord(ExpireRecordBody(getUserToken(), businessId, 10, pageIndex))
            }
        }, expireList)

        if (expireadapter != null) {
            expireadapter!!.disableLoadMoreIfNotFullPage()
            expireadapter!!.setPreLoadNumber(2)
        }
        expireadapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.oneLayout -> {
                    expireadapter.data.forEachIndexed { index, dataBean ->
                        if (index == position) {
                            if (dataBean.isExpanded) {
                                dataBean.isExpanded = false
                            } else {
                                dataBean.isExpanded = true
                            }
                        } else {
                            dataBean.isExpanded = false
                        }
                    }
                }
            }
            expireadapter.notifyDataSetChanged()
        }
    }

    override fun getExpireRecordError() {
        expireRefresh.isRefreshing = false

    }

    override fun openEventBus(): Boolean = false
    private var businessId = 0
    private lateinit var expireadapter: ExpireAdapter
    private val presenter by lazy { ExpireRecordPresenter(this, this, this) }
    override fun getActivityLayout(): Int = R.layout.activity_expire
    private var pageIndex = 1

    override fun setActivityTitle() {
        titleText.text = "过期记录"
        businessId = intent.getIntExtra("businessId", 0)
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        expireRefresh.isRefreshing = false
        presenter.getExpireRecord(ExpireRecordBody(getUserToken(), businessId, 10, pageIndex))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        expireRefresh.setOnRefreshListener {
            pageIndex = 1
            presenter.getExpireRecord(ExpireRecordBody(getUserToken(), businessId, 10, pageIndex))
        }
    }
}