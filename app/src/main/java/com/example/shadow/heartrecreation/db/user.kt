package com.example.shadow.heartrecreation.db

import android.content.SharedPreferences
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.db.DbUtils.getUser
import java.util.*

object user {

    //获取用户头像
    fun getUserImage(): String {
        return getUser().avatar
    }

    //获取用户昵称
    fun getUserNick(): String {
        return getUser().nickname
    }

    //获取用户token
    fun getUserToken(): String {
        return getUser().token
    }

    fun getUserID(): String {
        return "${getUser().bixinId}"
    }
    fun getJMID(): String {
        return "${getUser().userId}"
    }
    //获取用户手机号
    fun getUserPhone():String{
        return  getUser().phone
    }


    //获取用户ID
//    fun getUserID():String{
//        return  getUser().
//    }
    //获取用户生日
    fun getUserBirthday(): String {
        return getUser().birthday
    }

    //获取用户星座
    fun getUserConstellation(): String {
        return getUser().constellation
    }

    //获取用年龄
    fun getUserAge(): String {
//        val c=Calendar.getInstance()
//        val year=getUser().birthday.substring(0,4)
//        val year2=c.get(Calendar.YEAR)
//        return (year2-year.toInt()).toString()
        return "${getUser().age}"
    }

//    fun getUserToken(): String = "42VbLl2tlRBxTnBAcnzZPZMxzF1j4weMwCGAdxB0FLwJbqRJPYhsO7/VJfA1JPhhbenE+D5EaIJaQ+A/pPia9KtgbBMIN5SVQ7b9+H0YOw65z36H+mTcz1x0752cRnVUD1xqiMI76kaBsctpx+jsDxiadLbNFhqf"

    //获取用户IMToken
    fun getUserIM(): String {
        return getUser().jmpassword
    }

    //当前精度
    fun getlng(): String {
        if (mCache.getAsString("lng") != null) {
            return mCache.getAsString("lng")
        } else {
            return ""
        }
    }

    //当前维度
    fun getlat(): String {
        if (mCache.getAsString("lat") != null) {
            return mCache.getAsString("lat")
        } else {
            return ""
        }
    }

    //当前城市
    fun getCity(): String {
        if (mCache.getAsString("city") != null) {
            return mCache.getAsString("city")
        } else {
            return ""
        }
    }

    //城市
    fun setCity(city: String) {
        mCache.put("city", city)
    }

    var mCache = ACache.get(getContext()) // 初始化，一般放在基类里
    //精度
    fun setlng(lng: String) {
        mCache.put("lng", lng)
    }

    //维度
    fun setlat(lat: String) {
        mCache.put("lat", lat)
    }

    //约玩卡name
    fun setYueName(name: String) {
        mCache.put("yueName", name)
    }

    //约玩卡id
    fun setYueID(id: String) {
        mCache.put("yueID",id)
    }

    //当前约玩卡name
    fun getYueName(): String {
        if (mCache.getAsString("yueName") != null) {
            return mCache.getAsString("yueName")
        } else {
            return ""
        }
    }

    //当前约玩卡id
    fun getYueID(): String {
        if (mCache.getAsString("yueID") != null) {
            return mCache.getAsString("yueID")
        } else {
            return "1"
        }
    }



    //城市ID
    fun setCityID(cityId: String) {
        mCache.put("cityid", cityId)
    }

    fun getCityID(): String {
        if (mCache.getAsBinary("cityid") != null) {
            return mCache.getAsString("cityid")
        } else {
            return "1"
        }

    }

    //当前约玩人数
    fun setNum(num: String) {
        mCache.put("num", num)
    }

    //获取当前约玩人数
    fun getNum(): String {
        if (mCache.getAsString("num") != null) {
            return mCache.getAsString("num")
        } else {
            return "0"
        }
    }

    //设置从订单还是主流程添加酒水和服务人员1为主流程0为订单
    fun setType(type: String) {
        mCache.put("type", type)
    }

    //设置从订单还是主流程添加酒水和服务人员
    fun getType(): String {
        if (mCache.getAsString("type") != null) {
            return mCache.getAsString("type")
        } else {
            return "1"
        }
    }

    fun setOrderID(orderID: String) {
        mCache.put("orderID", orderID)
    }

    fun getOrderID(): String = mCache.getAsString("orderID")

    //设置预约包房下单，还是在包房内下单（扫码下单）；0 预约包房，1在包房内（扫码下单）
    fun setRoomType(type: String) {
        mCache.put("roomType", type)
    }

    //设置预约包房下单，还是在包房内下单（扫码下单）；0 预约包房，1在包房内（扫码下单）
    fun getRoomType(): String {
        if (mCache.getAsString("roomType") != null) {
            return mCache.getAsString("roomType")
        } else {
            return "0"
        }
    }

    //设置是否经纪人下单，0 不是，1是
    fun setBrokerType(type: String) {
        mCache.put("brokerType", type)
    }

    //设置是否经纪人下单，0 不是，1是
    fun getBrokerType(): String {
        if (mCache.getAsString("brokerType") != null) {
            return mCache.getAsString("brokerType")
        } else {
            return "0"
        }
    }

    //设置房间服务费
    fun setRoomMoney(money:String){
        mCache.put("roomMoney",money)
    }

    fun getRoomMoney():String{
        if (mCache.getAsString("roomMoney") != null) {
            return mCache.getAsString("roomMoney")
        }else{
            return "0.00"
        }
    }

    //设置订单号
    fun setOrderNo(orderNo:String){
        mCache.put("orderNo",orderNo)
    }

    fun getOrderNo():String{
        if (mCache.getAsString("orderNo")!=null){
            return mCache.getAsString("orderNo")
        }else{
            return ""
        }
    }

    //是否是重新下单
    fun setOrderAgain(again:String){
        mCache.put("again",again)
    }

    fun getOrderAgain():String{
        if (mCache.getAsString("again")!=null){
            return mCache.getAsString("again")
        }else{
            return "0"
        }
    }



//
//    fun setBusinessId(businessId:String){
//        mCache.put("businessId",businessId)
//    }
//
//    fun getbusinessId():String{
//        if (mCache.getAsString("businessId") != null) {
//            return mCache.getAsString("businessId")
//        }else{
//            return "-1"
//        }
//    }

}
