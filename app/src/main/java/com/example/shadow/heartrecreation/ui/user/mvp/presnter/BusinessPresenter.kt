package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BusinessBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BusinessBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.BusinessData
import com.example.shadow.heartrecreation.ui.user.mvp.view.BusinessView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class BusinessPresenter(owner: LifecycleOwner, val view: BusinessView, val mContext: Context) : BasePresenter(owner, view, mContext), BusinessData.Business {
    override fun getBusinessRequest(data: BusinessBean) {
        view.dismissLoading(mContext)
        view.getBusinessRequest(data)
    }

    override fun getBusinessError() {
        view.dismissLoading(mContext)
        view.getBusinessError()
    }

    private val business = BusinessData(this)

    fun getBusiness(body: BusinessBody) {
        view.showLoading(mContext)
        business.getBusiness(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        business.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}