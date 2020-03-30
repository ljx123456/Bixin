package com.example.shadow.heartrecreation.ui.main.activity

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.view.View
import android.widget.TextView

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ScreenUtils
import com.example.shadow.heartrecreation.R
//import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.DbUtils.getUser
import com.example.shadow.heartrecreation.db.user.getUserImage
import com.example.shadow.heartrecreation.db.user.getUserNick
import com.example.shadow.heartrecreation.db.user.getUserAge
import com.example.shadow.heartrecreation.jpush.MiuiUtils
import com.example.shadow.heartrecreation.ui.main.adapter.PagerAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.MainPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.MainView
import com.example.shadow.heartrecreation.ui.main.utils.contextbanner.CardTransformer
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMeassage
import com.example.shadow.heartrecreation.ui.main.view.BannerView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentAttention
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentBroker
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentDiscount
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentJinji
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOrder
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRefund
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentSao
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentSet
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentWine
import com.google.gson.Gson
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_main.*
import android.os.Build
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import cn.jpush.android.api.JPushInterface
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.event.NotificationClickEvent
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.android.eventbus.EventBus
import cn.jpush.im.api.BasicCallback
import com.blankj.utilcode.util.AppUtils
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.db.*
import com.example.shadow.heartrecreation.db.user.getUserConstellation
import com.example.shadow.heartrecreation.db.user.setNum
import com.example.shadow.heartrecreation.ui.image.ImageBannerInfo
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.dialog.VersionUpdatingDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.*
import com.example.shadow.heartrecreation.ui.main.mvp.body.OrderCodeBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.WineCodeBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.OrderCodePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.OrderCodeView
import com.example.shadow.heartrecreation.ui.main.mvp.view.SplashView
import com.example.shadow.heartrecreation.ui.main.utils.BannerUtil
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.share.ShareDialog
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentUserEdit
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.permissions.UserPermissions
import com.example.shadow.heartrecreation.utils.utils.*
import com.makeramen.roundedimageview.RoundedDrawable
import com.pp.wsy.bosom.app.ui.login.mvp.presenter.SplashPresenter
import com.tbruyelle.rxpermissions2.RxPermissions
import jiguang.chat.activity.ChatActivity
import jiguang.chat.application.JGApplication
import jiguang.chat.entity.Event
import jiguang.chat.entity.EventType
import jiguang.chat.entity.NotificationClickEventReceiver


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, BannerView, MainView, ShareDialog.Share, SplashView, VersionUpdatingDialog.VersionUpdatingCallBack,
        UserPermissions.MemoryReadPermissionsFace, OrderCodeView{
    override fun getTipsDataRequest(data: TipsBean) {
        if (data.data!=null){
            if (data.data.isOrderTips!=null&&data.data.isOrderTips){
                var draw=resources.getDrawable(R.mipmap.mine_icon_order_red)
                (getId(R.id.mianOrder) as TextView).setCompoundDrawablesWithIntrinsicBounds(draw,null,null,null)
            }else{
                var draw=resources.getDrawable(R.mipmap.mine_icon_order)
                (getId(R.id.mianOrder) as TextView).setCompoundDrawablesWithIntrinsicBounds(draw,null,null,null)
            }

            if (data.data.isRefundTips!=null&&data.data.isRefundTips){
                var draw=resources.getDrawable(R.mipmap.mine_icon_refund_red)
                (getId(R.id.mainRefund) as TextView).setCompoundDrawablesWithIntrinsicBounds(draw,null,null,null)
            }else{
                var draw=resources.getDrawable(R.mipmap.mine_icon_refund)
                (getId(R.id.mainRefund) as TextView).setCompoundDrawablesWithIntrinsicBounds(draw,null,null,null)
            }

            if (data.data.isWineTips!=null&&data.data.isWineTips){
                var draw=resources.getDrawable(R.mipmap.mine_icon_alcohol_red)
                (getId(R.id.mainJiu) as TextView).setCompoundDrawablesWithIntrinsicBounds(draw,null,null,null)
            }else{
                var draw=resources.getDrawable(R.mipmap.mine_icon_alcohol)
                (getId(R.id.mainJiu) as TextView).setCompoundDrawablesWithIntrinsicBounds(draw,null,null,null)
            }

            if(JMessageClient.getAllUnReadMsgCount()>0||data.data.isMessageTips){
                mainRight.setImageResource(R.mipmap.messagered)
            }else{
                mainRight.setImageResource(R.mipmap.homepage_data_button_message)
            }

        }
    }

    override fun getOrderCodeRequest(data: OrderCodeBean) {
        if (data.data!=null){
            if(data.data.referencesUser!=null) {
            DrinkUtils.deleteALLDrinks()//删除所有酒水
            ServeUtils.deleteALLServe()//删除所有服务员
            DbUtils.delMerchat()
            user.setRoomType("1")
            user.setBrokerType("1")
//            user.setNum((data.data.serviceUsers.size*2).toString())
            DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                    data.data.businessName,
                   data.data.businessId.toString(),
                    "",
                    data.data.boxTypeName,
                    data.data.boxTypeId.toString(),
                    data.data.boxId.toString(),
                    data.data.boxName,
                    true,
                    "", data.data.boxFreePrice,
                    "",
                    "",
                    "",
                    data.data.boxServiceMoney))
            if (data.data.serviceUsers!=null&&data.data.serviceUsers.size>0) {
                setNum("${data.data.serviceUsers.size}")
                data.data.serviceUsers.forEach {
//                    OrderServeUtils.setOrder(OrderServeDB(null, "${it.userId}", it.nickname, it.avatar))
                    ServeUtils.setServe(ServePersonnelDB(null, "${it.userId}", it.nickname, it.avatar,
                            "${it.skillPrice}", "", "", "${it.age}", "${it.sex}", "", it.occupationName))
                }
            }
//
            if (data.data.wines!=null&&data.data.wines.size>0) {
                data.data.wines.forEach {
                    var drink = DrinkDB()
                    drink.mealName = it.wineTypeName
                    drink.mealId = "${it.wineTypeId}"
                    drink.drinkNum = it.num.toString()
                    drink.drinkID = "${it.wineId}"
                    drink.drinkMoney = "${it.winePrice}"
                    drink.drinkName = it.wineName
                    drink.drinkText = it.specifications
                    drink.drinkImage = it.wineImg
                    DrinkUtils.setDrinks(drink)
                }
            }
//            val couponsDialog = CouponsDialog()
//            couponsDialog.setorderSkillType(data.data.skillTypeId, "", data.data.referencesUser.userId.toString())
//            couponsDialog.show(supportFragmentManager, "")

                intentUsils.intentSaoOrder(data.data.referencesUser.userId.toString(), data.data.skillTypeId, "0")
            }else{
                Toast.Tips("二维码有误")
            }

//
//            var broker=data.data.referencesUser
//            intentUsils.intentYue( 1, broker.userId.toString(),
//                   broker.avatar,
//                    broker.nickname,
//                    broker.age.toString(),
//                    broker.sex.toString(),
//                    broker.occupationName,
//                    data.data.businessId.toString(),
//                    data.data.businessName)
        }

    }

    override fun getWineCodeRequest(data: WineCodeBean) {
        if (data.data!=null){
            DrinkUtils.deleteALLDrinks()//删除所有酒水
            ServeUtils.deleteALLServe()//删除所有服务员
            DbUtils.delMerchat()
            user.setRoomType("1")
            user.setBrokerType("0")
            if (data.data.wineTypes!=null&&data.data.wineTypes.size>0) {
                data.data.wineTypes.forEach {
                    var type = it
                    it.wines.forEach {
                        var drink = DrinkDB()
                        drink.mealName = type.wineTypeName
                        drink.mealId = "${type.wineTypeId}"
                        drink.drinkNum = it.wineNum
                        drink.drinkID = "${it.businessWineId}"
                        drink.drinkMoney = "${it.businessWinePrice}"
                        drink.drinkName = it.businessWineName
                        drink.drinkText = it.businessWineDetails
                        drink.drinkImage = it.businessWineImg
                        DrinkUtils.setDrinks(drink)
                    }
                }
            }

            DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                    data.data.businessName,
                    data.data.businessId,
                    "",
                    data.data.boxTypeName,
                    "",
                    "",
                    data.data.boxName,
                    true,
                    data.data.boxName, "",
                    "",
                    "",
                    "",
                    ""))

            intentUsils.intentSaoOrder(data.data.orderNo,"1")
        }
    }

