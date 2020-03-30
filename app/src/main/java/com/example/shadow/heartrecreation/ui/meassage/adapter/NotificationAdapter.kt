package com.example.shadow.heartrecreation.ui.meassage.adapter


import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.NotificationBean


class NotificationAdapter : BaseQuickAdapter<NotificationBean.DataBean, BaseViewHolder> {

    constructor(data: MutableList<NotificationBean.DataBean>) : super(R.layout.item_noti_two, data)

    override fun convert(helper: BaseViewHolder, item: NotificationBean.DataBean) {
        helper.setText(R.id.notiTime, item.createTime)//时间
        if (item.isRead==0){
            helper.setVisible(R.id.messageView,true)
        }else{
            helper.setVisible(R.id.messageView,false)
        }

//        消息类型：0 订单，1 评价，2 退款，3 优惠券，4 存取酒，5 服务，6 服务投诉，7 举报，8 建议，9 系统通知/活动
        when (item.type) {
            0 -> {
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, true)//订单号
                        .setText(R.id.notiItemID, "订单号：${item.orderNo}")
//                        .setVisible(R.id.notiContextTwoText, true)
                when (item.orderState) {
                    //取消
                    0 -> {
                        helper.setText(R.id.notiTitle, "订单被拒")//头部
                                .setText(R.id.notiContextTwo, "您在${item.businessName}预约的订单已被商家取消")//内容
//                                .setText(R.id.notiContextTwoText, "(${item.description})")//内容小字

                    }
                    //接单
                    1 -> {
                       var text="您在${item.businessName}预约的订单已被商家接单，包房号是：<font color='#FF6464'>${item.boxName}</font>；您的订单验证码是：<font color='#71BDFE'>${item.orderCode}</font>；祝您消费愉快！"
                        helper.setText(R.id.notiTitle, "商家已接单")//头部
                                .setText(R.id.notiContextTwo, Html.fromHtml(text))//内容
//                                .setText(R.id.notiContextTwoText, "(${item.description})")//内容小字

                    }
                    //订单开始
                    2->{
                        helper.setText(R.id.notiTitle, "订单已开始")//头部
                                .setText(R.id.notiContextTwo, "您在${item.businessName}预约的订单已到预约时间，请及时到场")//内容
                    }
                    //商家确认超时
                    3->{
                        helper.setText(R.id.notiTitle, "订单已取消")//头部
                                .setText(R.id.notiContextTwo, "您在${item.businessName}预约的订单由于商家分配超时，已被取消，请重新下单")//内容
//                                .setText(R.id.notiContextTwoText, "(${item.description})")//内容小字
                    }
                }
            }
            1 -> {//评价
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//价格
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示小字
                        .setVisible(R.id.notiImageLayout, false)
                        .setVisible(R.id.notiItemID, true)
                        .setText(R.id.notiItemID, "订单号：${item.orderNo}")
                        .setText(R.id.notiTitle, "评价提醒")//头部
                        .setText(R.id.notiContextTwo, "您有服务已完成，请及时评价")//内容
            }
            2 -> {//退款
                helper.setVisible(R.id.notiTitleDescription, true)//标题提示
                        .setVisible(R.id.notiMoneyLayout, true)//价格
                        .setVisible(R.id.notiLayout, false)//提示
                        .setVisible(R.id.notiImageLayout, false)
                        .setText(R.id.notiTitle, "退款成功")//头部
                        .setVisible(R.id.notiItemID, true)
                        .setText(R.id.notiItemID, "订单号：${item.orderNo}")
                        .setText(R.id.notiRefundPrice, "¥:${item.refundPrice}")//价格
                        .setVisible(R.id.notiContextTwoText, false)
                when (item.refundType) {
                    //商家退款
                    0 -> {
                        helper.setText(R.id.notiTitleDescription, "(酒水包房)")//头部小字
                    }
                    //服务退款
                    1 -> {
                        helper.setText(R.id.notiTitleDescription, "(达人)")//头部小字
//                        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.notiImage) as RoundedImageView)//头像
                    }
                }
            }
            3 -> {//优惠券
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, true)//订单号
                        .setText(R.id.notiItemID, "平台福利赠送")
                when (item.couponState) {
                    1 -> {//新增优惠券
                        helper.setText(R.id.notiTitle, "有新的优惠券")//头部
                                .setText(R.id.notiContextTwo, "恭喜您获得平台赠送满减优惠券")
                    }
                    0 -> {//优惠券到期
                        helper.setText(R.id.notiTitle, "优惠券到期")//头部
                                .setText(R.id.notiLayout, "您有优惠券已到期")
                    }
                }
            }//图片
//                .setText(R.id.notiTitleDescription, "(${item.titleDescription})")//头部小字
//                        .setText(R.id.notiRefundPrice, "¥:${item.refundPrice}")//价格
//                    .setText(R.id.notiContextTwoText, "(${item.contentDescription})")//内容小字
//                    .setText(R.id.notiItemID, item.itemId)
            4 -> {//存取酒
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, true)//订单号
                        .setText(R.id.notiItemID, "商家电话：${item.businessPhone}")
                when (item.storageState) {
                    0 -> {//取酒验证码
                        var text="您的取酒验证码是：<font color='#71BDFE'>${item.verificationCode}</font>；您正在${item.businessName}进行取酒操作，如非本人行为，请尽快联系商家处理"
                        helper.setText(R.id.notiContextTwo, Html.fromHtml(text))
                                .setText(R.id.notiTitle,"取酒验证码")

                    }
                    1 -> {//取酒成功
                        helper.setText(R.id.notiContextTwo, "您已取出暂存在${item.businessName}的酒水，如非本人行为，请尽快联系商家处理")
                                .setText(R.id.notiTitle,"取酒成功")

                    }
                    2 -> {//存酒成功
                        helper.setText(R.id.notiContextTwo, "成功在${item.businessName}存入一批酒水")
                                .setText(R.id.notiTitle,"存酒成功")
                    }
                    3->{//即将过期
                        helper.setText(R.id.notiContextTwo, "您在${item.businessName}存储的部分酒水即将过期，请尽快前往使用")
                                .setText(R.id.notiTitle,"酒水即将过期")
                    }
                    4->{//过期
                        helper.setText(R.id.notiContextTwo, "您在${item.businessName}存储的部分酒水已过期")
                                .setText(R.id.notiTitle,"存酒已过期")

                    }
                }
            }//商家电话
            5 -> {//服务
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, true)//订单号
                        .setText(R.id.notiItemID, "订单号：${item.orderNo}")
