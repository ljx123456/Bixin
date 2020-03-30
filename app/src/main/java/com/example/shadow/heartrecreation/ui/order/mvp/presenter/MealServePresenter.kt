package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.AddPointListServiceBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddPointListServiceBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderServicesBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.AddPointListServiceData
import com.example.shadow.heartrecreation.ui.order.mvp.data.OrderServicesData
import com.example.shadow.heartrecreation.ui.order.mvp.view.MealServeView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MealServePresenter(owner: LifecycleOwner, val view: MealServeView, val mContext: Context) : BasePresenter(owner, view, mContext),
        AddPointListServiceData.AddPointListService, OrderServicesData.OrderServices {
    private val orderservices = OrderServicesData(this)
    private val addpointlistservice = AddPointListServiceData(this)

    fun getOrderServices(body: OrderServicesBody) {
        view.showLoading(mContext)
        orderservices.getOrderServices(body)
    }

    fun getAddPointListService(body: AddPointListServiceBody) {
        view.showLoading(mContext)
        addpointlistservice.getAddPointListService(body)
    }


    //设置达人成功
    override fun getAddPointListServiceRequest(data: AddPointListServiceBean) {
        view.dismissLoading(mContext)
        view.getAddPointListServiceRequest(data)
    }

    //设置达人失败
    override fun getAddPointListServiceError() {
        view.getAddPointListServiceError()
        view.dismissLoading(mContext)
    }

    //获取列表成功
    override fun getOrderServicesRequeset(data: OrderServicesBean) {
        view.getOrderServicesRequeset(data)
        view.dismissLoading(mContext)
    }

    //获取列表失败
    override fun getOrderServicesError() {
        view.getOrderServicesError()
        view.dismissLoading(mContext)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        orderservices.getDisposable()?.let { list.add(it) }
        addpointlistservice.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}