package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.AddPointListServiceBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean

interface MealServeView : BaseView {
    fun getAddPointListServiceRequest(data: AddPointListServiceBean)
    fun getAddPointListServiceError()
    fun getOrderServicesRequeset(data: OrderServicesBean)
    fun getOrderServicesError()
}