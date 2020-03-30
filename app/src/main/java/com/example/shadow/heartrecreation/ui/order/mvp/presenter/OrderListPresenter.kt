package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderListBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.DelOrderBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderListBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.DelOrderData
import com.example.shadow.heartrecreation.ui.order.mvp.data.OrderListData
import com.example.shadow.heartrecreation.ui.order.mvp.view.OrderListView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class OrderListPresenter(owner: LifecycleOwner, val view: OrderListView, val mContext: Context) : BasePresenter(owner, view, mContext), OrderListData.OrderList ,DelOrderData.DelOrder{
    override fun getDelOrderRequest(data: DelOrderBean) {
        view.dismissLoading(mContext)
        view.getDelOrderRequest(data)
    }

    override fun getDelOrderError() {
        view.dismissLoading(mContext)
        view.getOrderListError()
    }

    fun getDelOrder(body:DelOrderBody){
        view.showLoading(mContext)
        del.getDelOrder(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        orderlist.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }

    fun getOrderList(body: OrderListBody) {
        orderlist.getOrderList(body)
    }

    override fun getOrderListRequest(data: OrderListBean) {
        view.getOrderListRequest(data)
    }

    override fun getOrderListError() {
        view.getOrderListError()
    }

    private val orderlist = OrderListData(this)
    private val del=DelOrderData(this)
}