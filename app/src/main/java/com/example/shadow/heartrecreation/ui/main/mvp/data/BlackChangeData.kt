package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.BlackChangeBean
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class BlackChangeData(val blackchange: BlackChange) : BaseData<BlackChangeBean>() {


    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getBlackChange(body: BlackChangeBean) {
        api(Api.getApi().getBlackChange(body)).build()
    }

    override fun onSucceedRequest(data: BlackChangeBean, what: Int) {
        blackchange.getBlackChangeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        blackchange.getBlackChangeError()
    }

    interface BlackChange {
        fun getBlackChangeRequest(data: BlackChangeBean)
        fun getBlackChangeError()
    }
}