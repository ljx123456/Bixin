package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionServeBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.AttertionServeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class AttertionServeData(val attertion: AttertionServe) : BaseData<AttertionServeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getAttertionServe(body: AttertionServeBody) {
        api(Api.getApi().getAttertionServe(body)).build()
    }

    override fun onSucceedRequest(data: AttertionServeBean, what: Int) {
        attertion.getAttertionServeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        attertion.getAttertionServeError()
    }

    interface AttertionServe {
        fun getAttertionServeRequest(data: AttertionServeBean)
        fun getAttertionServeError()
    }
}