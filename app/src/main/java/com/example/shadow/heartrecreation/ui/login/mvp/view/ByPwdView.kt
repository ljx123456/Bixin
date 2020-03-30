package com.example.shadow.heartrecreation.ui.login.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByPwdBean

interface ByPwdView:BaseView {
    fun getByPwdRequest(data: ByCodeBean)
}