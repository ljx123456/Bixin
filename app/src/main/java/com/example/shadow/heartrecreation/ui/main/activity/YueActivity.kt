package com.example.shadow.heartrecreation.ui.main.activity

import android.content.Context
import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.LogUtils
import com.bumptech.glide.Glide
import com.example.shadow.heartrecreation.R
//import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.DbUtils.delMerchat
import com.example.shadow.heartrecreation.db.DbUtils.getMerchat
import com.example.shadow.heartrecreation.db.DrinkUtils.deleteALLDrinks
import com.example.shadow.heartrecreation.db.DrinkUtils.getDrinksData
import com.example.shadow.heartrecreation.db.ServeUtils.deleteALLServe
import com.example.shadow.heartrecreation.db.ServeUtils.deleteServe
import com.example.shadow.heartrecreation.db.ServeUtils.getServeData
import com.example.shadow.heartrecreation.db.db.DrinkDB
import com.example.shadow.heartrecreation.db.user.getCity
import com.example.shadow.heartrecreation.db.user.getNum
import com.example.shadow.heartrecreation.db.user.setNum
import com.example.shadow.heartrecreation.ui.UIUtils
import com.example.shadow.heartrecreation.ui.main.adapter.ExpListBean
import com.example.shadow.heartrecreation.ui.main.adapter.YueDrinkAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.YueServeAdapter
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.dialog.CouponsDialog
import com.example.shadow.heartrecreation.ui.main.dialog.NumDialog
import com.example.shadow.heartrecreation.ui.main.dialog.YueTimeDialog
import com.example.shadow.heartrecreation.ui.main.location.LocationUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderShowTimeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.OrderShowTimeBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateCityBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.OrderShowTimePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.SetCityPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.UpdateCityPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.OrderShowTimeView
import com.example.shadow.heartrecreation.ui.main.mvp.view.SetCityView
import com.example.shadow.heartrecreation.ui.main.mvp.view.UpdateCityView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentDrinks
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMerchant
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMerchantDetails
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentServeList
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentSetCity
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.permissions.UserPermissions
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_yue.*
import kotlinx.android.synthetic.main.layout_add_drinks.*
import kotlinx.android.synthetic.main.layout_title.*
import kotlinx.android.synthetic.main.layout_yue_adds.*
import kotlinx.android.synthetic.main.layout_yue_broker.*
import kotlinx.android.synthetic.main.layout_yue_people.*
import kotlinx.android.synthetic.main.layout_yue_wine.*
import java.math.BigDecimal

class YueActivity : BaseActivity(), NumDialog.PeoPleNum, YueDrinkAdapter.Expandable, OrderShowTimeView, YueTimeDialog.YueTime ,CouponsDialog.DialogFinish, UserPermissions.MemoryReadPermissionsFace,LocationUtils.Location, SetCityView,UpdateCityView {
    override fun getUpdateCityRequest() {//更新用户城市成功

    }

    override fun getUpdateCityError() {

    }

    override fun getCityListError() {

    }

