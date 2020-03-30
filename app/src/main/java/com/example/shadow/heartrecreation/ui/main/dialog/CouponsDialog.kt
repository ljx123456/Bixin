package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.DbUtils.getMerchat
import com.example.shadow.heartrecreation.db.DrinkUtils.getDrinksData
import com.example.shadow.heartrecreation.db.ServeUtils.getServeData
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.db.user.getRoomType
import com.example.shadow.heartrecreation.db.user.setBrokerType
import com.example.shadow.heartrecreation.db.user.setNum
import com.example.shadow.heartrecreation.db.user.setOrderNo
import com.example.shadow.heartrecreation.db.user.setRoomMoney
import com.example.shadow.heartrecreation.db.user.setRoomType
import com.example.shadow.heartrecreation.db.user.setType
import com.example.shadow.heartrecreation.ui.main.activity.YueActivity
import com.example.shadow.heartrecreation.ui.main.adapter.CouponsDrinksGroupAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.DrinkDetailsAdapters
//import com.example.shadow.heartrecreation.ui.main.adapter.DrinkExpanAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.PayBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.PayPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.PayView
import com.example.shadow.heartrecreation.ui.pay.PayUtils
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dialog_coupons.*
import kotlinx.android.synthetic.main.layout_money_tips.*
import java.math.BigDecimal

@SuppressLint("ValidFragment")
class CouponsDialog(val finish:DialogFinish) : BaseDialogFragment(), PayView, PayTypeDialog.PayType, MerchantCouponDialog.MerchantCoupon {
    override fun getOrderRequest(data:OrderPayBean) {
        if (data.data.orderNo!=null)
            setOrderNo(data.data.orderNo)
        DrinkUtils.deleteALLDrinks()//删除所有酒水
        ServeUtils.deleteALLServe()//删除所有服务员
        setNum("0")
        setBrokerType("0")
        setBrokerType("0")
        setRoomType("0")
        setType("1")
        DbUtils.delMerchat()
        OrderServeUtils.deleteAllOrder()
        com.example.shadow.heartrecreation.ui.order.utils.intentUtils.intentOrderDetils(data.data.orderNo)
        activity!!.finish()
        dismiss()
    }

    override fun getPayError(data: ErrorDrinks?) {
        dismiss()
        if (data!=null&&data.data.size>0) {
            var drinks = DrinkUtils.getDrinksData()
            if (drinks != null && drinks.size > 0) {
                data.data[0].wines.forEach {
                    var id=it
                    drinks.forEach {
                        if (it.drinkID==id.toString()){
                            DrinkUtils.deleteDrinks(it.id)
                        }
                    }
                }
            }
        }
        ShowDialog.showCustomDialog(activity!!,"部分酒水已下架","已经自动帮你移除下架酒水\n请重新确认酒水","确认",object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface, which: Int) {
                dialog.dismiss()
                finish.dialogFinish()
            }
        })
//        Toast.Tips("有酒水已下架，请重新添加")


    }

    //优惠券信息
    override fun setMerchantCouponData(get: UserFindBean.DataBean?) {
        if (get!=null) {
            userCouponId = "${get!!.userCouponId}"
            couponMoney = get!!.couponMoney.toDouble()
            couponsMoney.text = "¥:${get!!.couponMoney}"
            layout_couponsMoney.visibility = View.VISIBLE
            tv_couponsMoney.text = "-¥:${get!!.couponMoney}"
            setMoney()
        }else{
            userCouponId=""
            couponMoney=0.00
            couponsMoney.text = "¥:0.00"
            layout_couponsMoney.visibility = View.GONE
            tv_couponsMoney.text = "-¥:0.00"
            setMoney()
        }
    }

    //支付宝支付
    override fun AliPay(data: AliPayBean.DataBean?) {
        dismiss()
        if (data != null) {
            PayUtils.AliPay(activity!!, data.payInfo)
            DrinkUtils.deleteALLDrinks()//删除所有酒水
            ServeUtils.deleteALLServe()//删除所有服务员
            setNum("0")
            setBrokerType("0")
            setBrokerType("0")
            setRoomType("0")
            setType("1")
            DbUtils.delMerchat()
            OrderServeUtils.deleteAllOrder()
            if (data.orderNo!=null)
                setOrderNo(data.orderNo)
            activity!!.finish()
//            activity!! as YueActivity
//            intentUtils.intentOrder()

        }
    }

    //微信支付
    override fun WeChatPay(data: WeChatBean.DataBean?) {
        dismiss()
        if (data != null) {
            PayUtils.WeChatPay(data)
            DrinkUtils.deleteALLDrinks()//删除所有酒水
            ServeUtils.deleteALLServe()//删除所有服务员
            setNum("0")
            setBrokerType("0")
            setBrokerType("0")
            setRoomType("0")
            setType("1")
            DbUtils.delMerchat()
            if (data.orderNo!=null)
                setOrderNo(data.orderNo)
            OrderServeUtils.deleteAllOrder()
//            intentUtils.intentOrder()
            activity!!.finish()
        }
    }

    //付款类型
    override fun setPayType(s: String) {
        presenter.getPay(setPayData(s))
    }

    override fun setLayoutID(): Int = R.layout.dialog_coupons

    private var orderSkillType = "0"
    private var couponMoney = 0.0
    private var roommoney=0.00
