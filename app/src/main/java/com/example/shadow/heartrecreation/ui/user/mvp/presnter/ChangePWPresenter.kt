package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ChangePWBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ChangePWBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.ChangePWData
import com.example.shadow.heartrecreation.ui.user.mvp.view.ChangePWView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ChangePWPresenter(owner: LifecycleOwner, val view: ChangePWView, val mContext: Context) : BasePresenter(owner, view, mContext),ChangePWData.ChangePW{

    private val change=ChangePWData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        change.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun changePw(body:ChangePWBody){
        view.showLoading(mContext)
        change.getChangePW(body)
    }

    override fun getChangePWRequest(data: ChangePWBean) {
        view.dismissLoading(mContext)
        view.getChangePWRequest()
    }

    override fun getChangePWError() {
        view.dismissLoading(mContext)
        view.getChangePWError()
    }
}