package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.KTVBoxBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.KTVBoxBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.KTVBoxData
import com.example.shadow.heartrecreation.ui.main.mvp.view.KTVBoxView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class KTVBoxPresenter(owner: LifecycleOwner, val view: KTVBoxView, val context: Context) : BasePresenter(owner, view, context), KTVBoxData.KTVBox{

    private val ktv=KTVBoxData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        ktv.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getKTVBoxRequest(data: KTVBoxBean) {
        view.dismissLoading(context)
        view.getKTVBoxRequest(data)
    }

    override fun getKTVBoxError() {
        view.dismissLoading(context)
    }

    fun getKTVBox(body: KTVBoxBody){
        view.showLoading(context)
        ktv.getKTVBox(body)
    }
}