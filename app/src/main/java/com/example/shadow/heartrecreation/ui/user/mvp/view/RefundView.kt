package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundBean

interface RefundView:BaseView {
    fun getRefundRequest(data: RefundBean)
    fun getRefundError()
}