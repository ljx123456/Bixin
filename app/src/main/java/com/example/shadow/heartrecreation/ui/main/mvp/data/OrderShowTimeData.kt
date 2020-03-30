package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderShowTimeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.OrderShowTimeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class OrderShowTimeData(val ordershowtime: OrderShowTime) : BaseData<OrderShowTimeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getOrderShowTime(body: OrderShowTimeBody) {
        api(Api.getApi().getOrderShowTime(body)).build()
    }

    override fun onSucceedRequest(data: OrderShowTimeBean, what: Int) {
        ordershowtime.getOrderShowTimeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        ordershowtime.getOrderShowTimeError()
    }

    interface OrderShowTime {
        fun getOrderShowTimeRequest(data: OrderShowTimeBean)
        fun getOrderShowTimeError()
    }
}