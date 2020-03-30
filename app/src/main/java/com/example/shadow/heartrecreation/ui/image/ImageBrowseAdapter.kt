package com.example.shadow.heartrecreation.ui.image

import android.annotation.SuppressLint
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.pyw.youyou.utils.image.ImageBrowseInfo
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.image.utils.intentVideo
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import uk.co.senab.photoview.PhotoView
import uk.co.senab.photoview.PhotoViewAttacher


/**
 * Created by Administrator on 2018/8/20 0020.
 */
class ImageBrowseAdapter(val list: MutableList<ImageBrowseInfo>) : PagerAdapter(), PhotoViewAttacher.OnPhotoTapListener {

    private var mChildCount = 0


    override fun notifyDataSetChanged() {
        mChildCount = count
        super.notifyDataSetChanged()
    }

    override fun getItemPosition(`object`: Any): Int {
        if (mChildCount > 0) {
            mChildCount--
            return PagerAdapter.POSITION_NONE
        }
        return super.getItemPosition(`object`)
    }


    override
    fun getCount(): Int = list.size


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    @SuppressLint("WrongViewCast")
    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val layoutView = LayoutInflater.from(view.context).inflate(R.layout.item_image_browse, view, false)
        val imageView = layoutView.findViewById<PhotoView>(R.id.item_image)
        val video = layoutView.findViewById<ImageView>(R.id.itemVideo)
        if (list.get(position).id == 1) {
            video.visibility = View.VISIBLE
            Click.viewClick(video).subscribe {
                intentVideo(list[position].openUrl)
            }
            ImageLoad.setImage(list[position].openUrl+"?vframe/jpg/offset/1", imageView)
        } else {
            video.visibility = View.GONE
            ImageLoad.setImage(list[position].openUrl, imageView)
        }

        imageView.setOnPhotoTapListener(this)
        view.addView(layoutView)
        return layoutView
    }


    override fun onPhotoTap(view: View, x: Float, y: Float) {
        (view.context as BaseActivity).finish()
        GlideCacheUtil.getInstance().clearImageAllCache(view.context as BaseActivity)
    }




}

