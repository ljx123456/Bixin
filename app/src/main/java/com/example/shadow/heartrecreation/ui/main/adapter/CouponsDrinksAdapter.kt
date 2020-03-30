package com.example.shadow.heartrecreation.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView
import java.math.BigDecimal

class CouponsDrinksAdapter(map:List<ExpListBean.DrinkBean>) :BaseQuickAdapter<ExpListBean.DrinkBean,BaseViewHolder>(R.layout.items_dialog_yue_drinks,map){
    override fun convert(helper: BaseViewHolder, item: ExpListBean.DrinkBean) {
        ImageLoad.setUserHead(item.drinkImage,helper.getView(R.id.yueDrinksImage) as RoundedImageView)
        helper.setText(R.id.yueDrinksMoney,"¥:"+(BigDecimal(item.drinkMoney).multiply(BigDecimal(item.drinkNum))).setScale(2,BigDecimal.ROUND_HALF_UP).toString())
                .setText(R.id.yueDrinksName,item.drinkName)
                .setText(R.id.yueDrinksNum,"x"+item.drinkNum)

    }

}