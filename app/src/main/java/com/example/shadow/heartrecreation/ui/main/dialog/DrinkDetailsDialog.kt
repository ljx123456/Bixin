package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.DrinkUtils.setDrinks
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.ui.main.adapter.DrinkDetailsAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinkDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinksBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.DrinkDetailsBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.DrinkDetailsPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.DrinkDetailsView
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.dialog_drinks_details.*


@SuppressLint("ValidFragment")
class DrinkDetailsDialog(val drinkdetails: DrinkDetails) : BaseDialogFragment(), DrinkDetailsView {
    override fun getDrinkDetailsRequest(data: DrinkDetailsBean) {
        var drinkAdapter = DrinkDetailsAdapter(data.data.wineDetailsInfo)
        var manager = LinearLayoutManager(activity)
        drinksDetailsList.layoutManager = manager
        drinksDetailsList.adapter = drinkAdapter
    }

    private val presenter by lazy { DrinkDetailsPresenter(this, this, activity!!) }
    override fun setLayoutID(): Int = R.layout.dialog_drinks_details
    private var dataMonel = DrinksBean.DataBean.WineTypesBean.WinesBean()
    private var wineType = DrinksBean.DataBean.WineTypesBean()
    override fun isFullScreen(): Boolean = false
    private var num = 0
    fun setData(get: DrinksBean.DataBean.WineTypesBean.WinesBean, wineTypes: DrinksBean.DataBean.WineTypesBean) {
        this.dataMonel = get
        this.wineType = wineTypes
    }

    override fun setLayoutData() {
        drinksDetailsName.text = dataMonel.businessWineName
        drinksDetailsMoney.text = "¥:${dataMonel.businessWinePrice}"
        drinksDetailsNum.text = "${dataMonel.drinksNum}"
        num = dataMonel.drinksNum
        drinksDetailsList
        if (wineType.isDetails==1) {
            detailsListLayout.visibility= View.VISIBLE
            detailsNoListLayout.visibility=View.GONE
            presenter.getDrinkDetails(DrinkDetailsBody(dataMonel.businessWineId))
        }else{
            detailsListLayout.visibility= View.GONE
            detailsNoListLayout.visibility=View.VISIBLE
            var util=""
            if (dataMonel.businessWineSpecifications!=null)
                util=dataMonel.businessWineSpecifications
            tv_drinkDetails.text="产品规格："+util
            tv_drinkDetails_num.text="产品数量：1/"+dataMonel.businessWineUnit
//            var list=ArrayList<DrinkDetailsBean.DataBean.WineDetailsInfoBean>()
////            var util=""
////            if (dataMonel.businessWineSpecifications!=null)
////                util=dataMonel.businessWineSpecifications
//            list.add(DrinkDetailsBean.DataBean.WineDetailsInfoBean("1",dataMonel.businessWineName,dataMonel.businessWineUnit,dataMonel.businessWineSpecifications))
//            var drinkAdapter = DrinkDetailsAdapter(list)
//            var manager = LinearLayoutManager(activity)
//            drinksDetailsList.layoutManager = manager
//            drinksDetailsList.adapter = drinkAdapter
        }
//        LogUtils.a("当前酒水" + Gson().toJson(dataMonel))
    }

    override fun clickListener() {
        Click.viewClick(drinksDetailsOver).subscribe { dismiss() }
//        Click.viewClick(drinksDetailsSub).subscribe {
//
//        }
        drinksDetailsSub.setOnClickListener {
            if (num == 0) {
                num = 0
            } else {
                num = num - 1
            }
            drinksDetailsNum.text = "${num}"
        }

        drinksDetailsAdd.setOnClickListener {
            num = num + 1
            drinksDetailsNum.text = "${num}"
        }
//        Click.viewClick(drinksDetailsAdd).subscribe {
//
//        }
        Click.viewClick(drinksDetailsOk).subscribe {
            setDrinksDB(dataMonel, "${num}")
        }
    }

    private fun setDrinksDB(item: DrinksBean.DataBean.WineTypesBean.WinesBean, s: String) {

        var drink = DrinkDB()
        drink.mealName = wineType.wineTypeName
        drink.mealId = "${wineType.wineTypeId}"
        drink.drinkNum = s
        drink.drinkID = "${item.businessWineId}"
        drink.drinkMoney = "${item.businessWinePrice}"
        drink.drinkName = item.businessWineName
        drink.drinkText = item.businessWineDetails
        drink.drinkImage = item.businessWineImg
        setDrinks(drink)
        dismiss()
        drinkdetails.setNewMoney()
    }

    interface DrinkDetails {
        fun setNewMoney()
    }


}