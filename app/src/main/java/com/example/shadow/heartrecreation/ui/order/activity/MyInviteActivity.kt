package com.example.shadow.heartrecreation.ui.order.activity

import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.OrderServeUtils.setOrder
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.example.shadow.heartrecreation.db.user.setType
import com.example.shadow.heartrecreation.ui.main.dialog.NumDialog
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentServeList
import com.example.shadow.heartrecreation.ui.order.adapter.MyInviteExAdapter
import com.example.shadow.heartrecreation.ui.order.adapter.MyInviteOneAdapter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderServicesBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.DelServicesBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderServicesBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayReInviteBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.MyInvitePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.MyInviteView
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import kotlinx.android.synthetic.main.activity_my_invite.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class MyInviteActivity : BaseActivity(), MyInviteView, MyInviteOneAdapter.MyInvite,NumDialog.PeoPleNum {
    override fun finsh() {
        presenter.getOrderServices(OrderServicesBody(orderID))
    }

    override fun setPeoPleNum(get: String) {
        user.setNum((get.toInt()*2).toString())
        setType("0")
        intentServeList(user.getYueID().toInt(),merchantID.toString())
    }

    private val numDialog = NumDialog(this)

    override fun setDelPositionData(serviceUserId: Int) {
        presenter.getPayReInvite(PayReInviteBody(orderID, "${serviceUserId}"))
    }

    override fun getPayReInviteRequest() {
        presenter.getOrderServices(OrderServicesBody(orderID))
    }

    override fun getDelServicesRequest() {
        OrderServeUtils.deleteAllOrder()
        presenter.getOrderServices(OrderServicesBody(orderID))
    }

    override fun getOrderServicesRequeset(data: OrderServicesBean) {
        swipeMyInvite.isRefreshing=false
        errorLayout.visibility = View.GONE
        var myInvite = MyInviteOneAdapter(data.data, this)
        var manager = LinearLayoutManager(mContext)
        myInviteList.layoutManager = manager
        myInviteList.adapter = myInvite
        myInvite.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.orderPeopleNum -> {
                    ShowDialog.showCustomDialogs(mContext, "是否删除已邀请信息?", "清空", "取消", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    dialog.dismiss()
                                    presenter.getDelServices(DelServicesBody("${myInvite.data.get(position).listId}"))
                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog.dismiss()
                                }
                            }
                        }
                    })
                }
            }
        }

        Click.viewClick(myInviteGo).subscribe {
            OrderServeUtils.deleteAllOrder()
            data.data.forEachIndexed { index, dataBean ->
                dataBean.serviceUsers.forEachIndexed { index, serviceUsersBean ->
                    if (serviceUsersBean.serviceState!=8&&serviceUsersBean.serviceState!=9&&serviceUsersBean.serviceState!=11&&serviceUsersBean.serviceState!=12) {
                        var orderservedb = OrderServeDB(null, "${serviceUsersBean.serviceUserId}", serviceUsersBean.nickname, serviceUsersBean.avatar)
                        setOrder(orderservedb)
                    }
                }
            }
//            if (numDialog.isAdded){
//                numDialog.dismiss()
//            }else {
//                numDialog.show(supportFragmentManager, "")
//            }

            setType("0")
            intentServeList(user.getYueID().toInt(),merchantID.toString())

        }
    }

    override fun getOrderServicesError() {
        errorLayout.visibility = View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            presenter.getOrderServices(OrderServicesBody(orderID))
        }
    }

    override fun openEventBus(): Boolean = false
    private var orderID = ""
    private var merchantID = 0
    private var flag=false
    private val presenter by lazy { MyInvitePresenter(this, this, this) }

    override fun getActivityLayout(): Int = R.layout.activity_my_invite

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleText.setText("我邀请的")
    }

    override fun initActivityData() {
        orderID = intent.getStringExtra("id")
        merchantID = intent.getIntExtra("merchantid", 0)
        flag=intent.getBooleanExtra("flag",false)
        if (flag){
            myInviteGo.isEnabled=true
        }else{
            myInviteGo.isEnabled=false
        }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        swipeMyInvite.setOnRefreshListener {
            presenter.getOrderServices(OrderServicesBody(orderID))
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getOrderServices(OrderServicesBody(orderID))
    }

    override fun onDestroy() {
        super.onDestroy()
        DrinkUtils.deleteALLDrinks()//删除所有酒水
        ServeUtils.deleteALLServe()//删除所有服务员
        DbUtils.delMerchat()
        user.setNum("0")
        user.setOrderAgain("0")
    }
}