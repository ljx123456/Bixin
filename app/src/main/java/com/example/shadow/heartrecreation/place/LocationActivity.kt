package com.example.shadow.heartrecreation.place

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.shadow.heartrecreation.utils.utils.Click
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdate
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.CameraPosition
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.MarkerOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.activity_place.*
import kotlinx.android.synthetic.main.layout_title.*


class LocationActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false
    override fun getActivityLayout(): Int = R.layout.activity_place
    var latitude = ""
    var longitude = ""
    var shangjiaImage = ""
    //初始化地图控制器对象
    internal var aMap: AMap? = null

    override fun setActivityTitle() {
        titleText.text = "查看位置"
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun onSavedInstanceState(bundle: Bundle?) {
        super.onSavedInstanceState(bundle)
        mapView.onCreate(bundle)
    }


    override fun initActivityData() {
        latitude = intent.getStringExtra("latitude")
        longitude = intent.getStringExtra("longitude")
        shangjiaImage = intent.getStringExtra("shangjiaImage")
        if (aMap == null) {
            aMap = mapView.getMap()
        }
        //商家
        var latLng2 = LatLng(latitude.toDouble(), longitude.toDouble())
        var views = LayoutInflater.from(mContext).inflate(R.layout.marker_layouts, null)
        var iv_heads = views.findViewById(R.id.iv_heads) as RoundedImageView
//        Glide.with(this).load(shangjiaImage)
//                .into(object : SimpleTarget<Bitmap>() {
//                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
////                        iv_heads.setImageDrawable(resource)
//                        Glide.with(this@LocationActivity).load(shangjiaImage).into(iv_heads)
//                        var bitmap = getViewBitmap(views)
//                        var markerOption = MarkerOptions()
//                        markerOption.position(latLng2)
//                                .draggable(false)
//                                .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
//                        aMap!!.addMarker(markerOption)
//                    }
//
//                })
        Glide.with(this).load(shangjiaImage).into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                iv_heads.setImageDrawable(resource)
//                Glide.with(this@LocationActivity).load(shangjiaImage).into(iv_heads)
                var bitmap = getViewBitmap(views)
                var markerOption = MarkerOptions()
                markerOption.position(latLng2)
                        .draggable(false)
                        .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                aMap!!.addMarker(markerOption)
            }
        })




        changeCamera(CameraUpdateFactory.newCameraPosition(CameraPosition(latLng2, 18F, 30F, 30F)))
    }

    /**
     *把View转换成Bitmap类型
     *@paramaddViewContent要转换的View
     *@return
     */
    fun getViewBitmap(addViewContent: View): Bitmap {
        addViewContent.setDrawingCacheEnabled(true);
        addViewContent.measure(
                View.MeasureSpec.makeMeasureSpec(0,
                        View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0,
                        View.MeasureSpec.UNSPECIFIED));
        addViewContent.layout(0, 0,
                addViewContent.getMeasuredWidth(),
                addViewContent.getMeasuredHeight());
        addViewContent.buildDrawingCache();
        var cacheBitmap = addViewContent.getDrawingCache();
        var bitmap = Bitmap.createBitmap(cacheBitmap);
        return bitmap;
    }

    fun changeCamera(updata: CameraUpdate) {
        aMap!!.moveCamera(updata)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    /**
     * 方法必须重写
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}