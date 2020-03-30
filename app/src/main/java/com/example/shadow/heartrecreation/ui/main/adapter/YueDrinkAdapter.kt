package com.example.shadow.heartrecreation.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.DrinkUtils.addDrinksNum
import com.example.shadow.heartrecreation.db.DrinkUtils.deleteDrinks
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView
import java.math.BigDecimal

class YueDrinkAdapter(val map: List<ExpListBean>, val mContext: Context, val clickExpandable: Expandable) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return map.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[groupPosition].drink.size
    }

    override fun getGroup(groupPosition: Int): Any? {
        return null
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[groupPosition].drink[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: GroupViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_group, parent, false)
            viewHolder = GroupViewHolder()
            viewHolder.textname = convertView!!.findViewById(R.id.group_name)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as GroupViewHolder
        }
        viewHolder.textname!!.text = map[groupPosition].name

        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ChildViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_yue_drinks, parent, false)
            viewHolder = ChildViewHolder()
            viewHolder.yueDrinksImage = convertView!!.findViewById(R.id.yueDrinksImage)
            viewHolder.yueDrinksAdd = convertView.findViewById(R.id.yueDrinksAdd)
            viewHolder.yueDrinksMoney = convertView.findViewById(R.id.yueDrinksMoney)
            viewHolder.yueDrinksName = convertView.findViewById(R.id.yueDrinksName)
            viewHolder.yueDrinksSub = convertView.findViewById(R.id.yueDrinksSub)
            viewHolder.yueDrinksNum = convertView.findViewById(R.id.yueDrinksNum)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ChildViewHolder
        }
        viewHolder.yueDrinksMoney!!.text = "¥"+map[groupPosition].drink[childPosition].drinkMoney.toBigDecimal().multiply(map[groupPosition].drink[childPosition].drinkNum.toBigDecimal()).setScale(2, BigDecimal.ROUND_HALF_UP).toString()
        viewHolder.yueDrinksName!!.text = map[groupPosition].drink[childPosition].drinkName
        viewHolder.yueDrinksNum!!.text = map[groupPosition].drink[childPosition].drinkNum
        ImageLoad.setImage(map[groupPosition].drink[childPosition].drinkImage, viewHolder.yueDrinksImage!!)
        Click.viewClick(viewHolder.yueDrinksAdd!!).subscribe {
            val num = Integer.valueOf(viewHolder.yueDrinksNum!!.text.toString())
            viewHolder.yueDrinksNum!!.text = "${num + 1}"
            addDrinksNum(map[groupPosition].drink[childPosition], viewHolder.yueDrinksNum!!.text.toString())
            clickExpandable.ChildClick()
            notifyDataSetChanged()
        }
        Click.viewClick(viewHolder.yueDrinksSub!!).subscribe {
            val num = Integer.valueOf(viewHolder.yueDrinksNum!!.text.toString())
            if (num <= 1&&num>0) {
                deleteDrinks(map[groupPosition].drink[childPosition].id)
                notifyDataSetInvalidated()
//                notifyDataSetChanged()
            } else {
                viewHolder.yueDrinksNum!!.text = "${num - 1}"
                addDrinksNum(map[groupPosition].drink[childPosition], viewHolder.yueDrinksNum!!.text.toString())
                notifyDataSetChanged()
            }
            clickExpandable.ChildClick()
        }
        return convertView
    }

    internal inner class GroupViewHolder {
        var textname: TextView? = null
    }

    internal inner class ChildViewHolder {
        var yueDrinksImage: RoundedImageView? = null
        var yueDrinksName: TextView? = null
        var yueDrinksMoney: TextView? = null
        var yueDrinksSub: ImageView? = null
        var yueDrinksAdd: ImageView? = null
        var yueDrinksNum: TextView? = null
    }

    interface Expandable {
        fun ChildClick()

    }
}