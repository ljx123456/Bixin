package com.example.shadow.heartrecreation.ui.order.adapter

import android.graphics.Color
import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.ui.login.utils.TimeUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class OrderServeAdapter(serviceUsers: MutableList<OrderDetailsBean.DataBean.ServiceUsersBean>) : BaseQuickAdapter<OrderDetailsBean.DataBean.ServiceUsersBean, BaseViewHolder>(R.layout.item_order_serve, serviceUsers),TimeUtils.TimeUtilCallBack {

    private var callBack:finshCallBack?=null
    override fun finishTime() {
        callBack!!.finshAdapter()
    }

    override fun convert(helper: BaseViewHolder, item: OrderDetailsBean.DataBean.ServiceUsersBean) {
        var timeutils = TimeUtils()
        timeutils.setCallBack(this)
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.orderServeImage) as RoundedImageView)
        helper.setText(R.id.orderServeName, item.nickname)
                .setText(R.id.orderServeAge, "${item.age}")

        if (item.occupation!=null&&item.occupation!=""){
            helper.setVisible(R.id.orderServeJoin,true).setText(R.id.orderServeJoin, item.occupation)
        }else{
            helper.setVisible(R.id.orderServeJoin,false)
        }
//                .setText(R.id.setatTime,"预计到场时间:${item}")//到场时间
//        服务状态：2 支付失败，3已接单/未付款，4 已付款，5 到场，6 开始服务，7 结束服务，20订单冻结
        if (item.serviceState!=null&&item.serviceState!=0) {
            when (item.serviceState) {
                2 -> {
                    if (item.waitPayServiceTime != null && item.waitPayServiceTime > 0) {
                        setType(helper, true, true, true, true, false, false, false, "¥:${item.price}")
                        timeutils.setEndTimer(item.waitPayServiceTime.toLong())
                        timeutils.codeCountTimerCancel(helper.getView(R.id.orderPayTime) as TextView)

                    } else {
                        setType(helper, true, true, true, true, false, false, false, "¥:${item.price}")
                    }
                    helper.setText(R.id.orderPay,"重新支付")
                    helper.setVisible(R.id.orderServeLayout, true)
                }
                3 -> {
                    if (item.waitPayServiceTime != null && item.waitPayServiceTime > 0) {
                        setType(helper, true, true, true, true, false, false, false, "¥:${item.price}")
                        timeutils.setEndTimer(item.waitPayServiceTime.toLong())
                        timeutils.codeCountTimerCancel(helper.getView(R.id.orderPayTime) as TextView)

                    } else {
                        setType(helper, true, true, true, true, false, false, false, "¥:${item.price}")
                    }
                    helper.setText(R.id.orderPay,"付款")
                    helper.setVisible(R.id.orderServeLayout, true)
                }
                4 -> {
                    helper.setText(R.id.orderPay,"付款")
                    if (item.isLate == "0") {
                        if (item.serviceCanRefuseTime != null && item.serviceCanRefuseTime > 0) {
                            setType(helper, true, false, true, false, true, false, false, "等待到场")//扫码到场：正在约玩，打卡到场：已到约玩地点
                            timeutils.setEndTimer(item.serviceCanRefuseTime.toLong())
                            timeutils.codeCountTimerCancel(helper.getView(R.id.orderServeTime) as TextView)
                        } else {
                            setType(helper, true, false, true, false, false, false, false, "等待到场")//扫码到场：正在约玩，打卡到场：已到约玩地点
                        }
                    } else {
                        setType(helper, false, false, true, false, false, false, true, "等待到场")
                    }
                    helper.setVisible(R.id.orderServeLayout, true)

                }
                5 -> {
                    if (item.serviceStartCountdown == null || item.serviceStartCountdown <= 0) {
                        setType(helper, false, false, false, false, false, true, false, "正在约玩")
                    } else {
                        setType(helper, true, false, false, false, true, true, false, "正在约玩")
                        timeutils.setEndTimer(item.serviceStartCountdown.toLong())
                        timeutils.codeCountTimerCancel(helper.getView(R.id.orderServeTime) as TextView)
                    }
                    helper.setVisible(R.id.orderServeLayout, true)
                }
                6 -> {
                    if (item.serviceStartCountdown == null || item.serviceStartCountdown <= 0) {
                        setType(helper, false, false, false, false, false, true, false, "正在约玩")
                    } else {
                        setType(helper, true, false, false, false, true, true, false, "正在约玩")
                        timeutils.setEndTimer(item.serviceStartCountdown.toLong())
                        timeutils.codeCountTimerCancel(helper.getView(R.id.orderServeTime) as TextView)
                    }
                    helper.setVisible(R.id.orderServeLayout, true)
                }
                7 -> {
                    setType(helper, false, false, false, false, false, false, false, "已结束")
                    helper.setVisible(R.id.orderServeLayout, false)
                }
                20 -> {
                    setType(helper, false, false, false, false, false, true, false, "达人订单已冻结")
                    helper.setVisible(R.id.orderServeLayout, true)
                }
            }
        }else{
            setType(helper, false, false, false, false, false, false, false, "")
            helper.setVisible(R.id.orderServeLayout, false)
        }

