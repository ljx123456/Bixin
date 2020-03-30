package com.example.shadow.heartrecreation.ui.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean

class DiscountAdapter(data: MutableList<UserFindBean.DataBean>) :BaseQuickAdapter<UserFindBean.DataBean,BaseViewHolder>(R.layout.item_discount,data) {
    override fun convert(helper: BaseViewHolder, item: UserFindBean.DataBean) {
        helper.setText(R.id.couponMoney,"${item.couponMoney}")
                .setText(R.id.couponTitle,item.couponName)
                .setText(R.id.couponTime,"有效期：${item.sendTime}")
        if (item.useCondition!=null&&item.useCondition>0.00){
            helper.setText(R.id.couponCondition,"大于${item.useCondition}元可用")
                    .setVisible(R.id.couponCondition,true)
        }else{
            helper.setVisible(R.id.couponCondition,false)
        }
    }
}