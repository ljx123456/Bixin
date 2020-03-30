package com.example.shadow.heartrecreation.ui.meassage.fragment

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.ui.layoutUtils
import com.example.shadow.heartrecreation.ui.meassage.activity.MeassageActivity
import com.example.shadow.heartrecreation.ui.meassage.adapter.NotificationAdapter
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.NotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReadNotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.NotificationBody
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.ReadNotificationBody
import com.example.shadow.heartrecreation.ui.meassage.mvp.presenter.NotificationPresenter
import com.example.shadow.heartrecreation.ui.meassage.mvp.view.NotificationView
import com.example.shadow.heartrecreation.ui.meassage.utils.intentUtils
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentComplaintDetails
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentOrderDetils
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentDiscount
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRefundMerchant
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRefundServe
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentWine
import kotlinx.android.synthetic.main.fragment_notification.*
import kotlinx.android.synthetic.main.layout_error_network.*


class NotificationFragment : BaseFragment(), NotificationView {
    override fun getReadRequest(data: ReadNotificationBean) {
        notiAdapter.data[position].isRead=1
        notiAdapter.notifyDataSetChanged()
    }

    override fun getNotificationRequest(data: NotificationBean) {
        try {
            dismiss()
        }catch (e:Exception){
            e.printStackTrace()
        }
        errorLayout.visibility = View.GONE
        notiRefresh.visibility=View.VISIBLE
        notiRefresh.isRefreshing = false

        if (isFresh){
            try {
                (activity!! as MeassageActivity).init()
            }catch (e:Exception){
                e.printStackTrace()
            }
            isFresh=false
        }
        if (pageIndex == 1) {
            notiAdapter = NotificationAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            notiList.layoutManager = manager
            notiList.adapter = notiAdapter
            notiAdapter.setEmptyView(layoutUtils.getNotiNull())
        } else {
            notiAdapter.addData(data.data)
        }

        notiAdapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex+1
                presenter.getNotification(NotificationBody(pageIndex, pageSize))
            }
        },notiList)
//        Log.e("测试通知","${data.data.size}")
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                notiAdapter.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                notiAdapter.loadMoreComplete()
            }
        }else{
            notiAdapter.loadMoreComplete()
        }
        notiAdapter.setOnItemClickListener { adapter, view, position ->
            this.position=position
            var info = notiAdapter.data.get(position)
            /**退款详情
             *   0 -> intentRefundMerchant(refundadapter.data.get(position).refundId)
            else -> intentRefundServe(refundadapter.data.get(position).refundId)
             */
            if (info.isRead==0){
                presenter.read(ReadNotificationBody(info.id))
            }
//            消息类型：0 订单，1 评价，2 退款，3 优惠券，4 存取酒，5 服务，6 服务投诉，7 举报，8 建议，9 系统通知/活动
            when (info.type) {
                0 -> intentOrderDetils(info.orderNo)
                1 -> intentOrderDetils(info.orderNo)
                2 -> {
                    if (info.refundType==0){
                        intentRefundMerchant(info.refundId)
                    }else{
                        intentRefundServe(info.refundId)
                    }
                }
                3 -> intentDiscount()
                4 -> intentWine()
                5 -> intentOrderDetils(info.orderNo)
                6-> intentComplaintDetails(info.complaintsId)

                7->{
                    intentUtils.intentReportDetails(info.reportId)
                }

                8-> intentUtils.intentFeedBackDetails(info.feedbackId)

                9-> intentUtils.intentActivity(info.messageId,info.messageType)
            }
        }
    }

    override fun getNotificationError() {
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
        notiRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        notiRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            pageIndex = 1
            show()
            presenter.getNotification(NotificationBody(pageIndex, pageSize))
        }
    }

    override fun openEventBus(): Boolean = false
    private lateinit var notiAdapter: NotificationAdapter
    private val presenter by lazy { NotificationPresenter(this, this, activity!!) }
    private var pageIndex: Int = 1
    private var pageSize: Int = 10
    private var position=0
    private var isFresh=false

    override fun setLayoutTitle() {
    }

    override fun initFragmentData() {
        notiRefresh.isRefreshing = false
        show()
        presenter.getNotification(NotificationBody(pageIndex, pageSize))
    }

    override fun setFragmentListener() {
        notiRefresh.setOnRefreshListener {
            isFresh=true
            pageIndex = 1
            presenter.getNotification(NotificationBody(pageIndex, pageSize))
        }
    }

    override fun layoutID(): Int = R.layout.fragment_notification

    fun init(){
        notiAdapter.setNewData(null)
    }
}