    override fun getCityListRequest(data: CityListBean) {
        var cityListBean=data
//        if (cityListBean!=null&&cityListBean.data.citys!=null&&cityListBean.data.citys.size>0) {
//            if (!"".equals(city)) {
//                for (i in cityListBean.data.citys.indices) {
//                    if (cityListBean.data.citys.get(i).cityName.contains(city)) {
//                        if (getCity()!="") {
//                            if (city == getCity()) {
//                                user.setCity(city)
//                                user.setCityID("${cityListBean.data.citys.get(i).cityId}")
//                            } else {
//                                ShowDialog.showCustomDialogs(this,"定位到您在 ${city}\n切换城市会清空约会卡\n是否切换至该城市进行探索","切换","取消",object :DialogInterface.OnClickListener{
//                                    override fun onClick(dialog: DialogInterface, which: Int) {
//                                        when (which) {
//                                            DialogInterface.BUTTON_POSITIVE -> {
//                                                user.setCity(city)
//                                                user.setCityID("${cityListBean.data.citys.get(i).cityId}")
//                                                dialog.dismiss()
//                                                DrinkUtils.deleteALLDrinks()//删除所有酒水
//                                                ServeUtils.deleteALLServe()//删除所有服务员
//                                                user.setNum("0")
//                                                user.setBrokerType("0")
//                                                user.setBrokerType("0")
//                                                user.setRoomType("0")
//                                                user.setType("1")
//                                                DbUtils.delMerchat()
//                                                OrderServeUtils.deleteAllOrder()
//                                                titleRightText.text = getCity()
//                                                init()
//                                                peopleNums = getNum().toInt()
//                                                haveMerchant()
//                                                haveServe()
//                                                haveDrinks()
//
//                                            }
//                                            DialogInterface.BUTTON_NEGATIVE -> {
//                                                dialog.dismiss()
//                                            }
//                                        }
//                                    }
//                                })
//                            }
//                        }else{
//                            user.setCity(city)
//                            user.setCityID("${cityListBean.data.citys.get(i).cityId}")
//                        }
//                    }
//                }
//            }
//            else {
//                user.setCity(cityListBean.data.citys[0].cityName)
//                user.setCityID("${cityListBean.data.citys.get(0).cityId}")
//            }
//        }
        if (cityListBean!=null&&cityListBean.data!=null&&cityListBean.data.citys.size>0) {
            if (!"".equals(city)) {
                for (i in cityListBean.data.citys.indices) {
                    if (cityListBean.data.citys.get(i).cityName.contains(city)) {
                        if (getCity()!="") {
                            if (city == getCity()) {
                                user.setCity(city)
                                user.setCityID("${cityListBean.data.citys.get(i).cityId}")
                            } else {
                                ShowDialog.showCustomDialogs(this,"定位到您在 ${city}\n切换城市会清空约会卡\n是否切换至该城市进行探索","切换","取消",object :DialogInterface.OnClickListener{
                                    override fun onClick(dialog: DialogInterface, which: Int) {
                                        when (which) {
                                            DialogInterface.BUTTON_POSITIVE -> {
                                                user.setCity(city)
                                                user.setCityID("${cityListBean.data.citys.get(i).cityId}")
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
                                                titleRightText.text = getCity()
                                                init()
                                                peopleNums = getNum().toInt()
                                                haveMerchant()
                                                haveServe()
                                                haveDrinks()

                                            }
                                            DialogInterface.BUTTON_NEGATIVE -> {
                                                dialog.dismiss()
                                            }
                                        }
                                    }
                                })
                            }
                        }else{
                            user.setCity("成都")
                            user.setCityID("1")
                        }
                        break
                    }else if (i==cityListBean.data.citys.lastIndex){
                        if (cityListBean.data.allCity!=null&&cityListBean.data.allCity.size>0){
                            for (t in cityListBean.data.allCity.indices) {
                                for (y in cityListBean.data.allCity[t].citys.indices) {
                                    if (cityListBean.data.allCity[t].citys.get(y).cityName.contains(city)) {
                                        if (getCity() != "") {
                                            if (city == getCity()) {
                                                user.setCity(city)
                                                user.setCityID("${cityListBean.data.allCity[t].citys.get(y).cityId}")
                                            } else {
                                                ShowDialog.showCustomDialogs(this, "定位到您在 ${city}\n切换城市会清空约会卡\n是否切换至该城市进行探索", "切换", "取消", object : DialogInterface.OnClickListener {
                                                    override fun onClick(dialog: DialogInterface, which: Int) {
                                                        when (which) {
                                                            DialogInterface.BUTTON_POSITIVE -> {
                                                                user.setCity(city)
                                                                user.setCityID("${cityListBean.data.citys.get(i).cityId}")
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
                                                                titleRightText.text = getCity()
                                                                init()
                                                                peopleNums = getNum().toInt()
                                                                haveMerchant()
                                                                haveServe()
                                                                haveDrinks()

                                                            }
                                                            DialogInterface.BUTTON_NEGATIVE -> {
                                                                dialog.dismiss()
                                                            }
                                                        }
                                                    }
                                                })
                                            }
                                        } else {
                                            user.setCity("成都")
                                            user.setCityID("1")
                                        }
                                        break
                                    }
                                }
                            }
                        }else{
                            user.setCity("成都")
                            user.setCityID("1")
                        }
                    }
                }
            }
            else {
                user.setCity(cityListBean.data.citys[0].cityName)
                user.setCityID("${cityListBean.data.citys.get(0).cityId}")
            }
        }
        if (!"".equals(getCity())) titleRightText.text = getCity()
        else titleRightText.text = "成都"

    }

