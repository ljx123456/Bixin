package com.example.shadow.heartrecreation.ui.order.activity

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.callback.GetUserInfoCallback
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.android.eventbus.EventBus
import cn.jpush.im.api.BasicCallback
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
//import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.DrinkUtils
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.db.db.MerchantDB
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.db.user.setNum
import com.example.shadow.heartrecreation.db.user.setOrderID
import com.example.shadow.heartrecreation.db.user.setType
import com.example.shadow.heartrecreation.place.intentUtils.intentPlace
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.login.utils.TimeUtils
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.dialog.CouponsDialog
import com.example.shadow.heartrecreation.ui.main.dialog.PayTypeDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentDrinks
import com.example.shadow.heartrecreation.ui.order.adapter.AddDrinkAdapter
import com.example.shadow.heartrecreation.ui.order.adapter.DrinkExpanAdapter
import com.example.shadow.heartrecreation.ui.order.adapter.FirstPresentAdapter
import com.example.shadow.heartrecreation.ui.order.adapter.OrderServeAdapter
import com.example.shadow.heartrecreation.ui.order.dialog.MealServeDialog
import com.example.shadow.heartrecreation.ui.order.dialog.PayServeDialog
import com.example.shadow.heartrecreation.ui.order.mvp.bean.CancelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.DelOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.*
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.OrderBtnPresenter
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.OrderDetailsPresenter
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.PayServicePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.OrderBtnView
import com.example.shadow.heartrecreation.ui.order.mvp.view.OrderDetailsView
import com.example.shadow.heartrecreation.ui.order.mvp.view.PayServiceView
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentComplaint
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentComplaintDetails
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentMyInvite
import com.example.shadow.heartrecreation.ui.pay.PayUtils
import com.example.shadow.heartrecreation.ui.share.SharePresenter
import com.example.shadow.heartrecreation.ui.share.ShareView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.dialog.SelectMapDialog
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.dialog.showPhoneDialog
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import jiguang.chat.activity.ChatActivity
import jiguang.chat.entity.Event
import jiguang.chat.entity.EventType
//import io.rong.imlib.model.Conversation
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_none_order.*
import kotlinx.android.synthetic.main.layout_order_five.*
import kotlinx.android.synthetic.main.layout_order_four.*
import kotlinx.android.synthetic.main.layout_order_one.*
import kotlinx.android.synthetic.main.layout_order_six.*
import kotlinx.android.synthetic.main.layout_order_three.*
import kotlinx.android.synthetic.main.layout_order_two.*
import kotlinx.android.synthetic.main.layout_title.*
import okhttp3.ResponseBody
import java.io.File
import java.math.BigDecimal
import java.net.URISyntaxException
import java.text.SimpleDateFormat
import java.util.*

class OrderDetailsActivity : BaseActivity(), OrderDetailsView, MealServeDialog.MealServe, OrderBtnView, PayTypeDialog.PayType, ShareView ,TimeUtils.TimeUtilCallBack,OrderServeAdapter.finshCallBack, SelectMapDialog.SelectMapDialogFace, PayServiceView {
    override fun getDelOrderRequest(data: DelOrderBean) {
        Toast.Tips("删除成功")
        finish()
    }

    override fun getPayServiceRequest(data: ResponseBody) {

    }

    override fun getPayServiceAgainRequest(data: ResponseBody) {
        if (parType.equals("1")) {//支付宝
            var Ali = Gson().fromJson(data.string(), AliPayBean::class.java)
            if (Ali.code == 0) PayUtils.AliPay(this, Ali.data.payInfo)
            else Toast.Tips(Ali.message)
        } else {
            var WeChat = Gson().fromJson(data.string(), WeChatBean::class.java)
            if (WeChat.code == 0) PayUtils.WeChatPay(WeChat.data)
            else Toast.Tips(WeChat.message)
        }
    }

    override fun gaodeBtn() {
        if (isPackageInstalled("com.autonavi.minimap")){
            var intent= Intent()
            intent.action= Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            var uri=Uri.parse("amapuri://route/plan/?did=BGVIS2&dlat=" + lat
                    + "&dlon=" + lng + "&dname=${name}&dev=0&t=0")
            intent.data=uri
            startActivity(intent)
        }else{
            Toast.Tips("请安装高德导航")
        }
    }

