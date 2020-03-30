package com.example.shadow.heartrecreation.ui.login.mvp.data

import android.util.Log
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ByCodeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.utils.Toast

class ByCodeData(val bycode: ByCode) : BaseData<ByCodeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun byCode(body: ByCodeBody) {
        api(Api.getApi().getByCode(body)).build()
    }

    override fun onSucceedRequest(data: ByCodeBean, what: Int) {
        bycode.getByCodeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        Toast.Tips(msg)
        bycode.getByCodeError()
    }

    interface ByCode {
        fun getByCodeRequest(data: ByCodeBean)
        fun getByCodeError()
    }
}