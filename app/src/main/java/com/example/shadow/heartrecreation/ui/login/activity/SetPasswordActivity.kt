package com.example.shadow.heartrecreation.ui.login.activity

import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.login.mvp.body.ResetPwdBody
import com.example.shadow.heartrecreation.ui.login.mvp.presenter.ResetPwdPresenter
import com.example.shadow.heartrecreation.ui.login.mvp.view.ResetPwdView
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentPasswordLogin
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentRegisterData
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_set_password.*

class SetPasswordActivity : BaseActivity(), ResetPwdView {


    var phone = ""
    var type = 0
    private var flag=false
    private val presenter by lazy { ResetPwdPresenter(this, this, this) }
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_set_password

    override fun setActivityTitle() {
    }

    override fun initActivityData() {
        phone = intent.getStringExtra("phone")
        type = intent.getIntExtra("type", 1)
        registerPassword.transformationMethod= PasswordTransformationMethod.getInstance()
        pwdHint.setImageResource(R.mipmap.ic_eye_off)
        flag=true
    }

    override fun clickListener() {
        Click.viewClick(registerNext).subscribe {
            if (type == 1) {
                if (registerPassword.text.toString().length >= 6 && registerPassword.text.toString().length <= 12) {
                    intentRegisterData(phone, registerPassword.text.toString())
                    finish()
                } else {
                    Toast.Tips("密码需要大于6位且小于12位")
                }
            } else {
                presenter.getResetPwd(ResetPwdBody(phone, registerPassword.text.toString(), registerPassword.text.toString()))
            }
        }

        Click.viewClick(pwdHint).subscribe {
            if (flag){
                registerPassword.transformationMethod= HideReturnsTransformationMethod.getInstance()
                pwdHint.setImageResource(R.mipmap.ic_eye_on)
                flag=false
            }else{
                registerPassword.transformationMethod= PasswordTransformationMethod.getInstance()
                pwdHint.setImageResource(R.mipmap.ic_eye_off)
                flag=true
            }
        }

        registerPassword.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length>=6){
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

    override fun getSendCodeRequest() {

    }

    override fun getValidationCodeRequest() {
    }

    //重置密码成功
    override fun getResetPwdRequest() {
        Toast.Tips("设置成功")
        intentPasswordLogin()
        ActivityUtils.finishAllActivities()
    }
}