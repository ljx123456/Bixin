package com.example.shadow.heartrecreation.ui.order.adapter

import android.widget.RatingBar
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateOrderBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class EvaluateAdapter(serviceUsers: MutableList<EvaluateOrderBean.DataBean.ServiceUsersBean>) : BaseQuickAdapter<EvaluateOrderBean.DataBean.ServiceUsersBean, BaseViewHolder>(R.layout.item_evaluate, serviceUsers) {
    override fun convert(helper: BaseViewHolder, item: EvaluateOrderBean.DataBean.ServiceUsersBean) {
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.evaluateImage) as RoundedImageView)
        setAgeUtils(helper.getView(R.id.evaluateAge), item.sex, item.age)
        helper.setText(R.id.evaluateName, item.nickname)
                .setText(R.id.evaluateJoin, item.occupation)
                .setText(R.id.evaluateMoney, "¥:${item.price}")
                .addOnClickListener(R.id.evaluateTag)
        (helper.getView(R.id.evaluateOne) as RatingBar).rating = item.one
        (helper.getView(R.id.evaluateTwo) as RatingBar).rating = item.tow
        (helper.getView(R.id.evaluateThree) as RatingBar).rating = item.three
        (helper.getView(R.id.evaluateFour) as RatingBar).rating = item.four


    }
}