    override fun requestPermissionsFaceSucceed(context: Context, what: Int) {
        LocationUtils(this).getLocation()
    }

    override fun requestPermissionsFaceError() {
        Toast.Tips("请打开APP所需定位权限→设置→应用→权限管理")
        citypresenter.getCityList()
    }

    override fun getLocationSuccess(city:String) {
        this.city=city
        citypresenter.getCityList()
        updateCityPresenter.getUpdateCity(UpdateCityBody(user.getlng(),user.getlat()))
    }

    override fun dialogFinish() {
        haveDrinks()
    }
    //预约时间选择返回
    override fun setYueTime(time: String,times: String) {
        yueTime = time
        this.times=times
        YueAddsTime.setText(times)
    }

    //获取预约时间成功
    override fun getOrderShowTimeRequest(data: OrderShowTimeBean) {
        val yuetimedialog = YueTimeDialog(this)
        yuetimedialog.show(supportFragmentManager, "")
        yuetimedialog.setData(data.data.orderTime)
    }

    //获取预约时间失败
    override fun getOrderShowTimeError() {

    }

    override fun ChildClick() {
        haveDrinks()
    }

    //选择人数
    override fun setPeoPleNum(get: String) {
        if (peopleNums == 0)
            intentServeList(id,merchantID)
        var serveData = getServeData()
        if (serveData!=null&&serveData.size>0&& serveData.get(0).image != null&&serveData.size>get.toInt()*2){
            Toast.Tips("设置的约玩人数低于已选约玩对象人数，请删除部分约玩对象后重试")
        }else {
            peopleNums = (get.toInt() * 2)
            setNum(peopleNums.toString())
            haveServe()
        }

    }

//    private val numDialog = NumDialog(this)
    private val couponsDialog = CouponsDialog(this)
    private var name = ""
    private var id = 1
    private var peopleNums = getNum().toInt()
    private var merchantID = ""
    private var yueTime = ""
    private var times=""
    private var type = 0
    private var brokerID = ""
    private var brokerImages = ""
    private var brokerNames = ""
    private var brokerAges = ""
    private var brokerSexs = ""
    private var brokerJobs = ""
    private var businessName = ""
    private var baofangMoney = ""
    private var money = BigDecimal("0.00")
    private var roomType="0"
    private var city=""
    private val citypresenter by lazy { SetCityPresenter(this, this, this) }
    private val updateCityPresenter by lazy { UpdateCityPresenter(this,this,this) }
    private var isDrinkMiss=true
    private var isServeMiss=true

    override fun openEventBus(): Boolean = false

    private val presenter by lazy { OrderShowTimePresenter(this, this, this) }

    override fun getActivityLayout(): Int = R.layout.activity_yue

    override fun setActivityTitle() {
        titleText.setText("约唱歌")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRight.visibility = View.GONE
        titleRightText.text="成都"

        Click.viewClick(titleRightText).subscribe { intentSetCity() }
    }

