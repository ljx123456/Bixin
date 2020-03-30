package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.login.mvp.bean.SendCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ValidationCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.SendCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.ValidationCodeBody
import com.example.shadow.heartrecreation.ui.login.mvp.data.SendCodeData
import com.example.shadow.heartrecreation.ui.login.mvp.data.ValidationCodeData
import com.example.shadow.heartrecreation.ui.user.mvp.view.ChangePWCodeView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ChangePWCodePresenter(owner: LifecycleOwner, val view: ChangePWCodeView, val mContext: Context) : BasePresenter(owner, view, mContext),SendCodeData.SendCode,ValidationCodeData.ValidationCode{


    private val send=SendCodeData(this)
    private val validation=ValidationCodeData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        send.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun sendCode(body:SendCodeBody){
        view.showLoading(mContext)
        send.getSendCode(body)
    }

    override fun getSendCodeRequest(data: SendCodeBean) {
        view.dismissLoading(mContext)
        view.getCodeRequest(data)
    }

    override fun getSendCodeError() {
        view.dismissLoading(mContext)
        view.getCodeError()
    }

    fun validationCode(body:ValidationCodeBody){
        view.showLoading(mContext)
        validation.getValidationCode(body)
    }

    override fun getValidationCodeRequest(data: ValidationCodeBean) {
        view.dismissLoading(mContext)
        view.getValidationCode(data)
    }

    override fun getValidationCodeError() {
        view.dismissLoading(mContext)
        view.getValidationCodeError()
    }
}