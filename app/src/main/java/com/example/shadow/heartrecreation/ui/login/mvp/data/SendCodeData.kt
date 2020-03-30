package com.example.shadow.heartrecreation.ui.login.mvp.data

import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.ui.login.mvp.bean.SendCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.SendCodeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.utils.Toast
//发送验证码
class SendCodeData(val sendcode: SendCode) : BaseData<SendCodeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getSendCode(body: SendCodeBody) {
        api(Api.getApi().getSendCode(body)).build()
    }

    override fun onSucceedRequest(data: SendCodeBean, what: Int) {
        Toast.Tips(data.message)
        sendcode.getSendCodeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        Toast.Tips(msg)
        sendcode.getSendCodeError()
    }

    interface SendCode {
        fun getSendCodeRequest(data: SendCodeBean)
        fun getSendCodeError()
    }
}