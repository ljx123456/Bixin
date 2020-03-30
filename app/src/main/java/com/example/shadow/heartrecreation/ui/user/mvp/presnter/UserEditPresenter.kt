package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.login.mvp.bean.CheckNameBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.CheckNameBody
import com.example.shadow.heartrecreation.ui.login.mvp.data.CheckNameData
import com.example.shadow.heartrecreation.ui.user.mvp.bean.UserEditBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.UserEditBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.UserEditData
import com.example.shadow.heartrecreation.ui.user.mvp.view.UserEditView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class UserEditPresenter(owner: LifecycleOwner, val view: UserEditView, val mContext: Context) : BasePresenter(owner, view, mContext), UserEditData.UserEdit, CheckNameData.CheckName {
    //昵称校验成功
    override fun getCheckNameRequest(data: CheckNameBean) {
        view.dismissLoading(mContext)
        view.setCheckNameRequest(data)
    }

    override fun getCheckNameError() {
        view.dismissLoading(mContext)
    }

    override fun getUserEditRequest(data: UserEditBean) {
        view.dismissLoading(mContext)
        view.getUserEditRequest(data)
    }

    override fun getUserEditError() {
        view.dismissLoading(mContext)
    }

    private val useredit = UserEditData(this)
    private val check=CheckNameData(this)

    fun setCheckName(body: CheckNameBody){
        view.showLoading(mContext)
        check.getCheckName(body)
    }

    fun UserEdit(body: UserEditBody) {
        view.showLoading(mContext)
        useredit.UserEdit(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        useredit.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}