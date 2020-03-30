package com.example.shadow.heartrecreation.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean

class AllCityItemAdapter(citys:MutableList<CityListBean.DataBean.AllCityBean.CitysBeanX>):BaseQuickAdapter<CityListBean.DataBean.AllCityBean.CitysBeanX,BaseViewHolder>(R.layout.item_allcity_city,citys){
    override fun convert(helper: BaseViewHolder, item: CityListBean.DataBean.AllCityBean.CitysBeanX) {
        helper.setText(R.id.item_city,item.cityName)
    }
}