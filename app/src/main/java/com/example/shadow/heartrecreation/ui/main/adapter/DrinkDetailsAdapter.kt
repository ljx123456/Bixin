package com.example.shadow.heartrecreation.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinkDetailsBean

class DrinkDetailsAdapter(data: MutableList<DrinkDetailsBean.DataBean.WineDetailsInfoBean>) : BaseQuickAdapter<DrinkDetailsBean.DataBean.WineDetailsInfoBean, BaseViewHolder>(R.layout.item_dialog_drink_details, data) {
    override fun convert(helper: BaseViewHolder, item: DrinkDetailsBean.DataBean.WineDetailsInfoBean) {
        var s=""
        if (item.businessWineSpecifications!=null)
            s=item.businessWineSpecifications
        helper.setText(R.id.drinkName, item.wineName)
                .setText(R.id.drinkMoney, "x${item.wineNum}")
                .setText(R.id.drinkContent,s+"/"+item.businessWineUnit)
    }
}