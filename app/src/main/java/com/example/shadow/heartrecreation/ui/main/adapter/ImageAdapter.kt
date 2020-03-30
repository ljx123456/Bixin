package com.example.shadow.heartrecreation.ui.main.adapter

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.media.ThumbnailUtils

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.makeramen.roundedimageview.RoundedImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import android.support.annotation.NonNull
import android.widget.ImageView
//import io.rong.imlib.filetransfer.RequestOption
import java.security.MessageDigest
import android.media.ThumbnailUtils.OPTIONS_RECYCLE_INPUT
import android.os.Build
import android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH
import android.provider.MediaStore
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.shadow.heartrecreation.base.BaseContext
import com.example.shadow.heartrecreation.utils.image.ImageConfiguration
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.*


class ImageAdapter(list: MutableList<ImageInfoList>) : BaseQuickAdapter<ImageInfoList, BaseViewHolder>(R.layout.item_images, list) {
    override fun convert(helper: BaseViewHolder, item: ImageInfoList) {
        when (item.imageId) {
            1 -> {
                ImageLoad.setImage(item.url+"?vframe/jpg/offset/1", helper.getView(R.id.itemImage) as RoundedImageView)
                helper.setVisible(R.id.itemVideo, true)
            }
            else ->{
                helper.setVisible(R.id.itemVideo, false)
                ImageLoad.setImage(item.url+"?imageView2/1/w/200/h/200/q/75", helper.getView(R.id.itemImage) as RoundedImageView)
            }
        }
    }

//    override fun onViewRecycled(holder: BaseViewHolder) {
//        super.onViewRecycled(holder)
//        var imageView = holder.getView<RoundedImageView>(R.id.itemImage)
//        if (imageView != null) {
//            Glide.with(mContext).clear(imageView)
//        }
//    }

}