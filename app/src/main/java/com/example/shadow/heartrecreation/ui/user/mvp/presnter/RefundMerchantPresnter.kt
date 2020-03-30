package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundMerchantBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundMerchantBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.RefundMerchantData
import com.example.shadow.heartrecreation.ui.user.mvp.view.RefundMerchantView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class RefundMerchantPresnter(owner: LifecycleOwner, val view: RefundMerchantView, val mContext: Context) : BasePresenter(owner, view, mContext),
        RefundMerchantData.RefundMerchant {

    private val refundmerchant = RefundMerchantData(this)


    fun getRefundMerchant(body: RefundMerchantBody) {
//        view.showLoading(mContext)
        refundmerchant.getRefundMerchant(body)
    }

    override fun getRefundMerchantRequest(data: RefundMerchantBean) {
//        view.dismissLoading(mContext)
        view.getRefundMerchantRequest(data)
    }

    override fun getRefundMerchantError() {
//        view.dismissLoading(mContext)
        view.getRefundMerchantError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        refundmerchant.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}