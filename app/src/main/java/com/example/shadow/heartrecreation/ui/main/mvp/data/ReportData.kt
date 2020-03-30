package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.FansChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ReportBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ReportData(val report: Report) : BaseData<FansChangeBean>() {

    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getReport(body:ReportBody) {
        api(Api.getApi().getReport(body)).build()
    }

    override fun onSucceedRequest(data: FansChangeBean, what: Int) {
        report.getReportRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        report.getReportError()
    }

    interface Report {
        fun getReportRequest(data: FansChangeBean)
        fun getReportError()
    }
}