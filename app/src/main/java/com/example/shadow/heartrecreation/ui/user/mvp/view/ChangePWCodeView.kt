package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.login.mvp.bean.SendCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ValidationCodeBean

interface ChangePWCodeView:BaseView{
    fun getCodeRequest(data:SendCodeBean)

    fun getCodeError()

    fun getValidationCode(data:ValidationCodeBean)

    fun getValidationCodeError()
}