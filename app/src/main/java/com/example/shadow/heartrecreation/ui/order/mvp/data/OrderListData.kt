package com.example.shadow.heartrecreation.ui.order.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderListBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderListBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class OrderListData(val orderlist: OrderList) : BaseData<OrderListBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getOrderList(body: OrderListBody) {
        api(Api.getApi().getOrderList(body)).build()
    }

    override fun onSucceedRequest(data: OrderListBean, what: Int) {
        orderlist.getOrderListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        orderlist.getOrderListError()
    }

    interface OrderList {
        fun getOrderListRequest(data: OrderListBean)
        fun getOrderListError()
    }
}