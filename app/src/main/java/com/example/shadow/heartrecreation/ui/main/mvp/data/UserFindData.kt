package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UserFindBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class UserFindData(val userfind: UserFind) : BaseData<UserFindBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getUserFind(body: UserFindBody) {
        api(Api.getApi().getUserFind(body)).build()
    }

    override fun onSucceedRequest(data: UserFindBean, what: Int) {
        userfind.getUserFindRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        userfind.getUserFindError()
    }

    interface UserFind {
        fun getUserFindRequest(data: UserFindBean)
        fun getUserFindError()
    }
}