    override fun initActivityData() {
        yueServeList.setNestedScrollingEnabled(false)

        name = user.getYueName()
        id = user.getYueID().toInt()
        type = intent.getIntExtra("type", 0)
        titleText.setText(name)
        if (type != 1) {
            yuejinjiren.visibility = View.GONE
            jinjiren.visibility = View.GONE
            tvNameImg.visibility=View.VISIBLE
            titleRightText.visibility = View.VISIBLE
            UserPermissions.userLocation(mContext, this)
        } else {
            if (intent.getStringExtra("brokerID")!=null&&intent.getStringExtra("brokerID")!="") {
                yuejinjiren.visibility = View.GONE
                jinjiren.visibility = View.VISIBLE
                brokerID = intent.getStringExtra("brokerID")
                brokerImages = intent.getStringExtra("brokerImage")
                brokerNames = intent.getStringExtra("brokerName")
                brokerAges = intent.getStringExtra("brokerAge")
                brokerSexs = intent.getStringExtra("brokerSex")
                brokerJobs = intent.getStringExtra("brokerJob")
                businessName = intent.getStringExtra("businessName")
                merchantID = intent.getStringExtra("businessId")
                ImageLoad.setUserHead(brokerImages, brokerImage)
                brokerName.text = brokerNames
                brokerAge.text = brokerAges
                if (brokerJobs != "") {
                    brokerJob.visibility = View.VISIBLE
                    brokerJob.text = brokerJobs
                } else {
                    brokerJob.visibility = View.GONE
                }

                UIUtils.setAgeUtils(brokerAge, brokerSexs.toInt(), brokerAges)
//            Click.viewClick(brokerGenghuan).subscribe {
//                finish()
//            }
                Click.viewClick(brokerOver).subscribe {
                    ShowDialog.showCustomDialogs(mContext, "是否清除约玩经纪人信息", "清除", "取消", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    yuejinjiren.visibility = View.GONE
                                    jinjiren.visibility = View.GONE
                                    deleteALLServe()//删除所有服务人员
                                    deleteALLDrinks()//删除所有酒水
                                    setNum("0")
                                    peopleNums = 0
                                    type = 0
//                                var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//                                merchat.deleteAll()
//                                var merchatDrinkDB = GreenDaoHelper.getDaoSessions().drinkDBDao
//                                merchatDrinkDB.deleteAll()
                                    haveServe()
                                    haveMerchant()
                                    haveDrinks()
                                    dialog.dismiss()
                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog.dismiss()
                                }
                            }
                        }
                    })
                }
            }else{
                yuejinjiren.visibility = View.GONE
                jinjiren.visibility = View.GONE
            }
            titleRightText.visibility = View.GONE
            YueAddsName.setText(businessName)
            YueAddsName.isEnabled = false
            tvNameImg.visibility=View.GONE
            yueAdds.visibility = View.GONE
            yueAddss.visibility = View.VISIBLE
        }

        if (isDrinkMiss){
            yueDrinkss.visibility=View.GONE
            wineMiss.text="展开"
        }else{
            yueDrinkss.visibility=View.VISIBLE
            wineMiss.text="折叠"
        }

        if (isServeMiss){
            yueServeList.visibility=View.GONE
            yueServeMiss.text="展开"
        }else{
            yueServeList.visibility=View.VISIBLE
            yueServeMiss.text="折叠"
        }
    }

    fun init(){
        roomType=user.getRoomType()
//        Log.e("测试type",type.toString())
        if (roomType.equals("0")){
            layout_yue_room_num.visibility=View.GONE
            layout_yue_room_time.visibility=View.VISIBLE
            yueAddMiniMoney.visibility=View.VISIBLE
            titleRightText.visibility=View.VISIBLE
            addsBaofang.isEnabled=true
            YueAddsName.isEnabled = true
            tvNameImg.visibility=View.VISIBLE
        }else if (roomType.equals("1")){
            layout_yue_room_num.visibility=View.VISIBLE
            layout_yue_room_time.visibility=View.GONE
            yueAddMiniMoney.visibility=View.GONE
            addsBaofang.isEnabled=false
            layout_yue_room_num.isEnabled=false
            YueAddsName.isEnabled = false
            titleRightText.visibility=View.GONE
            tvNameImg.visibility=View.GONE
        }

        if (type != 1) {
            yuejinjiren.visibility = View.GONE
            jinjiren.visibility = View.GONE
//            titleRightText.visibility = View.VISIBLE
        } else {

//            brokerID = intent.getStringExtra("brokerID")
//            brokerImages = intent.getStringExtra("brokerImage")
//            brokerNames = intent.getStringExtra("brokerName")
//            brokerAges = intent.getStringExtra("brokerAge")
//            brokerSexs = intent.getStringExtra("brokerSex")
//            brokerJobs = intent.getStringExtra("brokerJob")
//            businessName = intent.getStringExtra("businessName")
//            merchantID = intent.getStringExtra("businessId")
            if (brokerID!="") {
                yuejinjiren.visibility = View.GONE
                jinjiren.visibility = View.VISIBLE
                ImageLoad.setUserHead(brokerImages, brokerImage)
                brokerName.text = brokerNames
                brokerAge.text = brokerAges
                if (brokerJobs != "") {
                    brokerJob.visibility = View.VISIBLE
                    brokerJob.text = brokerJobs
                } else {
                    brokerJob.visibility = View.GONE
                }
                UIUtils.setAgeUtils(brokerAge, brokerSexs.toInt(), brokerAges)
                Click.viewClick(brokerOver).subscribe {
                    ShowDialog.showCustomDialogs(mContext, "是否清除约玩经纪人信息", "清除", "取消", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    yuejinjiren.visibility = View.GONE
                                    jinjiren.visibility = View.GONE
//                                deleteALLServe()//删除所有服务人员
//                                deleteALLDrinks()//删除所有酒水
//                                setNum("0")
//                                peopleNums = 0
                                    user.setBrokerType("0")
                                    type=0
                                    brokerID=""
//                                var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//                                merchat.deleteAll()
//                                var merchatDrinkDB = GreenDaoHelper.getDaoSessions().drinkDBDao
//                                merchatDrinkDB.deleteAll()
                                    haveServe()
                                    haveMerchant()
                                    haveDrinks()
                                    dialog.dismiss()
                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog.dismiss()
                                }
                            }
                        }
                    })
                }
            }else{
                yuejinjiren.visibility = View.GONE
                jinjiren.visibility = View.GONE
            }
            titleRightText.visibility = View.GONE
            YueAddsName.setText(businessName)
            YueAddsName.isEnabled = false
            tvNameImg.visibility=View.GONE
