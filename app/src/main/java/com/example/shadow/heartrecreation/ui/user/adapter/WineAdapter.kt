package com.example.shadow.heartrecreation.ui.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.WineBean

class WineAdapter(list: MutableList<WineBean.DataBean>) : BaseQuickAdapter<WineBean.DataBean, BaseViewHolder>(R.layout.item_wine, list) {
    override fun convert(helper: BaseViewHolder, item: WineBean.DataBean) {
        helper.setText(R.id.wineName, item.businessName)
                .setText(R.id.isWineSurplus,item.isWineSurplus)
    }
}