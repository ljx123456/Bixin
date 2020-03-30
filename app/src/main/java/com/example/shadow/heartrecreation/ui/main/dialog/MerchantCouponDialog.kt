package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.layoutUtils
import com.example.shadow.heartrecreation.ui.main.adapter.CouponsAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UserFindBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.UserFindPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.UserFindView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.dialog_merchant_coupon.*
import kotlinx.android.synthetic.main.layout_error_network.*

@SuppressLint("ValidFragment")
class MerchantCouponDialog(val merchantcoupon: MerchantCoupon,val type:Int) : BaseDialogFragment(), UserFindView {


    override fun setLayoutID(): Int = R.layout.dialog_merchant_coupon

    override fun isFullScreen(): Boolean = true
    private var skilltype = "1"
    private lateinit var adapters: CouponsAdapter
    private val presenter by lazy { UserFindPresenter(this, this, activity!!) }
    private var id=""
    private var money=0.00
    private var usedServiceCoupon="0"

    fun setSillType(orderSkillType: String) {
//        this.skilltype = orderSkillType

    }

    fun setMoney(money:Double){//满减金额
        this.money=money
    }

    fun setId(id:String){//优惠券ID
        this.id=id
    }

    fun setUsedCoupons(usedServiceCoupon:String){
        this.usedServiceCoupon=usedServiceCoupon
    }

    override fun getUserFindRequest(data: UserFindBean) {
        errorLayout.visibility = View.GONE
        var list=ArrayList<UserFindBean.DataBean>()
        if (type==0){
            data.data.forEach {
                if (it.couponType!=2){
                    list.add(it)
                }
            }
        }else if (type==1){
            data.data.forEach {
                if (it.couponType==2){
                    list.add(it)
                }
            }
        }
//        if (id!="") {
            list.forEach {
                if (it.userCouponId.toString()==id){
                    it.isChick=true
                }else{
                    it.isChick=false
                }
            }
//        }
        adapters = CouponsAdapter(list)
        if (data.data==null||data.data.size==0)
            nextBtn.isEnabled=false
        else
            nextBtn.isEnabled=true
        var manager = LinearLayoutManager(activity!!)
        manager.orientation = LinearLayout.VERTICAL
        couponList.layoutManager = manager
        couponList.adapter = adapters
        adapters.setEmptyView(layoutUtils.getDiscountNull())

//        adapter.addFooterView()
        adapters.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.couponsNext -> {
                    adapters.data.forEachIndexed { index, dataBean ->
                        if (index == position) {
                            if (dataBean.isChick){
                                dataBean.isChick = false
                            }else{
                                dataBean.isChick = true
                            }
                        } else {
                            dataBean.isChick = false
                        }
                    }
                    adapters.notifyDataSetChanged()
                }
            }
        }
    }

    override fun getUserFindError() {
        errorLayout.visibility = View.VISIBLE
        Click.viewClick(anewClick).subscribe { presenter.getUserFind(UserFindBody(skilltype, getUserToken(),money)) }
    }


    override fun setLayoutData() {
        presenter.getUserFind(UserFindBody(skilltype, getUserToken(),money))
    }

    override fun clickListener() {
        Click.viewClick(overDialog).subscribe { dismiss() }
        Click.viewClick(couponOver).subscribe { dismiss() }
        Click.viewClick(couponWhy).subscribe { intentUtils.intentHtml(2)}
        Click.viewClick(nextBtn).subscribe {
            if (adapters != null) {
                if (getChiskData() != -1) {
                    merchantcoupon.setMerchantCouponData(adapters.data.get(getChiskData()))
                } else {
                    merchantcoupon.setMerchantCouponData(null)
                }
            }
            dismiss()
        }
    }

    fun getChiskData(): Int {
        var data = adapters.data
        for (i in data.indices) {
            if (data.get(i).isChick) {
                return i
            }
        }
        return -1
    }

    interface MerchantCoupon {
        fun setMerchantCouponData(get: UserFindBean.DataBean?)
    }
}