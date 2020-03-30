package com.example.shadow.heartrecreation.db

import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.db.GreenDaoHelper.getDaoSessions
import com.example.shadow.heartrecreation.db.db.MerchantDB
import com.example.shadow.heartrecreation.db.db.UserDB
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean

object DbUtils {

    fun getUser(): UserDB {
        var user = getDaoSessions().userDBDao
        var data = user.loadAll().get(0)
        return data
    }

    fun setUserDB(info: ByCodeBean.DataBean) {
        var userDB = UserDB(0.toLong(), info.avatar, info.birthday, info.constellation, info.identity, info.nickname, info.phone, info.rongToken, "${info.sex}", info.token,info.bixinId,info.userId.toInt(),info.age,info.jmpassword)
        var userdata = getDaoSessions().userDBDao
        if (userdata != null) {
            userdata.deleteAll()
        }
        try {
            userdata.insert(userDB)
        } catch (e: Exception) {
            LogUtils.a("DB", e.toString())
        }
    }

    fun DelUser(){
        var user = getDaoSessions().userDBDao
        user.deleteAll()
    }

    fun setMerchatDB(info: MerchantDB) {
        var merchatDB = MerchantDB(0.toLong(), info.merchantName, info.merchantID, info.merchantImage, info.baofangType,info.baofangTypeID, info.baofangID, info.baofangName,info.baofang, info.baofangNum, info.baofangMoney, info.lon, info.dem, info.merchantAdds, info.merchatServicePrice)
        var merchatdata = getDaoSessions().merchantDBDao
        if (merchatdata != null) {
            merchatdata.deleteAll()
        }
        try {
            merchatdata.insert(merchatDB)
        } catch (e: Exception) {
            LogUtils.a("DB", e.toString())
        }
    }




    fun delMerchat() {
        var merchat = getDaoSessions().merchantDBDao
        if (merchat != null) {
            merchat.deleteAll()
        }
    }

    fun getMerchat(): MerchantDB {
        var merchat = getDaoSessions().merchantDBDao
        var data:MerchantDB=MerchantDB()
        if (merchat!=null&&merchat.loadAll().size>0)
            data = merchat.loadAll().get(0)
        return data
    }
}