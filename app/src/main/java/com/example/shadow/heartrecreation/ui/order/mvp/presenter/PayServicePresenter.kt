package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayServiceAgainBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayServiceBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.PayServiceAgainData
import com.example.shadow.heartrecreation.ui.order.mvp.data.PayServiceData
import com.example.shadow.heartrecreation.ui.order.mvp.view.PayServiceView
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import java.util.ArrayList

class PayServicePresenter(owner: LifecycleOwner, val view: PayServiceView, val mContext: Context) : BasePresenter(owner, view, mContext),
        PayServiceData.PayService, PayServiceAgainData.PayServiceAgain {
    override fun getPayServiceAgainRequest(data: ResponseBody) {
        view.dismissLoading(mContext)
        view.getPayServiceAgainRequest(data)
    }

    override fun getPayServiceAgainError() {
        view.dismissLoading(mContext)
    }

    fun getPayServiceAgain(body:PayServiceAgainBody){
        view.showLoading(mContext)
        payServiceAgain.getPayServiceAgain(body)
    }

    private val payservice = PayServiceData(this)
    private val payServiceAgain=PayServiceAgainData(this)

    fun getPayService(body: PayServiceBody) {
        view.showLoading(mContext)
        payservice.getPayService(body)
    }

    override fun getPayServiceRequest(data: ResponseBody) {
        view.dismissLoading(mContext)
        view.getPayServiceRequest(data)
    }

    override fun getPayServiceError() {
        view.dismissLoading(mContext)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        payservice.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}