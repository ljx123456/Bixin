package com.example.shadow.heartrecreation.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean

class ServeDetailsAddsAdapter(businessInfo: MutableList<ServeDetailsBean.DataBean.BusinessInfoBean>) : BaseQuickAdapter<ServeDetailsBean.DataBean.BusinessInfoBean, BaseViewHolder>(R.layout.item_serve_details_adds, businessInfo) {
    override fun convert(helper: BaseViewHolder, item: ServeDetailsBean.DataBean.BusinessInfoBean) {
        helper.setText(R.id.serveMerchant, item.businessName)
    }

}