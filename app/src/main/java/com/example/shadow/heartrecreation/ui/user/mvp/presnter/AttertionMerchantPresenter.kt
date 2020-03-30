package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionMerchantBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.AttertionMerchantBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.AttertionMerchantData
import com.example.shadow.heartrecreation.ui.user.mvp.view.AttertionMerchantView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class AttertionMerchantPresenter(owner: LifecycleOwner, val view: AttertionMerchantView, val mContext: Context) : BasePresenter(owner, view, mContext), AttertionMerchantData.AttertionMerchant {

    private val attertionmerchant = AttertionMerchantData(this)

    fun getAttertionMerchant(body: AttertionMerchantBody) {
        attertionmerchant.getAttertionMerchant(body)
    }

    //获取商家成功
    override fun getAttertionMerchantRequest(data: AttertionMerchantBean) {
        view.getAttertionMerchantRequest(data)
    }

    //获取商家失败
    override fun getAttertionMerchantError() {
        view.getAttertionMerchantError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        attertionmerchant.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}