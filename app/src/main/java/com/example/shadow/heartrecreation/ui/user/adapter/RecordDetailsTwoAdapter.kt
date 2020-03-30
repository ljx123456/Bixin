package com.example.shadow.heartrecreation.ui.user.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordInfoBean

class RecordDetailsTwoAdapter(winesInfo: MutableList<RecordInfoBean.DataBean.WineInfoBean>) : BaseQuickAdapter<RecordInfoBean.DataBean.WineInfoBean, BaseViewHolder>(R.layout.item_record_one, winesInfo) {
    override fun convert(helper: BaseViewHolder, item: RecordInfoBean.DataBean.WineInfoBean) {
        helper.setText(R.id.recordOneName, item.wineTypeName)
        var list = helper.getView(R.id.recordOneList) as RecyclerView
        var dAdapter = DetailsAdapter(item.wines)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        list.layoutManager = manager
        list.adapter = dAdapter
    }
}

class DetailsAdapter(wines: MutableList<RecordInfoBean.DataBean.WineInfoBean.WinesBean>) : BaseQuickAdapter<RecordInfoBean.DataBean.WineInfoBean.WinesBean, BaseViewHolder>(R.layout.item_record_list, wines) {
    override fun convert(helper: BaseViewHolder, item: RecordInfoBean.DataBean.WineInfoBean.WinesBean) {
        helper.setText(R.id.recordListName, item.wineName).setText(R.id.recordListML, "${item.wineSpecifications}/${item.wineUnit}")
                .setText(R.id.recordListNum, "x${item.wineNum}${item.wineUnit}")
    }
}