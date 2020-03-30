package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderListBean

interface OrderListView:BaseView {
    fun getOrderListRequest(data: OrderListBean)
    fun getOrderListError()

    fun getDelOrderRequest(data:DelOrderBean)
}