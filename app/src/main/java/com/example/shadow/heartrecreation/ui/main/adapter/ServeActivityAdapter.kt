package com.example.shadow.heartrecreation.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean

class ServeActivityAdapter(skillTypeList: MutableList<ServeDetailsBean.DataBean.SkillTypeListBean>) : BaseQuickAdapter<ServeDetailsBean.DataBean.SkillTypeListBean, BaseViewHolder>(R.layout.item_serve, skillTypeList) {
    override fun convert(helper: BaseViewHolder, item: ServeDetailsBean.DataBean.SkillTypeListBean) {
        helper.setText(R.id.serveType, item.skillTypeName)
                .setText(R.id.serveMoney, "¥:${item.skillTypePriceUp}")
    }
}