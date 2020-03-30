package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean

interface MyInviteView:BaseView {
    fun getOrderServicesRequeset(data: OrderServicesBean)
    fun getOrderServicesError()
    fun getDelServicesRequest()
    fun getPayReInviteRequest()
}