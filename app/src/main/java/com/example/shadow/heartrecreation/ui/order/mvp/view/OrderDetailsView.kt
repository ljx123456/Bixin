package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean

interface OrderDetailsView :BaseView{
    fun getOrderDetailsRequest(data: OrderDetailsBean)
    fun getOrderDetailsError(code:Int)


}