package com.example.shadow.heartrecreation.ui.user.adapter

import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BlackListBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class BlackListAdapter(list: MutableList<BlackListBean.DataBean>) : BaseQuickAdapter<BlackListBean.DataBean, BaseViewHolder>(R.layout.item_black_list, list) {
    override fun convert(helper: BaseViewHolder, item: BlackListBean.DataBean) {
        helper.setText(R.id.brokerName, item.nickname)

        helper.setText(R.id.brokerName, item.nickname)
                .setText(R.id.blackJoin, item.constellation)
                .addOnClickListener(R.id.black_list_btn)

//                .setVisible(R.id.blackNum, false)

        var age = helper.getView<TextView>(R.id.blackAge)
//        when (item.sex) {
//            1 -> age.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//            else -> age.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//        }
        UIUtils.setAgeUtils(age,item.sex,item.age.toString())
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.black_list_image) as RoundedImageView)


    }
}