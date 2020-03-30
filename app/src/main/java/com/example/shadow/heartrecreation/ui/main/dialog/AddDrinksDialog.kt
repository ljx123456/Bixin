package com.example.shadow.heartrecreation.ui.main.dialog

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.ui.main.adapter.CouponsDrinksGroupAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.DrinkDetailsAdapters
//import com.example.shadow.heartrecreation.ui.main.adapter.DrinkExpanAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddWineBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.AddWinePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.AddWineView
import com.example.shadow.heartrecreation.ui.pay.PayUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dialog_coupons.*
import kotlinx.android.synthetic.main.layout_money_tips.*
import okhttp3.ResponseBody

class AddDrinksDialog : BaseDialogFragment(), AddWineView, PayTypeDialog.PayType {
    override fun getAddWineRequest(data: ResponseBody) {
        if (parType.equals("1")) {//支付宝
            var Ali = Gson().fromJson(data.string(), AliPayBean::class.java)
            if (Ali.code == 0) {
                PayUtils.AliPay(activity!!, Ali.data.payInfo)
                DrinkUtils.deleteALLDrinks()//删除所有酒水
                ServeUtils.deleteALLServe()//删除所有服务员
                user.setNum("0")
                user.setBrokerType("0")
                user.setBrokerType("0")
                user.setRoomType("0")
                user.setType("1")
                DbUtils.delMerchat()
                OrderServeUtils.deleteAllOrder()
            } else Toast.Tips(Ali.message)
        } else {
            var WeChat = Gson().fromJson(data.string(), WeChatBean::class.java)
            if (WeChat.code == 0) {
                PayUtils.WeChatPay(WeChat.data)
                DrinkUtils.deleteALLDrinks()//删除所有酒水
                ServeUtils.deleteALLServe()//删除所有服务员
                user.setNum("0")
                user.setBrokerType("0")
                user.setBrokerType("0")
                user.setRoomType("0")
                user.setType("1")
                DbUtils.delMerchat()
                OrderServeUtils.deleteAllOrder()
            } else Toast.Tips(WeChat.message)
        }
    }

    override fun setPayType(s: String) {
        parType = s
        var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            var drinkData = ArrayList<AddWineBody.WinesBean>()
            data.forEachIndexed { index, drinkDB ->
                drinkData.add(AddWineBody.WinesBean(drinkDB.drinkID, drinkDB.drinkNum))
            }
            addwine.getAddWine(AddWineBody(user.getOrderID(), s,user.getRoomType() ,drinkData))
        } else {
            Toast.Tips("请选择添加的酒水")
        }
    }

    private val addwine by lazy { AddWinePresenter(this, this, activity!!) }
    private val paytype = PayTypeDialog(this)
    private var parType = ""
    override fun setLayoutID(): Int = R.layout.dialog_coupons

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        couponsQuan.visibility = View.GONE
        layout_coupons_roomMoney.visibility=View.GONE
        layout_money_tip.visibility=View.GONE
        haveDrinks()
    }

    override fun clickListener() {
        Click.viewClick(overDialog).subscribe { dismiss() }
        Click.viewClick(mainContextGo).subscribe {
            paytype.show(activity!!.supportFragmentManager, null)
        }
    }

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
                LogUtils.a("酒水价格" + Gson().toJson(moneyList))

                var drinkAdapter = DrinkDetailsAdapters(moneyList, activity!!)
                drinksMoney.adapter = drinkAdapter


                var adapters = CouponsDrinksGroupAdapter(list)
                var manager= LinearLayoutManager(activity!!)
                drinksList.layoutManager=manager
                drinksList.setAdapter(adapters)
//                for (i in list.indices) {
//                    drinksList.expandGroup(i)
//                }
//                drinksList.setOnGroupClickListener { parent, v, groupPosition, id ->
//                    return@setOnGroupClickListener true
//                }
                setMoney()
            }
        }
    }

    fun setMoney() {
        var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
                DrinksMoney()
            } else {

            }
        } else {

        }
    }

    //总价
    fun DrinksMoney() {
        var money = 0.0
        var drinks = DrinkUtils.getDrinksData()
        drinks.forEachIndexed { index, drinkDB ->
            var num = drinkDB.drinkMoney.toDouble() * drinkDB.drinkNum.toInt()
            money = money + num
        }
        yueMoney.setText("需付款:¥:${money}")
        couponsMoneys.text = "¥:${money}"
//        drinksnum.setText("${drinks.size}")
    }
}