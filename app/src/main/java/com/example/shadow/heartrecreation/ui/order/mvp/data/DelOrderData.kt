package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.DelOrderBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class DelOrderData(val del: DelOrder) : BaseData<DelOrderBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getDelOrder(body: DelOrderBody) {
        api(Api.getApi().getDelOrder(body)).build()
    }

    override fun onSucceedRequest(data: DelOrderBean, what: Int) {
        del.getDelOrderRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        del.getDelOrderError()
    }

    interface DelOrder {
        fun getDelOrderRequest(data: DelOrderBean)
        fun getDelOrderError()
    }
}