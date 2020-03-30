package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.user.mvp.bean.TakeRecordListBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.TakeRecordListBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.TakeRecordListData
import com.example.shadow.heartrecreation.ui.user.mvp.view.DrinksRecordView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class DrinksRecordPresnter(owner: LifecycleOwner, val view: DrinksRecordView, val mContext: Context) : BasePresenter(owner, view, mContext), TakeRecordListData.TakeRecordList {
    //取酒列表
    override fun getTakeRecordListRequest(data: TakeRecordListBean) {
        view.getTakeRecordListRequest(data)
    }

    //取酒列表
    override fun getTakeRecordListError() {
        view.DrinksRecordError()
    }

    private val takerecordlist = TakeRecordListData(this)

    fun getTakeRecordList(pageIndex: Int) {
        takerecordlist.getTakeRecordList(TakeRecordListBody(getUserToken(), 10, pageIndex))
    }

    fun getRecordList(pageIndex: Int){
        takerecordlist.getRecordList(TakeRecordListBody(getUserToken(), 10, pageIndex))
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }

    fun getExpireRecordList(pageIndex: Int) {
        takerecordlist.getExpireRecordList(TakeRecordListBody(getUserToken(), 10, pageIndex))
    }
}