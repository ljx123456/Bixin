package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelServicesBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.DelServicesBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class DelServicesData(val delservices: DelServices) : BaseData<DelServicesBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getDelServices(body: DelServicesBody) {
        api(Api.getApi().getDelServices(body)).build()
    }

    override fun onSucceedRequest(data: DelServicesBean, what: Int) {
        delservices.getDelServicesRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        delservices.getDelServicesError()
    }

    interface DelServices {
        fun getDelServicesRequest(data: DelServicesBean)
        fun getDelServicesError()
    }
}