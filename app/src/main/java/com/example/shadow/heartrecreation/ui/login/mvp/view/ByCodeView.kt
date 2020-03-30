package com.example.shadow.heartrecreation.ui.login.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean

interface ByCodeView : BaseView {
    fun getSendCodeRequest()
    fun getByCodeRequest(data: ByCodeBean)
}