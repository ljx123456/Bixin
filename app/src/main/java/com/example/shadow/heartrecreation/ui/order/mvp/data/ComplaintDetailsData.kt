package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.ComplaintDetailsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ComplaintDetailsData(val complaint: ComplaintDetails) : BaseData<ComplaintDetailsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getComplaintDetails(body: ComplaintDetailsBody) {
        api(Api.getApi().getComplaintDetails(body)).build()
    }

    override fun onSucceedRequest(data: ComplaintDetailsBean, what: Int) {
        complaint.getComplaintDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        complaint.getComplaintDetailsError()
    }

    interface ComplaintDetails {
        fun getComplaintDetailsRequest(data: ComplaintDetailsBean)
        fun getComplaintDetailsError()
    }
}