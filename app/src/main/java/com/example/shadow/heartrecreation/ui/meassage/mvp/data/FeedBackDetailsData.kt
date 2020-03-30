package com.example.shadow.heartrecreation.ui.meassage.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.FeedBackDetailsBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.FeedBackDetailsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class FeedBackDetailsData(val details: FeedBackDetails) : BaseData<FeedBackDetailsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)
    fun getFeedBackDetails(body: FeedBackDetailsBody) {
        api(Api.getApi().getFeedBackDetails(body)).build()
    }

    override fun onSucceedRequest(data: FeedBackDetailsBean, what: Int) {
        details.getFeedBackDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        details.getFeedBackDetailsError()
    }

    interface FeedBackDetails {
        fun getFeedBackDetailsRequest(data: FeedBackDetailsBean)
        fun getFeedBackDetailsError()
    }
}