//    var coupon = MerchantCouponDialog(this,0)
    var time = ""
    var paytype = PayTypeDialog(this)
    var userCouponId = ""
    var referencesUserId = ""
    var isOrder=false

    fun setorderSkillType(type: String, yueTime: String, referencesUserId: String) {
        this.orderSkillType = type
        this.time = yueTime
        this.referencesUserId = referencesUserId
    }

    private val presenter by lazy { PayPresenter(this, this, activity!!) }

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        var merchant=DbUtils.getMerchat()
        if (merchant.merchatServicePrice!=null&&merchant.merchatServicePrice!=""&&merchant.merchatServicePrice.toDouble()>0.00){
            layout_coupons_roomMoney.visibility=View.VISIBLE
            roomMoney.text="¥:"+BigDecimal(user.getRoomMoney()).setScale(2,BigDecimal.ROUND_HALF_UP).toString()
            roommoney=user.getRoomMoney().toDouble()
            tv_money_tips.text="该付款金额为酒水金额（含服务费），不包含达人金额"
        }else{
            layout_coupons_roomMoney.visibility=View.GONE
            tv_money_tips.text="该付款金额为酒水金额，不包含达人金额"
        }
        if (getRoomType()=="1"){
            couponsMoneys.text="¥0.00"
            setRoomMoney("0.00")
            roommoney=0.00
            layout_coupons_roomMoney.visibility=View.GONE
            tv_money_tips.text="该付款金额为酒水金额，不包含达人金额"
        }else{
            tv_money_tips.text="该付款金额为酒水金额（含服务费），不包含达人金额"
        }
        haveDrinks()
    }

    override fun clickListener() {
        Click.viewClick(overDialog).subscribe { dismiss() }
        //优惠券
        Click.viewClick(couponsQuan).subscribe {
//            coupon.setSillType(orderSkillType)
//            coupon.show(activity!!.supportFragmentManager, null)
        }

        Click.viewClick(mainContextGo).subscribe {

            if (isOrder) {
                ShowDialog.showCustomDialog(activity!!, "付款提示", "付款后若需发起退款，可能会收取部分违约金，是否继续？", "继续", "取消", true, object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                dialog.dismiss()
                                paytype.show(activity!!.supportFragmentManager, null)
                            }
                            DialogInterface.BUTTON_NEGATIVE -> {
                                dialog.dismiss()
                            }
                        }

                    }

                }, object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        intentUtils.intentHtml(2)
                    }
                })
            }else{
                presenter.getPay(setPayData("3"))
            }

        }
    }

    fun setPayData(s: String): PayBody {
        var body = PayBody()
        var merchant = getMerchat()//商家信息
        var server = getServeData()//服务人员信息
        var drink = getDrinksData()//酒水信息
        var serverList = ArrayList<serverData>()
        if (server != null && server.size > 0 && server.get(0).image != null) {
//            server.isNotEmpty()
            server.forEachIndexed  { index, servePersonnelDB ->
                serverList.add(serverData(servePersonnelDB.serveID, orderSkillType, "1", "3600"))
            }
        }

        body.serviceUsers = serverList//服务人员
        var drinkList = ArrayList<drinkData>()
        for (i in drink.indices) {
            var drinkData = drink.get(i)
            drinkList.add(drinkData(drinkData.drinkID, drinkData.drinkNum))
        }
        body.wines = drinkList//酒水
        body.orderSkillType = orderSkillType//技能ID
        body.businessId = merchant.merchantID//商家ID
        body.boxId = merchant.baofangID//包间类型
        body.boxTypeId = merchant.baofangTypeID//包间类型
        body.boxId = merchant.baofangID//包房ID//在包间内才有
        body.reserveStartTime = time//预约时间
        body.referencesUserId = referencesUserId//约玩经纪人
        body.userCouponId = userCouponId//优惠券ID
        body.payType = s// 1 支付宝，2 微信
        body.serviceUserNum = "${user.getNum().toInt()/2}"//约玩人数
        body.orderBoxType = user.getRoomType()//订单类型 0 预约包房，1在包房内（扫码下单）
        return body
    }

    //{\"serviceUserId\":\"3265\",\"skillTypeId\":\"2\",\"skillNum\":\"1\",\"timeRequired\":\"3600\"}]
    //包括服务人员id，技能，技能数量，到场所需时间(单位：秒)
    class serverData(var serviceUserId: String, var skillTypeId: String, var skillNum: String, var timeRequired: String)

    //[{\"wineId\":\"1\",\"num\":\"3\"},{\"wineId\":\"2\",\"num\":\"2\"}]",
    class drinkData(var wineId: String, var num: String)

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
                var moneyList = ArrayList<DrinkMoney>()
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
                    moneyList.add(DrinkMoney(wine.key, "${money}"))
                }
                LogUtils.a("酒水价格" + Gson().toJson(moneyList))
                LogUtils.a("list" + list.toString())

                var drinkAdapter = DrinkDetailsAdapters(moneyList, activity!!)
                drinksMoney.adapter = drinkAdapter


                var adapters = CouponsDrinksGroupAdapter(list)
                var manager=LinearLayoutManager(activity!!)
                drinksList.layoutManager=manager
                drinksList.setAdapter(adapters)
