package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.AddPointListServiceBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddPointListServiceBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class AddPointListServiceData(val addpointlistservice: AddPointListService) : BaseData<AddPointListServiceBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getAddPointListService(body: AddPointListServiceBody) {
        api(Api.getApi().getAddPointListService(body)).build()
    }

    override fun onSucceedRequest(data: AddPointListServiceBean, what: Int) {
        addpointlistservice.getAddPointListServiceRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        addpointlistservice.getAddPointListServiceError()
    }

    interface AddPointListService {
        fun getAddPointListServiceRequest(data: AddPointListServiceBean)
        fun getAddPointListServiceError()
    }
}