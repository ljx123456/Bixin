package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.DrinkUtils
import com.example.shadow.heartrecreation.db.DrinkUtils.deleteALLDrinks
import com.example.shadow.heartrecreation.db.DrinkUtils.getDrinksData
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.main.adapter.DialogDrinksGroupAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.ui.main.adapter.YueDrinkAdapter
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.dialog_drinks.*
import java.math.BigDecimal

@SuppressLint("ValidFragment")
class DrinksDialog(val drinks: Drinks) : BaseDialogFragment(), DialogDrinksGroupAdapter.Expandable {

    override fun ChildClick() {
        haveDrinks()
        drinks.ChildDrinksClick()
    }

    override fun setLayoutID(): Int = R.layout.dialog_drinks

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        haveDrinks()
    }

    //有酒水时
    private fun haveDrinks() {
        var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
                drinksExList.visibility=View.VISIBLE
                val map = HashMap<String, List<DrinkDB>>()
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
//                drinksExList.setGroupIndicator(null)
                var list = ArrayList<ExpListBean>()
                for (wine in map) {
                    var info = ExpListBean()
                    var drinkList = ArrayList<ExpListBean.DrinkBean>()
                    info.name = wine.key
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
                    }
                    info.drink = drinkList
                    list.add(info)
                }
                var adapters = DialogDrinksGroupAdapter(list,this)
                var manager= LinearLayoutManager(activity!!)
                drinksExList.layoutManager=manager
                drinksExList.setAdapter(adapters)
//                Click.viewClick(addDrinkss).subscribe { intentDrinks(merchantID) }
                setMoney()
            } else {
                drinksExList.visibility=View.GONE
                setMoney()
            }
        } else {
            drinksExList.visibility=View.GONE
            setMoney()
        }
    }

    override fun clickListener() {
        Click.viewClick(dialogOver).subscribe { dismiss() }
        Click.viewClick(delDrinks).subscribe {
            ShowDialog.showCustomDialogs(activity, "是否清空已选酒水信息", "清空", "取消", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            dialog.dismiss()
                            deleteALLDrinks()
                            dismiss()
                            drinks.ChildDrinksClick()
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            })
        }
        Click.viewClick(dialogDrinksGo).subscribe {
            if ("1".equals(user.getType())) {
                dismiss()
                drinks.DrinksDialogOver()
            } else {
                if (DrinkUtils.getDrinksData()!=null&&DrinkUtils.getDrinksData().size>0) {
                    val addDrinks = AddDrinksDialog()
                    addDrinks.show(activity!!.supportFragmentManager, "")
                }else{
                    Toast.Tips("请添加酒水")
                }
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
                DrinksMoney()
            }
        } else {
            DrinksMoney()
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
//        var money = 0.0
//        var num=0
//        var drinks = getDrinksData()
//        drinks.forEachIndexed { index, drinkDB ->
//            var m = drinkDB.drinkMoney.toDouble() * drinkDB.drinkNum.toInt()
//            money = money + m
//            num=num+drinkDB.drinkNum.toInt()
//        }
//        moneysss.setText("¥:${money}")
//        drinksnum.setText("${num}")
    }

    interface Drinks {
        fun ChildDrinksClick()
        fun DrinksDialogOver()
    }

    override fun onDestroy() {
        super.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(activity!!)//清除图片所有缓存
    }
}