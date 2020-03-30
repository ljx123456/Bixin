package com.example.shadow.heartrecreation.ui.order.adapter

import android.util.Log
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.login.utils.TimeUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderListBean
import java.text.SimpleDateFormat
import java.util.*

class OrderAdapter(list: MutableList<OrderListBean.DataBean>) : BaseQuickAdapter<OrderListBean.DataBean, BaseViewHolder>(R.layout.item_order, list),TimeUtils.TimeUtilCallBack {

    private var callBack:CallBack?=null
    override fun finishTime() {
        callBack!!.finish()
    }

    override fun convert(helper: BaseViewHolder, item: OrderListBean.DataBean) {
        var timeutils = TimeUtils()
        timeutils.setCallBack(this)
        helper.setText(R.id.orderAdds, item.businessName)
                .setText(R.id.orderBaofangType, item.boxTypeName)


        if (item.waitPaymentTime != null && item.waitPaymentTime > 0) {
            helper.setVisible(R.id.orderTime, false)
            var timeView = helper.getView<TextView>(R.id.orderTime)
            timeutils.setEndTimer(item.waitPaymentTime)
            timeutils.codeCountTimerOrder(timeView)
        } else {
            helper.setVisible(R.id.orderTime, true)
        }

        if (item.reserveTime!=null&&item.reserveTime!=""){
            helper.setVisible(R.id.orderReserveLayout,true)
                    .setText(R.id.orderReserveText,"预约时间")
                    .setText(R.id.orderReserve,getTime(item.reserveTime))
        }else{
            helper.setVisible(R.id.orderReserveLayout,false)
        }

        if (item.startTime!=null&&item.startTime!=""){
            helper.setVisible(R.id.orderStartLayout,true)
                    .setText(R.id.orderStartText,"开始时间")
                    .setText(R.id.orderStart, getTime(item.startTime))
        }else{
            helper.setVisible(R.id.orderStartLayout,false)
//                    .setText(R.id.orderStartText,"下单时间")
//                    .setText(R.id.orderStart, getTime(item.createTime))

        }

        if (item.endTime != null && item.endTime!="") {
            helper.setVisible(R.id.overTimeLayout, true)
                    .setText(R.id.orderEndTime, getTime(item.endTime))
        } else {
            helper.setVisible(R.id.overTimeLayout, false)
        }

        if (item.boxName != null && item.boxName!="") {
            helper.setText(R.id.orderNum, "${item.boxName}")//包房号码
                    .setVisible(R.id.orderNumLayout,true)
        } else {
            helper.setText(R.id.orderNum, "暂无")//包房
                    .setVisible(R.id.orderNumLayout,false)
        }
        if (item.description != null && "".equals(item.description)) {
            helper.setText(R.id.orderZhuangtai, "(${item.description})")
        } else {
            helper.setText(R.id.orderZhuangtai, "")
        }
        helper.addOnClickListener(R.id.orderCancel)
                .addOnClickListener(R.id.orderRelation)
                .addOnClickListener(R.id.orderCode)
                .addOnClickListener(R.id.orderPay)
                .addOnClickListener(R.id.orderDel)
//服务人员状态：0 等待商家确认，1 未接单，2 支付失败，3已接单/未付款，4 已付款，5 到场，6 开始服务，7 结束服务，8 超时，9 用户取消，10 服务人员拒绝，11 服务人员繁忙，12 邀约已满
        when (item.orderState) {//订单状态：-1 订单冻结，0 等待商家确认，1 待服务，2 进行中 ，3 待评价，4 已结束，5 未付款，6 用户取消，7 付款超时，8 商家拒绝，9 商家确认超时

            //订单冻结
            "-1" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, false)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
                    .setText(R.id.orderType, "订单冻结")//描述
//                    .setVisible(R.id.orderNumLayout,true)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,false)//删除订单
                    .setVisible(R.id.orderLayout,false)
            //等待商家确认
            "0" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, true)//取消订单
                    .setVisible(R.id.orderRelation, true)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
//                    .setVisible(R.id.orderNumLayout,false)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,false)//删除订单
                    .setText(R.id.orderType, "等待商家确认")
                    .setVisible(R.id.orderLayout,true)
            //待服务
            "1" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, true)//取消订单
                    .setVisible(R.id.orderRelation, true)//联系商家
                    .setVisible(R.id.orderCode, true)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
//                    .setVisible(R.id.orderNumLayout,true)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,false)//删除订单
                    .setText(R.id.orderType, "未开始")
                    .setVisible(R.id.orderLayout,true)
            //进行中
            "2" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, false)//联系商家
                    .setVisible(R.id.orderCode, true)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
