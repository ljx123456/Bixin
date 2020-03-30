package com.example.shadow.heartrecreation.ui.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BrokerBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class BrokerAddsAdapter(addsDatas: ArrayList<BrokerBean.DataBean.BusinessInfoBean>) : BaseQuickAdapter<BrokerBean.DataBean.BusinessInfoBean, BaseViewHolder>(R.layout.item_broker_adds, addsDatas) {
    override fun convert(helper: BaseViewHolder, item: BrokerBean.DataBean.BusinessInfoBean) {
        ImageLoad.setUserHead(item.avatar,helper.getView(R.id.broker_adds_image) as RoundedImageView)
        helper.setChecked(R.id.broker_adds_check, item.isCheck)
                .setText(R.id.broker_adds_name, item.businessName)
                .addOnClickListener(R.id.broker_adds_check)
    }
}