package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.ComplaintBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ComplaintData(val complaint: Complaint) : BaseData<ComplaintBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getComplaint(body: ComplaintBody) {
        api(Api.getApi().getComplaint(body)).build()
    }

    override fun onSucceedRequest(data: ComplaintBean, what: Int) {
        complaint.getComplaintRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        complaint.getComplaintError()
    }

    interface Complaint {
        fun getComplaintRequest(data: ComplaintBean)
        fun getComplaintError()
    }
}