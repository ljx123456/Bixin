package com.example.shadow.heartrecreation.ui.order.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.ui.main.dialog.CouponsDialog
import com.example.shadow.heartrecreation.ui.order.mvp.bean.OrderDetailsBean
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.view.NestedExpandaleListView
import com.google.android.exoplayer2.C
import java.math.BigDecimal

class AddDrinkAdapter(appendWines: MutableList<OrderDetailsBean.DataBean.OrderWineBean.AppendWinesBean>) : BaseQuickAdapter<OrderDetailsBean.DataBean.OrderWineBean.AppendWinesBean, BaseViewHolder>(R.layout.item_add_drink, appendWines) {
    override fun convert(helper: BaseViewHolder, item: OrderDetailsBean.DataBean.OrderWineBean.AppendWinesBean) {
        helper.setText(R.id.addDrinkTitle, "追加酒水${helper.position + 1}")
//                .setText(R.id.addDrinkTime,item.gift)

        var addDrinkPresentList = helper.getView(R.id.addDrinkPresentList) as RecyclerView
        if (item.gift != null) {
            helper.setVisible(R.id.addDrinkPresentList, true)
            helper.setVisible(R.id.AddPresentLayout, true)
//            helper.setText(R.id.addDrinkTime, item.createTime)
            var addDrinkPresentAdapter = AddDrinkPresentAdapter(item.gift.wines)
            val manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            addDrinkPresentList.layoutManager = manager
            addDrinkPresentList.adapter = addDrinkPresentAdapter
        } else {
            helper.setVisible(R.id.addDrinkPresentList, false)
            helper.setVisible(R.id.AddPresentLayout, false)
        }


        var addDrinkList = helper.getView(R.id.addDrinkList) as NestedExpandaleListView
        setDrinkData(item.wines, addDrinkList, mContext, helper)

        var addDrink=helper.getView<RelativeLayout>(R.id.addDrinkMiss)
        var text=helper.getView<TextView>(R.id.addDrinkMissText)
        var addDrinkListMoney=helper.getView<LinearLayout>(R.id.addDrinkListMoneyLayout)
        var addDrinkMiss=helper.getView<LinearLayout>(R.id.addDrinkMoneyLayout)
        addDrinkMiss.visibility=View.GONE
        var flag=true
        Click.viewClick(addDrink).subscribe {
            if (flag){
                flag=false
                addDrinkList.visibility= View.GONE
                addDrinkListMoney.visibility=View.GONE
                addDrinkMiss.visibility=View.VISIBLE
                var drawable=mContext.resources.getDrawable(R.mipmap.double_more_button_down)
                drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                text.setCompoundDrawables(drawable,null,null,null)
                text.text="展开"
            }else{
                flag=true
                addDrinkList.visibility= View.VISIBLE
                addDrinkListMoney.visibility=View.VISIBLE
                addDrinkMiss.visibility=View.GONE
                var drawable=mContext.resources.getDrawable(R.mipmap.double_more_button_top)
                drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
                text.setCompoundDrawables(drawable,null,null,null)
                text.text="折叠"
            }
        }
    }


    //设置酒水
    private fun setDrinkData(wines: MutableList<OrderDetailsBean.DataBean.OrderWineBean.AppendWinesBean.WinesBeanXXX>, addDrinkList: NestedExpandaleListView, mContext: Context, helper: BaseViewHolder) {
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
                map[wine.wineTypeName] = drinkDBS
            } else {
                var drinkDBS = map[wine.wineTypeName] as ArrayList
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
        addDrinkList.setGroupIndicator(null)
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
        var adapters = DrinkExpanAdapter(list, mContext)
        addDrinkList.setAdapter(adapters)
//        orderFourMoney.text =
        helper.setText(R.id.addDrinkMoney, money.setScale(2,BigDecimal.ROUND_HALF_UP).toString())
                .setText(R.id.addDrinkMoneyMiss,money.setScale(2,BigDecimal.ROUND_HALF_UP).toString())
        for (i in list.indices) {
            addDrinkList.expandGroup(i)
        }
        addDrinkList.setOnGroupClickListener { parent, v, groupPosition, id ->
            return@setOnGroupClickListener true
        }
    }
}