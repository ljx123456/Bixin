package com.example.shadow.heartrecreation.ui.main.activity

import android.content.Context
import android.content.DialogInterface
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.user.getCity
import com.example.shadow.heartrecreation.db.user.getCityID
import com.example.shadow.heartrecreation.db.user.setCity
import com.example.shadow.heartrecreation.db.user.setCityID
import com.example.shadow.heartrecreation.ui.main.adapter.AllCityAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.SetCityAdapter
import com.example.shadow.heartrecreation.ui.main.location.LocationUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.SetCityPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.SetCityView
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.permissions.UserPermissions
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.example.shadow.heartrecreation.view.SpaceItemDecoration
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_set_city.*
import kotlinx.android.synthetic.main.layout_title.*

class SetCityActivity : BaseActivity(), SetCityView, UserPermissions.MemoryReadPermissionsFace ,LocationUtils.Location,AllCityAdapter.ClickBack{
    override fun click(cityId: Int, cityName: String) {
        if (cityName.contains(getCity())){
            finish()
        }else {
            ShowDialog.showCustomDialogs(this,"确定切换到 ${cityName},切换城市会清空约会卡的数据","切换","取消",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            setCity(cityName)
                            setCityID("${cityId}")
                            cityNow.text = "${getCity()}"
//                                    cityAdapter
                            dialog.dismiss()
                            DrinkUtils.deleteALLDrinks()//删除所有酒水
                            ServeUtils.deleteALLServe()//删除所有服务员
                            user.setNum("0")
                            user.setBrokerType("0")
                            user.setBrokerType("0")
                            user.setRoomType("0")
                            user.setType("1")
                            DbUtils.delMerchat()
                            OrderServeUtils.deleteAllOrder()
                            finish()

                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            })

        }
    }

    override fun requestPermissionsFaceError() {

    }

    override fun getLocationSuccess(city:String) {
        setCity(city)
        cityNow.text = "${getCity()}"
    }

    override fun requestPermissionsFaceSucceed(context: Context, what: Int) {
        //获取定位
        if (getCity()!=""&& getCityID()!=""){

        }else {
            LocationUtils(this).getLocation()
        }
    }

    private val presenter by lazy { SetCityPresenter(this, this, this) }

    override fun getCityListRequest(data: CityListBean) {
//        var info = ArrayList<CityListBean.DataBean>()
//        for (i in data.data.indices) {
//            var infoModel = CityListBean.DataBean()
//            infoModel.cityName = data.data.get(i).cityName
//            infoModel.cityId = data.data.get(i).cityId
//            if (data.data.get(i).cityName.contains(getCity())) {
//                infoModel.isChick = true
//            } else {
//                infoModel.isChick = false
//            }
//            info.add(infoModel)
//        }
//        if (Gson().toJson(data).contains(getCity())) {
//
//        } else {
//            cityNow.text = "暂未开放您当前位置"
//        }

        if (data.data!=null&&data.data.citys!=null&&data.data.citys.size>0){
            hotCityList.visibility=View.VISIBLE
            data.data.citys.forEach {
                if (it.cityName.contains(getCity())){
                    it.isFlag=true
                }else{
                    it.isFlag=false
                }
            }
            var cityAdapter = SetCityAdapter(data.data.citys)
            var manager = GridLayoutManager(this,3)
//            var itemDecoration = SpaceItemDecoration()
//            itemDecoration.setItemSize(4)
//            hotCityList.addItemDecoration(itemDecoration)
            hotCityList.layoutManager = manager
            hotCityList.adapter = cityAdapter


            cityAdapter.setOnItemClickListener { adapter, view, position ->
                if (cityAdapter.data[position].cityName.contains(getCity())){
                    finish()
                }else {
                    ShowDialog.showCustomDialogs(this,"确定切换到 ${cityAdapter.data[position].cityName},切换城市会清空约会卡的数据","切换","取消",object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    setCity(cityAdapter.data[position].cityName)
                                    setCityID("${cityAdapter.data[position].cityId}")
                                    cityNow.text = "${getCity()}"
//                                    cityAdapter
                                    dialog.dismiss()
                                    DrinkUtils.deleteALLDrinks()//删除所有酒水
                                    ServeUtils.deleteALLServe()//删除所有服务员
                                    user.setNum("0")
                                    user.setBrokerType("0")
                                    user.setBrokerType("0")
                                    user.setRoomType("0")
                                    user.setType("1")
                                    DbUtils.delMerchat()
                                    OrderServeUtils.deleteAllOrder()
                                    finish()

                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog.dismiss()
                                }
                            }
                        }
                    })

                }
            }
        }else{
            hotCityList.visibility=View.GONE
        }

        if (data.data.allCity!=null&&data.data.allCity.size>0){
            cityList.visibility=View.VISIBLE
            var cityAdapter=AllCityAdapter(data.data.allCity)
            var manager=LinearLayoutManager(this)
            manager.orientation=LinearLayout.VERTICAL
            cityList.layoutManager=manager
            cityList.adapter=cityAdapter
            cityAdapter.setCallBack(this)
        }


