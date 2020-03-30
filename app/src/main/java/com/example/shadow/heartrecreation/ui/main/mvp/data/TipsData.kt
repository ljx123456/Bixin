package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.TipsBean
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class TipsData(val tips: Tips) : BaseData<TipsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getTipsData() {
        api(Api.getApi().getTipsData()).build()
    }

    override fun onSucceedRequest(data: TipsBean, what: Int) {
        tips.getTipsDataRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        tips.getTipsDataErroe()
    }

    interface Tips {
        fun getTipsDataRequest(data: TipsBean)
        fun getTipsDataErroe()
    }
}