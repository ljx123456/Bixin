package com.example.shadow.heartrecreation.ui.main.adapter

import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.view.MyRecyclerView

class CouponsDrinksGroupAdapter(map:List<ExpListBean>) :BaseQuickAdapter<ExpListBean,BaseViewHolder>(R.layout.item_group,map){
    override fun convert(helper: BaseViewHolder, item: ExpListBean) {
        helper.setText(R.id.group_name,item.name)
        var itemAdapter=CouponsDrinksAdapter(item.drink)
        var list=helper.getView<MyRecyclerView>(R.id.group_drinkList)
        var manager=LinearLayoutManager(mContext)
        list.layoutManager=manager
        list.adapter=itemAdapter
    }

}