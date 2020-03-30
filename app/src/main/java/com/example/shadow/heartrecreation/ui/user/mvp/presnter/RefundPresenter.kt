package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.RefundData
import com.example.shadow.heartrecreation.ui.user.mvp.view.RefundView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class RefundPresenter(owner: LifecycleOwner, val view: RefundView, val mContext: Context) : BasePresenter(owner, view, mContext), RefundData.Refund {


    private val refund = RefundData(this)

    fun getRefund(body: RefundBody) {
        refund.getRefund(body)
    }

    override fun getRefundRequest(data: RefundBean) {
        view.getRefundRequest(data)
    }

    override fun getRefundError() {
        view.getRefundError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }
}