    override fun baiduBtn() {
        if (isPackageInstalled("com.baidu.BaiduMap")){
            try {
                var pareUrl = "baidumap://map/direction?region=" +
                        "&destination=" + lat + "," + lng + "&coord_type=bd09ll&src=andr.bixinyule.NewBixin"
                var intent= Intent()
                intent.action= Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                intent.data= Uri.parse(pareUrl)
//                var intent = Intent.getIntent(pareUrl)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }else{
            Toast.Tips("请安装百度地图")
        }
    }

    override fun finshAdapter() {
//        Toast.Tips("倒计时结束")
        showLoading()
       var h=Handler()
        h.postDelayed(object :Runnable{
            override fun run() {
                presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
                h.removeCallbacksAndMessages(null)
            }
        },200)

    }

    override fun finishTime() {
//        Toast.Tips("倒计时结束")
        showLoading()
        var h=Handler()
        h.postDelayed(object :Runnable{
            override fun run() {
                presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
                h.removeCallbacksAndMessages(null)
            }
        },200)
//        presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
    }


    //取消服务人员
    override fun getCancelServiceRequest() {
//        showLoading()
        presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
        if (server!=null){
            if (server!!.serviceState!=2&&server!!.serviceState!=3){
                Toast.Tips("该达人取消成功\n您可前往退款中心查看详情")
            }
        }
    }

    //选择付款类型
    override fun setPayType(s: String) {
        if (isOrder) {
            btnPresenter.getPayAgain(this, PayAgainBody(orderID, s))
        }else{
            parType=s
            if (server!=null)
                servePayPresenter.getPayServiceAgain(PayServiceAgainBody(server!!.orderServiceNo,s))
        }

    }

    //取消订单
    override fun CancelOrderRequest(data: CancelOrderBean) {
        if (info.orderState==0||info.orderState==1) {
            if (parent is OrderActivity) {
                intentUtils.intentRefund()
                parent.finish()
                finish()
            } else {
                intentUtils.intentRefund()
//            parent.finish()
                finish()
            }
        }else {
            presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
        }
    }

    //取消订单失败
    override fun CancelOrderError() {
        showLoading()
        presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
    }

    //设置点单达人后刷新界面
    override fun getAddPointListServiceRequest() {
        showLoading()
        presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
    }

    private val paytype = PayTypeDialog(this)
    private var payservedialog = PayServeDialog()
    private val presenter by lazy { OrderDetailsPresenter(this, this, this) }
    private val btnPresenter by lazy { OrderBtnPresenter(this, this, this) }
    private val sharePresenter by lazy { SharePresenter(this, this, this) }
    private val servePayPresenter by lazy { PayServicePresenter(this,this,this) }
    private var orderID = ""
    private lateinit var info: OrderDetailsBean.DataBean
    private val mealserve = MealServeDialog(this)
    private lateinit var dialog: SelectMapDialog
    private var lat=""
    private var lng=""
    private var name=""
    private var time=0
    private var image=""
    private var isOrder=true
    private var server:OrderDetailsBean.DataBean.ServiceUsersBean?=null
    private var parType="1"
    private var flag=true
    private var handler:Handler?=null
    private var runnable:Runnable?=null
    private var isOpen=false
    private var flagServe=true
    private var flagDrink=true

    override fun getOrderDetailsRequest(data: OrderDetailsBean) {
        dismissLoading()
        swipe_order.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        noneOrderLayout.visibility=View.GONE
        swipe_order.isRefreshing=false
        info = data.data

        //定时刷新器
        if (!isOpen&&handler==null&&runnable==null){
            isOpen=true
            Log.e("测试","开始创建定时器")
            handler= Handler()
            runnable= object :Runnable{
                override fun run() {
                    Log.e("测试","开始运行定时器")
                    if (info.orderState==0||info.orderState==1||info.orderState==2){
                        Log.e("测试","开始刷新订单")
                        presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
                    }
                    handler!!.postDelayed(this,1000*10)
                }
            }
            handler!!.postDelayed(runnable!!,1000)
        }

        image=info.businessImg
        orderID=info.orderNo
        //订单状态：-1 订单冻结，0 等待商家确认，1 待服务，2 进行中 ，3 待评价，4 已结束，5 未付款，6 用户取消，7 付款超时，8 商家拒绝，9 商家确认超时
        orderTextLayout.visibility = View.VISIBLE

        if (info.reserveTime!=null&&info.reserveTime!=""){
            orderReserveTimeLayout.visibility=View.VISIBLE
            orderReserveTime.text=getTime(info.reserveTime)
            orderReserveTimeTitle.text="预约时间"
        }else{
            orderReserveTimeLayout.visibility=View.GONE
        }

        if (info.startTime!=null&&info.startTime!=""){
            orderStartTimeLayout.visibility=View.VISIBLE
            orderStartTime.setText(getTime(info.startTime))//预约时间
            orderStartTimeTitle.text="开始时间"
        }else{
            orderStartTimeLayout.visibility=View.GONE
//            orderStartTime.setText(getTime(info.createTime))//开始时间
//            orderStartTimeTitle.text="下单时间"
        }
        orderPlaceTime.text=info.createTime//下单时间
        when (info.orderState) {

            0 -> {
                setTypes(R.mipmap.refund_step_01, "等待商家与达人确认", true)
            }
            1 -> setTypes(R.mipmap.refund_step_01, "商家已接单\n等待服务开始", true)
            2 -> {
                setTypes(R.mipmap.refund_step_02, "进行中", true)
                orderStartTime.setText(getTime(info.startTime))//开始时间
                orderStartTimeTitle.text="开始时间"
            }
            3->  {
                setTypes(R.mipmap.refund_step_03, "订单完成", true)
                orderStartTime.setText(getTime(info.startTime))//开始时间
                orderStartTimeTitle.text="开始时间"
            }
            4 -> {
                setTypes(R.mipmap.refund_step_03, "订单完成", true)
                orderStartTime.setText(getTime(info.startTime))//开始时间
                orderStartTimeTitle.text="开始时间"
            }
            5 -> setTypes(R.mipmap.order_01, "待支付", true)
            6 -> {

                orderTextLayout.visibility = View.GONE
                orderTypeLayout.setBackgroundColor(Color.parseColor("#ECF0F4"))
                orderTypeTitle.text="订单已取消"
                if (info.refundState!=null&&info.refundState!=""){
//                    orderLayoutTips.visibility=View.VISIBLE
                    when(info.refundState){
                        "0"->{
                            setTypes(R.mipmap.order_01, "发起退款", false)
                        }
                        "1"->{
                            setTypes(R.mipmap.order_01, "退款中", false)
//                            orderTips.text="退款中"
                        }
                        "2"->{
                            setTypes(R.mipmap.order_01, "已退款", false)
//                            orderTips.text="已退款"
                        }
                        "3"->{
                            setTypes(R.mipmap.order_01, "退款失败", false)
//                            orderTips.text="退款失败"
                        }
                    }
                }else{
                    setTypes(R.mipmap.order_01, "", false)
                }
            }
            7 -> {
                setTypes(R.mipmap.order_01, "支付超时", false)
                orderTextLayout.visibility = View.GONE
                orderTypeLayout.setBackgroundColor(Color.parseColor("#ECF0F4"))
            }
            8 ->{
                setTypes(R.mipmap.order_01, "", false)
                orderTextLayout.visibility = View.GONE
                orderTypeLayout.setBackgroundColor(Color.parseColor("#ECF0F4"))
                orderLayoutTips.visibility=View.VISIBLE
//                orderTypeTitle.text="商家分配超时"
                when(info.refundState){
                    "0"->{
                        orderTips.text="发起退款"
                    }
                    "1"->{
                        orderTips.text="退款中"
                    }
                    "2"->{
                        orderTips.text="已退款"
                    }
                    "3"->{
                        orderTips.text="退款失败"
                    }
                }
            }
            9 ->{
                setTypes(R.mipmap.order_01, "", false)
                orderTextLayout.visibility = View.GONE
                orderTypeLayout.setBackgroundColor(Color.parseColor("#ECF0F4"))
                orderLayoutTips.visibility=View.VISIBLE
                orderTipsTitle.text="商家分配超时"
                when(info.refundState){
                    "0"->{
                        orderTips.text="发起退款"
                    }
                    "1"->{
                        orderTips.text="退款中"
                    }
                    "2"->{
                        orderTips.text="已退款"
                    }
                    "3"->{
                        orderTips.text="退款失败"
                    }
                }
            }
            else -> setTypes(R.mipmap.order_01, "", false)
        }
        time=info.waitPaymentTime
        setTypeText(info.orderState)
        orderAdds.setText(info.businessName)//商家地址
        lat=info.latitude
        lng=info.longitude
        name=info.businessName
        //查看商家位置
        Click.viewClick(orderNavigation).subscribe {
//            intentLocation(info.latitude, info.longitude, info.businessImg)
            dialog.showDialog()
        }//导航
        orderBaofangType.setText(info.boxTypeName)//包房类型
        orderBaofangNum.setText(info.boxName)//包房号

        if (info.endTime!=null&&info.endTime!=""&&info.orderState==4) {
            orderEndTimeLayout.visibility=View.VISIBLE
            orderEndTime.setText(getTime(info.endTime))//结束时间
        }else{
            orderEndTimeLayout.visibility=View.GONE
        }
        serviceCountPrice.setText("¥:"+info.serviceCountPrice.setScale(2,BigDecimal.ROUND_HALF_UP).toString())//达人费用
        orderSixActivity.text = "¥:"+info.boxServiceMoney.setScale(2,BigDecimal.ROUND_HALF_UP).toString()//包房服务费
        wineCountPrice.setText("¥:"+info.wineCountPrice.setScale(2,BigDecimal.ROUND_HALF_UP).toString())//酒水费用
        couponPrice.setText("-¥:"+info.couponPrice.setScale(2,BigDecimal.ROUND_HALF_UP).toString())//优惠费用
        orderCountPrice.setText("¥:"+info.orderCountPrice.setScale(2,BigDecimal.ROUND_HALF_UP).toString())//共支付
        serviceUserCountNum.setText("（${info.orderTakingNum}/${info.serviceCountNum}人）")
        if (info.orderTakingNum != null && info.orderTakingNum == 0) {
            orderThreeNull.visibility = View.VISIBLE
        } else {
            orderThreeNull.visibility = View.GONE
        }
        if (info.serviceUsers!=null&&info.serviceUsers.size>0) {
            orderServeList.visibility=View.VISIBLE
            orderServeMiss.visibility=View.VISIBLE
            var orderAdapter = OrderServeAdapter(info.serviceUsers)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            orderServeList.layoutManager = manager
            orderServeList.adapter = orderAdapter
            orderAdapter.setCallBack(this)
            orderAdapter.setOnItemChildClickListener { adapter, view, position ->
                when (view.id) {
                    //查看地址
                    R.id.orderServeLookAdds -> intentPlace(orderAdapter.data.get(position).avatar, orderAdapter.data.get(position).longitude, orderAdapter.data.get(position).latitude, info.latitude, info.longitude, info.businessImg)
                    //聊天
                    R.id.orderServeMassage -> {
                        LogUtils.a("点击聊天"+orderAdapter.data.get(position).serviceUserId.toString())
                        if (flag) {
                            flag=false
                            JMessageClient.getUserInfo(orderAdapter.data.get(position).serviceUserId.toString(), "b2a8076f779c87568f4d0656", object : GetUserInfoCallback() {
                                override fun gotResult(p0: Int, p1: String, p2: UserInfo) {
                                    if (p0 == 0) {
                                        flag=true
                                        var mUserInfo = p2
                                        var intent = Intent()
                                        intent.setClass(this@OrderDetailsActivity, ChatActivity::class.java)
                                        //创建会话
                                        intent.putExtra("targetId", mUserInfo.getUserName())
                                        intent.putExtra("targetAppKey", mUserInfo.getAppKey())
                                        var notename = mUserInfo.getNotename()
                                        if (TextUtils.isEmpty(notename)) {
                                            notename = mUserInfo.getNickname()
                                            if (TextUtils.isEmpty(notename)) {
                                                notename = mUserInfo.getUserName()
                                            }
                                        }
                                        intent.putExtra("conv_title", notename)
                                        var conv: Conversation? = JMessageClient.getSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
                                        //如果会话为空，使用EventBus通知会话列表添加新会话
                                        if (conv == null) {
                                            conv = Conversation.createSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
                                            EventBus.getDefault().post(Event.Builder()
                                                    .setType(EventType.createConversation)
                                                    .setConversation(conv)
                                                    .build())
                                        }
                                        startActivity(intent)
                                    }
                                }
                            })
                        }else{
                            Toast.Tips("聊天正在创建中。。。")
                        }
//                    val uri = Uri.parse("rong://" + mContext!!.applicationInfo.packageName).buildUpon()
//                            .appendPath("conversation").appendPath(Conversation.ConversationType.PRIVATE.getName().toLowerCase())
//                            .appendQueryParameter("targetId", "${orderAdapter.data.get(position).serviceUserId}").appendQueryParameter("title", orderAdapter.data.get(position).nickname).build()
//                    var intent = Intent(Intent.ACTION_VIEW, uri)
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    startActivity(intent)
                    }
                    //取消
                    R.id.orderServeOver -> {
                        server=orderAdapter.data[position]
                        ShowDialog. showCustomDialog(this,"提示","若现在取消该达人服务，则将从退款中扣取部分金额作为补偿金（详情请查看退款规则或联系客服）","继续", "取消",object :DialogInterface.OnClickListener{
                            override fun onClick(dialog: DialogInterface, which: Int) {
                                when (which) {
                                    DialogInterface.BUTTON_POSITIVE -> {
                                        btnPresenter.getCancelService(CancelServiceBody(orderAdapter.data.get(position).orderServiceNo))
                                        dialog.dismiss()
                                    }
                                    DialogInterface.BUTTON_NEGATIVE -> {
                                        dialog.dismiss()
                                    }
                                }

                            }

                        })
                    }
                    //付款
                    R.id.orderServePay -> {
                        isOrder=false
                        server=orderAdapter.data[position]
                        ShowDialog. showCustomDialog(this,"付款提示","付款后若需发起退款，可能会收取部分违约金，是否继续？","继续", "取消",true,object :DialogInterface.OnClickListener{
                            override fun onClick(dialog: DialogInterface, which: Int) {
                                when (which) {
                                    DialogInterface.BUTTON_POSITIVE -> {
                                        if (orderAdapter.data[position].serviceState==2){
                                            paytype.show(supportFragmentManager, "")
                                        }else {
                                            payservedialog.setUsedCoupons(info.usedServiceCoupon)
                                            payservedialog.setData(orderAdapter.data.get(position))
                                            payservedialog.show(supportFragmentManager, "")
                                        }
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

                    //投诉
                    R.id.orderServeComplaints ->{
                        if (orderAdapter.data[position].complaintsState!=null&&orderAdapter.data[position].complaintsId!=null&&orderAdapter.data[position].complaintsId!=0){
                            intentComplaintDetails(orderAdapter.data[position].complaintsId.toString())
                        }else{
                            intentComplaint(orderAdapter.data[position].orderServiceNo)
                        }
                    }

                    //迟到退款
                    R.id.orderServeLate ->{
                        btnPresenter.getCancelService(CancelServiceBody(orderAdapter.data.get(position).orderServiceNo))
                    }
                }
            }

            if (flagServe){
                orderServeList.visibility=View.VISIBLE
                var drawable=resources.getDrawable(R.mipmap.double_more_button_top)
                drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                orderServeMissText.setCompoundDrawables(drawable,null,null,null)
                orderServeMissText.text="折叠"
            }else{
                orderServeList.visibility=View.GONE
                var drawable=resources.getDrawable(R.mipmap.double_more_button_down)
                drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                orderServeMissText.setCompoundDrawables(drawable,null,null,null)
                orderServeMissText.text="展开"
            }

            Click.viewClick(orderServeMiss).subscribe {
                if (flagServe){
                    flagServe=false
                    orderServeList.visibility=View.GONE
                    var drawable=resources.getDrawable(R.mipmap.double_more_button_down)
                    drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                    orderServeMissText.setCompoundDrawables(drawable,null,null,null)
                    orderServeMissText.text="展开"
                }else{
                    flagServe=true
                    orderServeList.visibility=View.VISIBLE
                    var drawable=resources.getDrawable(R.mipmap.double_more_button_top)
                    drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                    orderServeMissText.setCompoundDrawables(drawable,null,null,null)
                    orderServeMissText.text="折叠"
                }
            }
        }else{
            orderServeList.visibility=View.GONE
            orderServeMiss.visibility=View.GONE
        }
//        if (info.orderState==1||info.orderState==2){
//            detailsAddServe.visibility=View.VISIBLE
//        }else{
//            detailsAddServe.visibility=View.GONE
//        }
//        if (info.orderState==1||info.orderState==2) {
////            detailsAddServe.visibility=View.VISIBLE
//            orderPeopleNum.visibility=View.VISIBLE
//        }else{
////            detailsAddServe.visibility=View.GONE
//            orderPeopleNum.visibility=View.GONE
//        }
        //添加点单人员
        Click.viewClick(detailsAddServe).subscribe {
            if (info.orderState==1||info.orderState==2) {
                var list = ArrayList<OrderDetailsBean.DataBean.ServiceUsersBean>()
                list.addAll(data.data.serviceUsers)
                if (data.data.referencesUser != null && data.data.referencesUser.avatar != null) {
                    list.add(OrderDetailsBean.DataBean.ServiceUsersBean(data.data.referencesUser.serviceUserId.toInt(), data.data.referencesUser.age, data.data.referencesUser.nickname, data.data.referencesUser.sex,
                            data.data.referencesUser.avatar, data.data.referencesUser.occupation, 6, false, "1"))
                }

                mealserve.getID(orderID, list)
                mealserve.show(supportFragmentManager, "")
            }
        }

        //查看邀请列表
        Click.viewClick(orderPeopleNum).subscribe {
            //            deleteAllOrder()
//            info.serviceUsers.forEachIndexed { index, serviceUsersBean ->
//                if (serviceUsersBean.serviceState!=8&&serviceUsersBean.serviceState!=9&&serviceUsersBean.serviceState!=12) {
//                    var orderservedb = OrderServeDB(null, "${serviceUsersBean.serviceUserId}", serviceUsersBean.nickname, serviceUsersBean.avatar)
//                    setOrder(orderservedb)
//                }
//            }
            if (info.orderState==1||info.orderState==2) {
                DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                        info.businessName,
                        "${info.businessId}",
                        "",
                        "",
                        "",
                        "",
                        "",
                        true,
                        "", "",
                        info.longitude,
                        info.latitude,
                        "",
                        ""))





                setOrderID(orderID)
                setType("0")
                setNum("0")
                intentMyInvite(orderID, info.businessId,true)
            }else{
                setOrderID(orderID)
                setType("0")
                setNum("0")
                intentMyInvite(orderID, info.businessId,false)
            }
        }

        if (info.orderState==1||info.orderState==2){
            if (info.hasWaitServiceAccept==1){
                orderThreeNull.visibility=View.VISIBLE
            }else{
                orderThreeNull.visibility=View.GONE
            }
        }else{
            orderThreeNull.visibility=View.GONE
        }

        //酒水
        if (info.orderWine.firstWine.wines != null&&info.orderWine.firstWine.wines.size>0) {
            layoutOrderDrink.visibility=View.VISIBLE
            setDrinkData(info.orderWine.firstWine.wines)
            if (flagDrink){
                orderDrinkLayout.visibility=View.VISIBLE
                orderDrinkMoneyLayout.visibility=View.GONE
                var drawable=resources.getDrawable(R.mipmap.double_more_button_top)
                drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                orderDrinkMissText.setCompoundDrawables(drawable,null,null,null)
                orderDrinkMissText.text="折叠"
            }else{
                orderDrinkLayout.visibility=View.GONE
                orderDrinkMoneyLayout.visibility=View.VISIBLE
                var drawable=resources.getDrawable(R.mipmap.double_more_button_down)
                drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                orderDrinkMissText.setCompoundDrawables(drawable,null,null,null)
                orderDrinkMissText.text="展开"
            }
            Click.viewClick(orderDrinkMiss).subscribe {
                if (flagDrink){
                    flagDrink=false
                    orderDrinkLayout.visibility=View.GONE
                    orderDrinkMoneyLayout.visibility=View.VISIBLE
                    var drawable=resources.getDrawable(R.mipmap.double_more_button_down)
                    drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                    orderDrinkMissText.setCompoundDrawables(drawable,null,null,null)
                    orderDrinkMissText.text="展开"
                }else{
                    flagDrink=true
                    orderDrinkLayout.visibility=View.VISIBLE
                    orderDrinkMoneyLayout.visibility=View.GONE
                    var drawable=resources.getDrawable(R.mipmap.double_more_button_top)
                    drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                    orderDrinkMissText.setCompoundDrawables(drawable,null,null,null)
                    orderDrinkMissText.text="折叠"
                }
            }
        }else{
            layoutOrderDrink.visibility=View.GONE
        }
        if (info.orderWine.firstWine.gift != null) {
            presentLayout.visibility = View.VISIBLE
            setDrinkPresent(info.orderWine.firstWine.gift)
        } else {
            presentLayout.visibility = View.GONE
        }
        //二次酒水
        if (info.orderWine.appendWines != null) {
            var addDrink = AddDrinkAdapter(info.orderWine.appendWines)
            val manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            orderAddDrinkList.layoutManager = manager
            orderAddDrinkList.adapter = addDrink
        }
        if (info.boxName!=null&&info.boxName!=""&&info.boxId!=null&&info.boxId!="") {//包房内
            setBotton(info.orderState,true)
        }else{
            setBotton(info.orderState,false)
        }
        buttonBtnClick(info)
        setBrokerLayout(info)
        setOrderWoMan(info)
    }


    //点单达人显示
    private fun setOrderWoMan(info: OrderDetailsBean.DataBean) {
        if (info.pointListService != null) {
            orderDetailsYue.visibility = View.GONE
            brokerLayout.visibility = View.VISIBLE
            ImageLoad.setUserHead(info.pointListService.avatar, brokerImage)
            brokerName.text = info.pointListService.nickname
            UIUtils.setAgeUtils(brokerSex, info.pointListService.sex, info.pointListService.age)
            if (info.pointListService.occupation!=null&&info.pointListService.occupation!=""){
                brokerJoin.text = info.pointListService.occupation
                brokerJoin.visibility=View.VISIBLE
            }else{
                brokerJoin.visibility=View.GONE
            }

        } else {
            orderDetailsYue.visibility = View.VISIBLE
            brokerLayout.visibility = View.GONE
            if (info.hasMaster!=null&&info.hasMaster!=""&&info.hasMaster=="0"){
                if (info.orderState==1||info.orderState==2) {
                    detailsAddServe.visibility = View.VISIBLE
                }else{
                    detailsAddServe.visibility=View.GONE
                }
            }else{
                detailsAddServe.visibility=View.GONE
            }
        }
    }

    //经纪人显示
    private fun setBrokerLayout(info: OrderDetailsBean.DataBean) {
        if (info.referencesUser != null && info.referencesUser.avatar != null) {
            orderFiveLayout.visibility = View.VISIBLE
            ImageLoad.setUserHead(info.referencesUser.avatar, brokerImageFive)
            brokerNameFive.text = info.referencesUser.nickname
            UIUtils.setAgeUtils(brokerAgeFive, info.referencesUser.sex, "${info.referencesUser.age}")
            if (info.referencesUser.occupation!=null&&info.referencesUser.occupation!="") {
                brokerJobFive.visibility=View.VISIBLE
                brokerJobFive.text = info.referencesUser.occupation
            }else{
                brokerJobFive.visibility=View.GONE
            }
        } else {
            orderFiveLayout.visibility = View.GONE
        }
    }

    private fun setTypeText(orderState: Int) {
        when (orderState) {
            1 -> getTypeColor(true, false, false)
            2 -> getTypeColor(true, true, false)
            3 -> getTypeColor(true, true, false)
            4 -> getTypeColor(true, true, true)
            else -> getTypeColor(false, false, false)
        }
    }

    fun getTypeColor(one: Boolean, two: Boolean, four: Boolean) {
        if (one) orderOne.setTextColor(resources.getColor(R.color.white)) else orderOne.setTextColor(resources.getColor(R.color.whites))
        if (two) orderTwo.setTextColor(resources.getColor(R.color.white)) else orderTwo.setTextColor(resources.getColor(R.color.whites))
        if (four) orderFour.setTextColor(resources.getColor(R.color.white)) else orderFour.setTextColor(resources.getColor(R.color.whites))
    }

    private fun buttonBtnClick(info: OrderDetailsBean.DataBean) {
        //评价
        Click.viewClick(orderEvaluate).subscribe { presenter.GoEvaluate() }
        //联系商家
        Click.viewClick(orderRelation).subscribe { showPhoneDialog.showDialog(this@OrderDetailsActivity, info.platformPhone) }
        //取消订单
        Click.viewClick(orderCancel).subscribe {
            if (info.orderState==0||info.orderState==5) {
                ShowDialog.showCustomDialog(this, "提示", "是否继续取消订单？ （现在取消订单将不会收取任何手续费，订单取消后，所有达人邀请及达人订单都将取消）", "继续", "取消", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                btnPresenter.CancelOrder(CancelOrderBody(info.orderNo))
                                dialog.dismiss()
                            }
                            DialogInterface.BUTTON_NEGATIVE -> {
                                dialog.dismiss()
                            }
                        }

                    }

                })
            }else{
                ShowDialog. showCustomDialog(this,"提示","若现在取消订单，根据《退款规则》，将扣除部分手续费用（订单取消后所有达人邀请以及达人订单都将取消）","继续", "取消",true,object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                btnPresenter.CancelOrder(CancelOrderBody(info.orderNo))
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
        //分享
        Click.viewClick(orderCode).subscribe {
            var url = BaseUrl.HOST_URL + "share/order?orderNo=" + orderID
            sharePresenter.showShareDialogMerchant(this, "来自" + "${user.getUserNick()}的订单分享", "上比心娱乐APP，你喜欢的，这里都有！",url,"")
        }
        //去支付
        Click.viewClick(orderPay).subscribe {
            isOrder=true
            ShowDialog. showCustomDialog(this,"付款提示","付款后若需发起退款，可能会收取部分违约金，是否继续？","继续", "取消",true,object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            paytype.show(supportFragmentManager, "")
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

        //重新下单
        Click.viewClick(orderAgain).subscribe {
            if (info.allServiceUsers!=null&&info.allServiceUsers.size>0){//添加达人
                user.setNum((info.allServiceUsers.size*2).toString())
                ServeUtils.deleteALLServe()
                info.allServiceUsers.forEach {
//                    var sex=""
//                    if (it.sex==1){
//                        sex="男"
//                    }else{
//                        sex="女"
//                    }
                    ServeUtils.setServe(ServePersonnelDB(
                            null,
                            "${it.serviceUserId}",
                            it.nickname, it.avatar,
                            "${it.price}",
                            "",
                            "",
                            "${it.age}",
                            "${it.sex}",
                            "",
                            it.occupation)
                    )
                }

            }

            if (info.orderWine!=null&&info.orderWine.firstWine!=null&&info.orderWine.firstWine.wines!=null&&info.orderWine.firstWine.wines.size>0){//添加酒水
                DrinkUtils.deleteALLDrinks()
                info.orderWine.firstWine.wines.forEach {
                    var drink = DrinkDB()
                    drink.mealName = it.wineTypeName
                    drink.mealId = "${it.wineTypeId}"
                    drink.drinkNum = "${it.num}"
                    drink.drinkID = "${it.wineId}"
                    drink.drinkMoney = "${(it.wineCountPrice.divide(BigDecimal(it.num))).toDouble()}"
                    drink.drinkName = it.wineName
                    drink.drinkText = ""
                    drink.drinkImage = it.wineImage
                    DrinkUtils.setDrinks(drink)
                }
                if (info.orderWine!=null&&info.orderWine.appendWines!=null&&info.orderWine.appendWines.size>0){
                    info.orderWine.appendWines.forEach {
                        if (it.wines!=null&&it.wines.size>0){
                            it.wines.forEach {
                                var drink = DrinkDB()
                                drink.mealName = it.wineTypeName
                                drink.mealId = "${it.wineTypeId}"
                                drink.drinkNum = "${it.num}"
                                drink.drinkID = "${it.wineId}"
                                drink.drinkMoney = "${(it.wineCountPrice.divide(BigDecimal(it.num))).toDouble()}"
                                drink.drinkName = it.wineName
                                drink.drinkText = ""
                                drink.drinkImage = it.wineImage
                                DrinkUtils.setDrinks(drink)
                            }
                        }
                    }
                }
            }else if (info.orderWine!=null&&info.orderWine.appendWines!=null&&info.orderWine.appendWines.size>0){
                DrinkUtils.deleteALLDrinks()
                info.orderWine.appendWines.forEach {
                    if (it.wines!=null&&it.wines.size>0){
                        it.wines.forEach {
                            var drink = DrinkDB()
                            drink.mealName = it.wineTypeName
                            drink.mealId = "${it.wineTypeId}"
                            drink.drinkNum = "${it.num}"
                            drink.drinkID = "${it.wineId}"
                            drink.drinkMoney = "${(it.wineCountPrice.divide(BigDecimal(it.num))).toDouble()}"
                            drink.drinkName = it.wineName
                            drink.drinkText = ""
                            drink.drinkImage = it.wineImage
                            DrinkUtils.setDrinks(drink)
                        }
                    }
                }
            }

            if (info.boxName!=null&&info.boxName!=""&&info.boxId!=null&&info.boxId!=""){//包房内
                user.setRoomType("1")
                DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                        info.businessName,
                        "${info.businessId}",
                        "",
                        info.boxTypeName,
                        info.boxTypeId,
                        info.boxId,
                        info.boxName,
                        true,
                        "", info.boxFreePrice.toString(),
                        info.longitude,
                        info.latitude,
                        info.address,
                        "${info.nowBoxServiceMoney.toDouble()}"))
            }else{//预约
                user.setRoomType("0")
                DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                        info.businessName,
                        "${info.businessId}",
                        "",
                        info.boxTypeName,
                        info.boxTypeId,
                        "",
                        "",
                        false,
                        "", info.boxFreePrice.toString(),
                        info.longitude,
                        info.latitude,
                        info.address,
                        "${info.nowBoxServiceMoney.toDouble()}"))
            }

            user.setRoomMoney(info.nowBoxServiceMoney.toString())
            user.setOrderAgain("1")

            LogUtils.a("重新下单")
            if (info.referencesUser!=null&&info.referencesUser.avatar!=null){//经纪人下单
                intentUsils.intentYue( 1, info.referencesUser.serviceUserId,
                        info.referencesUser.avatar,
                        info.referencesUser.nickname,
                        info.referencesUser.age,
                        "${info.referencesUser.sex}",
                        info.referencesUser.occupation,
                        "${info.businessId}",
                        info.businessName)
                finish()
            }else{//正常下单
                intentUsils.intentYue(1)
                finish()
            }

        }

        //删除订单
        Click.viewClick(orderDel).subscribe {
            ShowDialog.showCustomDialogs(this,"确定删除该订单吗？","确定","取消",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            dialog.dismiss()
                            btnPresenter.getDelOrder(DelOrderBody(info.orderNo))
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            })

        }


    }


    /**
     * 设置对应图片显示
     */
    private fun setTypes(image: Int, s: String, b: Boolean) {
        if (b) orderTypeImage.visibility = View.VISIBLE else orderTypeImage.visibility = View.GONE
        orderTypeImage.setImageResource(image)
        orderTypeText.setText(s)
    }

    override fun getOrderDetailsError(code:Int) {
        try {
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismissLoading()
//                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        if (code==-3002) {
            swipe_order.visibility = View.GONE
            noneOrderLayout.visibility=View.VISIBLE
            errorLayout.visibility = View.GONE
        }else{
            swipe_order.visibility = View.GONE
            noneOrderLayout.visibility=View.GONE
            errorLayout.visibility = View.VISIBLE
            Click.viewClick(anewClick).subscribe {
                showLoading()
                presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
            }
        }
    }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_order_details

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleText.setText("订单详情")
//        if (!NetworkUtils.isConnected()) {
//            setContentView(R.layout.layout_error_network)
//            errorLayout.visibility = View.VISIBLE
//            Click.viewClick(errorLayout).subscribe {
//
//            }
//        }
    }

