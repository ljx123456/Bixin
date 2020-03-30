package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.KTVBoxBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.KTVBoxBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast


class KTVBoxData(val ktv: KTVBox) : BaseData<KTVBoxBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getKTVBox(body: KTVBoxBody) {
        api(Api.getApi().getKTVBox(body)).build()
    }

    override fun onSucceedRequest(data: KTVBoxBean, what: Int) {
        ktv.getKTVBoxRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        ktv.getKTVBoxError()
    }

    interface KTVBox {
        fun getKTVBoxRequest(data: KTVBoxBean)
        fun getKTVBoxError()
    }
}