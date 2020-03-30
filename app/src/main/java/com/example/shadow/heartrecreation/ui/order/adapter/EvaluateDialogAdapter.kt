package com.example.shadow.heartrecreation.ui.order.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateModel
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.example.shadow.heartrecreation.view.SpaceItemDecoration

class EvaluateDialogAdapter(dataInfo: ArrayList<EvaluateModel>, var evaluateOne: ArrayList<String>, val evaluateclick: EvaluateClick) : BaseQuickAdapter<EvaluateModel, BaseViewHolder>(R.layout.item_evaluate_dialog, dataInfo) {
    override fun convert(helper: BaseViewHolder, item: EvaluateModel) {
        helper.setText(R.id.evaluateTitle, item.name)
                .addOnClickListener(R.id.evaluateMultiLine)
        var itemAdapter = EvaluateItemAdapter(item.list,evaluateOne)
        var reList = helper.getView(R.id.itemItemList) as RecyclerView
        var manager = GridLayoutManager(mContext, 5)
        reList.layoutManager = manager
        var itemDecoration = SpaceItemDecoration()
        itemDecoration.setItemSize(5)
        reList.addItemDecoration(itemDecoration)
        reList.adapter = itemAdapter
        itemAdapter.setOnItemChildClickListener { adapter, view, position ->
            if (evaluateOne.size >= 5) {
                Toast.Tips("最多只能选择5个标签")
                for (i in itemAdapter.data.indices) {
                    if (itemAdapter.data.get(position).chack) {
                        itemAdapter.data.get(position).chack = false
                    }
                }
                itemAdapter.notifyDataSetChanged()
                evaluateclick.setOnItemClickListerOne(itemAdapter.data.get(position))
            } else {
                evaluateclick.setOnItemClickListerOne(itemAdapter.data.get(position))
            }

        }
    }
}