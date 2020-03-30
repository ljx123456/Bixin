package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddWineBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.AddWineData
import com.example.shadow.heartrecreation.ui.order.mvp.view.AddWineView
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import java.util.ArrayList

class AddWinePresenter(owner: LifecycleOwner, val view: AddWineView, val mContext: Context) : BasePresenter(owner, view, mContext), AddWineData.AddWine {
    override fun getAddWineRequest(data: ResponseBody) {
        view.dismissLoading(mContext)
        view.getAddWineRequest(data)
    }

    override fun getAddWineError() {
        view.dismissLoading(mContext)
    }

    private val addwine = AddWineData(this)

    fun getAddWine(body: AddWineBody) {
        view.showLoading(mContext)
        addwine.getAddWine(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        addwine.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}