package com.example.shadow.heartrecreation.ui.order.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class FirstPresentAdapter(wines: MutableList<OrderDetailsBean.DataBean.OrderWineBean.FirstWineBean.GiftBean.WinesBean>) : BaseQuickAdapter<OrderDetailsBean.DataBean.OrderWineBean.FirstWineBean.GiftBean.WinesBean, BaseViewHolder>(R.layout.items_dialog_yue_drinks, wines) {
    override fun convert(helper: BaseViewHolder, item: OrderDetailsBean.DataBean.OrderWineBean.FirstWineBean.GiftBean.WinesBean) {
        ImageLoad.setUserHead(item.wineImage, helper.getView(R.id.yueDrinksImage) as RoundedImageView)
        helper.setVisible(R.id.yueDrinksMoney, false)
                .setText(R.id.yueDrinksName, item.wineName)
                .setText(R.id.yueDrinksNum, "x${item.num}")
    }
}