    override fun initActivityData() {
        orderID = intent.getStringExtra("orderid")
        orderServiceNum.text = orderID
        if (!NetworkUtils.isConnected()) {
            swipe_order.visibility=View.GONE
            errorLayout.visibility=View.VISIBLE

        }
//        else{
//            swipe_order.visibility=View.VISIBLE
//            errorLayout.visibility=View.GONE
//        }
        dialog= SelectMapDialog(this)
        dialog.setDialogFace(this)

    }

    override fun onResume() {
        super.onResume()
        showLoading()
        presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
    }

    override fun onPause() {
        super.onPause()
        if (handler!=null&&runnable!=null){
            handler!!.removeCallbacksAndMessages(null)
            handler=null
            runnable=null
            isOpen=false
        }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        swipe_order.setOnRefreshListener {
            presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
        }

        Click.viewClick(whet).subscribe {
            intentUtils.intentHtml(2)
//            ShowDialog.showCustomDialog(this, "点单达人", "点单达人负者您在包房内酒水、食品、服务等点单操作，您可以自行选择任意一个作为您的点单达人！祝您约完愉快！", "我知道了", object : DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface, which: Int) {
//                    dialog.dismiss()
//                }
//            })
        }
        //添加酒水
        Click.viewClick(orderCome).subscribe {
            DrinkUtils.deleteALLDrinks()//删除所有酒水
            setType("0")
            setOrderID(orderID)
            intentDrinks("${info.businessId}")
        }

        Click.viewClick(anewClick).subscribe {
            presenter.getOrderDetails(OrderDetailsBody(getUserToken(), orderID))
        }
    }

