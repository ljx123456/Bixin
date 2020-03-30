package com.example.shadow.heartrecreation.ui.user.activity

import android.text.Editable
import android.text.TextWatcher
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.login.mvp.bean.SendCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ValidationCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.SendCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.ValidationCodeBody
import com.example.shadow.heartrecreation.ui.login.utils.CodeTime
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.ChangePWCodePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.ChangePWCodeView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.layout_title.*

class ChangePWCodeActivity:BaseActivity(),ChangePWCodeView{


    private val presnter by lazy { ChangePWCodePresenter(this,this,this) }
    private val codeTime = CodeTime()
    private var phone=""

    //发送验证码成功
    override fun getCodeRequest(data: SendCodeBean) {
        codeTime.codeCountTimer(registerGetVerification)
    }

    override fun getCodeError() {


    }

    override fun getValidationCode(data: ValidationCodeBean) {
        intentUtils.intentChangePW()
    }

    override fun getValidationCodeError() {

    }

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.activity_change_password

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        var user = GreenDaoHelper.getDaoSessions().userDBDao
        if (user != null) {
            var data = user.loadAll()
            if (data != null && data.size >= 1 && data.get(0).token != null) {
                phone=data[0].phone
                presnter.sendCode(SendCodeBody(phone,data[0].token,6))
            }
        }

        registerVerification.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length==4){
                    btn_next.isEnabled=true
                }else{
                    btn_next.isEnabled=false
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
        Click.viewClick(btn_next).subscribe {
            if (phone!="") {
                presnter.validationCode(ValidationCodeBody(phone,registerVerification.text.toString(),6))
            }
        }
    }

}