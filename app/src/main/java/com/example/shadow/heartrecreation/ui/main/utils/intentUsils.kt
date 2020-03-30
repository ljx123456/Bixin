package com.example.shadow.heartrecreation.ui.main.utils

import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.db.user.setType
import com.example.shadow.heartrecreation.ui.main.activity.*
import com.example.shadow.heartrecreation.ui.meassage.activity.MeassageActivity

object intentUsils {

    /**
     * 跳转到约界面
     */
    fun intentYue( type: Int) {
        setType("1")
        var intent = Intent(getContext(), YueActivity::class.java)
        intent.putExtra("type", type)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到约界面
     */
    fun intentYue( type: Int, brokerID: String, brokerImage: String, brokerName: String, brokerAge: String, brokerSex: String, brokerJob: String, businessId: String, businessName: String) {
        setType("1")
        var intent = Intent(getContext(), YueActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("brokerID", brokerID)
        intent.putExtra("brokerImage", brokerImage)
        intent.putExtra("brokerName", brokerName)
        intent.putExtra("brokerAge", brokerAge)
        intent.putExtra("brokerSex", brokerSex)
        intent.putExtra("brokerJob", brokerJob)
        intent.putExtra("businessId", businessId)
        intent.putExtra("businessName", businessName)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到扫描订单
     */
    fun intentSaoOrder(referencesUserId: String,orderSkillType:String,type:String) {
        var intent = Intent(getContext(), SaoOrderActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("referencesUserId", referencesUserId)
        intent.putExtra("orderSkillType",orderSkillType)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到扫描酒水订单
     */
    fun intentSaoOrder(orderId:String,type: String) {
        var intent = Intent(getContext(), SaoOrderActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("orderId", orderId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到商家列表界面
     */
    fun intentMerchant() {
        ActivityUtils.startActivity(MerchantActivity::class.java)
    }

    /**
     * 跳转到商家详情
     */
    fun intentMerchantDetails(businessId: String,type:Int) {
        var intent = Intent(getContext(), MerchantDetailsActivity::class.java)
        intent.putExtra("businessId", businessId)
        intent.putExtra("type",type)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到确认包房界面
     */
    fun intentRoomInfo(businessId:String,boxTypeId:String,businessBoxId:String){
        var intent = Intent(getContext(), RoomInfoActivity::class.java)
        intent.putExtra("businessId", businessId)
        intent.putExtra("boxTypeId", boxTypeId)
        intent.putExtra("businessBoxId", businessBoxId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 领取优惠券
     */
    fun intentCoupons(businessId: String) {
        var intent = Intent(getContext(), CouponsActivity::class.java)
        intent.putExtra("businessId", businessId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 服务人员列表
     */
    fun intentServeList(id: Int) {
        var intent = Intent(getContext(), ServeListActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 服务人员列表
     */
    fun intentServeList(id: Int,businessId: String) {
        var intent = Intent(getContext(), ServeListActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("businessID", businessId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 服务人员详情
     */
    fun intentServeDetails(userId: Int, businessId: String, ids: Int) {
        var intent = Intent(getContext(), ServeDetailsActivity::class.java)
        intent.putExtra("id", userId)
        intent.putExtra("businessId", businessId)
        intent.putExtra("typeID", ids)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到酒水套餐
     */
    fun intentDrinks(businessId: String) {

        var intent = Intent(getContext(), DrinksActivity::class.java)
        intent.putExtra("businessId", businessId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到首页
     */
    fun intentMain() {
        ActivityUtils.startActivity(MainActivity::class.java)
    }

    /**
     * 跳转到服务人员搜索界面
     */
    fun intentServeListSearch(id: Int) {
        var intent = Intent(getContext(), ServeListSearchActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到商家搜索界面
     */
    fun intentMerchantListSearch() {
        ActivityUtils.startActivity(MerchantListSearchActivity::class.java)
    }

    /**
     * 我的消息
     */
    fun intentMeassage() {
        ActivityUtils.startActivity(MeassageActivity::class.java)
    }

    /**
     * 选择地址
     */
    fun intentSetCity() {
        ActivityUtils.startActivity(SetCityActivity::class.java)
    }

    /**
     * 跳转到活动banner界面
     */
    fun intentBanner(title:String,url:String){
        var intent = Intent(getContext(), BannerActivity::class.java)
        intent.putExtra("url", url)
        intent.putExtra("title",title)
        ActivityUtils.startActivity(intent)
    }
}