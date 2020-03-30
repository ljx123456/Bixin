package com.example.shadow.heartrecreation.ui.main.activity

import android.content.Intent
import android.net.Uri
import android.view.View
import com.blankj.utilcode.util.AppUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.db.MerchantDB
import com.example.shadow.heartrecreation.db.user.setNum
import com.example.shadow.heartrecreation.db.user.setYueID
import com.example.shadow.heartrecreation.ui.main.mvp.bean.KTVBoxBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.KTVBoxBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.KTVBoxPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.KTVBoxView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.utils.dialog.SelectMapDialog
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_room_info.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File
import java.math.BigDecimal
import java.net.URISyntaxException

class RoomInfoActivity :BaseActivity(),KTVBoxView, SelectMapDialog.SelectMapDialogFace{
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
    override fun getKTVBoxRequest(data: KTVBoxBean) {
        if (data.data!=null&&data.data.myOrderInfo.size>0) {
            ktvImg = data.data.businessInfo.avatar
            ktvName = data.data.businessInfo.businessName
            name= data.data.businessInfo.businessName
            ktvAddress = data.data.businessInfo.businessAddress
            boxPrice = data.data.businessInfo.servicePrice.toDouble()
            lat=data.data.businessInfo.latitude
            lng=data.data.businessInfo.longitude

           var orderinfo=data.data.myOrderInfo
            var flag = false
            for (i in orderinfo.indices){
                if (orderinfo[i].boxTypeId==boxTypeId){
                    boxTypeName=orderinfo[i].boxTypeName
                    minPrice=orderinfo[i].minPrice
                    var box=orderinfo[i].boxs
                    for (t in box.indices){
                        if (box[t].businessBoxId==businessBoxId){
                            boxID=box[t].businessBoxId
                            boxName=box[t].businessBoxName
                            flag=true
                            break
                        }
                    }
                }
                if (flag){
                    break
                }else if (i==orderinfo.size-1){
                    Toast.Tips("没有该包房请重新扫描")
                    finish()
                    return
                }
            }
//            data.data.orderInfo.forEach {
//                if (it.boxTypeId.toString() == boxTypeId) {
//                    boxTypeName = it.boxTypeName
//                    minPrice=it.minPrice.toDouble()
//                    it.boxs.forEach {
//                        if (it.businessBoxId.toString() == businessBoxId) {
//                            boxName = it.businessBoxName
//                            boxID=it.businessBoxId.toString()
//                            return@forEach
//                        }
//                    }
//                    return@forEach
//                }
//            }
            tv_room_address.text="商家地址："+ktvAddress
            roomKTVName.text=ktvName
            roomNum.text=boxName
            roomType.text=boxTypeName
//            if (boxPrice>0){
//                layout_roomMoney.visibility=View.VISIBLE
//                roomMoney.text="${boxPrice}"
//            }else{
                layout_roomMoney.visibility=View.GONE
//            }

            Click.viewClick(tv_room_address).subscribe {
                dialog.showDialog()
            }


        }
    }

    private var boxTypeId = ""
    private var boxTypePeoples = ""
    private var ktvImg=""
    private var ktvName=""
    private var ktvAddress=""
    private var boxPrice=0.00
    private var minPrice= BigDecimal(0.00)
    private var boxTypeName=""
    private var boxName=""
    private var boxID=""
    private var businessId=""
    private var businessBoxId=""
    private var lat=""
    private var lng=""
    private var name=""
    private val presenter by lazy { KTVBoxPresenter(this,this,this) }
    private lateinit var dialog: SelectMapDialog

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_room_info

    override fun setActivityTitle() {
        titleText.text="包房信息"
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
        businessId=intent.getStringExtra("businessId")
        boxTypeId=intent.getStringExtra("boxTypeId")
        businessBoxId=intent.getStringExtra("businessBoxId")
        presenter.getKTVBox(KTVBoxBody(businessId.toInt()))
        dialog= SelectMapDialog(this)
        dialog.setDialogFace(this)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(btn_room_info).subscribe {
            DrinkUtils.deleteALLDrinks()//删除所有酒水
            ServeUtils.deleteALLServe()//删除所有服务员
            setNum("0")
            user.setRoomType("1")
            DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                    ktvName,
                    businessId,
                    ktvImg,
                    boxTypeName,
                    boxTypeId,
                    boxID,
                    boxName,
                    true,
                    boxTypePeoples, minPrice.toString(),
                    lng,
                    lat,
                    ktvAddress,
                    boxPrice.toString()))

            finish()
            setYueID("1")
            intentUsils.intentYue(0)

        }


    }

    //判断包名是否存在
    fun isPackageInstalled(packageName: String): Boolean {
        return File("/data/data/$packageName").exists()
    }

}