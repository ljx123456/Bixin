package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.WineBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.WineBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class WineData(val wine: Wine) : BaseData<WineBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getWine(body: WineBody) {
        api(Api.getApi().getWine(body)).build()
    }

    override fun onSucceedRequest(data: WineBean, what: Int) {
        wine.getWineRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        wine.getWineError()
    }

    interface Wine {
        fun getWineRequest(data: WineBean)
        fun getWineError()
    }
}