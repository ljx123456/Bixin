package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import okhttp3.ResponseBody

interface AddWineView:BaseView {
    fun getAddWineRequest(data: ResponseBody)
}