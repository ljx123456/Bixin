package com.example.shadow.heartrecreation.ui.order.dialog

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.ui.main.dialog.MerchantCouponDialog
import com.example.shadow.heartrecreation.ui.main.dialog.PayTypeDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayServiceAgainBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.PayServiceBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.PayServicePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.PayServiceView
import com.example.shadow.heartrecreation.ui.pay.PayUtils
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dialog_pay_serve.*
import okhttp3.ResponseBody
import java.math.BigDecimal

class PayServeDialog: BaseDialogFragment(), MerchantCouponDialog.MerchantCoupon, PayServiceView, PayTypeDialog.PayType {
    override fun getPayServiceAgainRequest(data: ResponseBody) {
        dismiss()
        if (parType.equals("1")) {//支付宝
            var Ali = Gson().fromJson(data.string(), AliPayBean::class.java)
            if (Ali.code == 0) PayUtils.AliPay(activity!!, Ali.data.payInfo)
            else Toast.Tips(Ali.message)
        } else {
            var WeChat = Gson().fromJson(data.string(), WeChatBean::class.java)
            if (WeChat.code == 0) PayUtils.WeChatPay(WeChat.data)
            else Toast.Tips(WeChat.message)
        }
    }

    override fun setPayType(s: String) {
        parType = s
        if (data.serviceState==2){
            presenter.getPayServiceAgain(PayServiceAgainBody(data.orderServiceNo,s))
        }else {
            presenter.getPayService(PayServiceBody(data.orderServiceNo, id, s))
        }

    }

    override fun getPayServiceRequest(data: ResponseBody) {
        dismiss()
        if (parType.equals("1")) {//支付宝
            var Ali = Gson().fromJson(data.string(), AliPayBean::class.java)
            if (Ali.code == 0) PayUtils.AliPay(activity!!, Ali.data.payInfo)
            else Toast.Tips(Ali.message)
        } else {
            var WeChat = Gson().fromJson(data.string(), WeChatBean::class.java)
            if (WeChat.code == 0) PayUtils.WeChatPay(WeChat.data)
            else Toast.Tips(WeChat.message)
        }
    }

    private val paytype = PayTypeDialog(this)
    private var parType = "1"
    private val presenter by lazy { PayServicePresenter(this, this, activity!!) }
    override fun setLayoutID(): Int = R.layout.dialog_pay_serve
    private var data = OrderDetailsBean.DataBean.ServiceUsersBean()
    private var merchantcoupon = MerchantCouponDialog(this,1)
    private var id = ""
    private var money= BigDecimal(0.00)
    private var usedServiceCoupon="0"

//    private var serviceState=0
    fun setData(get: OrderDetailsBean.DataBean.ServiceUsersBean) {
        this.data = get
        LogUtils.a("set:${data.serviceState}")
        this.money=get.price
    }

    fun setUsedCoupons(usedServiceCoupon:String){
        this.usedServiceCoupon=usedServiceCoupon
    }



    override fun setMerchantCouponData(get: UserFindBean.DataBean?) {
        if (get!=null) {
            layout_serve_coupons.visibility = View.VISIBLE
            payServeCouponsMoney.text = "-¥:"+get.couponMoney.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
            id = "${get.userCouponId}"
            payServeYouhuiMoney.text = "优惠：¥"+get.couponMoney.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
            payServeAllMoney.text = "¥:"+data.price.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
            if (get.couponMoney.toDouble()<= data.price.toDouble()) {
                payServeAllMoneyTwo.text = "需付款:¥:"+(data.price.subtract(get.couponMoney)).setScale(2,BigDecimal.ROUND_HALF_UP).toString()
            } else {
                payServeAllMoneyTwo.text = "需付款:¥:0.00"
            }

        }else{
            layout_serve_coupons.visibility = View.GONE
            payServeYouhuiMoney.text = ""
            id=""
            payServeAllMoney.text = "¥:"+data.price.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
            payServeAllMoneyTwo.text = "需付款:"+data.price.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        }
    }

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        payServeName.text = data.nickname
        if (data.occupation!=null&&data.occupation!="") {
            payServeJob.visibility=View.VISIBLE
            payServeJob.text = data.occupation
        }else{
            payServeJob.visibility=View.GONE
        }
        ImageLoad.setUserHead(data.avatar,payServeImage)
        payServeMoney.text = "¥:"+data.price.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        payServeAllMoney.text = "¥:"+data.price.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        payServeAllMoneyTwo.text = "需付款:¥:"+data.price.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
        setAgeUtils(payServeAge, data.sex, data.age)
        LogUtils.a("data:${data.serviceState}")
        if (data.serviceState==2){
//            layout_serve_coupons.visibility=View.GONE
            payServeYouhui.visibility=View.GONE
        }else{
//            layout_serve_coupons.visibility=View.VISIBLE
            payServeYouhui.visibility=View.VISIBLE
        }
    }

    override fun clickListener() {
        Click.viewClick(mealServeOver).subscribe { dismiss() }
        Click.viewClick(payServeYouhui).subscribe {
//            if (id!=""){
            if (usedServiceCoupon=="0") {
                merchantcoupon.setId(id)
                merchantcoupon.setMoney(money.toDouble())
//            }
                merchantcoupon.show(activity!!.supportFragmentManager, "")
            }else{
                Toast.Tips("订单只能使用一次达人优惠券")
            }
        }
        Click.viewClick(payServeGo).subscribe {
            ShowDialog. showCustomDialog(activity!!,"付款提示","付款后若需发起退款，可能会收取部分违约金，是否继续？","继续", "取消",object : DialogInterface.OnClickListener{
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

            })

        }
    }
}