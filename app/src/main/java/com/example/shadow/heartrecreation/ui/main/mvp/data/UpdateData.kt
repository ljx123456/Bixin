package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class UpdateData(val update: Update) : BaseData<UpdateBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getUpdate(body: UpdateBody) {
        api(Api.getApi().getUpdate(body)).build()
    }

    override fun onSucceedRequest(data: UpdateBean, what: Int) {
        update.getUpdateRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            if (flag!=-1301)
                Toast.Tips(msg)
        }
        update.getUpdateError(flag,msg)
    }

    interface Update {
        fun getUpdateRequest(data: UpdateBean)
        fun getUpdateError(code:Int,msg:String)
    }
}