package com.example.shadow.heartrecreation.ui.user.adapter

import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionServeBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class AttertionServeAdapter(data: MutableList<AttertionServeBean.DataBean>) : BaseQuickAdapter<AttertionServeBean.DataBean, BaseViewHolder>(R.layout.item_attertion_serve, data) {
    override fun convert(helper: BaseViewHolder, item: AttertionServeBean.DataBean) {
        helper.setText(R.id.searchName, item.nickname)
                .setText(R.id.searchAge, "${item.age}")
        if (item.occupationName!=null&&item.occupationName!=""){
            helper.setText(R.id.searchJoin, item.occupationName)
                    .setVisible(R.id.searchJoin,true)
        }else{
            helper.setVisible(R.id.searchJoin,false)
        }
//                .setText(R.id.searchAdds, item.km)

//        if (item.)
//                .setVisible(R.id.searchSao, false)
//        var age = helper.getView<TextView>(R.id.searchAge)
//        when (item.sex) {
//            1 -> age.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//            else -> age.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//        }
        UIUtils.setAgeUtils(helper.getView<TextView>(R.id.searchAge), item.sex, "${item.age}")
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.serveImage) as RoundedImageView)
    }
}