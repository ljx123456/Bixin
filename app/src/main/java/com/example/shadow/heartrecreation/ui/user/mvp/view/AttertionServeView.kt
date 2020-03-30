package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionServeBean

interface AttertionServeView : BaseView {
    fun getAttertionServeRequest(data: AttertionServeBean)
    fun getAttertionServeError()
}