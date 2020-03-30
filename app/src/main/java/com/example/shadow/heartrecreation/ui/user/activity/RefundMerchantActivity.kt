package com.example.shadow.heartrecreation.ui.user.activity

import android.content.DialogInterface
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout

import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.place.intentUtils
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.ui.main.dialog.CouponsDialog
import com.example.shadow.heartrecreation.ui.order.adapter.DrinkExpanAdapter
import com.example.shadow.heartrecreation.ui.user.adapter.RefundServeAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundMerchantBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundMerchantBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.RefundMerchantPresnter
import com.example.shadow.heartrecreation.ui.user.mvp.view.RefundMerchantView
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.dialog.showPhoneDialog
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import kotlinx.android.synthetic.main.activity_refund_merchant.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_order_five.*
import kotlinx.android.synthetic.main.layout_order_one.*
import kotlinx.android.synthetic.main.layout_order_three.*
//import kotlinx.android.synthetic.main.layout_refund_zero.*
import kotlinx.android.synthetic.main.layout_title.*
import java.math.BigDecimal

class RefundMerchantActivity : BaseActivity(), RefundMerchantView {

    override fun openEventBus(): Boolean = false
    private var refundId = 0
    private val presenter by lazy { RefundMerchantPresnter(this, this, this) }

    override fun getActivityLayout(): Int = R.layout.activity_refund_merchant

    override fun getRefundMerchantRequest(data: RefundMerchantBean) {
        dismissLoading()
        content.visibility=View.VISIBLE
        bottom.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        var info = data.data
        setlayoutTitle(info)
        var orderDetail = info.orderDetail
        refundNum.text=orderDetail.orderNo
        refundAdds.text = "${orderDetail.businessName}${orderDetail.boxTypeName}${orderDetail.boxName}"
        refundStartTime.text=info.startTime.substring(0,info.startTime.length-3)
        if (info.endTime!=null) {
            refundEndTime.text=info.endTime.substring(0,info.endTime.length-3)
        }
        refundTime.text = "下单时间：${orderDetail.createTime.substring(0,orderDetail.createTime.length-3)}"
        if (info.orderDetail.referencesUser != null) {
            orderFiveLayout.visibility = View.VISIBLE
            var referData = info.orderDetail.referencesUser
            ImageLoad.setUserHead(referData.avatar, brokerImageFive)
            brokerNameFive.text = referData.nickname
            setAgeUtils(brokerAgeFive,referData.sex,referData.age)
//            when (referData.sex) {
//                1 -> brokerAgeFive.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//                else -> brokerAgeFive.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//            }
//            brokerAgeFive.text = "${referData.age}"
            if (referData.occupation!=null&&referData.occupation!=""){
                brokerJobFive.visibility=View.VISIBLE
                brokerJobFive.text = referData.occupation
            }else{
                brokerJobFive.visibility=View.GONE
            }

        } else {
            orderFiveLayout.visibility = View.GONE
        }

//        serviceCountPrice.setText("${orderDetail.serviceCountPrice}")//达人费用
//        wineCountPrice.setText("${orderDetail.wineCountPrice}")//酒水费用
//        couponPrice.setText("${orderDetail.couponPrice}")//优惠费用
//        orderCountPrice.setText("${orderDetail.orderCountPrice}")//共支付
//        serviceUserCountNum.setText("（${orderDetail.orderTakingNum}/${orderDetail.serviceUserCountNum}人）")
        var type = false
        refundPayMoney.text="¥"+info.payPrice.setScale(2,BigDecimal.ROUND_HALF_UP)
        refundMoney.text="¥"+info.refundPrice.setScale(2,BigDecimal.ROUND_HALF_UP)
        refundCouponMoney.text="¥"+orderDetail.couponPrice.setScale(2,BigDecimal.ROUND_HALF_UP)
        refundActivityMoney.text="¥"+orderDetail.activityDeductionPrice.setScale(2,BigDecimal.ROUND_HALF_UP)
//        refundZeroText.text =
//                "酒水费用:¥${orderDetail.wineCountPrice}\n" +
//                "优惠券抵扣:¥${orderDetail.couponPrice}"
//        +"活动抵扣:¥12343.00"
//        refundZeroDetails.visibility = View.GONE
//        orderPeopleNum.visibility = View.GONE
//        orderPeopleNum.visibility = View.GONE
//        orderThreeNull.visibility = View.GONE
        Click.viewClick(refundZeroMore).subscribe {
            when (type) {
                false -> {
                    type = true
                    refundZeroMore.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(R.mipmap.more_top), null)
                    refundCoupon.visibility = View.VISIBLE
                    refundActivity.visibility = View.VISIBLE
                }
                else -> {
                    type = false
                    refundZeroMore.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(R.mipmap.more_down), null)
                    refundCoupon.visibility = View.GONE
                    refundActivity.visibility = View.GONE
                }
            }
        }
