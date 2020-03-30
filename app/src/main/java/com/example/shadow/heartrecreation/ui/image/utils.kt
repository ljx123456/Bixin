package com.example.shadow.heartrecreation.ui.image

import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import com.example.pyw.youyou.utils.image.ImageBrowseInfo
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.ui.main.activity.VideoActivity

object utils {
    /**
     * 图片详情-查看自己的
     */
    fun intentImage(delete: Boolean, list: ArrayList<ImageInfo>, index: Int) {
        val imageList = ArrayList<ImageBrowseInfo>()
        list.forEach { if (!it.addButton) imageList.add(ImageBrowseInfo(it.imageUrl!!, false, it.imageId)) }
        val intent = Intent(ActivityUtils.getTopActivity(), ImageActivity::class.java)
        intent.putExtra("images", imageList)
        intent.putExtra("delete", delete)
        intent.putExtra("index", index)
        ActivityUtils.startActivity(intent)
    }

    fun intentVideo(video: String) {
        var intent = Intent(getContext(), VideoActivity::class.java)
        intent.putExtra("video", video)
        ActivityUtils.startActivity(intent)
    }


}