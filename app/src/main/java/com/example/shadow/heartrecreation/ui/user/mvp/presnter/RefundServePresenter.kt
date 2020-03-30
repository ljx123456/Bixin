package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundServeBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundServeBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.RefundServeData
import com.example.shadow.heartrecreation.ui.user.mvp.view.RefundServeView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class RefundServePresenter(owner: LifecycleOwner, val view: RefundServeView, val mContext: Context) : BasePresenter(owner, view, mContext), RefundServeData.RefundServe {
    private val refundserve = RefundServeData(this)

    fun getRefundServe(body: RefundServeBody) {
//        view.showLoading(mContext)
        refundserve.getRefundServe(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        refundserve.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }

    override fun getRefundServeRequest(data: RefundServeBean) {
//        view.dismissLoading(mContext)
        view.getRefundServeRequest(data)
    }

    override fun getRefundServeError() {
//        view.dismissLoading(mContext)
        view.getRefundServeError()
    }

}