package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeDetailsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ServeDetailsData(val servedetails: ServeDetails) : BaseData<ServeDetailsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getServeDetails(body: ServeDetailsBody) {
        api(Api.getApi().getServeDetails(body)).build()
    }

    override fun onSucceedRequest(data: ServeDetailsBean, what: Int) {
        servedetails.getServeDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        servedetails.getServeDetailsError()
    }

    interface ServeDetails {
        fun getServeDetailsRequest(data: ServeDetailsBean)
        fun getServeDetailsError()
    }
}