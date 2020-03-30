package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundServeBean

interface RefundServeView : BaseView {
    fun getRefundServeRequest(data: RefundServeBean)
    fun getRefundServeError()
}