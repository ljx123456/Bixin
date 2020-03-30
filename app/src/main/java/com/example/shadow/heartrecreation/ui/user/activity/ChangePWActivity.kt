package com.example.shadow.heartrecreation.ui.user.activity

import android.content.DialogInterface
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils
import com.example.shadow.heartrecreation.ui.user.mvp.body.ChangePWBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.ChangePWPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.ChangePWView
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_change_password_pw.*
import kotlinx.android.synthetic.main.layout_title.*

class ChangePWActivity:BaseActivity(),ChangePWView{

    private var flag=false
    private val presnter by lazy { ChangePWPresenter(this,this,this) }

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.activity_change_password_pw

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        var phone=user.getUserPhone().substring(0,3)+"****"+user.getUserPhone().substring(7,11)
        set_password_phone.text="您可以使用设置的密码登录您的账号（"+phone+"）"
        registerPassword.transformationMethod= PasswordTransformationMethod.getInstance()
        pwdHint.setImageResource(R.mipmap.ic_eye_off)
        flag=true
        registerPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length>=6&&s.toString().length<=12){
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

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(registerNext).subscribe {
            if (registerPassword.text.toString().length >= 6 && registerPassword.text.toString().length <= 12) {
                presnter.changePw(ChangePWBody(registerPassword.text.toString()))
            } else {
                Toast.Tips("密码需要大于6位且小于12位")
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
    }

    override fun getChangePWRequest() {
        ShowDialog.showCustomDialog(this,"密码修改成功,请重新登录","确定",object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                intentUtils.intentLogin()
                finish()
            }
        })
    }

    override fun getChangePWError() {

    }

}