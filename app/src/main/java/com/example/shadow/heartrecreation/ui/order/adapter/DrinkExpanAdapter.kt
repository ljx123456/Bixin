package com.example.shadow.heartrecreation.ui.order.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView
import java.math.BigDecimal

class DrinkExpanAdapter(val map: List<ExpListBean>, val mContext: Context) : BaseExpandableListAdapter() {

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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.items_dialog_yue_drinks, parent, false)
            viewHolder = ChildViewHolder()
            viewHolder.yueDrinksImage = convertView!!.findViewById(R.id.yueDrinksImage)
            viewHolder.yueDrinksMoney = convertView.findViewById(R.id.yueDrinksMoney)
            viewHolder.yueDrinksName = convertView.findViewById(R.id.yueDrinksName)
            viewHolder.yueDrinksNum = convertView.findViewById(R.id.yueDrinksNum)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ChildViewHolder
        }
        viewHolder.yueDrinksMoney!!.text = "¥:"+BigDecimal(map[groupPosition].drink[childPosition].drinkMoney).setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        viewHolder.yueDrinksName!!.text = map[groupPosition].drink[childPosition].drinkName
        viewHolder.yueDrinksNum!!.text = "x${map[groupPosition].drink[childPosition].drinkNum}"
        ImageLoad.setImage(map[groupPosition].drink[childPosition].drinkImage, viewHolder.yueDrinksImage!!)
        return convertView
    }

    internal inner class GroupViewHolder {
        var textname: TextView? = null
    }

    internal inner class ChildViewHolder {
        var yueDrinksImage: RoundedImageView? = null
        var yueDrinksName: TextView? = null
        var yueDrinksMoney: TextView? = null
        var yueDrinksNum: TextView? = null
    }

}