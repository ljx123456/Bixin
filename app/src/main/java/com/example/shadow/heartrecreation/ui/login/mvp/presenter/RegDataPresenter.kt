package com.example.shadow.heartrecreation.ui.login.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.CheckNameBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ValidationCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.CheckNameBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.RegDataBody
import com.example.shadow.heartrecreation.ui.login.mvp.data.CheckNameData
import com.example.shadow.heartrecreation.ui.login.mvp.data.RegDataData
import com.example.shadow.heartrecreation.ui.login.mvp.view.RegDataView
import com.example.shadow.heartrecreation.utils.utils.Toast
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class RegDataPresenter(owner: LifecycleOwner, val view: RegDataView, val mContext: Context) : BasePresenter(owner, view, mContext), RegDataData.RegData ,CheckNameData.CheckName{


    private val regdata = RegDataData(this)
    private val check=CheckNameData(this)

    fun setRgeData(body: RegDataBody) {
        if (body.birthday.equals(""))
            Toast.Tips("请选择生日")
        else if (body.sex == 0)
            Toast.Tips("请选择性别")
        else if (body.nickname.equals(""))
            Toast.Tips("请输入昵称")
        else {
            view.showLoading(mContext)
            regdata.setRgeData(body)
        }
    }

    fun setCheckName(body:CheckNameBody){
        view.showLoading(mContext)
        check.getCheckName(body)
    }

    //昵称校验成功
    override fun getCheckNameRequest(data: CheckNameBean) {
        view.dismissLoading(mContext)
        view.setCheckNameRequest(data)
    }

    override fun getCheckNameError() {
        view.dismissLoading(mContext)
    }


    //完善用户资料成功
    override fun setRgeDataRequest(data: ByCodeBean) {
        view.dismissLoading(mContext)
        view.setRgeDataRequest(data)
    }

    //完善用户资料失败
    override fun setRgeDataError() {
        view.dismissLoading(mContext)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
       regdata.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}