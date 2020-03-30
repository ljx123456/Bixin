package com.example.shadow.heartrecreation.ui.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordDetailsOneBean

class RecordListAdapter(wines: MutableList<RecordDetailsOneBean.DataBean.WineInfoBean.WinesBean>) : BaseQuickAdapter<RecordDetailsOneBean.DataBean.WineInfoBean.WinesBean, BaseViewHolder>(R.layout.item_record_list, wines) {
    override fun convert(helper: BaseViewHolder, item: RecordDetailsOneBean.DataBean.WineInfoBean.WinesBean) {
        helper.setText(R.id.recordListName, item.wineName).setText(R.id.recordListML, "${item.wineSpecifications}/${item.wineUnit}")
                .setText(R.id.recordListNum, "x${item.wineNum}${item.wineUnit}")
    }
}