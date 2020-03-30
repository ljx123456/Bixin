package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionServeBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.AttertionServeBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.AttertionServeData
import com.example.shadow.heartrecreation.ui.user.mvp.view.AttertionServeView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class AttertionServePresnter(owner: LifecycleOwner, val view: AttertionServeView, val mContext: Context) : BasePresenter(owner, view, mContext), AttertionServeData.AttertionServe {

    private val attertionServe = AttertionServeData(this)

    fun getAttertionServe(body: AttertionServeBody) {
        attertionServe.getAttertionServe(body)
    }


    //获取到关注的达人
    override fun getAttertionServeRequest(data: AttertionServeBean) {
        view.getAttertionServeRequest(data)
    }

    //获取关注达人失败
    override fun getAttertionServeError() {
        view.getAttertionServeError()
    }


    override fun addDisposableList(list: ArrayList<Disposable>) {
        attertionServe.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}