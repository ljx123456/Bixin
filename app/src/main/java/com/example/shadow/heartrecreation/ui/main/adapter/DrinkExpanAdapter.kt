package com.example.shadow.heartrecreation.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class DrinkExpanAdapter(val map: List<ExpListBean>, val mContext: Context) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return map.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[groupPosition].drink.size
    }

    override fun getGroup(groupPosition: Int): ExpListBean {
        return map[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): ExpListBean.DrinkBean {
        return map[groupPosition].drink[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
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
        LogUtils.a("map次数" + "groupPosition:"+groupPosition.toString())
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
        LogUtils.a("次数" + "groupPosition:"+groupPosition.toString()+"childPosition:"+childPosition.toString())
        viewHolder.yueDrinksMoney!!.text = "¥:${getChild(groupPosition,childPosition).drinkMoney}"
        viewHolder.yueDrinksName!!.text = getChild(groupPosition,childPosition).drinkName
        viewHolder.yueDrinksNum!!.text = "x${getChild(groupPosition,childPosition).drinkNum}"
        ImageLoad.setImage(getChild(groupPosition,childPosition).drinkImage, viewHolder.yueDrinksImage!!)
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