package com.example.shadow.heartrecreation.ui.user.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordBean

class ExpireAdapter(data: MutableList<ExpireRecordBean.DataBean>) : BaseQuickAdapter<ExpireRecordBean.DataBean, BaseViewHolder>(R.layout.item_expire, data) {
    override fun convert(helper: BaseViewHolder, item: ExpireRecordBean.DataBean) {
        helper.setText(R.id.oneName, item.storageTime)
                .setImageResource(R.id.oneImage, if (item.isExpanded) R.mipmap.more_down_black else R.mipmap.more_top)
                .addOnClickListener(R.id.oneLayout)
                .setVisible(R.id.recordGroupList, item.isExpanded)
                .setVisible(R.id.oneLinearLayout, item.isExpanded)
                .setText(R.id.oneOverTime, "存酒时间：${item.expireTime}")
        var list = helper.getView(R.id.recordGroupList) as RecyclerView
        var expiretwoadapter = ExpireTwoAdapter(item.wineInfo)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        list.layoutManager = manager
        list.adapter = expiretwoadapter
    }
}

class ExpireTwoAdapter(wineInfo: MutableList<ExpireRecordBean.DataBean.WineInfoBean>) : BaseQuickAdapter<ExpireRecordBean.DataBean.WineInfoBean, BaseViewHolder>(R.layout.item_record_three, wineInfo) {
    override fun convert(helper: BaseViewHolder, item: ExpireRecordBean.DataBean.WineInfoBean) {
        helper.setText(R.id.threeName, item.wineName)
                .setText(R.id.threeMl, "${item.wineSpecifications}/${item.wineUnit}")
                .setText(R.id.threeNum, "x${item.wineNum}${item.wineUnit}")
    }
}