    //设置底部按钮
    fun setBotton(orderState: Int,flag:Boolean) {
        when (orderState) {//订单状态：-1 订单冻结，0 等待商家确认，1 待服务，2 进行中 ，3 待评价，4 已结束，5 未付款，6 用户取消，7 付款超时，8 商家拒绝，9 商家确认超时

            //等待商家确认
            0 -> {
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, true)//取消订单
                setVisible(orderRelation, true)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, true)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,false)//删除订单
//                        .setText(orderType, "等待商家确认")
            }
            //待服务
            1 -> {
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, true)//取消订单
                setVisible(orderRelation, true)//联系商家
                setVisible(orderCode, true)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, true)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,false)//删除订单
//                        .setText(orderType, "待服务")
            }
            //进行中
            2 -> {
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, false)//取消订单
                setVisible(orderRelation, false)//联系商家
                setVisible(orderCode, true)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, true)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,false)//删除订单
//                        .setText(orderType, "正在消费")
            }
            //待评价
            3 -> {
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, false)//取消订单
                setVisible(orderRelation, true)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, false)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,true)//删除订单
//                        .setText(orderType, "待评价")
            }
            //已结束
            4 -> {//订单状态：-1 订单冻结，0 等待商家确认，1 待服务，2 进行中 ，3 待评价，4 已结束，5 未付款，6 用户取消，7 付款超时，8 商家拒绝，9 商家确认超时
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, false)//取消订单
                setVisible(orderRelation, true)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, false)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,true)//删除订单
