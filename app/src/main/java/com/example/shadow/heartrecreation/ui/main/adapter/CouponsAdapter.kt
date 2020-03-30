package com.example.shadow.heartrecreation.ui.main.adapter

import android.graphics.Color
import android.support.v7.widget.CardView
import android.widget.CheckBox
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean

class CouponsAdapter(data: MutableList<UserFindBean.DataBean>) : BaseQuickAdapter<UserFindBean.DataBean, BaseViewHolder>(R.layout.item_coupons, data) {
    override fun convert(helper: BaseViewHolder, item: UserFindBean.DataBean) {
        if (item.state==1) {
            helper.setVisible(R.id.couponsNext,true)
                    .setVisible(R.id.couponsState,false)
                    .addOnClickListener(R.id.couponsNext)
            var chick = helper.getView<CheckBox>(R.id.couponsNext)
            if (item.isChick) {
                chick.isChecked = true
                chick.setTextColor(Color.parseColor("#73000000"))
            } else {
                chick.isChecked = false
                chick.setTextColor(Color.parseColor("#fffe849b"))
            }

        }else{
            helper.setVisible(R.id.couponsNext,false)
                    .setVisible(R.id.couponsState,true)
        }
        helper.setText(R.id.couponsMoney,"${item.couponMoney}")
                .setText(R.id.couponsTitle,item.couponName)
                .setText(R.id.couponsTime,"有效期：${item.sendTime}")
        if (item.useCondition!=null&&item.useCondition>0.00){
            helper.setText(R.id.couponsCondition,"大于${item.useCondition}元可用")
                    .setVisible(R.id.couponsCondition,true)
        }else{
            helper.setVisible(R.id.couponsCondition,false)
        }
    }
}