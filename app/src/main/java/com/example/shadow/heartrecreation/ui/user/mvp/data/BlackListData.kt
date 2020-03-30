package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BlackListBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BlackListBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class BlackListData(val blacklist: BlackList) : BaseData<BlackListBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getBlackList(body: BlackListBody) {
        api(Api.getApi().getBlackList(body)).build()
    }

    override fun onSucceedRequest(data: BlackListBean, what: Int) {
        blacklist.getBlackListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        blacklist.getBlackListError()
    }

    interface BlackList {
        fun getBlackListRequest(data: BlackListBean)
        fun getBlackListError()
    }
}