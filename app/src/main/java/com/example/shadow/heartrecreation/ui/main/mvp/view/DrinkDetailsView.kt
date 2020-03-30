package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinkDetailsBean

interface DrinkDetailsView : BaseView {
    fun getDrinkDetailsRequest(data: DrinkDetailsBean)
}