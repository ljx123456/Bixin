package com.example.shadow.heartrecreation.ui.main.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.OrderServeUtils.getOrderData
import com.example.shadow.heartrecreation.db.OrderServeUtils.haveData
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.db.user.getType
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.makeramen.roundedimageview.RoundedImageView

class ServeListAdapter : BaseQuickAdapter<ServeListBean.DataBean, BaseViewHolder> {

    constructor(list: MutableList<ServeListBean.DataBean>) : super(R.layout.item_serve_list, list)


    private var clickBack:ClickBack?=null
    override fun convert(helper: BaseViewHolder, item: ServeListBean.DataBean) {
        ImageLoad.setImageNull(item.avatar+"?imageView2/1/w/200/h/200/q/75", helper.getView(R.id.serveImage) as RoundedImageView)
        helper.setText(R.id.brokerName, item.nickname)
                .setText(R.id.brokerAge, "${item.age}")
                .setText(R.id.brokerSao, "魅力值:${item.charmValue}")
                .addOnClickListener(R.id.yue)
//                .addOnClickListener(R.id.brokerList)
        if (item.km != null && !"null".equals(item.km)) {
            helper.setText(R.id.brokerAdds, "${item.km}")
        } else {
            helper.setText(R.id.brokerAdds, "")
        }
        if (item.occupationName != null) {
            helper.setVisible(R.id.brokerJoin, true)
            helper.setText(R.id.brokerJoin, item.occupationName)
        } else {
            helper.setVisible(R.id.brokerJoin, false)
            helper.setText(R.id.brokerJoin, item.occupationName)
        }
        var ageView = helper.getView<TextView>(R.id.brokerAge)
        setAgeUtils(ageView, item.sex, "${item.age}")

        var lists = helper.getView(R.id.brokerList) as RecyclerView
        var imageList = ArrayList<ImageInfoList>()
        item.videoSetList.forEach { imageList.add(ImageInfoList(it.url, it.type.toInt())) }
        var adapters= ImageAdapter(imageList)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.HORIZONTAL
        lists.layoutManager = manager
        lists.adapter = adapters
//        Click.viewClick(lists).subscribe {
////            clickBack!!.click()
//            var imagelist = ArrayList<ImageInfo>()
//            adapters!!.data.forEach { imagelist.add(ImageInfo("${it.url}", false, it.imageId)) }
//            intentImage(false, imagelist, 0)
//        }

        adapters!!.setOnItemClickListener { adapter, view, position ->
            clickBack!!.click(item.userId)
//            var imagelist = ArrayList<ImageInfo>()
//            adapters!!.data.forEach { imagelist.add(ImageInfo("${it.url}", false, it.imageId)) }
//            intentImage(false, imagelist, position)
        }


        var yue = helper.getView(R.id.yue) as TextView

        if ("0".equals(getType())) {
            var data = getOrderData()
            var infoData = OrderServeDB(null, "${item.userId}", item.nickname, item.avatar)
            var datas=ServeUtils.getServeData()
            var serveModel = ServePersonnelDB(
                    null,
                    "${item.userId}",
                    item.nickname, item.avatar,
                    "${item.skillPrice}",
                    "",
                    "",
                    "${item.age}",
                    "${item.sex}",
                    item.km,
                    item.occupationName)
            if (haveData(data, infoData)||ServeUtils.haveData(datas,serveModel)) {
                yue.text = "已添加"
                yue.isEnabled = false
            } else {
                yue.text = "约TA"
                yue.isEnabled = true
            }
        } else {
            var serveModel = ServePersonnelDB(
                    null,
                    "${item.userId}",
                    item.nickname, item.avatar,
                    "${item.skillPrice}",
                    "",
                    "",
                    "${item.age}",
                    "${item.sex}",
                    item.km,
                    item.occupationName)
            if (item.isType) {
                yue.text = "已添加"
                yue.isEnabled = false
            } else {
                yue.text = "约TA"
                yue.isEnabled = true
            }
//        DataComparisonUtils.ServeData(serveModel, (helper.getView(R.id.yue) as TextView))
            var datasss = ServeUtils.getServeData()
            if (datasss != null && datasss.size >= 1 && datasss.get(0).name != null) {
                if (ServeUtils.haveData(datasss, serveModel)) {
                    yue.text = "已添加"
                    yue.isEnabled = false
                } else {
                    yue.text = "约TA"
                    yue.isEnabled = true
                }
            } else {
                yue.text = "约TA"
                yue.isEnabled = true
            }
        }

        if (item.isInOrder!=0){
            yue.text="接单中"
            yue.isEnabled=false
        }


    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        super.onViewRecycled(holder)
        var imageView = holder.getView<RoundedImageView>(R.id.serveImage)
        if (imageView != null) {
//            Glide.with(mContext).clear(imageView)
            GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
        }
    }

    public fun setCallBack(clickBack:ClickBack){
        this.clickBack=clickBack
    }

    interface ClickBack{
        fun click(userId:Int)
    }

}

data class ImageInfoList(val url: String, val imageId: Int)