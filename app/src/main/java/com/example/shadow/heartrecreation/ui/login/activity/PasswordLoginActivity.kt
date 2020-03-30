package com.example.shadow.heartrecreation.ui.login.activity

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import cn.jpush.android.api.JPushInterface
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.api.BasicCallback
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
//import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.DbUtils.setUserDB
import com.example.shadow.heartrecreation.ui.leadpage.utils.intentUtils
import com.example.shadow.heartrecreation.ui.login.BaseActivity
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByPwdBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ByPwdBody
import com.example.shadow.heartrecreation.ui.login.mvp.presenter.ByPwdPresenter
import com.example.shadow.heartrecreation.ui.login.mvp.view.ByPwdView
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentLogin
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentResetPassword
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMain
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_password_login.*

class PasswordLoginActivity : BaseActivity(), ByPwdView {

    private val presenter by lazy { ByPwdPresenter(this, this, this) }
    private var flag=false
    private var phone=""

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_password_login

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        ActivityUtils.finishOtherActivities(PasswordLoginActivity::class.java)
        if (intent!=null&&intent.getStringExtra("phone")!=null) {
            phone = intent.getStringExtra("phone")
            passwordPhone.setText(phone)
        }
        registerVerification.transformationMethod= PasswordTransformationMethod.getInstance()
        pwdLoginHide.setImageResource(R.mipmap.ic_eye_off)
        flag=true
    }

    override fun clickListener() {
        Click.viewClick(smsBtn).subscribe {
            intentLogin(phone)
            finish()
        }
        Click.viewClick(passwordBtn).subscribe {
            intentResetPassword(phone)
            finish()
        }
        Click.viewClick(registerNext).subscribe {
            if (passwordPhone.text.toString().length != 11) {
                Toast.Tips("请输入正确手机号")
            } else if (registerVerification.text.toString().length > 12||registerVerification.text.toString().length <6) {
                Toast.Tips("请输入正确密码")
            } else {
                presenter.getByPwd(ByPwdBody(passwordPhone.text.toString(), registerVerification.text.toString()))
            }
        }

        Click.viewClick(pwdLoginHide).subscribe {
            if (flag){
                registerVerification.transformationMethod= HideReturnsTransformationMethod.getInstance()
                pwdLoginHide.setImageResource(R.mipmap.ic_eye_on)
                flag=false
            }else{
                registerVerification.transformationMethod= PasswordTransformationMethod.getInstance()
                pwdLoginHide.setImageResource(R.mipmap.ic_eye_off)
                flag=true
            }
        }

        passwordPhone.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length==11&&registerVerification.text!=null&&registerVerification.text.toString().length>=6){
                    registerNext.isEnabled=true
                }else{
                    registerNext.isEnabled=false
                }

                if (s!=null&&s.toString().length==11){
                    phone=s.toString()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        registerVerification.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length>=6&&passwordPhone.text!=null&&passwordPhone.text.toString().length==11){
                    registerNext.isEnabled=true
                }else{
                    registerNext.isEnabled=false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

    }

    //密码登陆成功
    override fun getByPwdRequest(data: ByCodeBean) {
        if (SharedUtils.getTag(this)){
            intentMain()
        }else{
            intentUtils.intentLead0()
        }

        try {
            var use= DbUtils.getUser()
//            LogUtils.a("useid"+use.userId)
//            LogUtils.a("dataid"+data.data.userId)
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
//                ActivityUtils.finishAllActivities()
            }else{
                setUserDB(data.data)
                finish()
//                ActivityUtils.finishAllActivities()
            }
        }catch (e:Exception){
            setUserDB(data.data)
            finish()
//            intentMain()
//            ActivityUtils.finishAllActivities()
        }

        JPushInterface.setAlias(this, 2, user.getJMID())
        LogUtils.a("id", user.getJMID())
        LogUtils.a("pwd", user.getUserIM())
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
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if(KeyEvent.KEYCODE_BACK==keyCode)
            return false
        return super.onKeyDown(keyCode, event)
    }
}