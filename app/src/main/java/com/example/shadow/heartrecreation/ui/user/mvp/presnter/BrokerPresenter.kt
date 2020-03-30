package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BrokerBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BrokerBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.BrokerData
import com.example.shadow.heartrecreation.ui.user.mvp.view.BrokerView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class BrokerPresenter(owner: LifecycleOwner, val view: BrokerView, val mContext: Context) : BasePresenter(owner, view, mContext), BrokerData.Broker {
    override fun getBrokerRequest(data: BrokerBean) {
        view.dismissLoading(mContext)
        view.getBrokerRequest(data)
    }

    override fun getBrokerError() {
        view.dismissLoading(mContext)
        view.getBrokerError()
    }

    fun getBroker(body: BrokerBody) {
        view.showLoading(mContext)
        borker.getBroker(body)
    }

    private val borker = BrokerData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        borker.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}