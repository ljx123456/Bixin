package com.example.shadow.heartrecreation.ui.login.mvp.data

import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ValidationCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ValidationCodeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.utils.Toast

class ValidationCodeData(val validationcode: ValidationCode) : BaseData<ValidationCodeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getValidationCode(body: ValidationCodeBody) {
        api(Api.getApi().getValidationCode(body)).build()
    }

    override fun onSucceedRequest(data: ValidationCodeBean, what: Int) {
        validationcode.getValidationCodeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        Toast.Tips(msg)
        validationcode.getValidationCodeError()
    }

    interface ValidationCode {
        fun getValidationCodeRequest(data: ValidationCodeBean)
        fun getValidationCodeError()
    }
}