package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.FeedbackAddBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.FeedbackAddBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class FeedbackAddData(val feedbackadd: FeedbackAdd) : BaseData<FeedbackAddBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getFeedbackAdd(body: FeedbackAddBody) {
        api(Api.getApi().getFeedbackAdd(body)).build()
    }


    override fun onSucceedRequest(data: FeedbackAddBean, what: Int) {
        feedbackadd.getFeedbackAddRequest()
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        feedbackadd.getFeedbackAddError()
    }

    interface FeedbackAdd {
        fun getFeedbackAddRequest()
        fun getFeedbackAddError()
    }
}