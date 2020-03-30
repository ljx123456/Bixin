package com.example.shadow.heartrecreation.ui.user.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.StorageRecordBean

class RecordAdapter(data: MutableList<StorageRecordBean.DataBean>) : BaseQuickAdapter<StorageRecordBean.DataBean, BaseViewHolder>(R.layout.item_record_group, data) {
    override fun convert(helper: BaseViewHolder, item: StorageRecordBean.DataBean) {
        helper.setText(R.id.oneName, item.createTime)
                .setImageResource(R.id.oneImage, if (item.isExpanded) R.mipmap.more_down_black else R.mipmap.more_top)
                .addOnClickListener(R.id.oneLayout)
        helper.setVisible(R.id.recordGroupList, item.isExpanded)
        var list = helper.getView(R.id.recordGroupList) as RecyclerView
        var twoAdapter = RecordTwoAdapter(item.wineInfo)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        list.layoutManager = manager
        list.adapter = twoAdapter
    }
}

class RecordTwoAdapter(wineInfo: MutableList<StorageRecordBean.DataBean.WineInfoBean>) : BaseQuickAdapter<StorageRecordBean.DataBean.WineInfoBean, BaseViewHolder>(R.layout.item_record_child, wineInfo) {
    override fun convert(helper: BaseViewHolder, item: StorageRecordBean.DataBean.WineInfoBean) {
        helper.setText(R.id.recordChildName, item.wineTypeName)
        if ("".equals(item.wineTypeStorageTime)) {
            helper.setText(R.id.recordChildTime, "")
        } else {
            helper.setText(R.id.recordChildTime, "有效期:${item.wineTypeStorageTime}")
        }
        var listView = helper.getView(R.id.recordChildList) as RecyclerView
        var threeAdapter = RecordThreeAdapter(item.wines)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        listView.layoutManager = manager
        listView.adapter = threeAdapter
    }
}

class RecordThreeAdapter(wines: MutableList<StorageRecordBean.DataBean.WineInfoBean.WinesBean>) : BaseQuickAdapter<StorageRecordBean.DataBean.WineInfoBean.WinesBean, BaseViewHolder>(R.layout.item_record_three, wines) {
    override fun convert(helper: BaseViewHolder, item: StorageRecordBean.DataBean.WineInfoBean.WinesBean) {
        helper.setText(R.id.threeName, item.wineName)
                .setText(R.id.threeMl, "${item.wineSpecifications}/${item.wineUnit}")
                .setText(R.id.threeNum, "x${item.wineNum}${item.wineUnit}")
        if ("".equals(item.wineSurplusTime)) {
            helper.setText(R.id.threeDay, "")
        } else {
            helper.setText(R.id.threeDay, " (剩余天数${item.wineSurplusTime})")
        }
    }
}

