package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MainBean
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class MainData(val main: Main) : BaseData<MainBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getMainData() {
        api(Api.getApi().getMainData()).build()
    }

    override fun onSucceedRequest(data: MainBean, what: Int) {
        main.getMainDataRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        main.getMainDataErroe()
    }

    interface Main {
        fun getMainDataRequest(data: MainBean)
        fun getMainDataErroe()
    }
}