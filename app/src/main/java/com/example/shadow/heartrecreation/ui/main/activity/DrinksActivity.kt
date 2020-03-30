package com.example.shadow.heartrecreation.ui.main.activity

import android.os.Handler
import android.support.v4.app.Fragment
import android.view.View
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.ACache
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.DrinkUtils
import com.example.shadow.heartrecreation.db.DrinkUtils.getDrinksData
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.db.MerchantDrinkDB
import com.example.shadow.heartrecreation.db.user.getOrderID
import com.example.shadow.heartrecreation.db.user.getRoomType
import com.example.shadow.heartrecreation.db.user.getType
import com.example.shadow.heartrecreation.ui.main.dialog.AddDrinksDialog
import com.example.shadow.heartrecreation.ui.main.dialog.DrinksDialog
import com.example.shadow.heartrecreation.ui.main.dialog.PayTypeDialog
import com.example.shadow.heartrecreation.ui.main.fragment.DrinksFragment
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinksBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.DrinksBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.DrinksPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.PayPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.DrinksView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.order.mvp.body.AddWineBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.AddWinePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.AddWineView
import com.example.shadow.heartrecreation.ui.pay.PayUtils
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import com.myproject.myproject.material_design.tablayout.FragmentAdapter
import kotlinx.android.synthetic.main.activity_drinks.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*
import okhttp3.ResponseBody
import java.math.BigDecimal

class DrinksActivity : BaseActivity(), DrinksView, DrinksFragment.Drinks, DrinksDialog.Drinks, AddWineView, PayTypeDialog.PayType {

    override fun setPayType(s: String) {

    }

    override fun getAddWineRequest(data: ResponseBody) {


    }

    override fun DrinksDialogOver() {
        (fragments[drinksPager.currentItem] as DrinksFragment).init()
        if (getRoomType()=="0") {
            if (BigDecimal(DbUtils.getMerchat().baofangMoney).compareTo(BigDecimal(moneysss.text.toString().substringAfter("¥:"))) <= 0) {
                intentUsils.intentYue(0)
                finish()
            } else {
//                    Toast.Tips()
                Toast.Tips("包间低消为“${DbUtils.getMerchat().baofangMoney}”未满足")
            }
        }else{
            intentUsils.intentYue(0)
            finish()
        }
    }

    override fun ChildDrinksClick() {
        setMoney()
        (fragments[drinksPager.currentItem] as DrinksFragment).init()
    }

    override fun setNewMoney() {
        setMoney()
//        initActivityData()
    }


    private val presenter by lazy { DrinksPresenter(this, this, this) }

    var mFragmentAdapter: FragmentAdapter? = null
    var drinksDialog = DrinksDialog(this)
    private var businessId = ""
    var fragments = ArrayList<Fragment>()

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_drinks

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
//        titleText.setText("蜂巢KTV（武侯店）")
    }

    override fun initActivityData() {
        var mCache = ACache.get(this)
        businessId = intent.getStringExtra("businessId")
        var merchantData = DbUtils.getMerchat()
        if (merchantData!=null){
           titleText.text=merchantData.merchantName
        }
//        businessId = "1"
//        var info = Gson().fromJson("${mCache.getAsString("merchant")}", MerchantDrinkDB::class.java)
//        if (info != null && businessId.equals(info.merchantID)) {
//            var data = Gson().fromJson(info.merchantData, DrinksBean::class.java)
//            errorLayout.visibility = View.GONE
//            var titles = ArrayList<String>()
//            fragments.clear()
//            data.data.forEach { titles.add(it.wineTypes.wineTypeName) }
//            titles.forEachIndexed { index, s ->
//                drinksTab.addTab(drinksTab.newTab().setText(s))
//                var fragment = DrinksFragment(data.data.get(index).wineTypes.wines, this)
//                fragment.setData(data.data.get(index))
//                fragments.add(fragment)
//            }
//            mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
//            drinksPager.adapter = mFragmentAdapter
//            drinksTab.setupWithViewPager(drinksPager)
//            drinksTab.setTabsFromPagerAdapter(mFragmentAdapter)
//            drinksPager.setOffscreenPageLimit(1)
//        } else {
//        if (NetworkUtils.isConnected()) {
        showLoading()
            presenter.getDrinks(DrinksBody(businessId))
//        }
            setMoney()
//        }
    }

    override fun getDrinksRequest(data: DrinksBean) {
//        var mCache = ACache.get(this)
        dismissLoading()
        var info = MerchantDrinkDB()
        info.merchantID = businessId
        info.merchantData = Gson().toJson(data)
//        mCache.put("merchant", Gson().toJson(info))
        errorLayout.visibility = View.GONE
        var titles = ArrayList<String>()
        data.data.forEach { titles.add(it.wineTypes.wineTypeName) }
//        fragments = ArrayList<Fragment>()
        fragments.clear()
        titles.forEachIndexed { index, s ->
            drinksTab.addTab(drinksTab.newTab().setText(s))
            var fragment = DrinksFragment(data.data.get(index).wineTypes.wines, this)
            fragment.setData(data.data.get(index))
            fragments.add(fragment)
        }
        mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
        drinksPager.adapter = mFragmentAdapter
        drinksTab.setupWithViewPager(drinksPager)
        drinksTab.setTabsFromPagerAdapter(mFragmentAdapter)
        drinksPager.setOffscreenPageLimit(1)
    }

    override fun getDrinksError() {
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
        errorLayout.visibility = View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getDrinks(DrinksBody(businessId)) }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(drinksGo).subscribe {
            if ("1".equals(getType())) {
                if (getRoomType()=="0") {
                    if (BigDecimal(DbUtils.getMerchat().baofangMoney).compareTo(BigDecimal(moneysss.text.toString().substringAfter("¥:"))) <= 0) {
                        intentUsils.intentYue(0)
                        finish()
                    } else {
//                    Toast.Tips()
                        Toast.Tips("包间低消为“${DbUtils.getMerchat().baofangMoney}”未满足")
                    }
                }else{
                    intentUsils.intentYue(0)
                    finish()
                }
            } else {
                if (DrinkUtils.getDrinksData()!=null&&DrinkUtils.getDrinksData().size>0) {
                    val addDrinks = AddDrinksDialog()
                    addDrinks.show(supportFragmentManager, "")
                }else{
                    Toast.Tips("请添加酒水")
                }
            }
        }
        Click.viewClick(drinksLists).subscribe { drinksDialog.show(supportFragmentManager, "") }
    }


    fun setMoney() {
        var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
                DrinksMoney()
            } else {
                moneysss.setText("¥:0.00")
                drinksnum.setText("0")
            }
        } else {
            moneysss.setText("¥:0.00")
            drinksnum.setText("0")
        }
    }

    //总价
    fun DrinksMoney() {
        var money = BigDecimal(0.0)
        var num=0
        var drinks = getDrinksData()
        drinks.forEachIndexed { index, drinkDB ->
            var m = BigDecimal(drinkDB.drinkMoney).multiply(BigDecimal(drinkDB.drinkNum))
            money = money.add(m)
            num=num+drinkDB.drinkNum.toInt()
        }
        moneysss.setText("¥:"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString())
        drinksnum.setText("${num}")
    }

    override fun onDestroy() {
        super.onDestroy()
        if ("1".equals(getType())) {

        } else {
            DrinkUtils.deleteALLDrinks()//删除所有酒水
        }
//        drinksDialog.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
    }

}