package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelServicesBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.PayReInviteBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.DelServicesBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderServicesBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayReInviteBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.DelServicesData
import com.example.shadow.heartrecreation.ui.order.mvp.data.OrderServicesData
import com.example.shadow.heartrecreation.ui.order.mvp.data.PayReInviteData
import com.example.shadow.heartrecreation.ui.order.mvp.view.MyInviteView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MyInvitePresenter(owner: LifecycleOwner, val view: MyInviteView, val mContext: Context) : BasePresenter(owner, view, mContext),
        OrderServicesData.OrderServices,
        PayReInviteData.PayReInvite,
        DelServicesData.DelServices {

    //删除邀约成功
    override fun getDelServicesRequest(data: DelServicesBean) {
        view.dismissLoading(mContext)
        view.getDelServicesRequest()
    }

    //删除邀约失败
    override fun getDelServicesError() {
        view.dismissLoading(mContext)
    }

    //重新邀请成功
    override fun getPayReInviteRequest(data: PayReInviteBean) {
        view.dismissLoading(mContext)
        view.getPayReInviteRequest()
    }

    //重新邀请失败
    override fun getPayReInviteError() {
        view.dismissLoading(mContext)
        view.getPayReInviteRequest()
    }

    //获取列表成功
    override fun getOrderServicesRequeset(data: OrderServicesBean) {
        view.dismissLoading(mContext)
        view.getOrderServicesRequeset(data)
    }

    //获取列表失败
    override fun getOrderServicesError() {
        view.dismissLoading(mContext)
        view.getOrderServicesError()
    }

    private val orderservices = OrderServicesData(this)
    private val payreinvite = PayReInviteData(this)
    private val delservices = DelServicesData(this)

    //获取列表
    fun getOrderServices(body: OrderServicesBody) {
        orderservices.getOrderServices(body)
//        view.showLoading(mContext)
    }

    //重新邀请
    fun getPayReInvite(body: PayReInviteBody) {
        view.showLoading(mContext)
        payreinvite.getPayReInvite(body)
    }

    //删除邀约
    fun getDelServices(body: DelServicesBody) {
        delservices.getDelServices(body)
        view.showLoading(mContext)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        orderservices.getDisposable()?.let { list.add(it) }
        payreinvite.getDisposable()?.let { list.add(it) }
        delservices.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}