package com.example.shadow.heartrecreation.ui.main.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.DbUtils.setMerchatDB
import com.example.shadow.heartrecreation.db.DrinkUtils
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.MerchantDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.db.user.setRoomMoney
import com.example.shadow.heartrecreation.jpush.MiuiUtils
import com.example.shadow.heartrecreation.ui.image.ImageInfo
import com.example.shadow.heartrecreation.ui.main.adapter.PeopleAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.FollowChangeBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantDetailsBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.MerchantDetailsPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.MerchantDetailsView
import com.example.shadow.heartrecreation.ui.main.pop.PopupWindowHelper
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentCoupons
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMain
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentRoomInfo
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentYue

import com.example.shadow.heartrecreation.ui.share.SharePresenter
import com.example.shadow.heartrecreation.ui.share.ShareView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOrder
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentSao
import com.example.shadow.heartrecreation.utils.banner.BannerUtils
import com.example.shadow.heartrecreation.utils.dialog.SelectMapDialog
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.utils.SystemUtils
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.example.shadow.heartrecreation.utils.utils.UrlParse
import kotlinx.android.synthetic.main.activity_merchant_details.*
import kotlinx.android.synthetic.main.error_net_layout.*
import java.io.File

class MerchantDetailsActivity : BaseActivity(), MerchantDetailsView, ShareView ,SelectMapDialog.SelectMapDialogFace{
    override fun gaodeBtn() {
        if (isPackageInstalled("com.autonavi.minimap")){
            var intent= Intent()
            intent.action= Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            var uri=Uri.parse("amapuri://route/plan/?did=BGVIS2&dlat=" + lat
                    + "&dlon=" + lng + "&dname=${name}&dev=0&t=0")
            intent.data=uri
            startActivity(intent)
        }else{
            Toast.Tips("请安装高德导航")
        }
    }