//        if (item.arriveTime)

        var sex = helper.getView<TextView>(R.id.orderServeAge)
        setAgeUtils(sex,item.sex,item.age)
//        when (item.sex) {
//            2 -> {
//                sex.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//                sex.setBackgroundResource(R.)
//            }
//            else -> sex.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//        }

        //退款状态:0 发起退款，1 退款中，2 退款成功，3 退款失败（未返回该字段时，表示无退款状态）
        if (item.refundState!=null&&item.refundState!=""){
            helper.setVisible(R.id.orderServeLayout,false)
                    .setVisible(R.id.setatTime,true)
            when(item.refundState){
                "1"->helper.setText(R.id.orderServeMoney, "退款中")
                "2"->helper.setText(R.id.orderServeMoney, "退款成功")
                "3"->helper.setText(R.id.orderServeMoney, "退款失败")
                else ->helper.setText(R.id.orderServeMoney, "退款中")
            }
        }else{
            helper.setVisible(R.id.orderServeLayout,true)
                    .setVisible(R.id.setatTime,false)
        }
//        投诉状态：0 已提交，1 处理中，2 处理完成
        if (item.complaintsState!=null&&item.complaintsState!=""){
            when(item.complaintsState){
                "0"->{
                    helper.setText(R.id.orderServeComplaints,"投诉中")
                }
                "1"->{
                    helper.setText(R.id.orderServeComplaints,"投诉中")
                }
               "2"->{
                    helper.setText(R.id.orderServeComplaints,"投诉结果")
                }
            }
        }else{
            helper.setText(R.id.orderServeComplaints,"投诉")
        }
//        //等待支付服务倒计时（单位：秒）返回-2时为已超时
//        if (item.waitPayServiceTime == -2) {
//            helper.setVisible(R.id.orderServeOver, true)
//        } else {
//            helper.setVisible(R.id.orderServeOver, false)
//            timeutils.setEndTimer(item.waitPayServiceTime.toLong())
//            timeutils.codeCountTimerOrder(helper.getView(R.id.orderServeTime) as TextView)
//        }
//        //服务开始倒计时（单位：秒）返回 -2 为已超时
//        if (item.serviceStartCountdown == -2) {
//            helper.setVisible(R.id.orderServeOver, true)
//        } else {
//            helper.setVisible(R.id.orderServeOver, false)
//            timeutils.setEndTimer(item.serviceStartCountdown.toLong())
//            timeutils.codeCountTimerOrder(helper.getView(R.id.orderServeTime) as TextView)
//        }

        when (item.serviceState) {
            2, 3, 4 -> {
                var time=""
                if (item.estimateArriveTime!=null&&item.estimateArriveTime!=""&&item.estimateArriveTime.length>10) {
                    time=item.estimateArriveTime.substring(10, item.estimateArriveTime.length-3)
                }
                helper.setText(R.id.setatTime, "预计到场时间：" + time).setVisible(R.id.setatTime, true)
            }
            5, 6 -> {
                var time=""
                if (item.serviceStartTime!=null&&item.serviceStartTime!=""&&item.serviceStartTime.length>10) {
                    time=item.serviceStartTime.substring(10, item.serviceStartTime.length-3)
                }
                helper.setText(R.id.setatTime, "开始时间：" + time).setVisible(R.id.setatTime, true)
            }
            else ->{
                var time=""
                var time1=""
                var time2=""
                if (item.serviceStartTime!=null&&item.serviceStartTime!=""&&item.serviceStartTime.length>10) {
                    time1=item.serviceStartTime.substring(10, item.serviceStartTime.length-3)
                }
                if (item.serviceEndTime!=null&&item.serviceEndTime!=""&&item.serviceEndTime.length>10) {
                    time2=item.serviceEndTime.substring(10, item.serviceEndTime.length-3)
                }
                if (time1!=""&&time2!=""){
                    time=time1+"至"+time2
                }
                helper.setText(R.id.setatTime, "约玩时间：" +time).setVisible(R.id.setatTime, true)
            }
        }

