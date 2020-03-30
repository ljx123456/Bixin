package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean

interface ServeDetailsView : BaseView {
    fun getServeDetailsRequest(data: ServeDetailsBean)
    fun getServeDetailsError()
    fun getFansChangeRequest()

    fun getReportRequest()
}