//            yueAdds.visibility = View.GONE
//            yueAddss.visibility = View.VISIBLE
            //修改包房类型
            Click.viewClick(addsBaofang).subscribe {
                intentMerchantDetails(merchantID,type)
            }

//            Click.viewClick(brokerGenghuan).subscribe {
//                finish()
//            }

        }
        if (merchantID!=""){
            yueDrinks.visibility = View.VISIBLE
        }else{
            yueDrinks.visibility = View.GONE
        }

//        if (yueAdds.visibility==View.VISIBLE){
//            yueDrinks.visibility=View.GONE
//        }else{
//            yueDrinks.visibility=View.VISIBLE
//        }
        if (!"".equals(getCity())) titleRightText.text = getCity()
        else titleRightText.text = "成都"

        YueAddsTime.setText(times)
    }

    override fun clickListener() {
        mainContextGo.isEnabled = true
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(yueAdds).subscribe { intentMerchant() }//选择地址
        //清除服务人员
        Click.viewClick(yueServeDel).subscribe {
            ShowDialog.showCustomDialogs(mContext, "是否清空已选达人信息", "清空", "取消", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            deleteALLServe()//删除所有服务人员
                            peopleNums = 0
                            setNum("0")
                            haveServe()
                            dialog.dismiss()
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            })
        }
        //清除酒水
        Click.viewClick(wineDel).subscribe {
            ShowDialog.showCustomDialogs(mContext, "是否清空已选酒水信息", "清空", "取消", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            dialog.dismiss()
                            deleteALLDrinks()//删除所有酒水
                            haveDrinks()
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            })
        }

        //折叠酒水
        Click.viewClick(wineMiss).subscribe {
            if (yueDrinkss.visibility==View.GONE){
                yueDrinkss.visibility=View.VISIBLE
                wineMiss.text="折叠"
                isDrinkMiss=false
            }else{
                yueDrinkss.visibility=View.GONE
                wineMiss.text="展开"
                isDrinkMiss=true
            }
        }

        Click.viewClick(yuePeople).subscribe {
            //选择服务人员
//            if (peopleNums == 0) {
//                numDialog.show(supportFragmentManager, "")
//            } else {
//                Log.e("测试id",merchantID)
                intentServeList(id,merchantID)
//            }
//            }
        }

        //折叠服务人员
        Click.viewClick(yueServeMiss).subscribe {
            if (yueServeList.visibility==View.GONE){
                yueServeList.visibility=View.VISIBLE
                yueServeMiss.text="折叠"
                isServeMiss=false
            }else{
                yueServeList.visibility=View.GONE
                yueServeMiss.text="展开"
                isServeMiss=true
            }
        }

        Click.viewClick(yueDrinks).subscribe {
            //选酒水
            if (yueAdds.visibility == 0) Toast.Tips("请先选择约玩场地")
            else intentDrinks(merchantID)
        }