//        var city=ArrayList<String>()
//        var i=0
//        if (data.data!=null&&data.data.size>0){
//            hotCity.visibility=View.VISIBLE
//            data.data.forEachIndexed { index, dataBean ->
//                city.add(dataBean.cityName)
//                if (dataBean.cityName.contains(getCity())){
//                    i=index
//                }
//            }
//            myCityChoose.setList(city)
//            myCityChoose.setIndexItemSelected(i)
//            myCityChoose.setOnItemClickListener { position, text ->
//                if (text.contains(getCity())){
//                    finish()
//                }else{
//                    ShowDialog.showCustomDialogs(this,"确定切换到 ${text},切换城市会清空约会卡的数据","切换","取消",object :DialogInterface.OnClickListener{
//                        override fun onClick(dialog: DialogInterface, which: Int) {
//                            when (which) {
//                                DialogInterface.BUTTON_POSITIVE -> {
//                                    setCity(text)
//                                    var id=0
//                                    data.data.forEach {
//                                        if (it.cityName==text){
//                                            id=it.cityId
//                                        }
//                                    }
//                                    setCityID("${id}")
//                                    cityNow.text = "${getCity()}"
//                                    dialog.dismiss()
//                                    DrinkUtils.deleteALLDrinks()//删除所有酒水
//                                    ServeUtils.deleteALLServe()//删除所有服务员
//                                    user.setNum("0")
//                                    user.setBrokerType("0")
//                                    user.setBrokerType("0")
//                                    user.setRoomType("0")
//                                    user.setType("1")
//                                    DbUtils.delMerchat()
//                                    OrderServeUtils.deleteAllOrder()
//                                    finish()
//
//                                }
//                                DialogInterface.BUTTON_NEGATIVE -> {
//                                    dialog.dismiss()
//                                }
//                            }
//                        }
//                    })
//                }
//            }
//        }else{
//            hotCity.visibility=View.GONE
//        }

//        cityAdapter.setOnItemChildClickListener { adapter, view, position ->
//            cityAdapter.data.forEachIndexed { index, dataBean ->
//                if (index == position) {
//                    dataBean.isChick = true
//                    if (dataBean.cityName.contains(getCity())){
//
//                    }else {
//                        setCity(dataBean.cityName)
//                        setCityID("${dataBean.cityId}")
//                        cityNow.text = "当前选择位置:${getCity()}"
//                    }
//                } else {
//                    dataBean.isChick = false
//                }
//            }
//            cityAdapter.notifyDataSetChanged()

//        }
    }

    override fun getCityListError() {

    }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_set_city

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
        titleText.text = "城市选择"
        cityNow.text = "${getCity()}"
    }

    override fun initActivityData() {
        UserPermissions.userLocation(mContext, this)
        presenter.getCityList()
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }
}