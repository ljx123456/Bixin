package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.FansChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.FansChangeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class FansChangeData(val fanschange: FansChange) : BaseData<FansChangeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getFansChange(body: FansChangeBody) {
        api(Api.getApi().getFansChange(body)).build()
    }

    override fun onSucceedRequest(data: FansChangeBean, what: Int) {
        fanschange.getFansChangeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        fanschange.getFansChangeError()
    }

    interface FansChange {
        fun getFansChangeRequest(data: FansChangeBean)
        fun getFansChangeError()
    }
}