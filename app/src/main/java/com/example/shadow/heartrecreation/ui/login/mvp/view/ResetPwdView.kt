package com.example.shadow.heartrecreation.ui.login.mvp.view

import com.example.shadow.heartrecreation.base.BaseView

interface ResetPwdView:BaseView {
    fun getSendCodeRequest()
    fun getValidationCodeRequest()
    fun getResetPwdRequest()
}