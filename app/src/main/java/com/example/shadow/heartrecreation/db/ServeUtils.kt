package com.example.shadow.heartrecreation.db

import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.db.GreenDaoHelper.getDaoSessions
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson

object ServeUtils {


    //添加或者减少数量
    fun addServeNum(key: Long, skillNum: Int) {
        var serveDB = getDaoSessions().servePersonnelDBDao
        var data = serveDB.load(key)
//        LogUtils.a("全部数据", Gson().toJson(serveDB.load(key)))
    }

    //删除对应某条数据
    fun deleteServe(key: Long) {
        var serveDB = getDaoSessions().servePersonnelDBDao
        serveDB.deleteByKey(key)
    }

    //获取全部数据库数据
    fun getServeData(): List<ServePersonnelDB> {
        var serveDB = getDaoSessions().servePersonnelDBDao
        if (serveDB != null) {
            var data = serveDB.loadAll()
            if (data != null && data.size > 0) {
                return data
            } else {
                var list = ArrayList<ServePersonnelDB>()
//                var model = ServePersonnelDB()
//                list.add(model)
                return list
            }
        } else {
            var list = ArrayList<ServePersonnelDB>()
//            var model = ServePersonnelDB()
//            list.add(model)
            return list
        }
    }


    //删除全部数据
    fun deleteALLServe() {
        var serveDB = getDaoSessions().servePersonnelDBDao
        serveDB.deleteAll()
    }


    //获取对应某条信息
    fun getServe(id: String): ServePersonnelDB {
        var data = getServeData()
        if (data != null && data.size > 0) {
            for (i in data.indices) {
                LogUtils.a("当前全部数据", Gson().toJson(data))
                if (id.equals(data.get(i).serveID)) {
                    LogUtils.a("当前全部数据sss", Gson().toJson(data.get(i)))
                    return data.get(i)
                }
            }
        } else {
            return ServePersonnelDB()
        }
        return ServePersonnelDB()
    }

    //插入某一条数据
    fun setServe(datas: ServePersonnelDB) {
        var serveDB = getDaoSessions().servePersonnelDBDao
        var data = getServeData()
        if (data != null && data.size >= 1 && data.get(0).name != null) {
            if (haveData(data, datas)) {
                Toast.Tips("您已选择当前达人")
            } else {
//                if (data.size >= user.getNum().toInt()) {
//                    Toast.Tips("当前邀请人数已到达最多邀请数")
//                } else {
                    try {
                        serveDB.insert(datas)
//                        Toast.Tips("添加成功")
//                        OrderServeUtils.setOrder(OrderServeDB(null, "${datas.serveID}", datas.name, datas.image))
                    } catch (e: Exception) {
                        LogUtils.a("DB", e.toString())
                    }
//                }

            }
        } else {
            try {
                serveDB.insert(datas)
//                Toast.Tips("添加成功")
            } catch (e: Exception) {
                LogUtils.a("DB", e.toString())
            }
        }
        LogUtils.a("当前全部数据sss", Gson().toJson(data))
    }

    internal fun haveData(data: List<ServePersonnelDB>, datas: ServePersonnelDB): Boolean {
        for (i in data.indices) {
            if (data.get(i).name.equals(datas.name)) {
                return true
            }
        }
        return false
    }
}