//        if (item.estimateArriveTime!=null&&item.estimateArriveTime!="") {
//            var time = item.estimateArriveTime.substring(10, item.estimateArriveTime.length)
//            //显示到场时间
//            when (item.serviceState) {
//                2, 3, 4 -> helper.setText(R.id.setatTime, "预计到场时间：" + time).setVisible(R.id.setatTime, true)
//                5, 6 -> helper.setText(R.id.setatTime, "开始时间：" + time).setVisible(R.id.setatTime, true)
//                else -> helper.setText(R.id.setatTime, "结束时间：" + time).setVisible(R.id.setatTime, true)
//            }
//        }
    }

    private fun setType(helper: BaseViewHolder, b: Boolean, b1: Boolean, b2: Boolean, b3: Boolean, b4: Boolean,b5: Boolean, b6: Boolean,money: String) {
        helper.setVisible(R.id.orderServeOver, b)//取消
                .setVisible(R.id.orderServeLookAdds, b1)//位置
                .setVisible(R.id.orderServeMassage, b2)//聊天
                .setVisible(R.id.orderServePay, b3)//付款
                .setVisible(R.id.orderServeTime, b4)//时间
                .setVisible(R.id.orderServeComplaints,b5)//投诉
                .setVisible(R.id.orderServeLate,b6)//迟到退款
                .setText(R.id.orderServeMoney, money)
                .addOnClickListener(R.id.orderServeOver)
                .addOnClickListener(R.id.orderServeLookAdds)
                .addOnClickListener(R.id.orderServeMassage)
                .addOnClickListener(R.id.orderServePay)
                .addOnClickListener(R.id.orderServeComplaints)
                .addOnClickListener(R.id.orderServeLate)

        if (b3){
            helper.setBackgroundRes(R.id.orderServePay,R.drawable.black_shape)
                    .setTextColor(R.id.orderPay,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeMassage,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderServeMassage,Color.parseColor("#999999"))
                    .setBackgroundRes(R.id.orderServeLookAdds,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderServeLookAdds,Color.parseColor("#999999"))
                    .setBackgroundRes(R.id.orderServeOver,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderCancel,Color.parseColor("#999999"))
                    .setBackgroundRes(R.id.orderServeComplaints,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderServeComplaints,Color.parseColor("#999999"))
        }else if (b2){
            helper.setBackgroundRes(R.id.orderServePay,R.drawable.black_shape)
                    .setTextColor(R.id.orderPay,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeMassage,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeMassage,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeLookAdds,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderServeLookAdds,Color.parseColor("#999999"))
                    .setBackgroundRes(R.id.orderServeOver,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderCancel,Color.parseColor("#999999"))
                    .setBackgroundRes(R.id.orderServeComplaints,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderServeComplaints,Color.parseColor("#999999"))
        }else if (b1){
            helper.setBackgroundRes(R.id.orderServePay,R.drawable.black_shape)
                    .setTextColor(R.id.orderPay,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeMassage,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeMassage,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeLookAdds,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeLookAdds,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeOver,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderCancel,Color.parseColor("#999999"))
                    .setBackgroundRes(R.id.orderServeComplaints,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderServeComplaints,Color.parseColor("#999999"))
        }else if (b){
            helper.setBackgroundRes(R.id.orderServePay,R.drawable.black_shape)
                    .setTextColor(R.id.orderPay,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeMassage,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeMassage,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeLookAdds,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeLookAdds,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeOver,R.drawable.black_shape)
                    .setTextColor(R.id.orderCancel,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeComplaints,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.orderServeComplaints,Color.parseColor("#999999"))
        }else if (b2){
            helper.setBackgroundRes(R.id.orderServePay,R.drawable.black_shape)
                    .setTextColor(R.id.orderPay,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeMassage,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeMassage,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeLookAdds,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeLookAdds,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeOver,R.drawable.black_shape)
                    .setTextColor(R.id.orderCancel,Color.parseColor("#333333"))
                    .setBackgroundRes(R.id.orderServeComplaints,R.drawable.black_shape)
                    .setTextColor(R.id.orderServeComplaints,Color.parseColor("#333333"))
        }

    }

    public fun setCallBack(callBack:finshCallBack){
        this.callBack=callBack
    }

    interface finshCallBack{
        fun finshAdapter()
    }
}