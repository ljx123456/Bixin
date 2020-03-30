package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ReasonBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.ReasonBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast


class ReasonData(val reason: Reason) : BaseData<ReasonBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getReason(body: ReasonBody) {
        api(Api.getApi().getReason(body)).build()
    }

    override fun onSucceedRequest(data: ReasonBean, what: Int) {
        reason.getReasonRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        reason.getReasonError()
    }

    interface Reason {
        fun getReasonRequest(data: ReasonBean)
        fun getReasonError()
    }
}