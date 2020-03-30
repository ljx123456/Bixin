package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.FollowChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.FollowChangeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class FollowChangeData(val followchange: FollowChange) : BaseData<FollowChangeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getFollowChange(body: FollowChangeBody) {
        api(Api.getApi().getFollowChange(body)).build()
    }

    override fun onSucceedRequest(data: FollowChangeBean, what: Int) {
        followchange.getFollowChangeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        followchange.getFollowChangeError()
    }

    interface FollowChange {
        fun getFollowChangeRequest(data: FollowChangeBean)
        fun getFollowChangeError()
    }
}