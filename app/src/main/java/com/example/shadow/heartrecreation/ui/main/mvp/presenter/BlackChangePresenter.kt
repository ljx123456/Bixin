package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.BlackChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.data.BlackChangeData
import com.example.shadow.heartrecreation.ui.main.mvp.view.BlackChangeView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class BlackChangePresenter(owner: LifecycleOwner, val view: BlackChangeView, val mContext: Context) : BasePresenter(owner, view, mContext), BlackChangeData.BlackChange {
    override fun getBlackChangeRequest(data: BlackChangeBean) {
        view.dismissLoading(mContext)
        view.getBlackChangeRequest()
    }

    override fun getBlackChangeError() {
        view.dismissLoading(mContext)
        view.getBlackChangeError()
    }

    private val blackchange = BlackChangeData(this)

    fun getBlackChange(body: BlackChangeBean) {
        view.showLoading(mContext)
        blackchange.getBlackChange(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        blackchange.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}