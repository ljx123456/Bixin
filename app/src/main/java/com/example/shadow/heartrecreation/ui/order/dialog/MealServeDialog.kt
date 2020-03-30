package com.example.shadow.heartrecreation.ui.order.dialog

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.ui.order.adapter.MealServeAdapter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.AddPointListServiceBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddPointListServiceBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderServicesBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.MealServePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.MealServeView
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.dialog_meal_serve.*
import kotlinx.android.synthetic.main.layout_error_network.*

@SuppressLint("ValidFragment")
class MealServeDialog(val mealserve: MealServe) : BaseDialogFragment(), MealServeView {

    private val presenter by lazy { MealServePresenter(this, this, activity!!) }
    override fun setLayoutID(): Int = R.layout.dialog_meal_serve
    override fun isFullScreen(): Boolean = true
    private var id = ""
    private var dataList = ArrayList<OrderDetailsBean.DataBean.ServiceUsersBean>()
    fun getID(ids: String, serviceUsers: ArrayList<OrderDetailsBean.DataBean.ServiceUsersBean>) {
        this.id = ids
        this.dataList = serviceUsers

    }


    override fun getAddPointListServiceRequest(data: AddPointListServiceBean) {
        dismiss()
        mealserve.getAddPointListServiceRequest()
    }

    override fun getAddPointListServiceError() {

    }

    override fun getOrderServicesRequeset(data: OrderServicesBean) {
        errorLayout.visibility = View.GONE
    }

    override fun getOrderServicesError() {
        errorLayout.visibility = View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            presenter.getOrderServices(OrderServicesBody(id))
        }
    }


    override fun setLayoutData() {
        if(dataList!=null&&dataList.size>0) {
            var list = ArrayList<OrderDetailsBean.DataBean.ServiceUsersBean>()
            dataList.forEachIndexed { index, serviceUsersBean ->
//                if (serviceUsersBean.serviceState == 6 && serviceUsersBean.isStationing.equals("1")) {
                if (serviceUsersBean.serviceState == 6) {
                    var info = OrderDetailsBean.DataBean.ServiceUsersBean()
                    info.age = serviceUsersBean.age
                    info.avatar = serviceUsersBean.avatar
                    info.serviceUserId = serviceUsersBean.serviceUserId
//                info.estimateArriveTime = serviceUsersBean.estimateArriveTime
                    info.isType = serviceUsersBean.isType
//                info.latitude = serviceUsersBean.latitude
//                info.longitude = serviceUsersBean.longitude
                    info.nickname = serviceUsersBean.nickname
                    info.occupation = serviceUsersBean.occupation
                    info.sex = serviceUsersBean.sex
                    info.isStationing = serviceUsersBean.isStationing
//                info.orderServiceNo = serviceUsersBean.orderServiceNo
//                info.price = serviceUsersBean.price
                    list.add(info)
                }
            }
            LogUtils.a("测试达人数据", list.size.toString())
            var mealServeAdapter = MealServeAdapter(list)
            var manager = LinearLayoutManager(activity)
            manager.orientation = LinearLayout.VERTICAL
            mealServeList.layoutManager = manager
            mealServeList.adapter = mealServeAdapter
            mealServeAdapter.setOnItemChildClickListener { adapter, view, position ->
                mealServeAdapter.data.forEachIndexed { index, serviceUsersBean ->
                    if (index == position) serviceUsersBean.isType = true
                    else serviceUsersBean.isType = false
                    mealServeAdapter.notifyDataSetChanged()
                }
            }
            if (list == null || list.size == 0)
                mealServeGo.isEnabled = false
            else
                mealServeGo.isEnabled = true

            Click.viewClick(mealServeGo).subscribe {
                var info = OrderDetailsBean.DataBean.ServiceUsersBean()
                mealServeAdapter.data.forEach {
                    if (it.isType)
                        info = it
                }
                if (info.serviceUserId!=null&&info.serviceUserId!=0) {
                    presenter.getAddPointListService(AddPointListServiceBody("${info.serviceUserId}", id))
                }else{
                    Toast.Tips("请添加点单达人")
                }
            }
        }

    }

    override fun clickListener() {
        Click.viewClick(mealServeOver).subscribe { dismiss() }
    }

    interface MealServe {
        fun getAddPointListServiceRequest()
    }
}