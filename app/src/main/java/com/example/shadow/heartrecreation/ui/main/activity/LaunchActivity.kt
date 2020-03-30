package com.example.shadow.heartrecreation.ui.main.activity

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.blankj.utilcode.util.AppUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.dialog.VersionUpdatingDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateBody
import com.example.shadow.heartrecreation.ui.main.mvp.view.SplashView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.permissions.UserPermissions
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.pp.wsy.bosom.app.ui.login.mvp.presenter.SplashPresenter
import com.tbruyelle.rxpermissions2.RxPermissions
import com.umeng.analytics.MobclickAgent
import kotlinx.android.synthetic.main.activity_merchant_details.*
import java.lang.Exception

class LaunchActivity:BaseActivity(),UserPermissions.MemoryReadPermissionsFace, SplashView, VersionUpdatingDialog.VersionUpdatingCallBack {

    private val updataPresenter by lazy { SplashPresenter(this, this, this) }
    private val updatingdialog = VersionUpdatingDialog()

//    public fun getUpdata(){
//        updataPresenter.getUpsata(UpdateBody(1, 17))
//    }



    //更新接口
    override fun getUpdateRequest(data: UpdateBean) {
        if (updatingdialog.isAdded){}else {
            updatingdialog.setDialogContent(data, this)
            updatingdialog.show(supportFragmentManager, "")
        }
    }
    override fun getUpdateError(code: Int, message: String) {
        if (code!=-1301) {
            Toast.Tips(message)
        }else{

        }
    }

    override fun enterInto() {

    }
    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.activity_launch

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

    }

    override fun clickListener() {

    }

    override fun requestPermissionsFaceSucceed(context: Context, what: Int) {

    }

    override fun requestPermissionsFaceError() {

    }

    private var flag=false
    private var isTime=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_launch)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = window.decorView
            val option = ( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            decorView.systemUiVisibility = option
            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        }
//        val actionBar = getSupportActionBar()
//        actionBar!!.hide()
//        nac_layout.alpha = 0.toFloat()
//        nac_root.setFadingView(nac_layout)
//        nac_root.setFadingHeightView(detailsBanner)
//        try {
//            DbUtils.delMerchat()
//            DrinkUtils.deleteALLDrinks()
//            ServeUtils.deleteALLServe()
//            OrderServeUtils.deleteAllOrder()
//            user.setNum("0")
//            user.setOrderNo("")
//            user.setType("1")
//            user.setRoomType("0")
//            user.setBrokerType("0")
//            user.setYueID("1")
//            user.setYueName("")
//            user.setOrderID("")
//            user.setCityID("1")
//            user.setCity("")
//            user.setRoomMoney("0.00")
//        }catch (e:Exception){
//            e.printStackTrace()
//        }
//        var user = GreenDaoHelper.getDaoSessions().userDBDao
//
//        Handler().postDelayed(object :Runnable{
//            override fun run() {
//                if (user != null) {
//                    var data = user.loadAll()
//                    if (data != null && data.size >= 1 && data.get(0).token != null) {
//                        intentUsils.intentMain()
//                        finish()
//                    }else{
//                        intentUtils.intentLogin()
//                        finish()
//                    }
//                }else {
//                    intentUtils.intentLogin()
//                    finish()
//                }
//            }
//        },1000*3)
    }

    override fun onResume() {
        super.onResume()
//        updataPresenter.getUpsata(UpdateBody(1, AppUtils.getAppVersionCode()))
        if (!flag) {
            flag=true
            UserPermissions.userLocation(this,this)
            init()
        }
        if (BaseUrl.HOST_URL=="http://app.bixinyule.com/") {
            MobclickAgent.onResume(this)
        }
    }

    override fun onPause() {
        super.onPause()
        if (BaseUrl.HOST_URL=="http://app.bixinyule.com/") {
            MobclickAgent.onPause(this)
        }
    }

    fun init(){
        val rxPermissions = RxPermissions(this)
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE).subscribe { aBoolean ->
            if (aBoolean!!) {
                try {
                    DbUtils.delMerchat()
                    DrinkUtils.deleteALLDrinks()
                    ServeUtils.deleteALLServe()
                    OrderServeUtils.deleteAllOrder()
                    user.setNum("0")
                    user.setOrderNo("")
                    user.setType("1")
                    user.setRoomType("0")
                    user.setBrokerType("0")
                    user.setYueID("1")
                    user.setYueName("")
                    user.setOrderID("")
                    user.setCityID("1")
                    user.setCity("")
                    user.setRoomMoney("0.00")
                }catch (e:Exception){
                    e.printStackTrace()
                }
                var user = GreenDaoHelper.getDaoSessions().userDBDao
                Handler().postDelayed(object :Runnable{
                    override fun run() {
                        if (user != null) {
                            var data = user.loadAll()
                            if (data != null && data.size >= 1 && data.get(0).token != null) {
                                if (SharedUtils.getTag(this@LaunchActivity)){
                                    intentUsils.intentMain()
                                }else{
                                    com.example.shadow.heartrecreation.ui.leadpage.utils.intentUtils.intentLead0()
                                }
                                finish()
                            }else{
                                intentUtils.intentLogin()
                                finish()
                            }
                        }else {
                            intentUtils.intentLogin()
                            finish()
                        }
                    }
                },1000)


//                    if (isTime) {
//                        isTime=false
//                        Handler().postDelayed(object :Runnable{
//                            override fun run() {
//                                if (user != null) {
//                                    var data = user.loadAll()
//                                    if (data != null && data.size >= 1 && data.get(0).token != null) {
//                                        intentUsils.intentMain()
//                                        finish()
//                                    }else{
//                                        intentUtils.intentLogin()
//                                        finish()
//                                    }
//                                }else {
//                                    intentUtils.intentLogin()
//                                    finish()
//                                }
//                            }
//                        },1000*3)
//                    }else{
//                        if (user != null) {
//                            var data = user.loadAll()
//                            if (data != null && data.size >= 1 && data.get(0).token != null) {
//                                intentUsils.intentMain()
//                                finish()
//                            }else{
//                                intentUtils.intentLogin()
//                                finish()
//                            }
//                        }else {
//                            intentUtils.intentLogin()
//                            finish()
//                        }
//                    }
            } else {
                if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    ShowDialog.showCustomDialogs(this, "由于无法获取设备信息的权限,应用无法运行，请前往设置中心应用权限页设置", "去设置", "取消", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    dialog.dismiss()
                                    flag=false
                                    UserPermissions.gotoSet(this@LaunchActivity)
                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog.dismiss()
                                    finish()
                                }
                            }
                        }
                    })
                }else{

                    ShowDialog.showCustomDialogs(this, "由于无法获取设备信息的权限,应用无法运行，请开启权限", "去开启", "取消", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    init()
                                    dialog.dismiss()
                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog.dismiss()
                                    finish()
                                }
                            }
                        }
                    })
                }

            }
        }
    }
}