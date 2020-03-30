package com.example.shadow.heartrecreation.ui.pay

import android.app.Activity
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.mvp.view.pay.alipay.AliPay.AliPayStart
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.WXAPIFactory

object PayUtils {

    fun AliPay(activity: Activity, payInfo: String) {
        AliPayStart(activity, payInfo)
    }

    fun WeChatPay(model: WeChatBean.DataBean) {
//        WXPay(activity)
        var api = WXAPIFactory.createWXAPI(getContext(), model!!.appid)
        if (api.isWXAppInstalled) {
            api.registerApp(model.appid)
            var payReq = PayReq()
            payReq.appId = model.appid
            payReq.partnerId = model.partnerid
            payReq.prepayId = model.prepayid
            payReq.nonceStr = model.noncestr
            payReq.timeStamp = model.timestamp.toString()
            payReq.sign = model.sign
            payReq.packageValue = model.packageX
            api.sendReq(payReq)
        } else {
            Toast.Tips("该手机未安装微信应用")
        }
    }
}