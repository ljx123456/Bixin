package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.WineBean

interface WineView:BaseView {
    fun getWineRequest(data: WineBean)
    fun getWineError()
}