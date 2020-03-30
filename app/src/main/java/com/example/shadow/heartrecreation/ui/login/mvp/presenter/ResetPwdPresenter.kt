package com.example.shadow.heartrecreation.ui.login.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ResetPwdBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.SendCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ValidationCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ResetPwdBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.SendCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.ValidationCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.data.ResetPwdData
import com.example.shadow.heartrecreation.ui.login.mvp.data.SendCodeData
import com.example.shadow.heartrecreation.ui.login.mvp.data.ValidationCodeData
import com.example.shadow.heartrecreation.ui.login.mvp.view.ResetPwdView
import com.example.shadow.heartrecreation.utils.utils.Toast
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ResetPwdPresenter(owner: LifecycleOwner, val view: ResetPwdView, val mContext: Context) : BasePresenter(owner, view, mContext),
        SendCodeData.SendCode, ResetPwdData.ResetPwd, ValidationCodeData.ValidationCode {

    //验证验证码
    fun getValidationCode(body: ValidationCodeBody) {
        validationcode.getValidationCode(body)
    }

    //验证验证码成功
    override fun getValidationCodeRequest(data: ValidationCodeBean) {
        view.dismissLoading(mContext)
        view.getValidationCodeRequest()
    }

    //验证验证码失败
    override fun getValidationCodeError() {
        view.dismissLoading(mContext)
    }


    private val sendcode = SendCodeData(this)
    private val resetpwd = ResetPwdData(this)
    private val validationcode = ValidationCodeData(this)

    //发送验证码
    fun getSendCode(body: SendCodeBody) {
        view.showLoading(mContext)
        sendcode.getSendCode(body)
    }

    //发送验证码成功
    override fun getSendCodeRequest(data: SendCodeBean) {
        if (data.code==-1101){
            Toast.Tips(data.message)
        }else{
            view.getSendCodeRequest()
        }
        view.dismissLoading(mContext)
    }

    //发送验证码失败
    override fun getSendCodeError() {
        view.dismissLoading(mContext)
    }

    //重置密码
    fun getResetPwd(body: ResetPwdBody) {
        view.showLoading(mContext)
        resetpwd.getResetPwd(body)
    }

    //重置成功
    override fun getResetPwdRequest(data: ResetPwdBean) {
        view.dismissLoading(mContext)
        view.getResetPwdRequest()
    }

    //重置失败
    override fun getResetPwdError() {
        view.dismissLoading(mContext)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        resetpwd.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}