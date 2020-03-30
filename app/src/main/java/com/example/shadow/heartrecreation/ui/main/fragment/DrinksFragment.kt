package com.example.shadow.heartrecreation.ui.main.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.db.DrinkUtils.getDrinksData
import com.example.shadow.heartrecreation.db.DrinkUtils.setDrinks
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.ui.main.adapter.DrinksAdapter
import com.example.shadow.heartrecreation.ui.main.dialog.DrinkDetailsDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinksBean
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_drinks.*

@SuppressLint("ValidFragment")
class DrinksFragment(val data: MutableList<DrinksBean.DataBean.WineTypesBean.WinesBean>, val drinks: Drinks) : BaseFragment(), DrinkDetailsDialog.DrinkDetails {
    override fun setNewMoney() {
//        drinksAdapter.notifyDataSetChanged()
        init()
    }

    override fun openEventBus(): Boolean = false
    private lateinit var info: DrinksBean.DataBean

    private lateinit var drinksAdapter:DrinksAdapter
    private var isCreate=false

    fun setData(get: DrinksBean.DataBean) {
        this.info = get
    }

    override fun setLayoutTitle() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCreate=true
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (!isCreate){
            return
        }

        if (isVisibleToUser){
            init()
        }
    }

    override fun initFragmentData() {
        var adapterData = ArrayList<DrinksBean.DataBean.WineTypesBean.WinesBean>()
        for (i in data.indices) {
            var info = DrinksBean.DataBean.WineTypesBean.WinesBean()
            info.businessWinePrice = data.get(i).businessWinePrice
            info.businessWineDetails = data.get(i).businessWineDetails
            info.businessWineName = data.get(i).businessWineName
            info.businessWineId = data.get(i).businessWineId
            info.businessWineImg = data.get(i).businessWineImg
            info.businessWineUnit = data.get(i).businessWineUnit
            info.state = data.get(i).state
            info.businessWineSpecifications=data.get(i).businessWineSpecifications
            var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
            if (merchat != null) {
                var datadb = merchat.loadAll()
                if (datadb != null && datadb.size >= 1) {
                    for (drinks in datadb) {
                        if (info.businessWineName.equals(drinks.drinkName)) {
                            info.drinksNum = drinks.drinkNum.toInt()
                        }
                    }
                } else info.drinksNum = 0
            } else info.drinksNum = 0
            adapterData.add(info)
        }
        drinksAdapter = DrinksAdapter(adapterData, info)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        drinksList.layoutManager = manager
        drinksList.adapter = drinksAdapter
        drinksAdapter.setOnItemChildClickListener { adapter, view, position ->
            var item = drinksAdapter.data.get(position)
            when (view.id) {
                R.id.drinksSub -> {
                    when (item.drinksNum) {
                        0 -> drinksAdapter.data.get(position).drinksNum = item.drinksNum
                        else -> {
                            drinksAdapter.data.get(position).drinksNum = item.drinksNum - 1
                            drinksAdapter.notifyDataSetChanged()
                            setDrinksDB(item, "${drinksAdapter.data.get(position).drinksNum}")
                        }
                    }
                }
                R.id.drinksAdd -> {
                    var nuwnum = drinksAdapter.data.get(position).drinksNum
                    drinksAdapter.data.get(position).drinksNum = nuwnum + 1
                    drinksAdapter.notifyDataSetChanged()
                    setDrinksDB(item, "${drinksAdapter.data.get(position).drinksNum}")
                }
            }
        }
        drinksAdapter.setOnItemClickListener { adapter, view, position ->
            var drinkDialog = DrinkDetailsDialog(this)
            drinkDialog.setData(drinksAdapter.data.get(position), info.wineTypes)
            drinkDialog.show(activity!!.supportFragmentManager, "")

        }
    }

    private fun setDrinksDB(item: DrinksBean.DataBean.WineTypesBean.WinesBean, s: String) {

        var drink = DrinkDB()
        drink.mealName = info.wineTypes.wineTypeName
        drink.mealId = "${info.wineTypes.wineTypeId}"
        drink.drinkNum = s
        drink.drinkID = "${item.businessWineId}"
        drink.drinkMoney = "${item.businessWinePrice}"
        drink.drinkName = item.businessWineName
        drink.drinkText = item.businessWineDetails
        drink.drinkImage = item.businessWineImg
        setDrinks(drink)
        drinks.setNewMoney()
    }

    override fun setFragmentListener() {
    }

    override fun layoutID(): Int = R.layout.fragment_drinks

    interface Drinks {
        fun setNewMoney()
    }

    public fun init(){
        var adapterData = ArrayList<DrinksBean.DataBean.WineTypesBean.WinesBean>()
        for (i in data.indices) {
            var info = DrinksBean.DataBean.WineTypesBean.WinesBean()
            info.businessWinePrice = data.get(i).businessWinePrice
            info.businessWineDetails = data.get(i).businessWineDetails
            info.businessWineName = data.get(i).businessWineName
            info.businessWineId = data.get(i).businessWineId
            info.businessWineImg = data.get(i).businessWineImg
            info.businessWineUnit = data.get(i).businessWineUnit
            info.businessWineSpecifications=data.get(i).businessWineSpecifications
            info.state = data.get(i).state
            var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
            if (merchat != null) {
                var datadb = merchat.loadAll()
                if (datadb != null && datadb.size >= 1) {
                    for (drinks in datadb) {
                        if (info.businessWineName.equals(drinks.drinkName)) {
                            info.drinksNum = drinks.drinkNum.toInt()
                        }
                    }
                } else info.drinksNum = 0
            } else info.drinksNum = 0
            adapterData.add(info)
        }
        drinksAdapter!!.setNewData(adapterData)
        drinks.setNewMoney()
    }

    override fun onDestroy() {
        super.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
    }
}