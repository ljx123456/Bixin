package com.example.shadow.heartrecreation.ui.login.activity

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import cn.jpush.android.api.JPushInterface
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.api.BasicCallback
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.AppUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
//import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.DbUtils.getUser
import com.example.shadow.heartrecreation.db.DbUtils.setUserDB
import com.example.shadow.heartrecreation.ui.leadpage.utils.intentUtils
import com.example.shadow.heartrecreation.ui.login.BaseActivity
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.SendCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ByCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.SendCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.presenter.ByCodePresenter
import com.example.shadow.heartrecreation.ui.login.mvp.view.ByCodeView
import com.example.shadow.heartrecreation.ui.login.utils.CodeTime
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentPasswordLogin
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentSetPassword
import com.example.shadow.heartrecreation.ui.main.dialog.VersionUpdatingDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateBody
import com.example.shadow.heartrecreation.ui.main.mvp.view.SplashView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMain
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import com.pp.wsy.bosom.app.ui.login.mvp.presenter.SplashPresenter
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.NullPointerException

class LoginActivity : BaseActivity(), ByCodeView, SplashView, VersionUpdatingDialog.VersionUpdatingCallBack {
    //更新接口
    override fun getUpdateRequest(data: UpdateBean) {
        updatingdialog.setDialogContent(data, this)
        updatingdialog.show(supportFragmentManager, "")
    }
    override fun getUpdateError(code: Int, message: String) {
        if (code!=-1301)
            Toast.Tips(message)
    }

    override fun enterInto() {

    }

    private val updataPresenter by lazy { SplashPresenter(this, this, this) }
    private val updatingdialog = VersionUpdatingDialog()

    private val presenter by lazy { ByCodePresenter(this, this, this) }
    private val codeTime = CodeTime()
    private var phone=""
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_login

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
//        JPushInterface.deleteAlias(this,2)
        ActivityUtils.finishOtherActivities(LoginActivity::class.java)
        updataPresenter.getUpsata(UpdateBody(1, AppUtils.getAppVersionCode()))
        if (intent!=null&&intent.getStringExtra("phone")!=null) {
            phone = intent.getStringExtra("phone")
            loginPhone.setText(phone)
        }
    }

    override fun clickListener() {
        Click.viewClick(passwordBtn).subscribe {
            intentPasswordLogin(phone)
            finish()
        }
        Click.viewClick(registerNext).subscribe {
            presenter.getCode(ByCodeBody(loginPhone.text.toString(), registerVerification.text.toString()))
        }
        //获取验证码
        Click.viewClick(registerGetVerification).subscribe {
            if (loginPhone.text.toString().length != 11) {
                Toast.Tips("请输入正确手机号")
            } else {
                presenter.getSendCode(SendCodeBody(loginPhone.text.toString(), "", 0))
            }
        }

        loginPhone.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
               if (registerVerification.text!=null&&registerVerification.text.toString().length==4&&s!=null&&s.toString().length==11){
                   registerNext.isEnabled=true
               }else{
                   registerNext.isEnabled=false
               }
                if (s!=null&&s.toString().length==11&&phone!=s.toString()){
                    codeTime.onDestroy()
                    phone=s.toString()
                }
            }
        })

        registerVerification.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (loginPhone.text!=null&&loginPhone.text.toString().length==11&&s!=null&&s.toString().length==4){
                    registerNext.isEnabled=true
                }else{
                    registerNext.isEnabled=false
                }
            }
        })


    }

    //发送验证码成功
    override fun getSendCodeRequest() {
        codeTime.codeCountTimer(registerGetVerification)
    }

    //登陆成功
    override fun getByCodeRequest(data: ByCodeBean) {
//        LogUtils.a("登陆数据", Gson().toJson(data))
        when (data.code) {
            -1101 -> {
                intentSetPassword(loginPhone.text.toString(), 1)
                finish()
            }
            0 -> {
                if (SharedUtils.getTag(this)){
                    intentMain()
                }else{
                    intentUtils.intentLead0()
                }
                try {
                   var use=getUser()
//                    LogUtils.a("useid"+use.userId)
//                    LogUtils.a("dataid"+data.data.userId)
                    if (use.userId.toString()!=data.data.userId){
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

                        setUserDB(data.data)
                        finish()
//                        ActivityUtils.finishAllActivities()
                    }else{
                        setUserDB(data.data)
                        finish()
//                        ActivityUtils.finishAllActivities()
                    }
                }catch (e:Exception){
                    setUserDB(data.data)
                    finish()
//                    ActivityUtils.finishAllActivities()
                }


                JPushInterface.setAlias(this, 2, user.getJMID())

//                LogUtils.a("id", user.getJMID())
//                LogUtils.a("pwd", user.getUserIM())
//        JMessageClient.logout()

                JMessageClient.login(user.getJMID(),user.getUserIM(),object : BasicCallback(){
                    override fun gotResult(p0: Int, p1: String?) {
                        if (p0==0) {
                            JMessageClient.logout()
                            LogUtils.a("极光聊天",p0.toString())
                            Handler().postDelayed(object :Runnable{
                                override fun run() {
                                    JMessageClient.login(user.getJMID(),user.getUserIM(),object : BasicCallback(){
                                        override fun gotResult(p0: Int, p1: String?) {
                                            if (p0==0) {
                                                LogUtils.a("极光聊天",p0.toString())
                                            }
                                        }
                                    })

                                }
                            },500)

                        }
                    }
                })
//                dismissLoading()

            }
            else -> Toast.Tips("")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        codeTime.onDestroy()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if(KeyEvent.KEYCODE_BACK==keyCode){
            try {
                dismissLoading()
            }catch (e:Exception){
                e.printStackTrace()
            }
            return false
        }
        return super.onKeyDown(keyCode, event)
    }
}