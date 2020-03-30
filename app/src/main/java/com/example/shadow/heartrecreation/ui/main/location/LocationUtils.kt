package com.example.shadow.heartrecreation.ui.main.location

import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.services.core.LatLonPoint
import com.amap.api.services.geocoder.GeocodeResult
import com.amap.api.services.geocoder.GeocodeSearch
import com.amap.api.services.geocoder.RegeocodeQuery
import com.amap.api.services.geocoder.RegeocodeResult
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getCity
import com.example.shadow.heartrecreation.db.user.setCity
import com.example.shadow.heartrecreation.db.user.setlat
import com.example.shadow.heartrecreation.db.user.setlng
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*


class LocationUtils (val location:Location): AMapLocationListener ,GeocodeSearch.OnGeocodeSearchListener{
    override fun onGeocodeSearched(p0: GeocodeResult?, p1: Int) {

    }

    override fun onRegeocodeSearched(p0: RegeocodeResult, p1: Int) {
        if (p1==1000){
            var add=p0.regeocodeAddress
           if (add.city!=null&&add.city!=""){
               location.getLocationSuccess(add.city.replace("市", ""))
           }else{
               location.getLocationSuccess(add.province.replace("市", ""))
           }
//            Toast.Tips("国家："+add.country+"省份:"+add.province+"城市："+add.city)
        }
    }

    var mlocationClient = AMapLocationClient(getContext())
    var mLocationOption = AMapLocationClientOption()
    var geocoderSearch = GeocodeSearch(getContext())

    fun getLocation() {
        mlocationClient.setLocationListener(this)
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
        mLocationOption.setInterval(2000)
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true)
        //设置是否允许模拟位置,默认为true，允许模拟位置
        mLocationOption.setMockEnable(true);
        mlocationClient.setLocationOption(mLocationOption)
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false)
        mlocationClient.startLocation()

        geocoderSearch.setOnGeocodeSearchListener(this)
    }

    override fun onLocationChanged(amapLocation: AMapLocation) {
        if (amapLocation != null && amapLocation.errorCode == 0) {

//            amapLocation.locationType
//            amapLocation.latitude//获取纬度
//            amapLocation.longitude//获取经度
//            amapLocation.accuracy//获取精度信息
//            val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//            val date = Date(amapLocation.time)
//            df.format(date)//定位时间
            setlng("${amapLocation.longitude}")
            setlat("${amapLocation.latitude}")
            val city = amapLocation.city

            if (city!=null&&city!="") {
//            Toast.Tips("国家："+amapLocation.country+"省份:"+amapLocation.province+"城市："+city+"地址："+amapLocation.address)
//            setCity(city.replace("市", ""))
                location.getLocationSuccess(city.replace("市", ""))
            }else if(amapLocation.province!=null&&amapLocation.province!=""){
                location.getLocationSuccess(amapLocation.province.replace("市",""))
//                Toast.Tips("国家："+amapLocation.country+"省份:"+amapLocation.province+"城市："+city+"地址："+amapLocation.address)
            }else{
                var query=RegeocodeQuery(LatLonPoint(amapLocation.latitude,amapLocation.longitude),100.toFloat(),GeocodeSearch.AMAP)
                geocoderSearch.getFromLocationAsyn(query)
            }
            LogUtils.a("定位" + getCity() + amapLocation.cityCode + Gson().toJson(amapLocation))
            mlocationClient.stopLocation()
        }
    }

    interface Location{
        fun getLocationSuccess(city:String)
    }
}
