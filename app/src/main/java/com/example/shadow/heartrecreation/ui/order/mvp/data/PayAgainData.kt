package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.PayAgainBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayAgainBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast
import okhttp3.ResponseBody

class PayAgainData(val payagain: PayAgain) : BaseData<ResponseBody>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getPayAgain(body: PayAgainBody) {
        api(Api.getApi().getPayAgain(body)).build()
    }

    override fun onSucceedRequest(data: ResponseBody, what: Int) {
        payagain.getPayAgainRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        payagain.getPayAgainError()
    }

    interface PayAgain {
        fun getPayAgainRequest(data: ResponseBody)
        fun getPayAgainError()
    }
}