    override fun baiduBtn() {
        if (isPackageInstalled("com.baidu.BaiduMap")){
            try {
                var pareUrl = "baidumap://map/direction?region=" +
                        "&destination=" + lat + "," + lng + "&coord_type=bd09ll&src=andr.bixinyule.NewBixin"
                var intent= Intent()
                intent.action= Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                intent.data= Uri.parse(pareUrl)
//                var intent = Intent.getIntent(pareUrl)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }else{
            Toast.Tips("请安装百度地图")
        }
    }

    override fun getFollowChange() {
        Toast.Tips("成功")
        presenter.getMerchantDetials(MerchantDetailsBody(businessId, getUserToken()))
    }

    private val presenter by lazy { MerchantDetailsPresenter(this, this, this) }
    private val sharePresenter by lazy { SharePresenter(this, this, this) }
    private var businessId = ""
    private var infodata: MerchantDetailsBean.DataBean? = null
    private var type = 2
    private var boxTypeId = ""
    private var boxTypePeoples = ""
    private var minPrice = ""
    private var boxTypeName = ""
    private var isBroker=2
    private lateinit var dialog: SelectMapDialog
    private var lat=""
    private var lng=""
    private var name=""

    //获取成功
    override fun getMerchantDetailsRequest(data: MerchantDetailsBean) {
        nac_root.visibility=View.VISIBLE
        bottom.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        infodata = data.data
        titleText.text=data.data.businessInfo.businessName
        name=data.data.businessInfo.businessName
        var merchantData = data.data.businessInfo

        var imagelist = ArrayList<ImageInfo>()
        merchantData.videoSetList.forEach { imagelist.add(ImageInfo(it.url, false, it.type)) }
        BannerUtils().setBanner(detailsBanner, imagelist)
        merchantAdds.setText("商家地址："+merchantData.businessAddress)
        if (data.data.businessInfo.servicePrice.toDouble() == 0.00) {
//            MerchantDetailsMoeny.visibility = View.GONE
            merchantBaofang.visibility=View.GONE
            baofangMoney.text="¥0.00"
        } else {
//            MerchantDetailsMoeny.visibility = View.VISIBLE
//            MerchantDetailsMoeny.setText("该类型包房将额外收取服务为:¥${data.data.businessInfo.servicePrice}")
            merchantBaofang.visibility=View.VISIBLE
            baofangMoney.text="¥${data.data.businessInfo.servicePrice}"
            setRoomMoney(data.data.businessInfo.servicePrice.toString())
        }
        lat=data.data.businessInfo.latitude
        lng=data.data.businessInfo.longitude

        merchantTime.text="营业时间："+merchantData.businessStartHours.substring(0,5)+"~"+merchantData.businessEndHours.substring(0,5)

        //附近达人
        if (data.data.nearServiceUser != null && data.data.nearServiceUser.size > 0) {
            detailsNearby.visibility = View.VISIBLE
            var peopleLists = ArrayList<String>()
            data.data.nearServiceUser.forEach { peopleLists.add(it) }
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.HORIZONTAL
            peopleList.layoutManager = manager
            var adapter = PeopleAdapter(peopleLists)
            peopleList.adapter = adapter
        } else {
            detailsNearby.visibility = View.GONE
        }

//        detailsServicePrice.text = "人均¥${data.data.businessInfo.servicePrice}/人"

        //Banner图片


        if (data.data.businessInfo.isFollow == 0) {
            (popView.findViewById(R.id.goAttention) as TextView).setText("关注商家")
        } else {
            (popView.findViewById(R.id.goAttention) as TextView).setText("取消关注")
        }

        myTypeDetails.setOnItemClickListener { position, text ->
            var model = data.data.orderInfo.get(position)
            boxTypeId = "${model.boxTypeId}"
            boxTypePeoples = model.boxTypePeoples
            minPrice = "${model.minPrice}"
            boxTypeName = model.boxTypeName
            nextBtn.isEnabled=true
            myTypeDetailsText.setText("（该包房适合${data.data.orderInfo.get(position).boxTypePeoples}人,最低酒水消费为${data.data.orderInfo.get(position).minPrice}元!）")
        }
//
//        myType.setOnItemClickListener { position, text ->
//            when (position) {
//                0 -> {
//                    type = 0
//                    user.setRoomType("0")
//                    nextBtn.setText("立即预定")
//                    merchantOne.visibility = View.VISIBLE
//                    myTypeLayout.visibility = View.VISIBLE
//                    myTypeDetails.visibility = View.VISIBLE
//                    myTypeDetailsText.text = "（请选择包房类型）"
////                    MerchantDetailsMoeny.visibility = View.VISIBLE
//                    var typeList = ArrayList<String>()
//                    data.data.orderInfo.forEach { typeList.add("    ${it.boxTypeName}    ") }
//                    myTypeDetails.setList(typeList)
//                }
//                else -> {
//                    type = 1
//
//                    nextBtn.setText("扫描桌上二维码")
//                    myTypeLayout.visibility = View.GONE
//                    merchantOne.visibility = View.GONE
//                    myTypeDetails.visibility = View.GONE
////                    MerchantDetailsMoeny.visibility = View.GONE
////                    myTypeDetailsText.text = "若您已在包房内，请扫描桌上二维码进行下单"
//                }
//            }
//        }
//        myType.setIndexItemSelected(0)
        type = 0
        user.setRoomType("0")
//        nextBtn.setText("立即预定")
        merchantOne.visibility = View.VISIBLE
        myTypeLayout.visibility = View.VISIBLE
        myTypeDetails.visibility = View.VISIBLE
        myTypeDetailsText.text = "（请选择包房类型）"
//                    MerchantDetailsMoeny.visibility = View.VISIBLE
        var typeList = ArrayList<String>()
        data.data.orderInfo.forEach { typeList.add("    ${it.boxTypeName}    ") }
        myTypeDetails.setList(typeList)
//        http://{{host}}/share/business?businessId=1
        var url=BaseUrl.HOST_URL+"share/business?businessId=${data.data.businessInfo.businessId}"
        //右上角更多
        Click.viewClick(titleRight).subscribe {
            pop.showAsDropDown(titleRight, 0, 0)
        }
        //返回首页
        Click.viewClick(popView.findViewById(R.id.goHome)).subscribe {
            pop.dismiss()
            intentMain()
            ActivityUtils.finishAllActivities()
        }
        //消息中心
        Click.viewClick(popView.findViewById(R.id.goMessage)).subscribe {

        }
        //订单中心
        Click.viewClick(popView.findViewById(R.id.goOrder)).subscribe {
            pop.dismiss()
            intentOrder()
        }
        //分享
        Click.viewClick(popView.findViewById(R.id.goShare)).subscribe {
            sharePresenter.showShareDialogMerchant(this, "比心娱乐", "今天在这玩，赶快过来吧！\n" +
                    "上比心娱乐APP，你喜欢的，这里都有！",url,"")
            pop.dismiss()
        }
        //关注
        Click.viewClick(popView.findViewById(R.id.goAttention)).subscribe {
            pop.dismiss()
            presenter.getFollowChange(FollowChangeBody(getUserToken(), businessId))
        }


    }

    //获取失败
    override fun getMerchantDetailsError() {
        try {
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismissLoading()
                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        nac_root.visibility=View.GONE
        bottom.visibility=View.GONE
        errorLayout.visibility=View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getMerchantDetials(MerchantDetailsBody(businessId, getUserToken()))
        }
    }

    override fun openEventBus(): Boolean = false
    private lateinit var pop: PopupWindowHelper
    private lateinit var popView: View
    override fun getActivityLayout(): Int = R.layout.activity_merchant_details

    override fun onSavedInstanceState(bundle: Bundle?) {
        super.onSavedInstanceState(bundle)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = window.decorView
            val option = ( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            decorView.systemUiVisibility = option
            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        }
        val actionBar = getSupportActionBar()
        actionBar!!.hide()
//        nac_layout.alpha = 0.toFloat()
//        nac_root.setFadingView(nac_layout)
//        nac_root.setFadingHeightView(detailsBanner)
        var miuiutils = MiuiUtils()
        if (miuiutils.isMIUI()){
            SystemUtils.setMiUiLightStatusBar(this,false)
        }else if (SystemUtils.isFlyme()){
            SystemUtils.setFlymeLightStatusBar(this,false)
        }else{
            SystemUtils.setAndroidLightStatusBar(this,false)
        }
    }

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_white_nor)
        titleRight.setImageResource(R.mipmap.nav_button_more_white_nor)
    }

    override fun initActivityData() {
        businessId = intent.getStringExtra("businessId")
        isBroker=intent.getIntExtra("type",0)
        if (!NetworkUtils.isConnected()) {
            nac_root.visibility=View.GONE
            bottom.visibility=View.GONE
            errorLayout.visibility=View.VISIBLE
        }
//        else{
//            nac_root.visibility=View.VISIBLE
//            bottom.visibility=View.VISIBLE
//            errorLayout.visibility=View.GONE
//        }
//        if (NetworkUtils.isConnected()) {
            presenter.getMerchantDetials(MerchantDetailsBody(businessId, getUserToken()))
//        }
        if (isBroker==0){
            var type = ArrayList<String>()
            type.add("预约包房")
            type.add("我在包房")
//            myType.setList(type)
        }else{
            var type = ArrayList<String>()
            type.add("预约包房")
//            myType.setList(type)
        }
        popView = LayoutInflater.from(mContext).inflate(R.layout.pop_merchantlist, null)
        pop = PopupWindowHelper(popView)
        merchantActivity.visibility = View.GONE//活动
        dialog= SelectMapDialog(this)
        dialog.setDialogFace(this)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(detailsCoupons).subscribe { intentCoupons(businessId) }
        Click.viewClick(nextBtn).subscribe {
            when (type) {
                0 -> {
                    if (type == 2) {
                        Toast.Tips("请选择我的状态")
                    } else if (boxTypeName.equals("")) {
                        Toast.Tips("请选择包房类型")
                    } else {
                        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
                        if (merchat != null && merchat.loadAll() != null && merchat.loadAll().size > 0) {
                            if (!merchat.loadAll().get(0).merchantID.equals(businessId)) {
                                DrinkUtils.deleteALLDrinks()//删除所有酒水
                                ServeUtils.deleteALLServe()//删除所有服务员
                                user.setNum("0")
                            }
                        }
                        user.setRoomType("0")
                        setMerchatDB(MerchantDB(0.toLong(),
                                infodata!!.businessInfo.businessName,
                                businessId,
                                "",
                                boxTypeName,
                                boxTypeId,
                                "",
                                "",
                                false,
                                boxTypePeoples, minPrice,
                                infodata!!.businessInfo.longitude,
                                infodata!!.businessInfo.latitude,
                                infodata!!.businessInfo.businessAddress,
                                "${infodata!!.businessInfo.servicePrice}"))

                        intentUsils.intentDrinks(businessId)
                        finish()
//                        intentYue(0)
                    }
                }
                2 -> Toast.Tips("请选择我的状态")
                else -> {
                    //扫描二维码界面
                    if (nextBtn.text.toString().equals("扫描桌上二维码")) {

                        intentSao(this)
                    }
                }
            }
        }

        Click.viewClick(merchantAdds).subscribe {
            dialog.showDialog()
        }

        Click.viewClick(anewClick).subscribe {
            presenter.getMerchantDetials(MerchantDetailsBody(businessId, getUserToken()))
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK){
            LogUtils.a("扫描成功" + data!!.extras.getString("codedContent"))
//            http://bixinyule.com?bixinClientType=3&qrcodeType=1&businessId=1&boxTypeId=1&businessBoxId=1
            var map= UrlParse.getUrlParams(data!!.extras.getString("codedContent"))
            if (map.containsKey("bixinClientType")){
                if (map["qrcodeType"]!=""&&map["qrcodeType"]=="1"&&map["bixinClientType"]=="3"){
//                    businesssId=map["businessId"]!!
//                    boxTypeId=map["boxTypeId"]!!
//                    boxId=map["businessBoxId"]!!
                    intentRoomInfo(map["businessId"]!!,map["boxTypeId"]!!,map["businessBoxId"]!!)
                }else{
                    Toast.Tips("请扫描包房二维码")
                }
            }else{
                Toast.Tips("请扫描正确的二维码")
            }
        }
    }

    //判断包名是否存在
    fun isPackageInstalled(packageName: String): Boolean {
        return File("/data/data/$packageName").exists()
    }
}