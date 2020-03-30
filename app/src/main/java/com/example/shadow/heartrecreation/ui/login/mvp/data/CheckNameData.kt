package com.example.shadow.heartrecreation.ui.login.mvp.data

import com.example.shadow.heartrecreation.ui.login.mvp.bean.CheckNameBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ValidationCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.CheckNameBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class CheckNameData(val check: CheckName) : BaseData<CheckNameBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getCheckName(body: CheckNameBody) {
        api(Api.getApi().getCheckName(body)).build()
    }

    override fun onSucceedRequest(data: CheckNameBean, what: Int) {
        check.getCheckNameRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        Toast.Tips(msg)
        check.getCheckNameError()
    }

    interface CheckName {
        fun getCheckNameRequest(data: CheckNameBean)
        fun getCheckNameError()
    }
}