//        Click.viewClick(yuePeopleNum).subscribe {
//            if (numDialog.isAdded){
//                numDialog.dismiss()
//            }else {
//                numDialog.show(supportFragmentManager, "")
//            }
//        }
        Click.viewClick(mainContextGo).subscribe {
            var server = getServeData()//服务人员信息
            var drink= getDrinksData()//酒水信息
            if (roomType.equals("0")) {
//                if (YueAddsBaofangType.text.toString().equals("")) {
//                    Toast.Tips("请先选择包房类型")
//                }
                if (merchantID==""){
                    Toast.Tips("请先选择商家")
                }
                else if (YueAddsTime.text.toString().equals("")) {
                    Toast.Tips("请选择约玩时间")
                }
//                else if (server == null || server.size == 0 || server.get(0).image == null) {
////                Log.e("测试server",server.size.toString())
//                    Toast.Tips("请选择服务人员")
//                }
                else if (drink==null||drink.size==0||drink[0].drinkID==null){
                    Toast.Tips("请添加酒水")
                } else if (baofangMoney!=null&&!baofangMoney.equals("") && (baofangMoney.toInt() > money.toDouble())) {
                    Toast.Tips("当前费用不满足当前最低消费,请添加酒水")
                } else {
                    couponsDialog.setorderSkillType("$id", yueTime, brokerID)
                    couponsDialog.show(supportFragmentManager, "")
                }
            }else if (roomType.equals("1")){
//                if (YueAddsBaofangType.text.toString().equals("")) {
//                    Toast.Tips("请先选择包房类型")
//                }
                if (merchantID==""){
                    Toast.Tips("请先选择商家")
                }
                else if ((server == null || server.size == 0||server.get(0).serveID == null)&&(drink==null||drink.size<=0||drink[0].drinkID==null)) {
                    Toast.Tips("请添加酒水或服务人员")
                }
//                else if (YueAddsTime.text.toString().equals("")) {
//                    Toast.Tips("请选择约玩时间")
//                }

                else {
                    couponsDialog.setorderSkillType("$id", yueTime, brokerID)
                    couponsDialog.show(supportFragmentManager, "")
                }
            }
        }
        //预约时间
        Click.viewClick(YueAddsTime).subscribe {
            presenter.getOrderShowTime(OrderShowTimeBody(merchantID))
        }

        //修改包房类型
        Click.viewClick(addsBaofang).subscribe {
            intentMerchantDetails(merchantID,type)
        }
    }

    override fun onResume() {
        super.onResume()

        init()
//        peopleNums = getNum().toInt()
        haveMerchant()
        haveServe()
        haveDrinks()

    }

    //有酒水时
    private fun haveDrinks() {
        var merchat = GreenDaoHelper.getDaoSessions().drinkDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size > 0) {
                layoutYueWine.visibility = View.VISIBLE
                yueDrinks.visibility = View.GONE
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
                yueDrinkss.setGroupIndicator(null)
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
                var adapters = YueDrinkAdapter(list, mContext, this)
                yueDrinkss.setAdapter(adapters)
                for (i in list.indices) {
                    yueDrinkss.expandGroup(i)
                }
                yueDrinkss.setOnGroupClickListener { parent, v, groupPosition, id ->
                    return@setOnGroupClickListener true
                }
                Click.viewClick(addDrinkss).subscribe { intentDrinks(merchantID) }
                DrinksMoney()
                yueMoneyTips.visibility=View.VISIBLE
            } else {
                DrinksMoney()
                layoutYueWine.visibility = View.GONE
                if (ServeUtils.getServeData().size==0) {
                    yueMoneyTips.visibility = View.GONE
                }
                if (merchantID!=""){
                    yueDrinks.visibility = View.VISIBLE
                }else{
                    yueDrinks.visibility = View.GONE
                }
//                yueDrinks.visibility = View.VISIBLE
            }

        } else {
            DrinksMoney()
            layoutYueWine.visibility = View.GONE
            if (ServeUtils.getServeData().size==0) {
                yueMoneyTips.visibility = View.GONE
            }
            if (merchantID!=""){
                yueDrinks.visibility = View.VISIBLE
            }else{
                yueDrinks.visibility = View.GONE
            }
//            yueDrinks.visibility = View.VISIBLE
        }
    }

    //总价
    fun DrinksMoney() {
        money = BigDecimal("0.00")
        val drinksMoney = getDrinksData()
        if (drinksMoney != null && drinksMoney!!.size > 0 && !drinksMoney!!.get(0).mealName.isNullOrEmpty())
            drinksMoney.forEachIndexed { index, drinkDB ->
                var num = BigDecimal(drinkDB.drinkMoney).multiply(BigDecimal(drinkDB.drinkNum))
                money = money.add(num)
            }
        wineMoney.setText("¥:"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString())
        yueMoney.setText("需付款：¥:"+money.setScale(2,BigDecimal.ROUND_HALF_UP).toString())
    }

    //有数据时商家
    fun haveMerchant() {
        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
        if (merchat != null) {
            var data = merchat.loadAll()
            if (data != null && data.size >= 1) {
                yueAdds.visibility = View.GONE
                yueAddss.visibility = View.VISIBLE
                yueDrinks.visibility = View.VISIBLE

                var merchantData = getMerchat()
                if (merchantID!=""&&merchantID!=merchantData.merchantID){
                    yuejinjiren.visibility = View.GONE
                    jinjiren.visibility = View.GONE
                    yueTime=""
                    YueAddsTime.setText(yueTime)
                }
                merchantID = merchantData.merchantID
                Log.e("测试id",merchantID)
                YueAddsName.setText(merchantData.merchantName)
                YueAddsBaofangType.setText(merchantData.baofangType)
                yueRoomNum.text=merchantData.baofangName

                baofangMoney = merchantData.baofangMoney
                if (merchantData.baofangMoney!=null&&merchantData.baofangMoney!=""&&merchantData.baofangMoney.toDouble()>0) {
                    yueAddMiniMoney.setText("最低酒水消费¥${merchantData.baofangMoney}")
                }else{
                    yueAddMiniMoney.text=""
//                    yueAddMiniMoney.visibility=View.GONE
                }
                Click.viewClick(YueAddsName).subscribe { intentMerchant() }
                //修改包房类型
                Click.viewClick(addsBaofang).subscribe {
                    intentMerchantDetails(merchantID,type)
                }
            } else {
//                if (type == 1) {
//                    yueAdds.visibility = View.GONE
//                    yueAddss.visibility = View.VISIBLE
//                    yueDrinks.visibility = View.GONE
//                } else {
                    yueAdds.visibility = View.VISIBLE
                    yueAddss.visibility = View.GONE
                    yueDrinks.visibility = View.GONE
                yuejinjiren.visibility = View.GONE
                jinjiren.visibility = View.GONE
                yueTime=""
                YueAddsTime.setText(yueTime)
                merchantID=""
//                }
            }
        } else {
//            if (type == 1) {
//                yueAdds.visibility = View.GONE
//                yueAddss.visibility = View.VISIBLE
//                yueDrinks.visibility = View.GONE
//            } else {
                yueAdds.visibility = View.VISIBLE
                yueAddss.visibility = View.GONE
                yueDrinks.visibility = View.GONE
            yuejinjiren.visibility = View.GONE
            jinjiren.visibility = View.GONE
            yueTime=""
            YueAddsTime.setText(yueTime)
            merchantID=""

//            }
        }
    }

    //有服务人员
    fun haveServe() {
        var serveData = getServeData()
        if (serveData != null && serveData.size >= 1 && serveData.get(0).image != null) {
            yuePeople.visibility = View.GONE
            layoutYuePeople.visibility = View.VISIBLE
            var adapters = YueServeAdapter(0,serveData)
            var merager = LinearLayoutManager(mContext)
            merager.orientation = LinearLayout.VERTICAL
            yueServeList.layoutManager = merager
            yueServeList.adapter = adapters
//            peopleNum.setText("（已选${serveData.size}/${peopleNums}人）")
            peopleNum.setText("（已选：${serveData.size}人）")
            adapters.setOnItemChildClickListener { adapter, view, position ->
                when (view.id) {
                    R.id.yueServeDell -> {
                        deleteServe(adapters.data.get(position).id)
                        adapters.remove(position)
//                        peopleNum.setText("（已选${adapters.data.size}/${peopleNums}人）")
                        peopleNum.setText("（已选：${serveData.size}人）")
                        if (serveData.size==0){
                            yuePeople.visibility = View.VISIBLE
                            layoutYuePeople.visibility = View.GONE
                            if (DrinkUtils.getDrinksData().size==0) {
                                yueMoneyTips.visibility = View.GONE
                            }
                        }
                    }
                }
            }
            Click.viewClick(addServess).subscribe { intentServeList(id,merchantID) }
            yueMoneyTips.visibility=View.VISIBLE

        } else {
            if (peopleNums>0){
                yuePeople.visibility = View.GONE
                layoutYuePeople.visibility = View.VISIBLE
                var adapters = YueServeAdapter(0,serveData)
                var merager = LinearLayoutManager(mContext)
                merager.orientation = LinearLayout.VERTICAL
                yueServeList.layoutManager = merager
                yueServeList.adapter = adapters
//                peopleNum.setText("（已选${serveData.size}/${peopleNums}人）")
                peopleNum.setText("（已选：${serveData.size}人）")
                adapters.setOnItemChildClickListener { adapter, view, position ->
                    when (view.id) {
                        R.id.yueServeDell -> {
                            deleteServe(adapters.data.get(position).id)
                            adapters.remove(position)
//                            peopleNum.setText("（已选${adapters.data.size}/${peopleNums}人）")
                            peopleNum.setText("（已选：${serveData.size}人）")
                        }
                    }
                }
                Click.viewClick(addServess).subscribe { intentServeList(id,merchantID) }
                yueMoneyTips.visibility=View.VISIBLE
            }else {
                yuePeople.visibility = View.VISIBLE
                layoutYuePeople.visibility = View.GONE
                if (DrinkUtils.getDrinksData().size==0) {
                    yueMoneyTips.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        Toast.Tips("销毁了")
        if (type==1||user.getOrderAgain()=="1"||roomType=="1") {
            DrinkUtils.deleteALLDrinks()//删除所有酒水
            ServeUtils.deleteALLServe()//删除所有服务员
            DbUtils.delMerchat()
            setNum("0")
            user.setOrderAgain("0")
//            var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//            merchat.deleteAll()
        }
    }
}