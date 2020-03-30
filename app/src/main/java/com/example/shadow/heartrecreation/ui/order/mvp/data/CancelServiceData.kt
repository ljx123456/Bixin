package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.CancelServiceBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.CancelServiceBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class CancelServiceData(val cancelservice: CancelService) : BaseData<CancelServiceBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getCancelService(body: CancelServiceBody) {
        api(Api.getApi().getCancelService(body)).build()
    }

    override fun onSucceedRequest(data: CancelServiceBean, what: Int) {
        cancelservice.getCancelServiceRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        cancelservice.getCancelServiceError()
    }

    interface CancelService {
        fun getCancelServiceRequest(data: CancelServiceBean)
        fun getCancelServiceError()
    }
}