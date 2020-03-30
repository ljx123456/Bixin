package com.example.shadow.heartrecreation.ui.main.activity

import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.ui.main.adapter.*
import com.example.shadow.heartrecreation.ui.main.dialog.CouponsDialog
import com.example.shadow.heartrecreation.ui.main.dialog.PayTypeDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.PayBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.PayPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.PayView
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddWineBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.AddWinePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.AddWineView
import com.example.shadow.heartrecreation.ui.order.utils.intentUtils
import com.example.shadow.heartrecreation.ui.pay.PayUtils
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOrder

import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sao_order.*
import kotlinx.android.synthetic.main.dialog_coupons.*
import kotlinx.android.synthetic.main.layout_title.*
import okhttp3.ResponseBody
import java.math.BigDecimal

class SaoOrderActivity:BaseActivity(),YueDrinkAdapter.Expandable, PayView, AddWineView, PayTypeDialog.PayType{
    override fun getOrderRequest(data:OrderPayBean) {
        if (data.data.orderNo!=null) {
            user.setOrderNo(data.data.orderNo)
            intentUtils.intentOrderDetils(data.data.orderNo)
        }else{
            intentOrder()
        }
        finish()
    }

    override fun getAddWineRequest(data: ResponseBody) {
        if (parType.equals("1")) {//支付宝
            var Ali = Gson().fromJson(data.string(), AliPayBean::class.java)
            if (Ali.code == 0) {
                PayUtils.AliPay(this, Ali.data.payInfo)
                if (Ali.data.orderNo!=null)
                    user.setOrderNo(Ali.data.orderNo)
                finish()
            } else Toast.Tips(Ali.message)
        } else {
            var WeChat = Gson().fromJson(data.string(), WeChatBean::class.java)
            if (WeChat.code == 0) {
                PayUtils.WeChatPay(WeChat.data)
                if (WeChat.data.orderNo!=null)
                    user.setOrderNo(WeChat.data.orderNo)
                finish()
            } else Toast.Tips(WeChat.message)
        }
    }

    override fun getPayError(data: ErrorDrinks?) {
        Toast.Tips("有商品已下架")
    }

    override fun AliPay(data: AliPayBean.DataBean?) {
        if (data != null) {
            PayUtils.AliPay(this, data.payInfo)
//            DrinkUtils.deleteALLDrinks()//删除所有酒水
//            ServeUtils.deleteALLServe()//删除所有服务员
//            user.setNum("0")
//            var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//            merchat.deleteAll()
//            var drink = GreenDaoHelper.getDaoSessions().drinkDBDao
//            drink.deleteAll()
//            activity!! as YueActivity
            if (data.orderNo!=null)
                user.setOrderNo(data.orderNo)
            finish()
        }
    }

    override fun WeChatPay(data: WeChatBean.DataBean?) {
        if (data != null) {
            PayUtils.WeChatPay(data)
//            DrinkUtils.deleteALLDrinks()//删除所有酒水
//            ServeUtils.deleteALLServe()//删除所有服务员
//            user.setNum("0")
//            var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//            merchat.deleteAll()
//            var drink = GreenDaoHelper.getDaoSessions().drinkDBDao
//            drink.deleteAll()
            if (data.orderNo!=null)
                user.setOrderNo(data.orderNo)
            finish()
        }
    }

    override fun setPayType(s: String) {
        if (type=="0") {
            if (isOrder) {
                payPresenter.getPay(setPayData(s))
                Log.e("测试订单","付款订单")
            } else {
                payPresenter.getPay(setPayData("3"))
            }
        }else{
            parType=s
            var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
            if (merchat != null) {
                var data = merchat.loadAll()
                var drinkData = ArrayList<AddWineBody.WinesBean>()
                data.forEachIndexed { index, drinkDB ->
                    drinkData.add(AddWineBody.WinesBean(drinkDB.drinkID, drinkDB.drinkNum))
                }
                addwine.getAddWine(AddWineBody(orderID, parType,"1" ,drinkData))
            }
        }
    }

    override fun ChildClick() {

    }

