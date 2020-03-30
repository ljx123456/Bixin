package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.PayReInviteBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayReInviteBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class PayReInviteData(val payreinvite: PayReInvite) : BaseData<PayReInviteBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getPayReInvite(body: PayReInviteBody) {
        api(Api.getApi().getPayReInvite(body)).build()
    }

    override fun onSucceedRequest(data: PayReInviteBean, what: Int) {
        payreinvite.getPayReInviteRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        payreinvite.getPayReInviteError()
    }

    interface PayReInvite {
        fun getPayReInviteRequest(data: PayReInviteBean)
        fun getPayReInviteError()
    }
}