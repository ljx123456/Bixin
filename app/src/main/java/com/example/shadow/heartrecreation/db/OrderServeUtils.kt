package com.example.shadow.heartrecreation.db

import android.util.Log
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.db.GreenDaoHelper.getDaoSessions
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.google.gson.Gson

object OrderServeUtils {

    fun getOrderData(): List<OrderServeDB> {
        var orderDB = getDaoSessions().orderServeDBDao
        LogUtils.a(Gson().toJson(orderDB.loadAll()))
        if (orderDB != null && orderDB.loadAll() != null && orderDB.loadAll().size > 0) {
            return orderDB.loadAll()
        } else {
            var list = ArrayList<OrderServeDB>()
//            var model = OrderServeDB()
//            list.add(model)
            return list
        }
    }


    fun deleteAllOrder() {
        var orderDB = getDaoSessions().orderServeDBDao
        orderDB.deleteAll()
        LogUtils.a("…………………………" + Gson().toJson(getOrderData()))
    }


    fun setOrder(data: OrderServeDB) {
        var orderDB = getDaoSessions().orderServeDBDao
        try {
            orderDB.insert(data)
        } catch (e: Exception) {
            LogUtils.a("DB", e.toString())
        }
        LogUtils.a("…………………………" + Gson().toJson(getOrderData()))
    }

    fun haveData(data: List<OrderServeDB>, datas: OrderServeDB): Boolean {
        Log.e("测试","data1:"+data.size.toString()+"data2: "+datas.image)
        if (data!=null&&data.size>0){
            for (i in data.indices) {
                if (data[i]!=null&&data.get(i).name!=null&&data.get(i).name.equals(datas.name)) {
                    return true
                }
            }
        }
        return false
    }

}