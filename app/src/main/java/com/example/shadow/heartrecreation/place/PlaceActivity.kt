package com.example.shadow.heartrecreation.place

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
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


class PlaceActivity : BaseActivity() {

    override fun openEventBus(): Boolean = false
    override fun getActivityLayout(): Int = R.layout.activity_place
    //初始化地图控制器对象
    internal var aMap: AMap? = null
    var lng = ""
    var lat = ""
    var latitude = ""
    var longitude = ""
    var avatar = ""
    var shangjiaImage = ""

    override fun setActivityTitle() {
        titleText.text = "查看位置"
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun onSavedInstanceState(bundle: Bundle?) {
        super.onSavedInstanceState(bundle)
        mapView.onCreate(bundle)
    }

    override fun initActivityData() {
        lat = intent.getStringExtra("lng")
        lng = intent.getStringExtra("lat")
        latitude = intent.getStringExtra("latitude")
        longitude = intent.getStringExtra("longitude")
        avatar = intent.getStringExtra("avatar")
        shangjiaImage = intent.getStringExtra("shangjiaImage")
        if (aMap == null) {
            aMap = mapView.getMap()
        }
        Handler().postDelayed({
            //服务人员
            var latLng = LatLng(lng.toDouble(), lat.toDouble())
            var view = LayoutInflater.from(mContext).inflate(R.layout.marker_layout, null)
            var iv_head = view.findViewById(R.id.iv_head) as RoundedImageView
            Glide.with(this).load(avatar)
                    .into(object : SimpleTarget<Drawable>() {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            iv_head.setImageDrawable(resource)
                            var bitmap = getViewBitmap(view)
                            var markerOption = MarkerOptions()
                            markerOption.position(latLng)
                                    .draggable(false)
                                    .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                            aMap!!.addMarker(markerOption)
                        }
                    })

            //商家
            var latLng2 = LatLng(latitude.toDouble(), longitude.toDouble())
            var views = LayoutInflater.from(mContext).inflate(R.layout.marker_layouts, null)
            var iv_heads = views.findViewById(R.id.iv_heads) as RoundedImageView
            Glide.with(this).load(shangjiaImage)
                    .into(object : SimpleTarget<Drawable>() {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            iv_heads.setImageDrawable(resource)
                            var bitmap = getViewBitmap(views)
                            var markerOption = MarkerOptions()
                            markerOption.position(latLng2)
                                    .draggable(false)
                                    .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                            aMap!!.addMarker(markerOption)
                        }
                    })
            changeCamera(CameraUpdateFactory.newCameraPosition(CameraPosition(latLng2, 18F, 30F, 30F)))
        }, 800)
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

    fun changeCamera(updata: CameraUpdate) {
        aMap!!.moveCamera(updata)
    }

    /**
     * 方法必须重写
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}