//                        setText(orderType, "约玩已完成")
            }

            //未付款
            5 -> {
                var timeutils = TimeUtils()
                timeutils.setCallBack(this)
                var timeView = findViewById<TextView>(R.id.orderTime)
                if (time>0) {
                    timeutils.setEndTimer(time.toLong())
                    timeutils.codeCountTimerOrder(timeView)
                }
                setVisible(orderTime, true)//时间
                setVisible(orderCancel, true)//取消订单
                setVisible(orderRelation, false)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, true)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, false)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,false)//删除订单
//                        .setText(orderType, "待评价")
            }
            //用户取消
            6 -> {
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, false)//取消订单
                setVisible(orderRelation, true)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, false)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,true)//删除订单
//                        .setText(orderType, "${item.orderCountPrice}")
            }
            //付款超时
            7 -> {//订单状态：-1 订单冻结，0 等待商家确认，1 待服务，2 进行中 ，3 待评价，4 已结束，5 未付款，6 用户取消，7 付款超时，8 商家拒绝，9 商家确认超时
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, false)//取消订单
                setVisible(orderRelation, false)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, false)//添加服务
//                setVisible(orderLayout,false)
                if (flag){
                    setVisible(orderAgain,false)//重新下单
                }else {
                    setVisible(orderAgain, true)//重新下单
                }
                setVisible(orderDel,true)//删除订单
