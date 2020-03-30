package com.example.shadow.heartrecreation.mvp.view.pay.alipay

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import com.alipay.sdk.app.PayTask
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.order.activity.OrderDetailsActivity
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils
import com.example.shadow.heartrecreation.ui.pay.AliModel
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOrder
import com.example.shadow.heartrecreation.utils.http.BaseUrl
//import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import com.umeng.analytics.MobclickAgent

object AliPay {
    private val SDK_PAY_FLAG = 1
    private lateinit var mActivity: Activity

    @SuppressLint("HandlerLeak")
    private val mHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                SDK_PAY_FLAG -> {
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    var data = Gson().fromJson(Gson().toJson(msg.obj), AliModel::class.java)
                    LogUtils.a("支付宝返回"+Gson().toJson(data))
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(data.resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        if (user.getOrderNo()!="") {
                            intentUtils.intentOrderDetils(user.getOrderNo())
                        }
//                        else{
//                            intentOrder()
//                        }
                        if (mActivity is OrderDetailsActivity){

                        }else {
                            mActivity.finish()
                        }
                        if (BaseUrl.HOST_URL=="http://app.bixinyule.com/") {
                            MobclickAgent.onEvent(mActivity, "BIXIN_UserClient_PayOrder")
                        }
                        Toast.Tips("支付成功")
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.Tips("支付失败")
                        if (user.getOrderNo()!="") {
                            intentUtils.intentOrderDetils(user.getOrderNo())
                        }
//                        else{
//                            intentOrder()
//                        }
                        if (mActivity is OrderDetailsActivity){

                        }else {
                            mActivity.finish()
                        }
                    }
                }
                else -> {
                }
            }
        }
    }


    fun AliPayStart(activity: Activity, orderInfo: String) {
        mActivity = activity
        var payRunnable = Runnable {
            kotlin.run {
                var alipay = PayTask(activity)
                var result = alipay.payV2(orderInfo, true)
                var msg = Message()
                msg.what = SDK_PAY_FLAG
                msg.obj = result
                mHandler.handleMessage(msg)

            }
        }
        // 必须异步调用
        val payThread = Thread(payRunnable)
        payThread.start()
    }
}