//    override fun getCityListRequest(data: CityListBean) {
//        cityListBean=data
//        if (cityListBean!=null&&cityListBean.data.size>0) {
//            if (!"".equals(city)) {
//                for (i in cityListBean.data.indices) {
//                    if (cityListBean.data.get(i).cityName.contains(city)) {
//                        if (getCity()!="") {
//                            if (city == getCity()) {
//                                setCity(city)
//                                setCityID("${cityListBean.data.get(i).cityId}")
//                            } else {
//                                ShowDialog.showCustomDialogs(this,"是否切换到${city}","是","否",object :DialogInterface.OnClickListener{
//                                    override fun onClick(dialog: DialogInterface, which: Int) {
//                                        when (which) {
//                                            DialogInterface.BUTTON_POSITIVE -> {
//                                                setCity(city)
//                                                setCityID("${cityListBean.data.get(i).cityId}")
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
//                                                finish()
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
//                            setCity(city)
//                            setCityID("${cityListBean.data.get(i).cityId}")
//                        }
//                    }
//                }
//            }
//            else {
//                setCity(cityListBean.data[0].cityName)
//                setCityID("${cityListBean.data.get(0).cityId}")
//            }
//        }
////        if (!"".equals(getCity())) {
////            for (i in data.data.indices) {
////                if (data.data.get(i).cityName.equals(getCity())) {
////                    setCityID("${data.data.get(i).cityId}")
////                }
////            }
////        } else {
////
////        }
//    }
//
//    override fun getCityListError() {
//
//    }

