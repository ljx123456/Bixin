package com.example.shadow.heartrecreation.ui.order.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ReasonBean

class ReasonAdapter(reason:MutableList<ReasonBean.DataBean>):BaseQuickAdapter<ReasonBean.DataBean,BaseViewHolder>(R.layout.item_reason,reason){
    override fun convert(helper: BaseViewHolder, item: ReasonBean.DataBean) {
        helper.setText(R.id.item_reason_content,item.describe)
                .addOnClickListener(R.id.item_reason_check)
                .setChecked(R.id.item_reason_check, item.isFlag)
    }

}