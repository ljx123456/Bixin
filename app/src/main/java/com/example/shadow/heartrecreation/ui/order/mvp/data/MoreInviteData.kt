package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.MoreInviteBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.MoreInviteBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class MoreInviteData(val moreinvite: MoreInvite) : BaseData<MoreInviteBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getMoreInvite(body: MoreInviteBody) {
        api(Api.getApi().getMoreInvite(body)).build()
    }

    override fun onSucceedRequest(data: MoreInviteBean, what: Int) {
        moreinvite.getMoreInviteRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        moreinvite.getMoreInviteError()
    }

    interface MoreInvite {
        fun getMoreInviteRequest(data: MoreInviteBean)
        fun getMoreInviteError()
    }
}