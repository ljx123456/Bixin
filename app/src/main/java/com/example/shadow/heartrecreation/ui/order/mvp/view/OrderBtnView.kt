package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.CancelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelOrderBean

interface OrderBtnView:BaseView {
    fun CancelOrderRequest(data: CancelOrderBean)
    fun CancelOrderError()
    fun getCancelServiceRequest()

    fun getDelOrderRequest(data: DelOrderBean)
}