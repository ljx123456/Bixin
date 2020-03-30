package com.example.shadow.heartrecreation.ui.user.activity

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.text.TextUtils
import android.view.View
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.callback.GetUserInfoCallback
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.android.eventbus.EventBus

import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundServeBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundServeBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.RefundServePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.RefundServeView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Click
import jiguang.chat.activity.ChatActivity
import jiguang.chat.entity.Event
import jiguang.chat.entity.EventType
//import io.rong.imlib.model.Conversation
import kotlinx.android.synthetic.main.activity_refund_serve.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class RefundServeActivity : BaseActivity(), RefundServeView {
    override fun getRefundServeRequest(data: RefundServeBean) {
        dismissLoading()
        content.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        var info = data.data
        setlayoutTitle(data.data)
        setlayoutTitle(info)
        refundNum.text = "${info.orderNo}"
        refundAdds.text = "${info.businessName}${info.boxTypeName}${info.boxName}"
        refundStartTime.text=info.startTime.substring(0,info.startTime.length-3)
        if (info.endTime!=null) {
            refundEndTime.text=info.endTime.substring(0,info.endTime.length-3)
        }
        var type = false
        refundCouponMoney.text="¥:${info.serviceCouponPrice}"
        refundCoupon.visibility=View.GONE
        Click.viewClick(refundZeroMore).subscribe {
            when (type) {
                false -> {
                    type = true
                    refundZeroMore.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(R.mipmap.more_top), null)
                    refundCoupon.visibility = View.VISIBLE
                }
                else -> {
                    type = false
                    refundZeroMore.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(R.mipmap.more_down), null)
                    refundCoupon.visibility = View.GONE
                }
            }
        }
        refundTime.text = "下单时间：${info.createTime.substring(0,info.createTime.length-3)}"
        ImageLoad.setUserHead(info.avatar, brokerImage)
        brokerName.text = info.serviceName
        refundAge.text = "${info.age}"
        if (info.occupation!=null&&info.occupation!=""){
            refundJoin.visibility=View.VISIBLE
            refundJoin.text = info.occupation
        }else{
            refundJoin.visibility=View.GONE
        }
        refundMoney.text="¥${info.refundPrice}"
        refundPayMoney.text="¥${info.payPrice}"
        UIUtils.setAgeUtils(refundAge,info.sex,info.age.toString())
//        when (info.sex) {
//            1 -> refundAge.setCompoundDrawablesRelativeWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//            2 -> refundAge.setCompoundDrawablesRelativeWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//        }
    }

    override fun getRefundServeError() {
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
        content.visibility=View.GONE
        errorLayout.visibility=View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getRefundServe(RefundServeBody("$refundId"))
        }

    }

    //设置头部显示
    private fun setlayoutTitle(info: RefundServeBean.DataBean) {
        //0 发起退款，1 退款中，2 退款成功，3 退款失败
        when (info.refundState) {
            0 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_01)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.whites))
                refundTypeThree.setTextColor(resources.getColor(R.color.whites))
                ShowDialog.showCustomDialog(this, "退款解释", "具体到账时间以微信、支付宝方的相应规则为准！", "我知道了", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        dialog.dismiss()
                    }
                })
                refundTypeContext.text="发起退款"
            }
            1 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_02)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.setTextColor(resources.getColor(R.color.whites))
                refundTypeContext.text="退款中"
            }
            2 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_03)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.text = "退款成功"
                refundTypeContext.text="退款成功"
            }
            3 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_03)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.text = "退款失败"
                refundTypeContext.text="退款失败"
            }
        }
//        Click.viewClick(refundOne).subscribe {
//            JMessageClient.getUserInfo(info.createUserId.toString(),"b2a8076f779c87568f4d0656",object : GetUserInfoCallback(){
//                override fun gotResult(p0: Int, p1: String, p2: UserInfo) {
//                    if (p0==0){
//                        var mUserInfo=p2
//                        var intent=Intent()
//                        intent.setClass(this@RefundServeActivity, ChatActivity::class.java)
//                        //创建会话
//                        intent.putExtra("targetId", mUserInfo.getUserName())
//                        intent.putExtra("targetAppKey", mUserInfo.getAppKey())
//                        var notename = mUserInfo.getNotename()
//                        if (TextUtils.isEmpty(notename)) {
//                            notename = mUserInfo.getNickname()
//                            if (TextUtils.isEmpty(notename)) {
//                                notename = mUserInfo.getUserName()
//                            }
//                        }
//                        intent.putExtra("conv_title", notename)
//                        var conv: Conversation? = JMessageClient.getSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
//                        //如果会话为空，使用EventBus通知会话列表添加新会话
//                        if (conv == null) {
//                            conv = Conversation.createSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
//                            EventBus.getDefault().post(Event.Builder()
//                                    .setType(EventType.createConversation)
//                                    .setConversation(conv)
//                                    .build())
//                        }
//                        startActivity(intent)
//                    }
//                }
//            })
////            val uri = Uri.parse("rong://" + mContext!!.applicationInfo.packageName).buildUpon()
////                    .appendPath("conversation").appendPath(Conversation.ConversationType.PRIVATE.getName().toLowerCase())
////                    .appendQueryParameter("targetId", "${info.createUserId}").appendQueryParameter("title", info.serviceName).build()
////            var intent = Intent(Intent.ACTION_VIEW, uri)
////            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
////            startActivity(intent)
//        }
    }

    override fun openEventBus(): Boolean = false
    private var refundId = 0
    private val presenter by lazy { RefundServePresenter(this, this, this) }

    override fun getActivityLayout(): Int = R.layout.activity_refund_serve

    override fun setActivityTitle() {
        titleText.setText("退款详情")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRight.setImageResource(R.mipmap.singerdetails_button_doubt)
    }

    override fun initActivityData() {
        refundId = intent.getIntExtra("refundId", 0)
        showLoading()
        presenter.getRefundServe(RefundServeBody("$refundId"))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(titleRight).subscribe {
            intentUtils.intentHtml(2)
        }
    }
}