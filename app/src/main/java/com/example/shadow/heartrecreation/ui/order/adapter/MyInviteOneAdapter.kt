package com.example.shadow.heartrecreation.ui.order.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.utils.utils.Click

class MyInviteOneAdapter(data: MutableList<OrderServicesBean.DataBean>, val myinvite: MyInvite) : BaseQuickAdapter<OrderServicesBean.DataBean, BaseViewHolder>(R.layout.item_mian_server, data),MyInviteAdapter.finshCallBack {
    override fun finsh() {
        myinvite.finsh()
    }

    override fun convert(helper: BaseViewHolder, item: OrderServicesBean.DataBean) {
        if (helper.position == 0) {
            helper.setVisible(R.id.itemMainNum, false)
        } else {
            helper.setVisible(R.id.itemMainNum, true)
            helper.setText(R.id.itemMainNum, "${helper.position + 1}")
        }
        helper.setText(R.id.myInviteNum, "(${item.orderTakingNum}/${item.serviceUserNum})")
        helper.addOnClickListener(R.id.orderPeopleNum)
        var myInvite = MyInviteAdapter(item.serviceUsers)
        var listview = helper.getView(R.id.myInviteList) as RecyclerView
        var manager = LinearLayoutManager(mContext)
        listview.layoutManager = manager
        listview.adapter = myInvite
        myInvite.setCallBack(this)
        var myInviteBtn = helper.getView(R.id.myInviteBtn) as TextView
        Click.viewClick(myInviteBtn).subscribe {
            if (listview.visibility == View.GONE) {
                listview.visibility = View.VISIBLE
                myInviteBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, mContext.getDrawable(R.mipmap.double_more_button_top))
            } else {
                listview.visibility = View.GONE
                myInviteBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, mContext.getDrawable(R.mipmap.double_more_button_down))
            }

        }
        myInvite.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.inviteImageOver -> {
                    myinvite.setDelPositionData(myInvite.data.get(position).serviceUserId)
                }
            }
        }
    }

    interface MyInvite {
        fun setDelPositionData(serviceUserId: Int)
        fun finsh()
    }
}