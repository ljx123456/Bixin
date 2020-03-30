package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderShowTimeBean

interface OrderShowTimeView:BaseView {
    fun getOrderShowTimeRequest(data: OrderShowTimeBean)
    fun getOrderShowTimeError()
}