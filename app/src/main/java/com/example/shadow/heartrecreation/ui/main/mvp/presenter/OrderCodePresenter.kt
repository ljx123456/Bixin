package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderCodeBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WineCodeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.OrderCodeBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.WineCodeBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.OrderCodeData
import com.example.shadow.heartrecreation.ui.main.mvp.data.WineCodeData
import com.example.shadow.heartrecreation.ui.main.mvp.view.OrderCodeView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class OrderCodePresenter(owner: LifecycleOwner, val view: OrderCodeView, val context: Context) : BasePresenter(owner, view, context), OrderCodeData.OrderCode, WineCodeData.WineCode {
    override fun getWineCodeRequest(data: WineCodeBean) {
        view.dismissLoading(context)
        view.getWineCodeRequest(data)
    }

    override fun getWineCodeError() {
        view.dismissLoading(context)
    }

    private val order=OrderCodeData(this)
    private val wine=WineCodeData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        order.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getOrderCodeRequest(data: OrderCodeBean) {
        view.dismissLoading(context)
        view.getOrderCodeRequest(data)
    }

    override fun getOrderCodeError() {
        view.dismissLoading(context)
    }

    fun getOrderCode(body:OrderCodeBody){
        view.showLoading(context)
        order.getOrderCode(body)
    }

    fun getWineCode(body:WineCodeBody){
        view.showLoading(context)
        wine.getWineCode(body)
    }
}