package com.example.shadow.heartrecreation.wxapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
import com.tencent.mm.opensdk.constants.ConstantsAPI
import com.blankj.utilcode.util.ToastUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOrder
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.utils.SystemUtils
//import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
//import com.example.shadow.heartrecreation.ui.main.utils.intentUsils


import com.tencent.mm.opensdk.openapi.WXAPIFactory
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.umeng.analytics.MobclickAgent
import org.greenrobot.eventbus.EventBus

/**
 * 微信分享，支付相关回调
 */
class WXPayEntryActivity : Activity(), IWXAPIEventHandler {
    private var api: IWXAPI? = null
    var APP_IDs = "wx4d89639ebf5bc12a"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        SystemUtils.activityFullScreen(this)
        setContentView(R.layout.pay_result)

        api = WXAPIFactory.createWXAPI(this, APP_IDs)
//        api = WXAPIFactory.createWXAPI(this, null)
        api!!.handleIntent(intent, this)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        api!!.handleIntent(intent, this)
    }

    override fun onResp(resp: BaseResp?) {
        if (resp!!.getType() === ConstantsAPI.COMMAND_PAY_BY_WX) {
            LogUtils.a(resp!!.getType())
            if (resp!!.errCode == 0) {
                ToastUtils.showShort("支付成功")
                if (user.getOrderNo()!="") {
                    intentUtils.intentOrderDetils(user.getOrderNo())
                }
//                else{
//                    intentOrder()
//                }
                if (BaseUrl.HOST_URL=="http://app.bixinyule.com/") {
                    MobclickAgent.onEvent(this, "BIXIN_UserClient_PayOrder")
                }
//                UserDB.payOver(this!!, 2)
            } else if (resp!!.errCode == -1) {
                ToastUtils.showShort("支付错误")
                if (user.getOrderNo()!="") {
                    intentUtils.intentOrderDetils(user.getOrderNo())
                }
//                else{
//                    intentOrder()
//                }
//                UserDB.payOver(this!!, 1)
            } else if (resp!!.errCode == -2) {
                ToastUtils.showShort("取消支付")
                if (user.getOrderNo()!="") {
                    intentUtils.intentOrderDetils(user.getOrderNo())
                }
//                else{
//                    intentOrder()
//                }
//                UserDB.payOver(this!!, 1)
            } else {

            }
            finish()

        }
    }

    override fun onReq(resp: BaseReq?) {

    }

}