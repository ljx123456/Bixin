package com.example.shadow.heartrecreation.ui.order.adapter

import android.widget.CheckBox
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateTagModel
import com.example.shadow.heartrecreation.utils.utils.Click

class EvaluateItemAdapter(list: List<EvaluateTagModel>, var evaluateOne: ArrayList<String>) : BaseQuickAdapter<EvaluateTagModel, BaseViewHolder>(R.layout.item_evaluate_item, list) {
    override fun convert(helper: BaseViewHolder, item: EvaluateTagModel) {
        helper.setText(R.id.evaluateCheck, item.tagName)
                .addOnClickListener(R.id.evaluateCheck)
        if (item.chack) helper.setChecked(R.id.evaluateCheck, true)
        else helper.setChecked(R.id.evaluateCheck, false)
//        var check = helper.getView(R.id.evaluateCheck) as CheckBox
//        Click.viewClick(check).subscribe {
//            if (evaluateOne.size >= 5) {
//                if (check.isChecked) {
//                    item.chack = false
//                }
//            }
//        }

    }
}