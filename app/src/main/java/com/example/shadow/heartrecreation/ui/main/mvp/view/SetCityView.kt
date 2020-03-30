package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean

interface SetCityView :BaseView{
    fun getCityListRequest(data: CityListBean)
    fun getCityListError()
}