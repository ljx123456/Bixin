package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MainBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.TipsBean

interface MainView : BaseView {
    fun getMainDataRequest(data: MainBean)
    fun getMainDataErroe()

    fun getTipsDataRequest(data:TipsBean)
}