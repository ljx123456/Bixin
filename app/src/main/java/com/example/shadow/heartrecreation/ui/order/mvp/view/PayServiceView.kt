package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import okhttp3.ResponseBody

interface PayServiceView:BaseView {
    fun getPayServiceRequest(data: ResponseBody)

    fun getPayServiceAgainRequest(data: ResponseBody)
}