package com.example.shadow.heartrecreation.ui.login.utils

import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.ui.login.activity.*

object intentUtils {

    //跳转到验证码登陆
    fun intentLogin() {
        ActivityUtils.startActivity(LoginActivity::class.java)
    }

    fun intentLogin(phone: String){
        var intent = Intent(getContext(), LoginActivity::class.java)
        intent.putExtra("phone", phone)
        ActivityUtils.startActivity(intent)
    }

    //跳转到更换手机号码
    fun intentChangePhone() {
        ActivityUtils.startActivity(ChangePhoneActivity::class.java)
    }

    //跳转到完善资料
    fun intentRegisterData(phone: String, toString: String) {
        var intent = Intent(getContext(), RegisterDataActivity::class.java)
        intent.putExtra("phone", phone)
        intent.putExtra("password", toString)
        ActivityUtils.startActivity(intent)
    }

    //跳转到密码设置
    fun intentSetPassword(toString: String, i: Int) {
        var intent = Intent(getContext(), SetPasswordActivity::class.java)
        intent.putExtra("phone", toString)
        intent.putExtra("type", i)
        ActivityUtils.startActivity(intent)
    }

    //跳转到忘记密码
    fun intentResetPassword(phone: String){
//        ActivityUtils.startActivity(ResetPasswordActivity::class.java)
        var intent = Intent(getContext(), ResetPasswordActivity::class.java)
        intent.putExtra("phone", phone)
        ActivityUtils.startActivity(intent)
    }

    //跳转到重置手机号
    fun intentNewPhone() {
        ActivityUtils.startActivity(NewPhoneActivtiy::class.java)
    }

    //跳转到密码登陆
    fun intentPasswordLogin() {
        ActivityUtils.startActivity(PasswordLoginActivity::class.java)
    }

    fun intentPasswordLogin(phone: String) {
        var intent = Intent(getContext(), PasswordLoginActivity::class.java)
        intent.putExtra("phone", phone)
        ActivityUtils.startActivity(intent)
    }

}