package com.example.shadow.heartrecreation.ui.main.adapter

import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean

class SetCityAdapter(data: MutableList<CityListBean.DataBean.CitysBean>) : BaseQuickAdapter<CityListBean.DataBean.CitysBean, BaseViewHolder>(R.layout.item_set_city, data) {
    override fun convert(helper: BaseViewHolder, item: CityListBean.DataBean.CitysBean) {

        if (item.isFlag){
            helper.setBackgroundRes(R.id.itemHotCity,R.drawable.city_bg)
                    .setTextColor(R.id.itemHotCity,Color.parseColor("#ffffff"))
                    .setText(R.id.itemHotCity, item.cityName)
        }else {
            helper.setBackgroundRes(R.id.itemHotCity,R.drawable.filtreate_off_shape)
                    .setTextColor(R.id.itemHotCity,Color.parseColor("#999999"))
                    .setText(R.id.itemHotCity, item.cityName)
        }
    }
}