    private var money = BigDecimal("0.00")//酒水费用
    private var merchantID = ""
//    private var baofangMoney = ""//包房服务费
//    private var serviceMoney=0.00
    var paytype = PayTypeDialog(this)
    private val payPresenter by lazy { PayPresenter(this, this, this) }
    private val addwine by lazy { AddWinePresenter(this, this, this) }
    var userCouponId = ""
    var referencesUserId = ""
    private var orderSkillType = "1"
    private var isOrder=false
    private var type=""
    private var orderID=""
    private var parType=""
//    var time = ""

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.activity_sao_order

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
        titleText.text="等待付款"
    }

    override fun initActivityData() {
        type=intent.getStringExtra("type")
        if (type=="0") {
            referencesUserId = intent.getStringExtra("referencesUserId")
            orderSkillType = intent.getStringExtra("orderSkillType")

        }else{
            orderID=intent.getStringExtra("orderId")
        }
        haveMerchant()
        haveServe()
        haveDrinks()
        tv_sao_total_money.text="¥"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        tv_sao_pay_money.text="酒水付款：¥"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString()

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe {
            finish()

        }
        Click.viewClick(btn_sao_pay).subscribe {

            if (!isOrder){
                payPresenter.getPay(setPayData("3"))
            }else {
                paytype.show(supportFragmentManager, null)
//                ShowDialog.showCustomDialog(this, "付款提示", "付款后若需发起退款，可能会收取部分违约金，是否继续？", "继续", "取消", object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface, which: Int) {
//                        when (which) {
//                            DialogInterface.BUTTON_POSITIVE -> {
//                                dialog.dismiss()
//                                paytype.show(supportFragmentManager, null)
//                            }
//                            DialogInterface.BUTTON_NEGATIVE -> {
//                                dialog.dismiss()
//                            }
//                        }
//
//                    }
//
//                })
            }
        }
    }

    //有酒水时
    private fun haveDrinks() {
        var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
                val map = HashMap<String, List<DrinkDB>>()
                LogUtils.a("保存的酒水" + Gson().toJson(data))
                for (wine in data) {
                    if (!map.containsKey(wine.mealName)) {
                        val drinkDBS = ArrayList<DrinkDB>()
                        drinkDBS.add(wine)
                        map[wine.mealName] = drinkDBS
                    } else {
                        var drinkDBS = map[wine.mealName] as ArrayList
                        drinkDBS.add(wine)
                    }
                }
//                drinksList.setGroupIndicator(null)
                var list = ArrayList<ExpListBean>()
//                var moneyList = ArrayList<CouponsDialog.DrinkMoney>()
                for (wine in map) {
                    var info = ExpListBean()
                    var drinkList = ArrayList<ExpListBean.DrinkBean>()
                    info.name = wine.key
//                    var money = 0.0
                    for (drink in wine.value) {
                        var drinkInfo = ExpListBean.DrinkBean()
                        info.id=drink.mealId
                        drinkInfo.drinkID = drink.drinkID
                        drinkInfo.drinkImage = drink.drinkImage
                        drinkInfo.drinkMoney = drink.drinkMoney
                        drinkInfo.drinkName = drink.drinkName
                        drinkInfo.id = drink.id
                        drinkInfo.drinkNum = drink.drinkNum
                        drinkInfo.drinkText = drink.drinkText
                        drinkInfo.mealName=drink.mealName
                        drinkInfo.mealId=drink.mealId
                        drinkList.add(drinkInfo)
//                        money = money + (drink.drinkMoney.toDouble() * drink.drinkNum.toDouble())
                    }
                    info.drink = drinkList
                    list.add(info)
//                    moneyList.add(CouponsDialog.DrinkMoney(wine.key, "${money}"))
                }
                LogUtils.a("酒水价格" + Gson().toJson(list))
                LogUtils.a("list" + list.toString())

//                var drinkAdapter = DrinkDetailsAdapters(moneyList, this)
//                drinksMoney.adapter = drinkAdapter

                isOrder=true
                var adapters = CouponsDrinksGroupAdapter(list)
                var manager=LinearLayoutManager(this)
                yueDrinkss.layoutManager=manager
                yueDrinkss.setAdapter(adapters)
//                Click.viewClick(addDrinkss).subscribe { intentDrinks(merchantID) }
                DrinksMoney()
            } else {
//                layoutYueWine.visibility = View.GONE
                yueDrinkss.visibility = View.GONE
                isOrder=false
                DrinksMoney()
            }
        } else {
            isOrder=false
            DrinksMoney()
//            layoutYueWine.visibility = View.GONE
            yueDrinkss.visibility = View.GONE
        }
    }

    //酒水总价
    fun DrinksMoney() {
        money = BigDecimal("0.00")
        val drinksMoney = DrinkUtils.getDrinksData()
        if (drinksMoney != null && drinksMoney!!.size > 0 && !drinksMoney!!.get(0).mealName.isNullOrEmpty()) {
            drinksMoney.forEachIndexed { index, drinkDB ->
                var num =BigDecimal(drinkDB.drinkMoney).multiply(BigDecimal(drinkDB.drinkNum))
                money = money.add(num)
            }
        }
        tv_sao_drink_money.text="¥"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
//        yueMoney.setText("需付款:¥${money}")
    }

    //有数据时商家
    fun haveMerchant() {
        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
//                yueAdds.visibility = View.GONE
//                yueAddss.visibility = View.VISIBLE
                layout_sao_ktv.visibility = View.VISIBLE
                var merchantData = DbUtils.getMerchat()
                merchantID = merchantData.merchantID
                Log.e("测试id",merchantID)
                YueAddsName.setText(merchantData.merchantName)
                YueAddsBaofangType.setText(merchantData.baofangType)
                yueRoomNum.text=merchantData.baofangName
//                baofangMoney = merchantData.merchatServicePrice
//                tv_sao_box_money.text="¥${baofangMoney}"
//                yueAddMiniMoney.setText("最低酒水消费¥${merchantData.baofangMoney}")
//                Click.viewClick(YueAddsName).subscribe { intentMerchant() }
//                //修改包房类型
//                Click.viewClick(addsBaofang).subscribe {
//                    intentMerchantDetails(merchantID,type)
//                }
            } else {
                layout_sao_ktv.visibility = View.GONE
//                if (type == 1) {
//                    yueAdds.visibility = View.GONE
//                    yueAddss.visibility = View.VISIBLE
//                    yueDrinks.visibility = View.GONE
//                } else {
//                    yueAdds.visibility = View.VISIBLE
//                    yueAddss.visibility = View.GONE
//                    yueDrinks.visibility = View.GONE
//                }
            }
        } else {
            layout_sao_ktv.visibility = View.GONE
//            if (type == 1) {
//                yueAdds.visibility = View.GONE
//                yueAddss.visibility = View.VISIBLE
//                yueDrinks.visibility = View.GONE
//            } else {
//                yueAdds.visibility = View.VISIBLE
//                yueAddss.visibility = View.GONE
//                yueDrinks.visibility = View.GONE
//            }
        }
    }

    //有服务人员
    fun haveServe() {
        var serveData = ServeUtils.getServeData()
        if (serveData != null && serveData.size >= 1 && serveData.get(0).image != null) {
//            yuePeople.visibility = View.GONE
            layout_sao_service.visibility = View.VISIBLE
            var adapters = YueServeAdapter(1,serveData)
            var merager = LinearLayoutManager(mContext)
            merager.orientation = LinearLayout.VERTICAL
            yueServeList.layoutManager = merager
            yueServeList.adapter = adapters
            saoMoneyTips.visibility=View.VISIBLE
//            peopleNum.setText("已选(${serveData.size}/${peopleNums})人")
//            adapters.setOnItemChildClickListener { adapter, view, position ->
//                when (view.id) {
//                    R.id.yueServeDell -> {
//                        ServeUtils.deleteServe(adapters.data.get(position).id)
//                        adapters.remove(position)
//                        peopleNum.setText("已选(${adapters.data.size}/${peopleNums})人")
//                    }
//                }
//            }
//            Click.viewClick(addServess).subscribe { intentServeList(id,merchantID) }
        } else {
//            yuePeople.visibility = View.VISIBLE
            saoMoneyTips.visibility=View.GONE
            layout_sao_service.visibility = View.GONE
        }
//        serviceMoney()
    }

    fun setPayData(s: String): PayBody {
        var body = PayBody()
        var merchant = DbUtils.getMerchat()//商家信息
        var server = ServeUtils.getServeData()//服务人员信息
        var drink = DrinkUtils.getDrinksData()//酒水信息
        var serverList = ArrayList<CouponsDialog.serverData>()
        if (server != null && server.size > 0 && server.get(0).image != null) {
//            server.isNotEmpty()
            server.forEachIndexed  { index, servePersonnelDB ->
                serverList.add(CouponsDialog.serverData(servePersonnelDB.serveID, orderSkillType, "1", "3600"))
            }
        }

        body.serviceUsers = serverList//服务人员
        var drinkList = ArrayList<CouponsDialog.drinkData>()
        drink.forEach {
            drinkList.add(CouponsDialog.drinkData(it.drinkID,it.drinkNum))
        }
//        for (i in drink.indices) {
//            var drinkData = drink.get(i)
//            drinkList.add(CouponsDialog.drinkData(drinkData.drinkID, drinkData.drinkNum))
//        }
        body.wines = drinkList//酒水
        body.orderSkillType = orderSkillType//技能ID
        body.businessId = merchant.merchantID//商家ID
        body.boxId = merchant.baofangID//包间类型
        body.boxTypeId = merchant.baofangTypeID//包间类型
        body.boxId = merchant.baofangID//包房ID//在包间内才有
//        body.reserveStartTime = time//预约时间
        body.referencesUserId = referencesUserId//约玩经纪人
//        body.userCouponId = userCouponId//优惠券ID
        body.payType = s// 1 支付宝，2 微信
        body.serviceUserNum = serverList.size.toString()//约玩人数
        var boxType="1"
        if (user.getBrokerType()=="0")
            boxType="1"
        else
            boxType="2"
        body.orderBoxType = boxType//订单类型 0 预约包房，1在包房内（扫码下单）
        return body
    }

    override fun onDestroy() {
        super.onDestroy()
        DrinkUtils.deleteALLDrinks()//删除所有酒水
        ServeUtils.deleteALLServe()//删除所有服务员
        user.setNum("0")
        user.setBrokerType("0")
        user.setBrokerType("0")
        user.setRoomType("0")
        user.setType("1")
        DbUtils.delMerchat()
        OrderServeUtils.deleteAllOrder()
    }
}