//    override fun getLocationSuccess(city:String) {
//        this.city=city
//        citypresenter.getCityList()
//    }

    override fun requestPermissionsFaceSucceed(context: Context, what: Int) {
        //获取定位
//        LocationUtils(this).getLocation()
    }

    override fun requestPermissionsFaceError() {
//        Toast.Tips("请打开APP所需定位权限→设置→应用→权限管理")
//        citypresenter.getCityList()
    }

    override fun enterInto() {

    }

    //更新接口
    override fun getUpdateRequest(data: UpdateBean) {
        updatingdialog.setDialogContent(data, this)
        updatingdialog.show(supportFragmentManager, "")
    }
    override fun getUpdateError(code: Int, message: String) {
        if (code!=-1301)
            Toast.Tips(message)
    }

    override fun setShareWX() {

    }

    override fun setSharePYQ() {

    }

    private val presenter by lazy { MainPresenter(this, this, this) }
    private val updataPresenter by lazy { SplashPresenter(this, this, this) }
    private val updatingdialog = VersionUpdatingDialog()
//    private val citypresenter by lazy { SetCityPresenter(this, this, this) }
    private val orderPresenter by lazy { OrderCodePresenter(this,this,this) }
    private lateinit var cityListBean:CityListBean
    private var city=""

    //获取数据成功
    override fun getMainDataRequest(data: MainBean) {
        errorLayout.visibility = View.GONE
        var imagelist = ArrayList<ImageBannerInfo>()
        if (ScreenUtils.getScreenHeight() / 16 * 9 == ScreenUtils.getScreenWidth()) {
            ViewSize.ViewSize(mianBanner, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenWidth() / 42 * 17)
        } else {
            ViewSize.ViewSize(mianBanner, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenWidth() / 3)
        }
        data.data.recommend.forEach { imagelist.add(ImageBannerInfo(it.image, true, it.id,it.url+"/?token=${user.getUserToken()}",it.name)) }
        BannerUtil.setBanner(mianBanner, imagelist)
        mainContentPager.setAdapter(PagerAdapter(data.data.show, mContext, this))
        mainContentPager.setOffscreenPageLimit(2)//预加载2个
        mainContentPager.setPageMargin(1)//设置viewpage之间的间距
        mainContentPager.setClipChildren(false)
        mainContentPager.setPageTransformer(true, CardTransformer())
        user.setYueName(data.data.show.get(0).showName)
        user.setYueID(data.data.show.get(0).typeId.toString())
    }

    //获取数据失败
    override fun getMainDataErroe() {
        errorLayout.visibility = View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            presenter.getMainData()
        }
    }

    var navHeaderView: View? = null

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return true
    }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_main

    override fun setActivityTitle() {

    }

    fun setTag(context: Context) {
        JPushInterface.setLatestNotificationNumber(context, 20)// 初始化 JPush
//        JPushInterface.setAlias(context, getJMID()) { i, s, set ->
//            if (i == 0) {
//                Log.d("123456", "成功")
//            } else if (i == 6002) {
//                setTag(context)
//                Log.d("123456", "JPush失败")
//            } else {
//                Log.d("123456", (i).toString() + "JPush")
//            }
//        }



        var userInfo=JMessageClient.getMyInfo()
        if (userInfo!=null) {
            userInfo.nickname = user.getUserNick()
            JMessageClient.updateMyInfo(UserInfo.Field.nickname, userInfo, object : BasicCallback() {
                override fun gotResult(p0: Int, p1: String?) {
                    LogUtils.a("极光昵称", p1)
                }
            })
        }
        JMessageClient.setNotificationFlag(JMessageClient.FLAG_NOTIFY_WITH_SOUND or JMessageClient.FLAG_NOTIFY_WITH_VIBRATE)
        //注册Notification点击的接收器
        NotificationClickEventReceiver(applicationContext)

        ImageLoad.setUserHead(getUserImage(), getId(R.id.imageView) as RoundedImageView)
        val rxPermissions = RxPermissions(this)
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE).subscribe { aBoolean ->
            if (aBoolean!!) {
                var file = FileUtils.saveImageFile(((getId(R.id.imageView) as RoundedImageView).drawable as RoundedDrawable).toBitmap())
                JMessageClient.updateUserAvatar(file, object : BasicCallback() {
                    override fun gotResult(p0: Int, p1: String?) {
                        LogUtils.a("极光头像", p1)
                        if (file.exists()) {
                            deletePic(file.absolutePath)
                        }
//                        if (file.delete()){
//                            LogUtils.a("删除头像","成功")
//                        }else{
//                            LogUtils.a("删除头像","失败")
//                        }
                    }
                })
            } else {
                Toast.Tips("请打开内存读取权限")
            }
        }
    }

    override fun initActivityData() {
//        citypresenter.getCityList()
        navHeaderView = mainLeft.getHeaderView(0)
        mainLeft.setNavigationItemSelectedListener(this)
//        userLocation(mContext, this)
//        setlng("")
//        setlat("")
//        LogUtils.a("id", getUser().)
//        user.setNum("0")
        updataPresenter.getUpsata(UpdateBody(1, AppUtils.getAppVersionCode()))
        presenter.getMainData()
        //融云处理
        var info = getUser()
        LogUtils.a("用户数据main" + Gson().toJson(info))
//        if (getApplicationInfo().packageName.equals(SystemUtils.getCurProcessName(getApplicationContext())) ||
//                "io.rong.push".equals(SystemUtils.getCurProcessName(getApplicationContext()))) {
//            var token = info.rongToken
//            LogUtils.a(token)
//            getRongIm(info)
//        }
        Thread(object:Runnable{
            override fun run() {
                var miuiutils = MiuiUtils()
                if (!miuiutils.isNotificationEnabled(this@MainActivity)) {
                    ShowDialog.showCustomDialog(this@MainActivity, "提示信息", "为了更好的使用本产品,请到设置中心打开对应通知设置", "去设置", "取消", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            when (which) {
                                DialogInterface.BUTTON_POSITIVE -> {
                                    if (miuiutils.isMIUI()) {
                                        miuiutils.goPermissionSettings(mContext)
                                    } else {
                                        val localIntent = Intent()
                                        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        if (Build.VERSION.SDK_INT >= 9) {
                                            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS")
                                            localIntent.setData(Uri.fromParts("package", this@MainActivity.packageName, null))
                                        } else if (Build.VERSION.SDK_INT <= 8) {
                                            localIntent.setAction(Intent.ACTION_VIEW)

                                            localIntent.setClassName("com.android.settings",
                                                    "com.android.settings.InstalledAppDetails")
                                            localIntent.putExtra("com.android.settings.ApplicationPkgName",
                                                    this@MainActivity.packageName)
                                        }
                                        startActivity(localIntent)
                                    }
                                    dialog!!.dismiss()
                                }
                                DialogInterface.BUTTON_NEGATIVE -> {
                                    dialog!!.dismiss()
                                }
                            }
                        }
                    })

                }
            }
        })


    }

    private fun getRongIm(info: UserDB) {
//        RongIM.connect(info.rongToken, object : RongIMClient.ConnectCallback() {
//            override fun onSuccess(p0: String?) {
//                LogUtils.a("融云", "身份验证通过")
//                RongIM.getInstance().refreshUserInfoCache(UserInfo("${info.id}", "${info.nickname}", Uri.parse("${info.avatar}")))
//                RongIM.getInstance().setCurrentUserInfo(UserInfo("${info.id}", "${info.nickname}", Uri.parse("${info.avatar}")))
//                RongIM.getInstance().setMessageAttachedUserInfo(true)
//            }
//
//            override fun onError(p0: RongIMClient.ErrorCode?) {
//                LogUtils.a("$p0 融云失败")
//                LogUtils.a("融云", "身份认证失败")
//            }
//
//            override fun onTokenIncorrect() {
//                getRongIm(info)
//                LogUtils.a("融云", "连接服务器失败,请检查网络设置")
//                //退出登录重新登录
//            }
//        })
    }
    public fun onEvent(event: NotificationClickEvent){
        var mUserInfo=event.message.fromUser
        var intent=Intent()
        intent.setClass(this, ChatActivity::class.java)
        //创建会话
        intent.putExtra(JGApplication.TARGET_ID, mUserInfo.getUserName())
        intent.putExtra(JGApplication.TARGET_APP_KEY, mUserInfo.getAppKey())
        var notename = mUserInfo.getNotename()
        if (TextUtils.isEmpty(notename)) {
            notename = mUserInfo.getNickname()
            if (TextUtils.isEmpty(notename)) {
                notename = mUserInfo.getUserName()
            }
        }
        intent.putExtra(JGApplication.CONV_TITLE, notename)
        var conv: Conversation? = JMessageClient.getSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
        //如果会话为空，使用EventBus通知会话列表添加新会话
        if (conv == null) {
            conv = Conversation.createSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
            EventBus.getDefault().post(Event.Builder()
                    .setType(EventType.createConversation)
                    .setConversation(conv)
                    .build())
        }
        startActivity(intent)
    }

    /**
     * 跳转到对应约界面
     */
    override fun OnClickListener(get: MainBean.DataBean.ShowBean) {
//        user.setYueName(get.showName)
//        user.setYueID(get.typeId.toString())
//        intentYue(0)
    }

    override fun clickListener() {
        Click.viewClick(mainImage).subscribe {
            drawer.openDrawer(GravityCompat.START)
        }
        Click.viewClick(mainRight).subscribe { intentMeassage() }
        //设置个人资料
        Click.viewClick(getId(R.id.mainUserSet)).subscribe {
            intentUserEdit()
            drawer.closeDrawers()
        }
        //扫一扫
        Click.viewClick(getId(R.id.mainSao)).subscribe {
            intentSao(this)
            drawer.closeDrawers()
        }
        //订单
        Click.viewClick(getId(R.id.mianOrder)).subscribe {
            intentOrder()
            drawer.closeDrawers()
        }
        //存酒
        Click.viewClick(getId(R.id.mainJiu)).subscribe {
            intentWine()
            drawer.closeDrawers()
        }
        //我的关注
        Click.viewClick(getId(R.id.mainAttention)).subscribe {
            intentAttention()
            drawer.closeDrawers()
        }
        //优惠券
        Click.viewClick(getId(R.id.mainDiscount)).subscribe {
            intentDiscount()
            drawer.closeDrawers()
        }
        //邀请好友
        Click.viewClick(getId(R.id.mainFriend)).subscribe {
            var shareDialog = ShareDialog(this)
            shareDialog.show(supportFragmentManager, "")
            drawer.closeDrawers()
        }
        //退款
        Click.viewClick(getId(R.id.mainRefund)).subscribe {
            intentRefund()
            drawer.closeDrawers()
        }
        //经纪人
        Click.viewClick(getId(R.id.mainBroker)).subscribe {
            intentBroker()
            drawer.closeDrawers()
        }
        //紧急处理
        Click.viewClick(getId(R.id.mainJinji)).subscribe {
            intentJinji()
            drawer.closeDrawers()
        }
        //设置
        Click.viewClick(getId(R.id.mainSet)).subscribe {
            intentSet()
            drawer.closeDrawers()
        }
    }

    fun getId(id: Int): View {
        var view = navHeaderView!!.findViewById<View>(id)
        return view
    }

    override fun onResume() {
        super.onResume()
//        mainName.setText(getUserNick())
        try {
            var use = getUser()
            ImageLoad.setUserHead(getUserImage(), mainImage)
            setTag(this)
            (getId(R.id.mainUserName) as TextView).text = getUserNick()
            (getId(R.id.mainElseData) as TextView).text = getUserAge() + "岁 " + getUserConstellation()//标签
//        setTag(this)
            presenter.getTipsData()

        }catch (e:Exception){

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK){
            LogUtils.a("扫描成功" + data!!.extras.getString("codedContent"))
//            http://bixinyule.com?bixinClientType=3&qrcodeType=1&businessId=1&boxTypeId=1&businessBoxId=1
            var map= UrlParse.getUrlParams(data!!.extras.getString("codedContent"))
            if (map.containsKey("bixinClientType")){
                if (map["qrcodeType"]!=""&&map["qrcodeType"]=="1"&&map["bixinClientType"]=="3"){
//                    businesssId=map["businessId"]!!
//                    boxTypeId=map["boxTypeId"]!!
//                    boxId=map["businessBoxId"]!!
                    intentUsils.intentRoomInfo(map["businessId"]!!, map["boxTypeId"]!!, map["businessBoxId"]!!)
                }else if (map["qrcodeType"]!=""&&map["qrcodeType"]=="2"&&map["bixinClientType"]=="2"){

                        if (map.containsKey("orderCode")&&map["orderCode"] != null && map["orderCode"] != "") {//http://bixinyule.com?bixinClientType=2&qrcodeType=2&orderCode=c3c5b2ec57fd5d0ac36323ba1363b3cadb9b3ee2dffea9a9eec486b7bd915a10
                            orderPresenter.getOrderCode(OrderCodeBody(map["orderCode"]))
                        } else if (map.containsKey("wineCode")&&map["wineCode"] != null && map["wineCode"] != "") {//http://bixinyule.com?bixinClientType=2&qrcodeType=2&wineCode=c3c5b2ec57fd5d0ac36323ba1363b3cadb9b3ee2dffea9a9eec486b7bd915a10
                            orderPresenter.getWineCode(WineCodeBody(map["wineCode"]))
                        } else{
                            Toast.Tips("请扫描订单二维码")
                        }
                } else if(map.containsKey("activityUrlPath")&&map["activityUrlPath"]!=""){
                    var url=BaseUrl.HOST_URL+"user/banner/coupon/?token=${user.getUserToken()}"
                    intentUsils.intentBanner("比心娱乐",url)
                }
                else if (map["qrcodeType"]!=""&&map["qrcodeType"]=="1"&&map["bixinClientType"]=="1"){
                    var url="http://app.bixinyule.com/user/banner/coupon/?id=${user.getJMID()}"
                    intentUsils.intentBanner("比心娱乐",url)
                } else{
                    Toast.Tips("请扫描包房二维码或者订单二维码")
                }
            }else{
                Toast.Tips("请扫描正确的二维码")
            }
        }
    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//        if(KeyEvent.KEYCODE_BACK==keyCode)
//            return false
//        return super.onKeyDown(keyCode, event)
//    }

    private fun deletePic(path:String){
        if(!TextUtils.isEmpty(path)){
            val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val contentResolver = this.getContentResolver()//cutPic.this是一个上下文
            val url =  MediaStore.Images.Media.DATA + "=?"
            //删除图片
            contentResolver.delete(uri, url, arrayOf(path))
        }
    }

    override fun onDestroy() {
        Log.e("测试","main销毁了")
        DbUtils.delMerchat()
        DrinkUtils.deleteALLDrinks()
        ServeUtils.deleteALLServe()
        OrderServeUtils.deleteAllOrder()
        user.setNum("0")
        user.setOrderNo("")
        user.setType("1")
        user.setRoomType("0")
        user.setBrokerType("0")
        user.setYueID("1")
        user.setYueName("")
        user.setOrderID("")
        user.setCityID("1")
        user.setCity("")
        user.setRoomMoney("0.00")
        super.onDestroy()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if(level == TRIM_MEMORY_UI_HIDDEN){
            GlideCacheUtil.getInstance().clearImageAllCache(this)//清除图片所有缓存
            DataCleanManager.cleanInternalCache(mContext)//清除本应用内部缓存
        }

    }

    override fun finish() {
        super.finish()
        Log.e("测试","mainfinish()了")
    }
}
