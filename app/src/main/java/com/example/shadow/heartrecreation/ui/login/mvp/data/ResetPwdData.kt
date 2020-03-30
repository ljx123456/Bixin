package com.example.shadow.heartrecreation.ui.login.mvp.data

import com.example.shadow.heartrecreation.ui.login.mvp.bean.ResetPwdBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ResetPwdBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ResetPwdData(val resetpwd: ResetPwd) : BaseData<ResetPwdBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getResetPwd(body: ResetPwdBody) {
        api(Api.getApi().getResetPwd(body)).build()
    }

    override fun onSucceedRequest(data: ResetPwdBean, what: Int) {
        resetpwd.getResetPwdRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        Toast.Tips(msg)
        resetpwd.getResetPwdError()
    }

    interface ResetPwd {
        fun getResetPwdRequest(data: ResetPwdBean)
        fun getResetPwdError()
    }
}