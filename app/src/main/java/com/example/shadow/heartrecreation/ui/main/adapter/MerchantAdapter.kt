package com.example.shadow.heartrecreation.ui.main.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantBean
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.makeramen.roundedimageview.RoundedImageView

class MerchantAdapter : BaseQuickAdapter<MerchantBean.DataBean, BaseViewHolder> {

    constructor(list: MutableList<MerchantBean.DataBean>) : super(R.layout.item_merchant, list)

    override fun convert(helper: BaseViewHolder, item: MerchantBean.DataBean) {
        ImageLoad.setImage("${item.avatar}", helper.getView(R.id.merchantImage) as RoundedImageView)
        helper.setText(R.id.merchantName, item.businessName)
                .setText(R.id.merchantType, "(${item.businessTypeName})")
//                .setText(R.id.merchantMoney, "人均¥${item.businessGdp}/人")
                .setText(R.id.merchantAdds, "地址:${item.businessAddress}")
                .setText(R.id.merchantDistance,"${item.distance}")
                .setText(R.id.merchantTime,"营业时间："+item.businessStartHours.substring(0,5)+"~"+item.businessEndHours.subSequence(0,5))

        var xingxing = helper.getView<RatingBar>(R.id.merchantxingxing)
        xingxing.rating = item.businessScore.toFloat()

        var merchantChoose=helper.getView<TextView>(R.id.merchantChoose)
        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
                var merchantData = DbUtils.getMerchat()
                if (item.businessId.toString().equals(merchantData.merchantID)){
                    merchantChoose.visibility=View.VISIBLE
                }else{
                    merchantChoose.visibility=View.GONE
                }

            } else {
                merchantChoose.visibility=View.GONE
            }
        } else {
            merchantChoose.visibility=View.GONE
        }

        var imageList = ArrayList<String>()
        item.photoList.forEach { imageList.add(it) }
        var list = helper.getView<RecyclerView>(R.id.merchantPeopleList)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.HORIZONTAL
        list.layoutManager = manager
        var adapter = PeopleAdapter(imageList)
        list.adapter = adapter
    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        super.onViewRecycled(holder)
        var imageView = holder.getView<RoundedImageView>(R.id.merchantImage)
        if (imageView != null) {
//            Glide.with(mContext).clear(imageView)
            GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
        }
    }


}