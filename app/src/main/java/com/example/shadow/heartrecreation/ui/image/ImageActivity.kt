package com.example.shadow.heartrecreation.ui.image

import android.content.ComponentCallbacks2
import android.support.v4.view.ViewPager
import com.example.pyw.youyou.utils.image.ImageBrowseInfo
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.utils.utils.DataCleanManager
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.example.shadow.heartrecreation.utils.utils.SystemUtils.activityFullScreen
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : BaseActivity(), ViewPager.OnPageChangeListener {
    private var index = 0
    private var delete = false

    private lateinit var images: ArrayList<ImageBrowseInfo>
    private lateinit var adapter: ImageBrowseAdapter


    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_image

    override fun setActivityTitle() {
        activityFullScreen(this)
        getIntentVariable()
    }

    override fun initActivityData() {
        setImageBrowseAdapter()
        setTextViewIndex()
    }

    //接收传递的值
    private fun getIntentVariable() {
        index = intent.getIntExtra("index", 0)
        delete = intent.getBooleanExtra("delete", false)
        images = intent.getSerializableExtra("images") as ArrayList<ImageBrowseInfo>
    }

    //设置选中的文本内容
    private fun setTextViewIndex() {
        textIndex.text = (index + 1).toString() + "/" + images.size
    }


    //初始化适配器
    private fun setImageBrowseAdapter() {
        adapter = ImageBrowseAdapter(images)
        imagePager.adapter = adapter
        imagePager.currentItem = index
    }

    override fun clickListener() {
        imagePager.setOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }


    override fun onPageSelected(position: Int) {
        textIndex.text = (position + 1).toString() + "/" + images.size
    }

    override fun onDestroy() {
        super.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)
    }

    override fun finish() {
        super.finish()
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level== TRIM_MEMORY_RUNNING_LOW){
            GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
        }
        if (level== ComponentCallbacks2.TRIM_MEMORY_BACKGROUND){
            GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
            DataCleanManager.cleanInternalCache(mContext)//清除本应用内部缓存
        }
    }
}