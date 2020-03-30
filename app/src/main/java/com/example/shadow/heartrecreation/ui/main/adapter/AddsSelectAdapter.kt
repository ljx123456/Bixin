package com.example.shadow.heartrecreation.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BrokerBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad

class AddsSelectAdapter(addsDatas: ArrayList<ServeDetailsBean.DataBean.BusinessInfoBean>) : BaseQuickAdapter<ServeDetailsBean.DataBean.BusinessInfoBean, BaseViewHolder>(R.layout.item_broker_adds, addsDatas) {
    override fun convert(helper: BaseViewHolder, item: ServeDetailsBean.DataBean.BusinessInfoBean) {
        helper.setChecked(R.id.broker_adds_check, item.isCheck)
                .setText(R.id.broker_adds_name, item.businessName)
                .addOnClickListener(R.id.broker_adds_check)
        ImageLoad.setImage(item.avatar,helper.getView(R.id.broker_adds_image))
    }
}