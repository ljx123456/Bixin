package com.example.shadow.heartrecreation.ui.order.fragment

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.NetworkUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.db.DrinkUtils
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.layoutUtils.orderLayoutNumm
import com.example.shadow.heartrecreation.ui.main.dialog.PayTypeDialog
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentYue
import com.example.shadow.heartrecreation.ui.order.adapter.OrderAdapter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.CancelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderListBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.CancelOrderBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.DelOrderBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.OrderListBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayAgainBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.OrderBtnPresenter
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.OrderListPresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.OrderBtnView
import com.example.shadow.heartrecreation.ui.order.mvp.view.OrderListView
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentOrderDetils
import com.example.shadow.heartrecreation.ui.share.ShareDialog
import com.example.shadow.heartrecreation.ui.share.SharePresenter
import com.example.shadow.heartrecreation.ui.share.ShareView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.dialog.showPhoneDialog
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import kotlinx.android.synthetic.main.activity_register_data.*
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.layout_error_network.*

@SuppressLint("ValidFragment")
class OrderFragment(val it: String) : BaseFragment(), OrderListView, OrderBtnView, PayTypeDialog.PayType,  ShareView ,OrderAdapter.CallBack{
    override fun getDelOrderRequest(data: DelOrderBean) {
        Toast.Tips("删除成功")
        presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
    }

    override fun finish() {
        var handler=Handler()
        handler.postDelayed(object :Runnable{
            override fun run() {
                presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
                handler.removeCallbacksAndMessages(null)
            }
        },200)

    }

    override fun setPayType(s: String) {
        btnPresenter.getPayAgain(activity!!, PayAgainBody(itemData.orderNo, s))
    }

    override fun CancelOrderRequest(data: CancelOrderBean) {
//        pageIndex = 1
        presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
    }

    override fun CancelOrderError() {
//        pageIndex = 1
        presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
    }

    override fun getCancelServiceRequest() {
//        pageIndex = 1
        presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
    }

