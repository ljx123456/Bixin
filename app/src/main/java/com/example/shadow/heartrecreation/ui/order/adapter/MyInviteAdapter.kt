package com.example.shadow.heartrecreation.ui.order.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.login.utils.TimeUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView
import java.math.BigDecimal

class MyInviteAdapter(serviceUsers: MutableList<OrderServicesBean.DataBean.ServiceUsersBean>) : BaseQuickAdapter<OrderServicesBean.DataBean.ServiceUsersBean, BaseViewHolder>(R.layout.item_my_invite, serviceUsers), TimeUtils.TimeUtilCallBack {
    private var callBack:finshCallBack?=null
    override fun finishTime() {
        callBack!!.finsh()
    }

    override fun convert(helper: BaseViewHolder, item: OrderServicesBean.DataBean.ServiceUsersBean) {
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.inviteImage) as RoundedImageView)
        helper.setText(R.id.inviteName, item.nickname)
                .setText(R.id.inviteMoney,"¥:"+item.price.setScale(2, BigDecimal.ROUND_HALF_UP).toString())
        if (item.occupation!=null&&item.occupation!=""){
            helper.setText(R.id.inviteJoin, item.occupation)
                    .setVisible(R.id.inviteJoin, true)
        }else{
            helper.setVisible(R.id.inviteJoin, false)
        }
        //服务状态：0 等待商家确认，1 未接单，2 支付失败，3已接单/未付款，4 已付款，5 到场，6 开始服务，7 结束服务，8 超时，9 用户取消，10 服务人员拒绝，11 服务人员繁忙
        //服务状态：0 等待商家确认，1 未接单，2 支付失败，3已接单/未付款，4 已付款，5 到场，6 开始服务，7 结束服务，8 超时，9 用户取消，10 服务人员拒绝，11 服务人员繁忙，12 邀约已满
        //8(用户支付超时，达人接单超时)， 10(拒绝理由:"距离太远","临时有事","已有其他订单","身体不适")，11(已下线，无法接单，已被约)
        var state = ""
        when (item.serviceState) {
            0 -> state = "等待商家确认"
            1 -> state = "未接单"
            2 -> state = "等待付款"
            3 -> state = "等待付款"
            4 -> state = "已付款"
            5 -> state = "到场"
            6 -> state = "开始服务"
            7 -> state = "结束服务"
            8 -> state = "接单超时"
            9 -> state = "用户取消"
            10 -> state = "服务人员拒绝"
            11 -> state = "服务人员繁忙"
            12 -> state="邀约已满"
        }
        helper.setText(R.id.inviteType, state)
                .setVisible(R.id.inviteTime,false)
                .addOnClickListener(R.id.inviteImageOver)
        var ageView = helper.getView<TextView>(R.id.inviteAge)
        UIUtils.setAgeUtils(ageView, item.sex, item.age)
        var timeUtils=TimeUtils()
        timeUtils.setCallBack(this)
        when (item.serviceState) {
            2->{
                if (item.waitPayServiceTime>0){
                    helper.setVisible(R.id.inviteTime,true)
                            .setVisible(R.id.inviteImageOver, false)
                            .setVisible(R.id.inviteOver, false)
                    timeUtils.setEndTimer(item.waitPayServiceTime.toLong())
                    timeUtils.codeCountTimerInvite(helper.getView(R.id.inviteTime))
                }
            }
            3->{
                if (item.waitPayServiceTime>0){
                    helper.setVisible(R.id.inviteTime,true)
                            .setVisible(R.id.inviteImageOver, false)
                            .setVisible(R.id.inviteOver, false)
                    timeUtils.setEndTimer(item.waitPayServiceTime.toLong())
                    timeUtils.codeCountTimerInvite(helper.getView(R.id.inviteTime))
                }
            }
            8 ->{
                helper.setText(R.id.inviteType, item.description)
                        .setVisible(R.id.inviteImageOver, true)
                        .setVisible(R.id.inviteOver, false)
            }
            11 -> {
                helper.setText(R.id.inviteType, item.description)
                        .setVisible(R.id.inviteImageOver, true)
                        .setVisible(R.id.inviteOver, false)
            }
            10 -> {
                helper.setText(R.id.inviteType, item.description)
                        .setVisible(R.id.inviteImageOver, true)
                        .setVisible(R.id.inviteOver, false)
            }
            else -> {
                helper.setText(R.id.inviteType, state)
                        .setVisible(R.id.inviteImageOver, false)
                        .setVisible(R.id.inviteOver, false)
            }
        }
    }


    public fun setCallBack(callBack:finshCallBack){
        this.callBack=callBack
    }

    interface finshCallBack{
        fun finsh()
    }
}