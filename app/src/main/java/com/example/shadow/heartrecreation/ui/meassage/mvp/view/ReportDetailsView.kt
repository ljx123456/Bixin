package com.example.shadow.heartrecreation.ui.meassage.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReportDetailsBean

interface ReportDetailsView:BaseView{
    fun getReportDetailsRequest(data:ReportDetailsBean)
    fun getReportDetailsError()
}