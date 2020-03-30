package com.example.shadow.heartrecreation.ui.user.adapter

import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class RefundAdapter : BaseQuickAdapter<RefundBean.DataBean, BaseViewHolder> {
    override fun convert(helper: BaseViewHolder, item: RefundBean.DataBean) {
        when (item.refundType) {
            0 -> {//商家
                helper.setVisible(R.id.refundAge, false).setVisible(R.id.refundJoin, false).setText(R.id.refundOne, "联系我们").setVisible(R.id.refundOne, true)
                        .setText(R.id.brokerName, item.businessName)//名称
            }
            else -> {//服务人员
                helper.setVisible(R.id.refundAge, true).setVisible(R.id.refundJoin, true).setVisible(R.id.refundOne, false)
                        .setText(R.id.brokerName, item.serviceName)//名称
                        .setText(R.id.refundAge, "${item.age}")//年龄

                if (item.occupation!=null&&item.occupation!=""){
                    helper.setVisible(R.id.refundJoin,true)
                            .setText(R.id.refundJoin, "${item.occupation}")//律师
                }else{
                    helper.setVisible(R.id.refundJoin,false)
                }
                var sex = helper.getView<TextView>(R.id.refundAge)
                UIUtils.setAgeUtils(sex,item.sex,item.age.toString())
//                when (item.sex) {
//                    1 -> sex.setCompoundDrawablesRelativeWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//                    2 -> sex.setCompoundDrawablesRelativeWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//                }
            }
        }
        helper.addOnClickListener(R.id.refundTwo)
                .addOnClickListener(R.id.refundOne)
                .setText(R.id.refundMoney, "${item.refundPrice}")//退款价格
                .setText(R.id.refundZongMoney, "实付金额¥:${item.payPrice}")//付款金额
                .setText(R.id.refundOrderNum, "订单号:${item.orderNo}")
        when (item.refundState) {
            0 -> helper.setText(R.id.refundType, "发起退款")
            1 -> helper.setText(R.id.refundType, "退款中")
            2 -> helper.setText(R.id.refundType, "退款成功")
            3 -> helper.setText(R.id.refundType, "退款失败")
        }
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.brokerImage) as RoundedImageView)
    }

    constructor(list: MutableList<RefundBean.DataBean>) : super(R.layout.item_refund, list)
}