package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateCityBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateCityBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class UpdateCityData(val update: UpdateCity) : BaseData<UpdateCityBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getUpdateCity(body: UpdateCityBody) {
        api(Api.getApi().getUpdateCity(body)).build()
    }

    override fun onSucceedRequest(data: UpdateCityBean, what: Int) {
        update.getUpdateCityRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        update.getUpdateCityError(flag,msg)
    }

    interface UpdateCity {
        fun getUpdateCityRequest(data: UpdateCityBean)
        fun getUpdateCityError(code:Int,msg:String)
    }
}