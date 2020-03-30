package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ChangePWBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ChangePWBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ChangePWData(val change: ChangePW) : BaseData<ChangePWBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getChangePW(body: ChangePWBody) {
        api(Api.getApi().getChangePW(body)).build()
    }


    override fun onSucceedRequest(data: ChangePWBean, what: Int) {
        change.getChangePWRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        change.getChangePWError()
    }

    interface ChangePW {
        fun getChangePWRequest(data: ChangePWBean)
        fun getChangePWError()
    }
}