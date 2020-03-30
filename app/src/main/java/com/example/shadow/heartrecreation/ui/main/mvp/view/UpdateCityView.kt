package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView

interface UpdateCityView:BaseView{
    fun getUpdateCityRequest()
    fun getUpdateCityError()
}