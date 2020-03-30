package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.EvaluateOrderBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.EvaluateOrderData
import com.example.shadow.heartrecreation.ui.order.mvp.view.EvaluateOrderView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class EvaluateOrderPresenter(owner: LifecycleOwner, val view: EvaluateOrderView, val mContext: Context) : BasePresenter(owner, view, mContext), EvaluateOrderData.EvaluateOrder {
    override fun addDisposableList(list: ArrayList<Disposable>) {
        evaluateorder.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }

    override fun getEvaluateOrderRequest(data: EvaluateOrderBean) {
        view.dismissLoading(mContext)
        view.getEvaluateOrderRequest(data)
    }

    override fun getEvaluateOrderError() {
        view.dismissLoading(mContext)
        view.getEvaluateOrderError()
    }

    private val evaluateorder = EvaluateOrderData(this)

    fun getEvaluateOrder(body: EvaluateOrderBody) {
        view.showLoading(mContext)
        evaluateorder.getEvaluateOrder(body)
    }
}