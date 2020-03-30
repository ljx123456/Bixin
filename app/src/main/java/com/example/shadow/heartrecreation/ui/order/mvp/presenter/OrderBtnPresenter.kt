package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.app.Activity
import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.dialog.PayTypeDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.CancelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.CancelServiceBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.PayAgainBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.CancelOrderBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.CancelServiceBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.DelOrderBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayAgainBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.CancelOrderData
import com.example.shadow.heartrecreation.ui.order.mvp.data.CancelServiceData
import com.example.shadow.heartrecreation.ui.order.mvp.data.DelOrderData
import com.example.shadow.heartrecreation.ui.order.mvp.data.PayAgainData
import com.example.shadow.heartrecreation.ui.order.mvp.view.OrderBtnView
import com.example.shadow.heartrecreation.ui.pay.PayUtils.AliPay
import com.example.shadow.heartrecreation.ui.pay.PayUtils.WeChatPay
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import java.util.ArrayList

class OrderBtnPresenter(owner: LifecycleOwner, val view: OrderBtnView, val mContext: Context) : BasePresenter(owner, view, mContext),
        CancelOrderData.CancelOrder,
        PayAgainData.PayAgain,
        CancelServiceData.CancelService ,
        DelOrderData.DelOrder{

    //删除成功
    override fun getDelOrderRequest(data: DelOrderBean) {
        view.dismissLoading(mContext)
        view.getDelOrderRequest(data)
    }

    //删除失败
    override fun getDelOrderError() {
        view.dismissLoading(mContext)
    }
    //删除订单
    fun getDelOrder(body:DelOrderBody){
        view.showLoading(mContext)
        delorder.getDelOrder(body)
    }

    //取消服务人员成功
    override fun getCancelServiceRequest(data: CancelServiceBean) {
        view.dismissLoading(mContext)
        view.getCancelServiceRequest()
    }

    //取消服务人员失败
    override fun getCancelServiceError() {
        view.dismissLoading(mContext)
        view.getCancelServiceRequest()
    }

    //取消服务人员
    fun getCancelService(body: CancelServiceBody) {
        view.showLoading(mContext)
        cancelservice.getCancelService(body)
    }

    override fun getPayAgainRequest(data: ResponseBody) {
        view.dismissLoading(mContext)
        if (type.equals("1")) {//支付宝
            var Ali = Gson().fromJson(data.string(), AliPayBean::class.java)
            if (Ali.code == 0) AliPay(mActivity!!, Ali.data.payInfo)
            else Toast.Tips(Ali.message)
        } else {
            var WeChat = Gson().fromJson(data.string(), WeChatBean::class.java)
            if (WeChat.code == 0) {
                WeChatPay(WeChat.data)
                mActivity!!.finish()
            }
            else Toast.Tips(WeChat.message)
        }
    }

    override fun getPayAgainError() {
        view.dismissLoading(mContext)
    }


    private val cancelorder = CancelOrderData(this)
    private val payagain = PayAgainData(this)
    private var type = ""
    private var mActivity: Activity? = null
    private val cancelservice = CancelServiceData(this)
    private val delorder=DelOrderData(this)

    fun getPayAgain(mactivity: Activity, body: PayAgainBody) {
        type = body.payType
        mActivity = mactivity
        view.showLoading(mContext)
        payagain.getPayAgain(body)
    }


    //取消订单
    fun CancelOrder(body: CancelOrderBody) {
        view.showLoading(mContext)
        cancelorder.CancelOrder(body)
    }

    //取消订单成功
    override fun CancelOrderRequest(data: CancelOrderBean) {
        view.CancelOrderRequest(data)
        view.dismissLoading(mContext)
    }

    //取消订单失败
    override fun CancelOrderError() {
        view.CancelOrderError()
        view.dismissLoading(mContext)
    }


    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }
}