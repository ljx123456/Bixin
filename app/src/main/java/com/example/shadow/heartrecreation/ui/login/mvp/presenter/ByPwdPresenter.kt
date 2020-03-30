package com.example.shadow.heartrecreation.ui.login.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByPwdBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.ByPwdBody
import com.example.shadow.heartrecreation.ui.login.mvp.data.ByPwdData
import com.example.shadow.heartrecreation.ui.login.mvp.view.ByPwdView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ByPwdPresenter(owner: LifecycleOwner, val view: ByPwdView, val mContext: Context) : BasePresenter(owner, view, mContext), ByPwdData.ByPwd {

    private val bypwd = ByPwdData(this)

    //密码登陆
    fun getByPwd(body: ByPwdBody) {
        view.showLoading(mContext)
        bypwd.getByPwd(body)
    }

    //密码登陆成功
    override fun getByPwdRequest(data: ByCodeBean) {
        view.getByPwdRequest(data)
        view.dismissLoading(mContext)
    }

    //密码登陆失败
    override fun getByPwdError() {
        view.dismissLoading(mContext)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        bypwd.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}