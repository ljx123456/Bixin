package com.example.shadow.heartrecreation.ui.user.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BusinessBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class WineDetailsAdapter(val winesInfo: MutableList<BusinessBean.DataBean.WineInfoBean>, val mContext: Context) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any = null!!

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = false

    override fun hasStableIds(): Boolean = true

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun getGroupCount(): Int = winesInfo.size

    override fun getChildrenCount(groupPosition: Int): Int {
        return winesInfo.get(groupPosition).wines.size
    }


    override fun getChild(groupPosition: Int, childPosition: Int): Any = winesInfo.get(groupPosition).wines.get(childPosition)

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder: ChildViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_dialog_yue_drinks, parent, false)
            viewHolder = ChildViewHolder()
            viewHolder.yueDrinksImage = convertView!!.findViewById(R.id.yueDrinksImage)
            viewHolder.yueDrinksMoney = convertView.findViewById(R.id.yueDrinksMoney)
            viewHolder.yueDrinksName = convertView.findViewById(R.id.yueDrinksName)
            viewHolder.yueDrinksNum = convertView.findViewById(R.id.yueDrinksNum)
            viewHolder.yueDrinksMl = convertView.findViewById(R.id.yueDrinksMl)
            viewHolder.yueDrinksTime = convertView.findViewById(R.id.yueDrinksTime)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ChildViewHolder
        }
        var info = winesInfo.get(groupPosition).wines.get(childPosition)
        viewHolder.yueDrinksMoney!!.text = "¥:${info.wineSurplus}"
        viewHolder.yueDrinksName!!.text = info.wineName
        viewHolder.yueDrinksNum!!.text = "x${info.wineSurplus}${info.wineUnit}"
        viewHolder.yueDrinksMl!!.text = "${info.wineSpecifications}/${info.wineUnit}"
        if (info.state == 2) {
            viewHolder.yueDrinksTime!!.setTextColor(Color.parseColor("#FF6464"))
        } else {
            viewHolder.yueDrinksTime!!.setTextColor(Color.parseColor("#999999"))
        }
        viewHolder.yueDrinksTime!!.text = "剩余有效期:${info.surplusTime}"

        ImageLoad.setImage(info.wineAvatar, viewHolder.yueDrinksImage!!)
        return convertView
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder: GroupViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_group, parent, false)
            viewHolder = GroupViewHolder()
            viewHolder.textname = convertView!!.findViewById(R.id.group_name)
            viewHolder.groupView = convertView!!.findViewById(R.id.groupView)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as GroupViewHolder
        }
        viewHolder.textname!!.text = winesInfo.get(groupPosition).wineTypeName
        viewHolder.groupView!!.visibility = View.GONE

        return convertView
    }

    internal inner class GroupViewHolder {
        var textname: TextView? = null
        var groupView: View? = null
    }

    internal inner class ChildViewHolder {
        var yueDrinksImage: RoundedImageView? = null
        var yueDrinksName: TextView? = null
        var yueDrinksMoney: TextView? = null
        var yueDrinksNum: TextView? = null
        var yueDrinksMl: TextView? = null
        var yueDrinksTime: TextView? = null
    }


}