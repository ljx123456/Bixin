package com.example.shadow.heartrecreation.ui.user.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordDetailsOneBean

class RecordDetailsOneAdapter(wines: MutableList<RecordDetailsOneBean.DataBean.WineInfoBean>) : BaseQuickAdapter<RecordDetailsOneBean.DataBean.WineInfoBean, BaseViewHolder>(R.layout.item_record_one, wines) {
    override fun convert(helper: BaseViewHolder, item: RecordDetailsOneBean.DataBean.WineInfoBean) {
        helper.setText(R.id.recordOneName, item.wineTypeName)
                .setText(R.id.recordOneTime, "有效期："+item.wineTypeStorageTime)
        var list = helper.getView(R.id.recordOneList) as RecyclerView
        var listAdapter = RecordListAdapter(item.wines)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        list.layoutManager = manager
        list.adapter = listAdapter
    }
}