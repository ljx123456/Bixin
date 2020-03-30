package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.body.PayBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast
import okhttp3.ResponseBody

class PayData(val pay: Pay) : BaseData<ResponseBody>() {


    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getPay(body: PayBody) {
        api(Api.getApi().getPay(body)).build()
    }

    override fun onSucceedRequest(data: ResponseBody, what: Int) {
        pay.getPayRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        pay.getPayError(drinks)
//        if (flag==-3030) {
//            pay.getPayError(drinks!!)
//        }
    }

    interface Pay {
        fun getPayRequest(data: ResponseBody)
        fun getPayError(data: ErrorDrinks?)
    }
}