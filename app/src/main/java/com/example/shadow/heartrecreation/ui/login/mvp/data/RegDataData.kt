package com.example.shadow.heartrecreation.ui.login.mvp.data

import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.ui.login.mvp.bean.RegDataBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.RegDataBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.utils.Toast

class RegDataData(val regdata: RegData) : BaseData<ByCodeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun setRgeData(body: RegDataBody) {
        api(Api.getApi().setRegData(body)).build()
    }

    override fun onSucceedRequest(data: ByCodeBean, what: Int) {
        regdata.setRgeDataRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        Toast.Tips(msg)
        regdata.setRgeDataError()
    }

    interface RegData {
        fun setRgeDataRequest(data: ByCodeBean)
        fun setRgeDataError()

    }
}