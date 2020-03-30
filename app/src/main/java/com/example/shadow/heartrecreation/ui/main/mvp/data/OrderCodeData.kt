package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderCodeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.OrderCodeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class OrderCodeData(val order: OrderCode) : BaseData<OrderCodeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getOrderCode(body: OrderCodeBody) {
        api(Api.getApi().getOrderCode(body)).build()
    }

    override fun onSucceedRequest(data: OrderCodeBean, what: Int) {
        order.getOrderCodeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        order.getOrderCodeError()
    }

    interface OrderCode {
        fun getOrderCodeRequest(data: OrderCodeBean)
        fun getOrderCodeError()
    }
}