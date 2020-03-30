package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayServiceAgainBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast
import okhttp3.ResponseBody

class PayServiceAgainData(val payservice: PayServiceAgain) : BaseData<ResponseBody>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getPayServiceAgain(body: PayServiceAgainBody) {
        api(Api.getApi().getPayServiceAgain(body)).build()
    }

    override fun onSucceedRequest(data: ResponseBody, what: Int) {
        payservice.getPayServiceAgainRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        payservice.getPayServiceAgainError()
    }

    interface PayServiceAgain {
        fun getPayServiceAgainRequest(data: ResponseBody)
        fun getPayServiceAgainError()
    }
}