package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderDetailsBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.OrderDetailsData
import com.example.shadow.heartrecreation.ui.order.mvp.view.OrderDetailsView
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentEvaluate
import com.google.gson.Gson
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class OrderDetailsPresenter(owner: LifecycleOwner, val view: OrderDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext), OrderDetailsData.OrderDetails {
    //    AddPointListServiceData
    override fun addDisposableList(list: ArrayList<Disposable>) {
        orderdetails.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    //获取详情成功
    override fun getOrderDetailsRequest(data: OrderDetailsBean) {
//        view.dismissLoading(mContext)
        datas = data
        view.getOrderDetailsRequest(data)
    }

    //获取详情失败
    override fun getOrderDetailsError(code:Int) {
//        view.dismissLoading(mContext)
        view.getOrderDetailsError(code)
    }

    private var datas = OrderDetailsBean()
    private val orderdetails = OrderDetailsData(this)
    fun getOrderDetails(body: OrderDetailsBody) {
//        view.showLoading(mContext)
        orderdetails.getOrderDetails(body)
    }

    fun GoEvaluate() {
        intentEvaluate(datas.data.orderNo)
    }
}