//                for (i in list.indices) {
//                    drinksList.expandGroup(i)
//                }
//                drinksList.setOnGroupClickListener { parent, v, groupPosition, id ->
//                    return@setOnGroupClickListener true
//                }
                setMoney()
                isOrder=true
            }else{
                isOrder=false
                couponsMoneys.text="¥0.00"
                layout_coupons_roomMoney.visibility=View.GONE
            }
        }else{
            isOrder=false
            couponsMoneys.text="¥0.00"
            layout_coupons_roomMoney.visibility=View.GONE
        }
    }

    fun setMoney() {
        var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
                DrinksMoney()
            } else {
                couponsMoneys.text="¥0.00"
            }
        } else {
            couponsMoneys.text="¥0.00"
        }
    }

    //总价
    fun DrinksMoney() {
        var money = 0.0
        var drinks = getDrinksData()
        drinks.forEachIndexed { index, drinkDB ->
            var num = drinkDB.drinkMoney.toDouble() * drinkDB.drinkNum.toInt()
            money = money + num
        }

        if (money>couponMoney) {
            yueMoney.setText("需付款:¥:"+BigDecimal((money - couponMoney + roommoney).toString()).setScale(2,BigDecimal.ROUND_HALF_UP).toString())
        }else{
            yueMoney.setText("需付款:¥:"+BigDecimal(roommoney.toString()).setScale(2,BigDecimal.ROUND_HALF_UP).toString())
        }
        couponsMoneys.text = "¥:"+BigDecimal((money  +roommoney).toString()).setScale(2,BigDecimal.ROUND_HALF_UP).toString()
//        drinksnum.setText("${drinks.size}")
    }

    class DrinkMoney(var money: String, var name: String)

    interface DialogFinish{
        fun dialogFinish()
    }
}

