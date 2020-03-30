package com.example.shadow.heartrecreation.ui.user.adapter

import android.widget.RatingBar

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionMerchantBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class AttertionMerchantAdapter(data: MutableList<AttertionMerchantBean.DataBean>) : BaseQuickAdapter<AttertionMerchantBean.DataBean, BaseViewHolder>(R.layout.item_attertion_merchant, data) {
    override fun convert(helper: BaseViewHolder, item: AttertionMerchantBean.DataBean) {
        helper.setText(R.id.searchName, item.businessName)
                .setText(R.id.searchSao, "地址:${item.businessAddress}")
//                .setText(R.id.searchAdds, "${item.distance}")
        ImageLoad.setImage("${item.avatar}", helper.getView(R.id.serveImage) as RoundedImageView)
//        var view = helper.getView(R.id.searchRating) as RatingBar
//        view.rating = item.businessScore.toFloat()
    }
}