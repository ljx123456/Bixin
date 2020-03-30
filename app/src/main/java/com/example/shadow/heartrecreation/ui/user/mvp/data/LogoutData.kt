package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.user.mvp.bean.LogoutBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.LogoutBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class LogoutData(val logout: Logout) : BaseData<LogoutBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getLogout() {
        api(Api.getApi().getLogout(LogoutBody(getUserToken()))).build()

    }

    override fun onSucceedRequest(data: LogoutBean, what: Int) {
        logout.getLogoutRequest()
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        logout.getLogoutError()
    }

    interface Logout {
        fun getLogoutRequest()
        fun getLogoutError()
    }
}