package com.example.shadow.heartrecreation.ui.main.adapter

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.DrinkUtils.addDrinksNum
import com.example.shadow.heartrecreation.db.DrinkUtils.deleteDrinks
import com.example.shadow.heartrecreation.view.MyRecyclerView


class DialogDrinksGroupAdapter(map:List<ExpListBean>, val clickExpandable: Expandable) : BaseQuickAdapter<ExpListBean, BaseViewHolder>(R.layout.item_group,map){
    override fun convert(helper: BaseViewHolder, item: ExpListBean) {
        helper.setText(R.id.group_name,item.name)
        var itemAdapter=DialogDrinksItemAdapter(item.drink)
        var list=helper.getView<MyRecyclerView>(R.id.group_drinkList)
        var manager= LinearLayoutManager(mContext)
        list.layoutManager=manager
        list.adapter=itemAdapter
        itemAdapter.setOnItemChildClickListener { adapter, view, position ->
            var tv=(view.parent as LinearLayout).findViewById<TextView>(R.id.yueDrinksNum)
            var num=tv.text.toString().toInt()
            when(view.id){
                R.id.yueDrinksSub ->{
                    if (num > 1) {
                        tv.text="${num-1}"
                        addDrinksNum(item.drink[position],tv.text.toString())
                    }else {
//                        if (num<1){
//                            com.example.shadow.heartrecreation.utils.utils.Toast.Tips("数量为0")
//                        }else{
                            deleteDrinks(item.drink[position].id)

//                        }
                    }
                    clickExpandable.ChildClick()
                    itemAdapter.notifyDataSetChanged()
                }
                R.id.yueDrinksAdd ->{
                    tv.text="${num+1}"
                    addDrinksNum(item.drink[position],tv.text.toString())
                    clickExpandable.ChildClick()
                    itemAdapter.notifyDataSetChanged()
                }
            }
        }

    }

    interface Expandable {
        fun ChildClick()

    }

}