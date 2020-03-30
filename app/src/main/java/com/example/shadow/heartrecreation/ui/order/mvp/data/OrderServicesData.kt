package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderServicesBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class OrderServicesData(val orderservices: OrderServices) : BaseData<OrderServicesBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getOrderServices(body: OrderServicesBody) {
        api(Api.getApi().getOrderServices(body)).build()
    }

    override fun onSucceedRequest(data: OrderServicesBean, what: Int) {
        orderservices.getOrderServicesRequeset(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        orderservices.getOrderServicesError()
    }

    interface OrderServices {
        fun getOrderServicesRequeset(data: OrderServicesBean)
        fun getOrderServicesError()
    }
}