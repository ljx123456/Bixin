package com.example.shadow.heartrecreation.ui.meassage.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReportDetailsBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.ReportDetailsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ReportDetailsData(val details: ReportDetails) : BaseData<ReportDetailsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)
    fun getReportDetails(body: ReportDetailsBody) {
        api(Api.getApi().getReportDetails(body)).build()
    }

    override fun onSucceedRequest(data: ReportDetailsBean, what: Int) {
        details.getReportDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        details.getReportDetailsError()
    }

    interface ReportDetails {
        fun getReportDetailsRequest(data: ReportDetailsBean)
        fun getReportDetailsError()
    }
}