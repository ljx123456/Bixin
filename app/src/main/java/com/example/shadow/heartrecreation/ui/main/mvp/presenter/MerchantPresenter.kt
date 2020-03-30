package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.MerchantData
import com.example.shadow.heartrecreation.ui.main.mvp.view.MerchantView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MerchantPresenter(owner: LifecycleOwner, val view: MerchantView, val mContext: Context) : BasePresenter(owner, view, mContext), MerchantData.Merchant {

    private val merchant = MerchantData(this)

    fun getMerchant(body: MerchantBody) {
//        view.showLoading(mContext)
        merchant.getMerchant(body)
    }

    override fun getMerchantRequest(data: MerchantBean) {
//        view.dismissLoading(mContext)
        view.getMerchantRequest(data)
    }

    override fun getMerchantError() {
//        view.dismissLoading(mContext)
        view.getMerchantError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        merchant.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}