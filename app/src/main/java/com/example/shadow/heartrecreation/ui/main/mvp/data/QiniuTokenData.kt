package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.example.shadow.heartrecreation.ui.main.mvp.bean.QiniuTokenBean
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo

class QiniuTokenData(val qiniutoken: QiniuToken) : BaseData<QiniuTokenBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getQiniuToken() {
        api(Api.getApi().getQiniuToken()).build()
    }

    override fun onSucceedRequest(data: QiniuTokenBean, what: Int) {
        qiniutoken.getQiniuTokenRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        qiniutoken.getQiniuTokenError()
    }

    interface QiniuToken {
        fun getQiniuTokenRequest(data: QiniuTokenBean)
        fun getQiniuTokenError()
    }
}