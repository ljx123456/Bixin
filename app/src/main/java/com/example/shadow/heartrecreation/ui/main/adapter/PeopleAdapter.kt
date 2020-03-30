package com.example.shadow.heartrecreation.ui.main.adapter


import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class PeopleAdapter(list: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_people, list) {
    override fun convert(helper: BaseViewHolder, item: String) {
        ImageLoad.setUserHead(item+"?imageView2/1/w/200/h/200/q/75", helper.getView(R.id.peopleImage) as RoundedImageView)
    }

//    override fun onViewRecycled(holder: BaseViewHolder) {
//        super.onViewRecycled(holder)
//        var imageView = holder.getView<RoundedImageView>(R.id.peopleImage)
//        if (imageView != null) {
//            Glide.with(mContext).clear(imageView)
////            GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
//        }
//    }
}