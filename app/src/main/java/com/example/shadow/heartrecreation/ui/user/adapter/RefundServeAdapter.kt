package com.example.shadow.heartrecreation.ui.user.adapter

import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundMerchantBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class RefundServeAdapter(serviceUsers: MutableList<RefundMerchantBean.DataBean.OrderDetailBean.ServiceUsersBean>) : BaseQuickAdapter<RefundMerchantBean.DataBean.OrderDetailBean.ServiceUsersBean, BaseViewHolder>(R.layout.item_order_serve, serviceUsers) {
    override fun convert(helper: BaseViewHolder, item: RefundMerchantBean.DataBean.OrderDetailBean.ServiceUsersBean) {
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.orderServeImage) as RoundedImageView)
        helper.setText(R.id.orderServeName, item.nickname)
                .setText(R.id.orderServeAge, "${item.age}")
                .setText(R.id.orderServeJoin, item.occupation)
                .setVisible(R.id.orderServeOver, false)//取消
                .setVisible(R.id.orderServeLookAdds, false)//位置
                .setVisible(R.id.orderServeMassage, false)//聊天
                .setVisible(R.id.orderServePay, false)//付款
                .setVisible(R.id.orderServeTime, false)//时间
                .setVisible(R.id.setatTime, false)//时间
        var sex = helper.getView<TextView>(R.id.orderServeAge)
        when (item.sex) {
            1 -> sex.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
            else -> sex.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
        }
    }
}