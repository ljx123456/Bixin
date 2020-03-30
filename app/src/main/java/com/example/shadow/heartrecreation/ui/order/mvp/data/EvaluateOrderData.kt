package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.EvaluateOrderBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class EvaluateOrderData(val evaluateorder: EvaluateOrder) : BaseData<EvaluateOrderBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getEvaluateOrder(body: EvaluateOrderBody) {
        api(Api.getApi().getEvaluateOrder(body)).build()
    }

    override fun onSucceedRequest(data: EvaluateOrderBean, what: Int) {
        evaluateorder.getEvaluateOrderRequest(data)

    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        evaluateorder.getEvaluateOrderError()
    }

    interface EvaluateOrder {
        fun getEvaluateOrderRequest(data: EvaluateOrderBean)
        fun getEvaluateOrderError()
    }
}