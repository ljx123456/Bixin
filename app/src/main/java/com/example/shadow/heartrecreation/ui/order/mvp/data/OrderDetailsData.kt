package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderDetailsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class OrderDetailsData(val orderdetails: OrderDetails) : BaseData<OrderDetailsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getOrderDetails(body: OrderDetailsBody) {
        api(Api.getApi().getOrderDetails(body)).build()
    }

    override fun onSucceedRequest(data: OrderDetailsBean, what: Int) {
        orderdetails.getOrderDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()&&flag!=-3002) {
            Toast.Tips(msg)
        }
        orderdetails.getOrderDetailsError(flag)
    }

    interface OrderDetails {
        fun getOrderDetailsRequest(data: OrderDetailsBean)
        fun getOrderDetailsError(code:Int)
    }
}