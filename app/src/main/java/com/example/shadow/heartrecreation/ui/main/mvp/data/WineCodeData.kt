package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WineCodeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.WineCodeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class WineCodeData(val order: WineCode) : BaseData<WineCodeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getWineCode(body: WineCodeBody) {
        api(Api.getApi().getWineCode(body)).build()
    }

    override fun onSucceedRequest(data: WineCodeBean, what: Int) {
        order.getWineCodeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        order.getWineCodeError()
    }

    interface WineCode {
        fun getWineCodeRequest(data: WineCodeBean)
        fun getWineCodeError()
    }
}