package com.example.shadow.heartrecreation.ui.login.mvp.data

import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByPwdBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ByPwdBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ByPwdData(val bypwd: ByPwd) : BaseData<ByCodeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getByPwd(body: ByPwdBody) {
        api(Api.getApi().getByPwd(body)).build()
    }

    override fun onSucceedRequest(data: ByCodeBean, what: Int) {
        bypwd.getByPwdRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        Toast.Tips(msg)
        bypwd.getByPwdError()
    }

    interface ByPwd {
        fun getByPwdRequest(data: ByCodeBean)
        fun getByPwdError()
    }
}