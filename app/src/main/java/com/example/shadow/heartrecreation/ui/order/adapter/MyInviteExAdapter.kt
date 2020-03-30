package com.example.shadow.heartrecreation.ui.order.adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Click
import com.makeramen.roundedimageview.RoundedImageView

class MyInviteExAdapter(val list: List<OrderServicesBean.DataBean>, val mContext: Context, val myinviteex: MyInviteEx) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any? = null
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true
    override fun hasStableIds(): Boolean = true
    override fun getChildrenCount(groupPosition: Int): Int = list.get(groupPosition).serviceUsers.size
    override fun getChild(groupPosition: Int, childPosition: Int): Any = list.get(groupPosition).serviceUsers.get(childPosition)
    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()
    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()
    override fun getGroupCount(): Int = list.size
    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val childviewholder: ChildViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_my_invite, parent, false)
            childviewholder = ChildViewHolder()
            childviewholder.inviteImage = convertView!!.findViewById(R.id.inviteImage)
            childviewholder.inviteName = convertView!!.findViewById(R.id.inviteName)
            childviewholder.inviteAge = convertView!!.findViewById(R.id.inviteAge)
            childviewholder.inviteJoin = convertView!!.findViewById(R.id.inviteJoin)
            childviewholder.inviteMoney = convertView!!.findViewById(R.id.inviteMoney)
            childviewholder.inviteType = convertView!!.findViewById(R.id.inviteType)
            childviewholder.inviteImageOver = convertView!!.findViewById(R.id.inviteImageOver)
            childviewholder.inviteOver = convertView!!.findViewById(R.id.inviteImageOver)
            convertView!!.tag = childviewholder
        } else {
            childviewholder = convertView!!.tag as ChildViewHolder
        }
        var data = list.get(groupPosition).serviceUsers.get(childPosition)
        var state = ""
        //服务状态：0 等待商家确认，1 未接单，2 支付失败，3已接单/未付款，4 已付款，5 到场，6 开始服务，
        // 7 结束服务，8 超时，9 用户取消，10 服务人员拒绝，11 服务人员繁忙
        when (data.serviceState) {
            0 -> state = "等待商家确认"
            1 -> state = "接单超时"
            2 -> state = "支付失败"
            3 -> state = "等待付款"
            4 -> state = "已付款"
            5 -> state = "到场"
            6 -> state = "开始服务"
            7 -> state = "结束服务"
            8 -> state = "接单超时"
            9 -> state = "用户取消"
            10 -> state = "服务人员拒绝"
            11 -> state = "邀约已满"
        }
        //约玩邀请中、等待付款、取消原因：距离太远、邀约已满、接单超时、付款超时、已被约、已下线
        childviewholder.inviteType!!.text = state
        when (data.serviceState) {
            11 -> {
                childviewholder.inviteType!!.text = data.description
                childviewholder.inviteOver!!.visibility = View.VISIBLE
                childviewholder.inviteImageOver!!.visibility = View.VISIBLE
            }
            10 -> {
                childviewholder.inviteType!!.text = data.description
                childviewholder.inviteOver!!.visibility = View.VISIBLE
                childviewholder.inviteImageOver!!.visibility = View.VISIBLE
            }
            else -> {
                childviewholder.inviteType!!.text = state
                childviewholder.inviteOver!!.visibility = View.GONE
                childviewholder.inviteImageOver!!.visibility = View.GONE
            }
        }



        Click.viewClick(childviewholder.inviteOver!!).subscribe {
            myinviteex.DelPositionData(list.get(groupPosition).listId, data.serviceUserId)
        }
        ImageLoad.setUserHead(data.avatar, childviewholder.inviteImage as RoundedImageView)
        childviewholder.inviteName!!.text = data.nickname
        UIUtils.setAgeUtils(childviewholder.inviteAge!!, data.sex, data.age)
        childviewholder.inviteJoin!!.text = data.occupation
        return convertView
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val groupviewholder: GroupViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_mian_server, parent, false)
            groupviewholder = GroupViewHolder()
            groupviewholder.itemMainText = convertView!!.findViewById(R.id.itemMainText)
            groupviewholder.myInviteNum = convertView!!.findViewById(R.id.myInviteNum)
            groupviewholder.orderPeopleNum = convertView!!.findViewById(R.id.orderPeopleNum)
            groupviewholder.itemMainNum = convertView!!.findViewById(R.id.itemMainNum)
            convertView!!.tag = groupviewholder
        } else {
            groupviewholder = convertView!!.tag as GroupViewHolder
        }
        if (groupPosition == 0) {
            groupviewholder.itemMainNum!!.visibility = View.GONE
        } else {
            groupviewholder.itemMainNum!!.visibility = View.VISIBLE
            groupviewholder.itemMainNum!!.text = "${groupPosition + 1}"
        }
        groupviewholder.myInviteNum!!.text = "(${list.get(groupPosition).orderTakingNum}/${list.get(groupPosition).serviceUserNum})"
        Click.viewClick(groupviewholder.orderPeopleNum!!).subscribe {
            ShowDialog.showCustomDialogs(mContext, "是否删除已邀请信息?", "清空", "取消", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            dialog.dismiss()
//                            presenter.getDelServices(DelServicesBody("${data.data.listId}"))
                            myinviteex.DelGtoupData(list.get(groupPosition).listId)
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            })
        }
        return convertView
    }

    internal inner class GroupViewHolder {
        var itemMainText: TextView? = null
        var myInviteNum: TextView? = null
        var orderPeopleNum: TextView? = null
        var itemMainNum: TextView? = null
    }

    internal inner class ChildViewHolder {
        var inviteImage: RoundedImageView? = null
        var inviteName: TextView? = null
        var inviteAge: TextView? = null
        var inviteJoin: TextView? = null
        var inviteMoney: TextView? = null
        var inviteType: TextView? = null
        var inviteImageOver: ImageView? = null
        var inviteOver: ImageView? = null
    }

    interface MyInviteEx {
        fun DelGtoupData(listId: Int)
        fun DelPositionData(listId: Int, serviceUserId: Int)
    }
}