    private val presenter by lazy { OrderListPresenter(this, this, activity!!) }
    private val btnPresenter by lazy { OrderBtnPresenter(this, this, activity!!) }
    private val sharePresenter by lazy { SharePresenter(this, this, activity!!) }
    private var orderState = ""
    private var pageIndex = 1
    private var pageSize = 10
    private var orderAdapter: OrderAdapter? = null
    private val paytype = PayTypeDialog(this)
    private var itemData = OrderListBean.DataBean()
    private var image=""
    private var orderID = ""
    private var isCreate=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCreate=true
    }

    //获取列表成功
    override fun getOrderListRequest(data: OrderListBean) {
        try {
            dismiss()
        }catch (e:Exception){
            e.printStackTrace()
        }
        errorLayout.visibility = View.GONE
        orderRefresh.visibility=View.VISIBLE
        orderRefresh.isRefreshing = false
        if (pageIndex == 1) {
            orderAdapter = OrderAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            orderList.layoutManager = manager
            orderList.adapter = orderAdapter
        } else {
            orderAdapter!!.addData(data.data)
        }
        orderAdapter!!.setCallBack(this)
        if (orderAdapter != null) {
            var view = orderLayoutNumm()
            orderAdapter!!.setEmptyView(view)
            Click.viewClick(view).subscribe {
                intentYue(0)
                activity!!.finish()
            }
        }

        orderAdapter!!.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex+1
                presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
            }

        },orderList)

        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                orderAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                orderAdapter!!.loadMoreComplete()
            }
        }else{
            orderAdapter!!.loadMoreComplete()
        }

        orderAdapter!!.setOnItemClickListener { adapter, view, position ->
            intentOrderDetils(orderAdapter!!.data.get(position).orderNo)
        }


        orderAdapter!!.setOnItemChildClickListener { adapter, view, position ->
            itemData = orderAdapter!!.data.get(position)
            when (view.id) {
                //取消订单
                R.id.orderCancel -> {
                    if (itemData.orderState=="0"||itemData.orderState=="5") {
                        ShowDialog.showCustomDialog(activity!!, "提示", "是否继续取消订单？ （现在取消订单将不会收取任何手续费，订单取消后，所有达人邀请及达人订单都将取消）", "继续", "取消", object : DialogInterface.OnClickListener {
                            override fun onClick(dialog: DialogInterface, which: Int) {
                                when (which) {
                                    DialogInterface.BUTTON_POSITIVE -> {
                                        btnPresenter.CancelOrder(CancelOrderBody(itemData.orderNo))
                                        dialog.dismiss()
                                    }
                                    DialogInterface.BUTTON_NEGATIVE -> {
                                        dialog.dismiss()
                                    }
                                }

                            }

                        })
                    }else{
                        ShowDialog. showCustomDialog(activity!!,"提示","若现在取消订单，根据《退款规则》，将扣除部分手续费用（订单取消后所有达人邀请以及达人订单都将取消）","继续", "取消",true,object :DialogInterface.OnClickListener{
                            override fun onClick(dialog: DialogInterface, which: Int) {
                                when (which) {
                                    DialogInterface.BUTTON_POSITIVE -> {
                                        btnPresenter.CancelOrder(CancelOrderBody(itemData.orderNo))
                                        dialog.dismiss()
                                    }
                                    DialogInterface.BUTTON_NEGATIVE -> {
                                        dialog.dismiss()
                                    }
                                }

                            }

                        },object :View.OnClickListener{
                            override fun onClick(v: View?) {
                                intentUtils.intentHtml(2)
                            }
                        })
                    }

                }
                //联系商家
                R.id.orderRelation -> {
                    showPhoneDialog.showDialog(activity!!, itemData.platformPhone)
                }
                //分享
                R.id.orderCode -> {
                    orderID=itemData.orderNo
//                   TODO  image=itemData.
//                    shareDialog.show(childFragmentManager, "")
                    var url = BaseUrl.HOST_URL + "share/order?orderNo=" + orderID
                    sharePresenter.showShareDialogMerchant(activity!!, "来自" + "${user.getUserNick()}的订单分享", "上比心娱乐APP，你喜欢的，这里都有！",url,"")
                }
                //支付
                R.id.orderPay -> {

//                    ShowDialog. showCustomDialog(activity!!,"付款提示","付款后若需发起退款，可能会收取部分违约金，是否继续？","继续", "取消",object :DialogInterface.OnClickListener{
//                        override fun onClick(dialog: DialogInterface, which: Int) {
//                            when (which) {
//                                DialogInterface.BUTTON_POSITIVE -> {
//                                    paytype.show(activity!!.supportFragmentManager, "")
//                                    dialog.dismiss()
//                                }
//                                DialogInterface.BUTTON_NEGATIVE -> {
//                                    dialog.dismiss()
//                                }
//                            }
//
//                        }
//
//                    })
                    ShowDialog. showCustomDialog(activity!!,"付款提示","付款后若需发起退款，可能会收取部分违约金，是否继续？","继续", "取消",true,object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    paytype.show(activity!!.supportFragmentManager, "")
                                    dialog.dismiss()
                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog.dismiss()
                                }
                            }

                        }

                    },object :View.OnClickListener{
                        override fun onClick(v: View?) {
                            intentUtils.intentHtml(2)
                        }
                    })

                }

                //添加酒水
                R.id.orderAddsLayout ->{
                    orderID=itemData.orderNo
                    DrinkUtils.deleteALLDrinks()//删除所有酒水
                    user.setType("0")
                    user.setOrderID(orderID)
//                    intentUsils.intentDrinks("${itemData.}")
                }
                //删除订单
                R.id.orderDel->{

                    ShowDialog.showCustomDialogs(activity!!,"确定删除该订单吗？","确定","取消",object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    dialog.dismiss()
                                    presenter.getDelOrder(DelOrderBody(itemData.orderNo))
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
    }

    //获取列表失败
    override fun getOrderListError() {
        try {
            var h=Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismiss()
                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        orderRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        orderRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            show()
            pageIndex = 1
            presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
        }
    }

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {
    }

    //订单状态，-1 全部订单，1 进行中，2 待支付，3 待评价，4 已完成
    override fun initFragmentData() {
        LogUtils.a("init")
        when (it) {
            "进行中" -> orderState = "1"
            "待支付" -> orderState = "2"
            "已完成" -> orderState = "4"
            "全部" -> orderState = "-1"
        }

    }

    override fun setFragmentListener() {
        orderRefresh.setOnRefreshListener {
            pageIndex = 1
            presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
        }
    }

    override fun layoutID(): Int = R.layout.fragment_order

    override fun onResume() {
        super.onResume()
        LogUtils.a("resume")
//        if (NetworkUtils.isConnected()) {
        show()
            presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
//        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (!isCreate){
            return
        }

        if (isVisibleToUser){
//            showLoading(activity!!)
            presenter.getOrderList(OrderListBody(getUserToken(), orderState, pageIndex, pageSize))
        }
    }
}