//                    .setVisible(R.id.orderNumLayout,true)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,false)//删除订单
                    .setText(R.id.orderType, "正在消费")
                    .setVisible(R.id.orderLayout,true)
                    .setText(R.id.orderStart, getTime(item.startTime))
                    .setText(R.id.orderStartText,"开始时间")
            //待评价
            "3" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, true)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
//                    .setVisible(R.id.orderNumLayout,true)//包房号
                    .setVisible(R.id.overTimeLayout,true)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,true)//删除订单
                    .setText(R.id.orderType, "订单完成")
                    .setVisible(R.id.orderLayout,true)
                    .setText(R.id.orderStart, getTime(item.startTime))
                    .setText(R.id.orderStartText,"开始时间")
            //订单状态：-1 订单冻结，0 等待商家确认，1 待服务，2 进行中 ，3 待评价，4 已结束，5 未付款，6 用户取消，7 付款超时，8 商家拒绝，9 商家确认超时
            //已结束
            "4" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, true)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
//                    .setVisible(R.id.orderNumLayout,true)//包房号
                    .setVisible(R.id.overTimeLayout,true)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,true)//删除订单
                    .setText(R.id.orderType, "订单完成")
                    .setVisible(R.id.orderLayout,true)
                    .setText(R.id.orderStart, getTime(item.startTime))
                    .setText(R.id.orderStartText,"开始时间")
            //未付款
            "5" -> helper.setVisible(R.id.orderTime, true)//时间
//                    .setVisible(R.id.orderNumLayout,false)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderCancel, true)//取消订单
                    .setVisible(R.id.orderRelation, false)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, true)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setText(R.id.orderType, "待支付¥:${item.orderCountPrice}")
                    .setVisible(R.id.orderDel,false)//删除订单
                    .setVisible(R.id.orderLayout,true)
            //已取消
            "6" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, true)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
//                    .setVisible(R.id.orderNumLayout,false)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setText(R.id.orderType, "订单已取消")//描述
                    .setVisible(R.id.orderDel,true)//删除订单
                    .setVisible(R.id.orderLayout,true)
            //支付超时
            "7" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, false)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
                    .setText(R.id.orderType, "支付超时")//描述
//                    .setVisible(R.id.orderNumLayout,false)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,true)//删除订单
                    .setVisible(R.id.orderLayout,true)
//                    .setText(R.id.orderType, "订单完成")

            //商家拒绝
            "8" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, true)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
                    .setText(R.id.orderType, "订单被拒")//描述
//                    .setVisible(R.id.orderNumLayout,false)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,true)//删除订单
                    .setVisible(R.id.orderLayout,true)

            //商家确认超时
            "9" -> helper.setVisible(R.id.orderTime, false)//时间
                    .setVisible(R.id.orderCancel, false)//取消订单
                    .setVisible(R.id.orderRelation, true)//联系商家
                    .setVisible(R.id.orderCode, false)//分享
                    .setVisible(R.id.orderPay, false)//去支付
                    .setVisible(R.id.orderCome, false)//再来一单
                    .setText(R.id.orderType, "商家确认超时")//描述
//                    .setVisible(R.id.orderNumLayout,false)//包房号
                    .setVisible(R.id.overTimeLayout,false)//结束时间
                    .setVisible(R.id.orderAddsLayout,false)//添加服务
                    .setVisible(R.id.orderDel,true)//删除订单
                    .setVisible(R.id.orderLayout,true)

        }
    }

    public fun setCallBack(callBack: CallBack){
        this.callBack=callBack
    }

    interface CallBack{
        fun finish()
    }

    /**
     * 根据当前日期获得是星期几
     * time=yyyy-MM-dd
     * @return
     */
    public fun getWeek(time:String):String {
        var  Week = ""
        var format = SimpleDateFormat("yyyy-MM-dd")
        var c = Calendar.getInstance()
        try {
            c.setTime(format.parse(time))
        } catch (e:Exception) {
            Log.e("测试","异常")
            e.printStackTrace()
        }

        var wek=c.get(Calendar.DAY_OF_WEEK)

        if (wek == 1) {
            Week += "周日"
        }
        if (wek == 2) {
            Week += "周一"
        }
        if (wek == 3) {
            Week += "周二"
        }
        if (wek == 4) {
            Week += "周三"
        }
        if (wek == 5) {
            Week += "周四"
        }
        if (wek == 6) {
            Week += "周五"
        }
        if (wek == 7) {
            Week += "周六"
        }
        return Week
    }

    fun getData(time:String):String{
        var split=time.split("-")
        return split[1]+"月"+split[2]+"日"
    }

    fun getTime(time:String):String{
        var split=time.split(" ")

        return getData(split[0])+"（"+getWeek(split[0])+"）"+split[1].substring(0,split[1].length-3)
    }


}