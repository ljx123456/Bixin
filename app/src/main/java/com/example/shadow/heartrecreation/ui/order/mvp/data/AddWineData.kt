package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.AddWineBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddWineBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast
import okhttp3.ResponseBody

class AddWineData(val addwine: AddWine) : BaseData<ResponseBody>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getAddWine(body: AddWineBody) {
        api(Api.getApi().getAddWine(body)).build()
    }

    override fun onSucceedRequest(data: ResponseBody, what: Int) {
        addwine.getAddWineRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        addwine.getAddWineError()
    }

    interface AddWine {
        fun getAddWineRequest(data: ResponseBody)
        fun getAddWineError()
    }
}