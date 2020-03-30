package com.example.shadow.heartrecreation.ui.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R

class BrokerHistoryAdapter(string: ArrayList<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_broker_history, string) {
    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.itemText, item)
    }

}