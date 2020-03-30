package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.data.LogoutData
import com.example.shadow.heartrecreation.ui.user.mvp.view.SetView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class SetPresenter(owner: LifecycleOwner, val view: SetView, val mContext: Context) : BasePresenter(owner, view, mContext), LogoutData.Logout {

    override fun getLogoutRequest() {
        view.getLogoutRequest()
        view.dismissLoading(mContext)
    }

    override fun getLogoutError() {
        view.dismissLoading(mContext)
    }

    private val logout = LogoutData(this)

    fun getLogout() {
        view.showLoading(mContext)
        logout.getLogout()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {
    }
}