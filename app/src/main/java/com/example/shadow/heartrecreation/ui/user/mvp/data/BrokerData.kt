package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BrokerBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BrokerBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class BrokerData(val broker: Broker) : BaseData<BrokerBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getBroker(body: BrokerBody) {
        api(Api.getApi().getBroker(body)).build()
    }

    override fun onSucceedRequest(data: BrokerBean, what: Int) {
        broker.getBrokerRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        broker.getBrokerError()
    }

    interface Broker {
        fun getBrokerRequest(data: BrokerBean)
        fun getBrokerError()
    }
}