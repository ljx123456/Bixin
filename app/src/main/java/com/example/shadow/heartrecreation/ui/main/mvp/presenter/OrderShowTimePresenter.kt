package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderShowTimeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.OrderShowTimeBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.OrderShowTimeData
import com.example.shadow.heartrecreation.ui.main.mvp.view.OrderShowTimeView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class OrderShowTimePresenter(owner: LifecycleOwner, val view: OrderShowTimeView, val mContext: Context) : BasePresenter(owner, view, mContext), OrderShowTimeData.OrderShowTime {

    private val ordershowtime = OrderShowTimeData(this)

    fun getOrderShowTime(body: OrderShowTimeBody) {
        view.showLoading(mContext)
        ordershowtime.getOrderShowTime(body)
    }

    //获取时间成功
    override fun getOrderShowTimeRequest(data: OrderShowTimeBean) {
        view.dismissLoading(mContext)
        view.getOrderShowTimeRequest(data)
    }

    //获取时间失败
    override fun getOrderShowTimeError() {
        view.dismissLoading(mContext)
        view.getOrderShowTimeError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        ordershowtime.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}