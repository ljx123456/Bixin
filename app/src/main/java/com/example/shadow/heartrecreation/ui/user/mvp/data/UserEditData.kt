package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.UserEditBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.UserEditBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class UserEditData(val useredit: UserEdit) : BaseData<UserEditBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun UserEdit(body: UserEditBody) {
        api(Api.getApi().getUserEdit(body)).build()
    }

    override fun onSucceedRequest(data: UserEditBean, what: Int) {
        useredit.getUserEditRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        useredit.getUserEditError()
    }

    interface UserEdit {
        fun getUserEditRequest(data: UserEditBean)
        fun getUserEditError()
    }
}