//                        .setText(R.id.notiTitle, "服务消息")//头部
//                ImageLoad.setUserHead(item.avatar, helper.getView(R.id.notiImage) as RoundedImageView)//头像
                when (item.serviceState) {
                    0 -> {//取消服务
                        helper.setText(R.id.notiTitle, "达人取消服务")//头部
                                .setText(R.id.notiContextTwo, "有达人拒绝邀请，请及时处理")
                    }
                    1 -> {//接单
                        helper.setText(R.id.notiTitle, "达人接单通知")//头部
                                .setText(R.id.notiContextTwo, "有达人应邀，请立即付款")
                    }
                    2->{//代付款
                        helper.setText(R.id.notiTitle, "待付款提示")//头部
                                .setText(R.id.notiContextTwo, "达人已应邀，请在2分钟内完成支付，否则将自动取消达人邀请")
                    }
                }
            }
            6->{//投诉
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, true)//订单号
                        .setText(R.id.notiItemID, "订单号：${item.orderNo}")
                        .setText(R.id.notiTitle, "投诉成功")//头部
            }

            7->{//举报
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, false)//订单号
                        .setText(R.id.notiTitle,"系统通知")
                        .setText(R.id.notiContextTwo,"您的举报已经收到，点击查看反馈！")
            }

            8->{//意见反馈
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, false)//订单号
                        .setText(R.id.notiTitle,"系统通知")
                        .setText(R.id.notiContextTwo,"您的建议已经收到，点击查看反馈！")

            }
            9->{//9 系统通知/活动
                helper.setVisible(R.id.notiTitleDescription, false)//标题提示
                        .setVisible(R.id.notiMoneyLayout, false)//金额
                        .setVisible(R.id.notiLayout, true)//提示
                        .setVisible(R.id.notiContextTwoText, false)//提示内容
                        .setVisible(R.id.notiImageLayout, false)//图片
                        .setVisible(R.id.notiItemID, false)//订单号
                        .setText(R.id.notiContextTwo,item.content)
                if (item.messageType==1){//公告
                    helper.setText(R.id.notiTitle,"系统公告")
                }else{
                    helper.setText(R.id.notiTitle,"活动通知")
                }
            }
        }
    }
}