package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OccupationBean
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class OccupationData(val occupation:Occupation): BaseData<OccupationBean>(){

    fun getOccupation(){
        api(Api.getApi().getOccupation()).build()
    }

    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    override fun onSucceedRequest(data: OccupationBean, what: Int) {
        occupation.getOccupationRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int, data: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        occupation.getOccupationError()
    }

    interface Occupation{
        fun getOccupationRequest(data: OccupationBean)
        fun getOccupationError()
    }
}