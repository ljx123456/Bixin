package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayServiceBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast
import okhttp3.ResponseBody

class PayServiceData(val payservice: PayService) : BaseData<ResponseBody>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getPayService(body: PayServiceBody) {
        api(Api.getApi().getPayService(body)).build()
    }

    override fun onSucceedRequest(data: ResponseBody, what: Int) {
        payservice.getPayServiceRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        payservice.getPayServiceError()
    }

    interface PayService {
        fun getPayServiceRequest(data: ResponseBody)
        fun getPayServiceError()
    }
}