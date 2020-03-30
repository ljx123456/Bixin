package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderCodeBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WineCodeBean

interface OrderCodeView:BaseView{
    fun getOrderCodeRequest(data:OrderCodeBean)
    fun getWineCodeRequest(data:WineCodeBean)
}