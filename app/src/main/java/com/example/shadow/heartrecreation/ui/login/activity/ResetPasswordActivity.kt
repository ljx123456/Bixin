package com.example.shadow.heartrecreation.ui.login.activity

import android.text.Editable
import android.text.TextWatcher
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.login.mvp.body.SendCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.ValidationCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.presenter.ResetPwdPresenter
import com.example.shadow.heartrecreation.ui.login.mvp.view.ResetPwdView
import com.example.shadow.heartrecreation.ui.login.utils.CodeTime
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentLogin
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : BaseActivity(), ResetPwdView {

    override fun getResetPwdRequest() {
        Toast.Tips("设置成功")
    }


    private val codeTime = CodeTime()
    private val presenter by lazy { ResetPwdPresenter(this, this, this) }
    private var phone=""

    //发送验证码成功
    override fun getSendCodeRequest() {
        codeTime.codeCountTimer(registerGetVerification)
    }

    //验证验证码成功
    override fun getValidationCodeRequest() {
        intentUtils.intentSetPassword(loginPhone.text.toString(), 2)
    }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_reset_password

    override fun setActivityTitle() {
    }

    override fun initActivityData() {
        if (intent!=null&&intent.getStringExtra("phone")!=null) {
            phone = intent.getStringExtra("phone")
            loginPhone.setText(phone)
        }
    }

    override fun clickListener() {
        Click.viewClick(smsBtn).subscribe {
            intentLogin(phone)
            finish()
        }

        Click.viewClick(registerGetVerification).subscribe {
            if (loginPhone.text.toString().length != 11) {
                Toast.Tips("请输入正确手机号")
            } else {
                presenter.getSendCode(SendCodeBody(loginPhone.text.toString(), "", 1))
            }
        }
        Click.viewClick(registerNext).subscribe {
            presenter.getValidationCode(ValidationCodeBody(loginPhone.text.toString(), registerVerification.text.toString(), 1))
        }
        loginPhone.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length==11&&registerVerification.text!=null&&registerVerification.text.toString().length==4){
                    registerNext.isEnabled=true
                }else{
                    registerNext.isEnabled=false
                }
                if (s!=null&&s.toString().length==11&&phone!=s.toString()){
                    codeTime.onDestroy()
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
                if (s!=null&&s.toString().length==4&&loginPhone.text!=null&&loginPhone.text.toString().length==11){
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

    override fun onDestroy() {
        super.onDestroy()
        codeTime.onDestroy()
    }
}