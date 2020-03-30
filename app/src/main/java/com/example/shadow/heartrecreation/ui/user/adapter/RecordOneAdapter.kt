package com.example.shadow.heartrecreation.ui.user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.StorageRecordBean

class RecordOneAdapter(val data: MutableList<StorageRecordBean.DataBean>, val mContext: Context) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any = null!!

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = false

    override fun hasStableIds(): Boolean = true

    override fun getChildrenCount(groupPosition: Int): Int = data.get(groupPosition).wineInfo.size

    override fun getChild(groupPosition: Int, childPosition: Int): Any = data.get(groupPosition).wineInfo.get(childPosition)

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun getGroupCount(): Int = data.size

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder: GroupViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_record_group, parent, false)
            viewHolder = GroupViewHolder()
            viewHolder.oneName = convertView!!.findViewById(R.id.oneName)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as GroupViewHolder
        }
        viewHolder.oneName!!.text = data.get(groupPosition).createTime
        return convertView!!
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder: ChildViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_record_child, parent, false)
            viewHolder = ChildViewHolder()
            viewHolder.recordChildName = convertView!!.findViewById(R.id.recordChildName)
            viewHolder.recordChildTime = convertView!!.findViewById(R.id.recordChildTime)
            viewHolder.recordChildList = convertView!!.findViewById(R.id.recordChildList)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ChildViewHolder
        }
        viewHolder.recordChildName!!.text = data.get(groupPosition).wineInfo.get(childPosition).wineTypeName
        viewHolder.recordChildTime!!.text = data.get(groupPosition).wineInfo.get(childPosition).wineTypeStorageTime

        return convertView!!
    }

    internal inner class GroupViewHolder {
        var oneName: TextView? = null
    }

    internal inner class ChildViewHolder {
        var recordChildName: TextView? = null
        var recordChildTime: TextView? = null
        var recordChildList: RecyclerView? = null

    }
}