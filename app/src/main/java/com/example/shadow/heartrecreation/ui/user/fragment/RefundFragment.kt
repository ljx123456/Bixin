package com.example.shadow.heartrecreation.ui.user.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.ui.layoutUtils.getLayoutNull
import com.example.shadow.heartrecreation.ui.layoutUtils.orderLayoutNumm
import com.example.shadow.heartrecreation.ui.user.adapter.RefundAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.RefundPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.RefundView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRefundMerchant
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRefundServe
import com.example.shadow.heartrecreation.utils.dialog.showPhoneDialog
//import io.rong.imlib.model.Conversation
import kotlinx.android.synthetic.main.fragment_refund.*
import kotlinx.android.synthetic.main.layout_error_network.*

@SuppressLint("ValidFragment")
class RefundFragment(var it: String) : BaseFragment(), RefundView {

    //获取列表成功
    override fun getRefundRequest(data: RefundBean) {
        try {
            dismiss()
        }catch (e:Exception){
            e.printStackTrace()
        }
        refundRefresh.isRefreshing = false
        errorLayout.visibility = View.GONE
        refundRefresh.visibility=View.VISIBLE
        if (data.data!=null) {
            if (pageIndex == 1) {
                refundadapter = RefundAdapter(data.data)
                var manager = LinearLayoutManager(mContext)
                manager.orientation = LinearLayout.VERTICAL
                refundList.layoutManager = manager
                refundList.adapter = refundadapter
                refundadapter.setEmptyView(getLayoutNull())
            } else {
                refundadapter.addData(data.data)
            }

            refundadapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
                override fun onLoadMoreRequested() {
                    pageIndex = pageIndex + 1
                    presenter.getRefund(RefundBody(refundState, pageIndex, pageSize))
                }
            }, refundList)

//            if (refundadapter != null) {
//                refundadapter.disableLoadMoreIfNotFullPage()
//                refundadapter.setPreLoadNumber(1)
//            }
            if (data.data.size<10){
                if (pageIndex>1||data.data.size>0){
                    refundadapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
                }else{
                    refundadapter!!.loadMoreComplete()
                }
            }else{
                refundadapter!!.loadMoreComplete()
            }

            refundadapter.setOnItemChildClickListener { adapter, view, position ->
                when (view.id) {
                    R.id.refundTwo -> {
                        when (refundadapter.data.get(position).refundType) {
                            0 -> intentRefundMerchant(refundadapter.data.get(position).refundId)
                            else -> intentRefundServe(refundadapter.data.get(position).refundId)
                        }
                    }
                    R.id.refundOne -> {
                        showPhoneDialog.showDialog(activity!!, refundadapter.data.get(position).platformPhone)
//                    when (refundadapter.data.get(position).refundType) {
//                        0 -> showPhoneDialog.showDialog(activity!!, refundadapter.data.get(position).platformPhone)
//                        else -> {
////                            val uri = Uri.parse("rong://" + mContext!!.applicationInfo.packageName).buildUpon()
////                                    .appendPath("conversation").appendPath(Conversation.ConversationType.PRIVATE.getName().toLowerCase())
////                                    .appendQueryParameter("targetId", "${refundadapter.data.get(position).serviceUserId}").appendQueryParameter("title", refundadapter.data.get(position).serviceName).build()
////                            var intent = Intent(Intent.ACTION_VIEW, uri)
////                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
////                            startActivity(intent)
//                        }
//                    }
                    }
                }
            }
        }
    }

    //获取列表失败
    override fun getRefundError() {
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
        refundRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        refundRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            pageIndex = 1
            show()
            presenter.getRefund(RefundBody(refundState, pageIndex, pageSize))
        }
    }

    override fun openEventBus(): Boolean = false
    private var refundState = ""
    private lateinit var refundadapter: RefundAdapter
    private val presenter by lazy { RefundPresenter(this, this, activity!!) }
    private var pageIndex: Int = 1
    private var pageSize: Int = 10
    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {
        when (it) {
            "处理中" -> refundState = "0"
            "已完成" -> refundState = "1"
        }
        show()
        presenter.getRefund(RefundBody(refundState, pageIndex, pageSize))
    }

    override fun setFragmentListener() {
        refundRefresh.setOnRefreshListener {
            pageIndex = 1
            presenter.getRefund(RefundBody(refundState, pageIndex, pageSize))
        }
    }

    override fun layoutID(): Int = R.layout.fragment_refund
}