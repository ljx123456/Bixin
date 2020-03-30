package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinksBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.DrinksBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class DrinksData(val drinks: Drinks) : BaseData<DrinksBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getDrinks(body: DrinksBody) {
        api(Api.getApi().getDrinks(body)).build()
    }

    override fun onSucceedRequest(data: DrinksBean, what: Int) {
        drinks.getDrinksRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,data: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        drinks.getDrinksError()
    }

    interface Drinks {
        fun getDrinksRequest(data: DrinksBean)
        fun getDrinksError()
    }
}