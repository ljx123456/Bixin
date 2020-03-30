package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.user.mvp.bean.WineBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.WineBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.WineData
import com.example.shadow.heartrecreation.ui.user.mvp.view.WineView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class WinePresenter(owner: LifecycleOwner, val view: WineView, val mContext: Context) : BasePresenter(owner, view, mContext), WineData.Wine {

    //获取列表成功
    override fun getWineRequest(data: WineBean) {
        view.getWineRequest(data)
    }

    //获取列表失败
    override fun getWineError() {
        view.getWineError()
    }

    private val win = WineData(this)

    fun getWine(pageIndex: Int) {
        win.getWine(WineBody(getUserToken(), 10, pageIndex))
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        win.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}