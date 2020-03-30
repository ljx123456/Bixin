package com.example.shadow.heartrecreation.place

import android.content.Intent
import android.graphics.Bitmap
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.blankj.utilcode.util.ActivityUtils
import com.bumptech.glide.Glide
import com.example.shadow.heartrecreation.base.BaseContext.getContext

object intentUtils {

    /**
     * 跳转到位置显示
     */
    fun intentPlace(avatar: String, lng: String, lat: String, latitude: String, longitude: String, shangjiaImage: String) {
        var intent = Intent(getContext(), PlaceActivity::class.java)
        intent.putExtra("avatar", avatar)
        intent.putExtra("lng", lng)
        intent.putExtra("lat", lat)
        intent.putExtra("latitude", latitude)
        intent.putExtra("longitude", longitude)
        intent.putExtra("shangjiaImage", shangjiaImage)
        ActivityUtils.startActivity(intent)
    }

    fun intentLocation(latitude: String, longitude: String, shangjiaImage: String) {
        var intent = Intent(getContext(), LocationActivity::class.java)
        intent.putExtra("latitude", latitude)
        intent.putExtra("longitude", longitude)
        intent.putExtra("shangjiaImage", shangjiaImage)
        ActivityUtils.startActivity(intent)
    }
}