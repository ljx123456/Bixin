package com.example.shadow.heartrecreation.ui.main.adapter

import android.widget.RatingBar
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantListSearchBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class MerchantListSearchAdapter(data: MutableList<MerchantListSearchBean.DataBean>) :
        BaseQuickAdapter<MerchantListSearchBean.DataBean, BaseViewHolder>(R.layout.item_search_ktv, data) {
    override fun convert(helper: BaseViewHolder, item: MerchantListSearchBean.DataBean) {
        helper.setText(R.id.searchName, item.businessName)
                .setText(R.id.searchAddress, "地址:${item.businessAddress}")

//        var xingxing = helper.getView<RatingBar>(R.id.itemBar)
//        xingxing.rating = item.businessScore.toFloat()
        ImageLoad.setImage(item.avatar, helper.getView(R.id.serveImage) as RoundedImageView)
    }
}