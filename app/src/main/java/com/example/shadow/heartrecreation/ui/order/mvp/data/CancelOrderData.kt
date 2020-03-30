package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.CancelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.CancelOrderBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class CancelOrderData(val cancelorder: CancelOrder) : BaseData<CancelOrderBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun CancelOrder(body: CancelOrderBody) {
        api(Api.getApi().getCancelOrder(body)).build()
    }

    override fun onSucceedRequest(data: CancelOrderBean, what: Int) {
        cancelorder.CancelOrderRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        cancelorder.CancelOrderError()
    }

    interface CancelOrder {
        fun CancelOrderRequest(data: CancelOrderBean)
        fun CancelOrderError()
    }
}