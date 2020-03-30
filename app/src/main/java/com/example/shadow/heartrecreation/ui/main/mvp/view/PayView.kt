package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks

interface PayView:BaseView {
    fun AliPay(data: AliPayBean.DataBean?)
    fun WeChatPay(data: WeChatBean.DataBean?)
    fun getOrderRequest(data:OrderPayBean)

    fun getPayError(data:ErrorDrinks?)
}