//                    .setText(orderType, "订单已取消")
            }
            //商家拒绝
            8 -> {
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, false)//取消订单
                setVisible(orderRelation, true)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, false)//添加服务
                setVisible(orderAgain,false)//重新下单
                setVisible(orderDel,true)//删除订单
//                        .setText(orderType, "${item.orderCountPrice}")
            }
            //商家确认超时
            9->{
                setVisible(orderTime, false)//时间
                setVisible(orderCancel, false)//取消订单
                setVisible(orderRelation, true)//联系商家
                setVisible(orderCode, false)//分享
                setVisible(orderPay, false)//去支付
                setVisible(orderEvaluate, false)//评价
                setVisible(orderCome, false)//添加服务
                if (flag){
                    setVisible(orderAgain,false)//重新下单
                }else {
                    setVisible(orderAgain, true)//重新下单
                }
                setVisible(orderDel,true)//删除订单
            }

        }
    }

    fun setVisible(view: View, type: Boolean) {
        if (type) view.visibility = View.VISIBLE else view.visibility = View.GONE
    }

    //设置酒水
    private fun setDrinkData(wines: List<OrderDetailsBean.DataBean.OrderWineBean.FirstWineBean.WinesBeanX>) {
        val map = HashMap<String, List<DrinkDB>>()
        for (wine in wines) {
            if (!map.containsKey(wine.wineTypeName)) {
                val drinkDBS = ArrayList<DrinkDB>()
                var drinkdb = DrinkDB()
                drinkdb.mealName = wine.wineTypeName
                drinkdb.drinkNum = "${wine.num}"
                drinkdb.drinkImage = wine.wineImage
                drinkdb.drinkName = wine.wineName
                drinkdb.drinkMoney = "${wine.wineCountPrice}"
                drinkDBS.add(drinkdb)
                map[wine.wineName] = drinkDBS
            } else {
                var drinkDBS = map[wine.wineName] as ArrayList
                var drinkdb = DrinkDB()
                drinkdb.mealName = wine.wineTypeName
                drinkdb.drinkNum = "${wine.num}"
                drinkdb.drinkImage = wine.wineImage
                drinkdb.drinkName = wine.wineName
                drinkdb.drinkMoney = "${wine.wineCountPrice}"
                drinkDBS.add(drinkdb)
            }
        }
        var money = BigDecimal("0.0")
        wines.forEachIndexed { index, winesBeanX ->
            money = (money.add(winesBeanX.wineCountPrice) )
        }
        orderFourList.setGroupIndicator(null)
        var list = ArrayList<ExpListBean>()
        var moneyList = ArrayList<CouponsDialog.DrinkMoney>()
        for (wine in map) {
            var info = ExpListBean()
            var drinkList = ArrayList<ExpListBean.DrinkBean>()
            info.name = wine.key
            var money = 0.0
            for (drink in wine.value) {
                var drinkInfo = ExpListBean.DrinkBean()
                drinkInfo.drinkID = drink.drinkID
                drinkInfo.drinkImage = drink.drinkImage
                drinkInfo.drinkMoney = drink.drinkMoney
                drinkInfo.drinkName = drink.drinkName
                drinkInfo.id = drink.id
                drinkInfo.drinkNum = drink.drinkNum
                drinkInfo.drinkText = drink.drinkText
                drinkList.add(drinkInfo)
                money = money + (drink.drinkMoney.toDouble() * drink.drinkNum.toDouble())
            }
            info.drink = drinkList
            list.add(info)
            moneyList.add(CouponsDialog.DrinkMoney(wine.key, "${money}"))
        }
        var adapters = DrinkExpanAdapter(list, this)
        orderFourList.setAdapter(adapters)

        orderFourMoney.text = "¥:"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        orderFourMoneyOther.text="¥:"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        for (i in list.indices) {
            orderFourList.expandGroup(i)
        }
        orderFourList.setOnGroupClickListener { parent, v, groupPosition, id ->
            return@setOnGroupClickListener true
        }
    }

    //第一次赠送酒水
    private fun setDrinkPresent(gift: OrderDetailsBean.DataBean.OrderWineBean.FirstWineBean.GiftBean) {
        var drinkAdapter = FirstPresentAdapter(gift.wines)
        var manager = LinearLayoutManager(this)
        manager.orientation = LinearLayout.VERTICAL
        presentList.layoutManager = manager
        presentList.adapter = drinkAdapter
    }

    //判断包名是否存在
    fun isPackageInstalled(packageName: String): Boolean {
        return File("/data/data/$packageName").exists()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (handler!=null&&runnable!=null){
            Log.e("测试","销毁定时器")
            handler!!.removeCallbacks(runnable)
            handler=null
        }
    }

    /**
     * 根据当前日期获得是星期几
     * time=yyyy-MM-dd
     * @return
     */
    public fun getWeek(time:String):String {
        var  Week = ""
        var format = SimpleDateFormat("yyyy-MM-dd")
        var c = Calendar.getInstance()
        try {
            c.setTime(format.parse(time))
        } catch (e:Exception) {
            Log.e("测试","异常")
            e.printStackTrace()
        }

        var wek=c.get(Calendar.DAY_OF_WEEK)

        if (wek == 1) {
            Week += "周日"
        }
        if (wek == 2) {
            Week += "周一"
        }
        if (wek == 3) {
            Week += "周二"
        }
        if (wek == 4) {
            Week += "周三"
        }
        if (wek == 5) {
            Week += "周四"
        }
        if (wek == 6) {
            Week += "周五"
        }
        if (wek == 7) {
            Week += "周六"
        }
        return Week
    }

    fun getData(time:String):String{
        var split=time.split("-")
        return split[1]+"月"+split[2]+"日"
    }

    fun getTime(time:String):String{
        var split=time.split(" ")

        return getData(split[0])+"（"+getWeek(split[0])+"）"+split[1].substring(0,split[1].length-3)
    }

}