//        Click.viewClick(orderNavigation).subscribe {
//            intentUtils.intentLocation(info.orderDetail.latitude, info.orderDetail.longitude, info.orderDetail.businessImg)
//        }
        Click.viewClick(orderCode).subscribe {
            showPhoneDialog.showDialog(this@RefundMerchantActivity, info.platformPhone)
        }
        setDrinkData(info.orderDetail.orderWine.firstWine.wines)

//        var orderAdapter = RefundServeAdapter(info.orderDetail.serviceUsers)
//        var manager = LinearLayoutManager(mContext)
//        manager.orientation = LinearLayout.VERTICAL
//        orderServeList.layoutManager = manager
//        orderServeList.adapter = orderAdapter

        /**
         * 约玩名单，酒水暂未处理
         */
    }

    //设置头部显示
    private fun setlayoutTitle(info: RefundMerchantBean.DataBean) {
//        refundTimeOne.text = info.startTime
//        refundTimeTwo.text = info.handleTime
//        refundTimeThree.text = info.endTime
        //0 发起退款，1 退款中，2 退款成功，3 退款失败
        when (info.refundState) {
            0 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_01)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.whites))
                refundTypeThree.setTextColor(resources.getColor(R.color.whites))
                refundTypeContext.text = "发起退款"
                ShowDialog.showCustomDialog(this, "退款解释", "具体到账时间以微信、支付宝方的相应规则为准！", "我知道了", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        dialog.dismiss()
                    }
                })
            }
            1 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_02)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.setTextColor(resources.getColor(R.color.whites))
                refundTypeContext.text = "退款中"
            }
            2 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_03)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.setTextColor(resources.getColor(R.color.white))
                refundTypeContext.text = "退款成功"
            }
            3 -> {
                orderTypeImage.setImageResource(R.mipmap.refund_step_03)
                refundTypeOne.setTextColor(resources.getColor(R.color.white))
                refundTypeTwo.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.setTextColor(resources.getColor(R.color.white))
                refundTypeThree.text = "退款失败"
                refundTypeContext.text = "退款失败"
            }
        }
    }

    override fun getRefundMerchantError() {
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
        content.visibility=View.GONE
        bottom.visibility=View.GONE
        errorLayout.visibility=View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getRefundMerchant(RefundMerchantBody("$refundId"))
        }
    }

    override fun setActivityTitle() {
        titleText.setText("退款详情")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRight.setImageResource(R.mipmap.singerdetails_button_doubt)
    }

    override fun initActivityData() {
        refundId = intent.getIntExtra("refundId", 0)
        showLoading()
        presenter.getRefundMerchant(RefundMerchantBody("$refundId"))

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(titleRight).subscribe {
            com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentHtml(2)
        }
    }

    //设置酒水
    private fun setDrinkData(wines: List<RefundMerchantBean.DataBean.OrderDetailBean.OrderWineBean.FirstWineBean.WinesBean>) {
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
        for (i in list.indices) {
            orderFourList.expandGroup(i)
        }
        orderFourList.setOnGroupClickListener { parent, v, groupPosition, id ->
            return@setOnGroupClickListener true
        }
    }

}