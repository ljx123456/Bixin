package com.example.shadow.heartrecreation.ui.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.TakeRecordListBean

class DrinksRecordOneAdapter(val type:Int,data: MutableList<TakeRecordListBean.DataBean>) : BaseQuickAdapter<TakeRecordListBean.DataBean, BaseViewHolder>(R.layout.item_wine_record, data) {
    override fun convert(helper: BaseViewHolder, item: TakeRecordListBean.DataBean) {
        helper.setText(R.id.wineName, item.businessName)

        if (type!=3){
            helper.setText(R.id.wineTime,item.createTime)
        }else{
            helper.setText(R.id.wineTime,item.expireTime)
        }

    }
}