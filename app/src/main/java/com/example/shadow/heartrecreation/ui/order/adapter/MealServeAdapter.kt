package com.example.shadow.heartrecreation.ui.order.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class MealServeAdapter(data: MutableList<OrderDetailsBean.DataBean.ServiceUsersBean>) : BaseQuickAdapter<OrderDetailsBean.DataBean.ServiceUsersBean, BaseViewHolder>(R.layout.item_meal_serve, data) {
    override fun convert(helper: BaseViewHolder, item: OrderDetailsBean.DataBean.ServiceUsersBean) {
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.mealServeImage) as RoundedImageView)
        helper.setText(R.id.searchName, item.nickname)
                .setText(R.id.searchAge, "${item.age}")

        var sex = helper.getView<TextView>(R.id.searchAge)
        UIUtils.setAgeUtils(sex, item.sex, item.age)
        if (item.occupation!=null&&item.occupation!=""){
            helper.setVisible(R.id.searchJoin,true)
                    .setText(R.id.searchJoin, item.occupation)
        }else{
            helper.setVisible(R.id.searchJoin,false)
        }
//        when (item.sex) {
//            1 -> sex.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//            else -> sex.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//        }
        helper.addOnClickListener(R.id.mealServeCheck)
        helper.setChecked(R.id.mealServeCheck, item.isType)
    }
}