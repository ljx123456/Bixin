package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateOrderBean

interface EvaluateOrderView:BaseView {
    fun getEvaluateOrderRequest(data: EvaluateOrderBean)
    fun getEvaluateOrderError()
}