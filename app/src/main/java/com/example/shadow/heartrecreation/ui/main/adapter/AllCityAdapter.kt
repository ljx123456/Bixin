package com.example.shadow.heartrecreation.ui.main.adapter

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean
import com.example.shadow.heartrecreation.view.MyRecyclerView

class AllCityAdapter(citys:MutableList<CityListBean.DataBean.AllCityBean>):BaseQuickAdapter<CityListBean.DataBean.AllCityBean,BaseViewHolder>(R.layout.item_allcity,citys){

    private var clickBack: ClickBack?=null
    override fun convert(helper: BaseViewHolder, item: CityListBean.DataBean.AllCityBean) {
        helper.setText(R.id.item_city_acronym,item.acronym)
        var list=helper.getView<MyRecyclerView>(R.id.item_city_list)
        var cityAdapter=AllCityItemAdapter(item.citys)
        var manager=LinearLayoutManager(mContext)
        manager.orientation=LinearLayout.VERTICAL
        list.layoutManager=manager
        list.adapter=cityAdapter
        cityAdapter.setOnItemClickListener { adapter, view, position ->
            clickBack!!.click(cityAdapter.data[position].cityId,cityAdapter.data[position].cityName)
        }
    }

    public fun setCallBack(clickBack:ClickBack){
        this.clickBack=clickBack
    }

    interface ClickBack{
        fun click(cityId:Int,cityName:String)
    }


}