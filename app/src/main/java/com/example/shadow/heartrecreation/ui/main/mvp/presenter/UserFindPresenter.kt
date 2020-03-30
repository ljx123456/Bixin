package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UserFindBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.UserFindData
import com.example.shadow.heartrecreation.ui.main.mvp.view.UserFindView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class UserFindPresenter(owner: LifecycleOwner, val view: UserFindView, val mContext: Context) : BasePresenter(owner, view, mContext), UserFindData.UserFind {

    private val userfind = UserFindData(this)

    fun getUserFind(body: UserFindBody) {
//        view.showLoading(mContext)
        userfind.getUserFind(body)
    }

    override fun getUserFindRequest(data: UserFindBean) {
//        view.dismissLoading(mContext)
        view.getUserFindRequest(data)
    }

    override fun getUserFindError() {
//        view.dismissLoading(mContext)
        view.getUserFindError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        userfind.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}