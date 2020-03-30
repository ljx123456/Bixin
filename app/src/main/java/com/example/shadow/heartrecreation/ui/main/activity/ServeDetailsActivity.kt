package com.example.shadow.heartrecreation.ui.main.activity

import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.ToastUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.OrderServeUtils
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.jpush.MiuiUtils
import com.example.shadow.heartrecreation.ui.image.ImageInfo
import com.example.shadow.heartrecreation.ui.main.dialog.AddsSelectDialog
import com.example.shadow.heartrecreation.ui.main.dialog.ServeListDialog
import com.example.shadow.heartrecreation.ui.main.dialog.ServeYueDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.BlackChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.FansChangeBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.ReportBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeDetailsBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.BlackChangePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.ServeDetailsPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.BlackChangeView
import com.example.shadow.heartrecreation.ui.main.mvp.view.ServeDetailsView
import com.example.shadow.heartrecreation.ui.main.pop.PopupWindowHelper
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMain
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentYue
import com.example.shadow.heartrecreation.ui.share.SharePresenter
import com.example.shadow.heartrecreation.ui.share.ShareView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOrder
import com.example.shadow.heartrecreation.utils.banner.BannerUtils
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.utils.*
//import io.rong.imlib.model.Conversation
import kotlinx.android.synthetic.main.activity_screen_details.*
import kotlinx.android.synthetic.main.error_net_layout.*
import java.math.BigDecimal
import kotlin.collections.ArrayList


class ServeDetailsActivity : BaseActivity(), ServeDetailsView, ShareView, ServeListDialog.ServeList, BlackChangeView , AddsSelectDialog.AddsSelect{
    override fun dialog() {
        intentYue(0)
        finish()
    }

    override fun setServeOver() {

    }

    override fun getReportRequest() {

    }

    override fun getBlackChangeRequest() {
        presenter.getServeDetails(ServeDetailsBody(getUserToken(), id, businessId, typeID))
    }

    override fun getBlackChangeError() {
        presenter.getServeDetails(ServeDetailsBody(getUserToken(), id, businessId, typeID))
    }

    override fun setServeGoYue() {
        finish()
    }

    //关注
    override fun getFansChangeRequest() {
        when (serveFan.text.toString()) {
            "取消关注" -> {
                serveFan.setText("+ 关注")
                serveFan.setBackgroundResource(R.drawable.pink_all_shape)
            }
            else -> {
                serveFan.setText("取消关注")
                serveFan.setBackgroundResource(R.drawable.white_shape)
            }
        }
        presenter.getServeDetails(ServeDetailsBody(getUserToken(), id, businessId, typeID))
    }

    //有服务人员
    fun haveServe() {
        var serveData = ServeUtils.getServeData()
        if (serveData != null && serveData.size >= 1 && serveData.get(0).image != null) {
            detailsYueNum.text = "${serveData.size}"
        }
    }

    override fun onResume() {
        super.onResume()
        haveServe()
    }

    private val presenter by lazy { ServeDetailsPresenter(this, this, this) }
    private val blackPresenter by lazy { BlackChangePresenter(this, this, this) }
    private var flag=false

    override fun getServeDetailsRequest(data: ServeDetailsBean) {
        nac_root.visibility=View.VISIBLE
        bottom.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        var info = data.data
        screenName.setText(info.nickname)
        serveFans.setText("接单数:${info.focus}\n粉丝:${info.fans}")
        serveBirthday.setText(info.birthdayAndConstellation)
        if (info.sex==1){
            serveSex.text="男"
        }else{
            serveSex.text="女"
        }
        var imagelist = ArrayList<ImageInfo>()

        info.videoSetList.forEach { imagelist.add(ImageInfo(it.url, false, it.type)) }
        BannerUtils().setBanner(detailsBanner, imagelist)
        occupationName.setText(info.occupationName)
        if (info.tagSet!=null&&info.tagSet!=""&&info.tagSet.length>0) {
            val lis = ArrayList(info.tagSet.split(","))
            serveDetailsLabel.setList(lis)
            serveDetailsLabelLayout.visibility=View.VISIBLE
            stringJoin.clear()
            if (info.evaluateTagSetList!=null&&info.evaluateTagSetList.size>0) {
                info.evaluateTagSetList.forEach { stringJoin.add(it.name) }
                serveDetailsImpression.setList(stringJoin)
            }
        }else{
            serveDetailsLabelLayout.visibility=View.GONE
        }
        if (info.skillTypeList != null) {
            serveTypeText.setText(info.skillTypeList.skillTypeName)
            serveTypeMoney.setText("¥:${info.skillTypeList.skillTypePriceUp.setScale(2, BigDecimal.ROUND_HALF_UP)}（5小时）")
        } else {
            serveType.visibility = View.GONE
        }

//        serveMerchant.setText(info.businessName)
        when (info.isFans) {
            1 -> {
                serveFan.setText("取消关注")
                serveFan.setBackgroundResource(R.drawable.white_shape)
            }
            else -> {
                serveFan.setText("+ 关注")
                serveFan.setBackgroundResource(R.drawable.pink_all_shape)
            }
        }
        Click.viewClick(serveFan).subscribe { presenter.getFansChange(FansChangeBody(getUserToken(), "${info.userId}")) }

        ktvList.visibility=View.GONE

//        if (info.businessInfo!=null&&info.businessInfo.size>0){
//            ktvList.visibility=View.VISIBLE
//            var list=ArrayList<String>()
//            info.businessInfo.forEach {
//                list.add(it.businessName)
//            }
//            screenDetailsAddsList.setList(list)
//        }else{
//            ktvList.visibility=View.GONE
//        }

//        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
        if (info.businessInfo!=null&&info.businessInfo.size>0){
            for (i in info.businessInfo.indices){
                if (info.businessInfo[i].businessId.toString()==businessId){
                    flag=true
                    break
                }
            }
        }

//        var addsAdapter = ServeDetailsAddsAdapter(info.businessInfo)
//        var manager = LinearLayoutManager(this)
//        screenDetailsAddsList.layoutManager = manager
//        screenDetailsAddsList.adapter = addsAdapter


//        if (info.inviteTime != null) {
//            detailsYue//倒计时
//            timeutils.setEndTimer(info.inviteTime)
//            timeutils.codeCountTimer(detailsYue) && info.inviteTime == null
//        } else {
        //是否可以预约
//        if (info.isOnline == 1 && info.isOnline == 1 && info.isInBlacklist == 1 && "空闲中".equals(info.state)) {
////                if (info.businessId == businessId.toInt()) {
//            //可以直接点
//            serveOrType.setText(info.state)
//            detailsYue.isEnabled = true//可以点击
//            detailsYue.setBackgroundResource(R.drawable.pink_ellipse_shape)
////                } else {
////                    if (info.isOut == 0) {
////                        可以外出
////                        serveOrType.setText(info.state)
////                        detailsYue.isEnabled = true//可以点击
////                        detailsYue.setBackgroundResource(R.drawable.pink_shape)
////                    } else {
////                        不可以外出
////                    }
////                }
//        } else {
//            serveOrType.setText(info.state)
//            detailsYue.isEnabled = false//不能点击
//            detailsYue.setBackgroundResource(R.drawable.pink_ellipse_shape)
//        }
//        }

        if (info.isInBlacklist == 0) {
            (popView.findViewById(R.id.goBlock) as TextView).setText("移除黑名单")
        } else {
            (popView.findViewById(R.id.goBlock) as TextView).setText("拉黑")
        }

        var datas = OrderServeUtils.getOrderData()
        var infoData = OrderServeDB(null, "${info.userId}", info.nickname, info.avatar)
        var da=ServeUtils.getServeData()
        var serve = ServePersonnelDB(
                null,
                "${info.userId}",
                info.nickname, info.avatar,
                "${info.skillTypeList.skillTypePriceUp}",
                "",
                "",
                "${info.age}",
                "${info.sex}",
                info.km,
                info.occupationName)
        if (OrderServeUtils.haveData(datas, infoData) ||ServeUtils.haveData(da,serve)) {
            serveOrType.visibility=View.GONE
            detailsYue.isEnabled = false
            detailsYue.text="已添加达人"
            detailsYue.setBackgroundResource(R.drawable.yue_btn_off)
        }else {
            //在线才可以点
            if (info.isOnline == 1) {
                //是否在黑名单  1不在
                if (info.isInBlacklist == 1) {
//                if (info.isCanInvite==1) {
                    if (info.isInOrder == 0) {
//                        when (info.state) {
//                            "空闲中" -> {
                        serveOrType.visibility = View.GONE
                        serveOrType.setText(info.state)
                        detailsYue.isEnabled = true
                        detailsYue.text = "邀请约玩"
                        detailsYue.setBackgroundResource(R.drawable.pink_ellipse_shape)
                        //是否在保护期内
                        //是否能外出
//                            }
//                            else -> {
//                                serveOrType.visibility = View.GONE
//                                detailsYue.isEnabled = false
//                                detailsYue.text = "不可邀约"
//                                detailsYue.setBackgroundResource(R.drawable.pink_ellipse_shape)
//                            }
//                        }
                    } else {
                        serveOrType.visibility = View.GONE
                        detailsYue.isEnabled = false
                        detailsYue.text = "不可邀约"
                        detailsYue.setBackgroundResource(R.drawable.yue_btn_off)
                    }
//                }else{
//                    serveOrType.visibility=View.GONE
//                    detailsYue.isEnabled = false
//                    detailsYue.text="不可邀约"
//                    detailsYue.setBackgroundResource(R.drawable.yue_btn_off)
//                }
                } else {
                    serveOrType.visibility = View.GONE
                    detailsYue.isEnabled = false
                    detailsYue.text = "不可邀约"
                    detailsYue.setBackgroundResource(R.drawable.yue_btn_off)
                }
            } else {
                serveOrType.visibility = View.GONE
                detailsYue.isEnabled = false
                detailsYue.text = "不可邀约"
                detailsYue.setBackgroundResource(R.drawable.yue_btn_off)
            }
        }


//        info.is
//        info.inviteTime//可以预约倒计时

//        var serveModel = ServePersonnelDB(
//                null,
//                "${id}",
//                info.nickname, info.avatar,
//                "${info.skillTypeList.skillTypePriceUp}",
//                "",
//                "",
//                "${info.age}",
//                "${info.sex}",
//                info.km,
//                info.occupationName
//        )
//
//        ServeData(serveModel, detailsYue)

        Click.viewClick(detailsYue).subscribe {
            //在线才可以点
            if (data.data.isOnline == 1) {
                //是否在黑名单  1不在
                if (info.isInBlacklist == 1) {
                        if (data.data.isInOrder == 0) {
                            var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
//                            Log.e("测试id",merchat.loadAll()[0].merchantID+"hah"+businessId)
                            var occupationName = ""
                            if (info.occupationName != null && info.occupationName != "") {
                                occupationName = info.occupationName
                            }
                            if (merchat != null && merchat.loadAll() != null && merchat.loadAll().size > 0 ) {
//                                if (flag) {
//                                Log.e("测试id",merchat.loadAll()[0].merchantID)

                                    serveYueDialog.setData("${id}", info.avatar, info.nickname,
                                            "${info.skillTypeList.skillTypePriceUp}",
                                            "${info.needTime}",
                                            "${info.km}",
                                            occupationName,
                                            "${info.sex}",
                                            "${info.age}",
                                            "",
                                            businessId)
                                    serveYueDialog.show(supportFragmentManager, "")
//                                }else{
//                                    Toast.Tips("该达人未开启此商家服务，请邀约其他达人")
//                                }
                            } else {
                                ServeUtils.setServe(ServePersonnelDB(
                                        null,
                                        "${id}",
                                        info.nickname, info.avatar,
                                        "${info.skillTypeList.skillTypePriceUp}",
                                        "",
                                        "",
                                        "${info.age}",
                                        "${info.sex}",
                                        "${info.km}",
                                        occupationName)
                                )
//            Toast.Tips("添加成功")
                                if (ServeUtils.getServeData()[ServeUtils.getServeData().lastIndex].serveID=="${id}"){
                                    Toast.Tips("添加成功")
                                }
                                finish()
                            }
//                            var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
////                            Log.e("测试id",merchat.loadAll()[0].merchantID+"hah"+businessId)
//                            if (merchat != null && merchat.loadAll() != null && merchat.loadAll().size > 0 ) {
//                                if (flag) {
////                                Log.e("测试id",merchat.loadAll()[0].merchantID)
//                                    var occupationName = ""
//                                    if (info.occupationName != null && info.occupationName != "") {
//                                        occupationName = info.occupationName
//                                    }
//                                    serveYueDialog.setData("${id}", info.avatar, info.nickname,
//                                            "${info.skillTypeList.skillTypePriceUp}",
//                                            "${info.needTime}",
//                                            "${info.km}",
//                                            occupationName,
//                                            "${info.sex}",
//                                            "${info.age}",
//                                            "",
//                                            businessId)
//                                    serveYueDialog.show(supportFragmentManager, "")
//                                }else{
//                                    Toast.Tips("该达人未开启此商家服务，请邀约其他达人")
//                                }
//                            } else {
//                                if (info.businessInfo != null&&info.businessInfo.size>0) {
//                                    addsselectdialog.setAddsData(info)
//                                    addsselectdialog.show(supportFragmentManager, "")
//                                } else {
//                                    Toast.Tips("该达人未开启商家服务，请邀约其他达人")
////                                    ShowDialog.showCustomDialog(this, "提示", "请先设置约玩地址", "取消", "去设置", object : DialogInterface.OnClickListener {
////                                        override fun onClick(dialog: DialogInterface, which: Int) {
////
////                                        }
////                                    })
//                                }
//                            }
                    }
                }
            }
        }

        //聊天
//        Click.viewClick(serveChat).subscribe {
//            JMessageClient.getUserInfo(info.userId.toString(),"b2a8076f779c87568f4d0656",object : GetUserInfoCallback(){
//                override fun gotResult(p0: Int, p1: String, p2: UserInfo) {
//                    if (p0==0){
//                        var mUserInfo=p2
//                        var intent=Intent()
//                        intent.setClass(this@ServeDetailsActivity, ChatActivity::class.java)
//                        //创建会话
//                        intent.putExtra("targetId", mUserInfo.getUserName())
//                        intent.putExtra("targetAppKey", mUserInfo.getAppKey())
//                        var notename = mUserInfo.getNotename()
//                        if (TextUtils.isEmpty(notename)) {
//                            notename = mUserInfo.getNickname()
//                            if (TextUtils.isEmpty(notename)) {
//                                notename = mUserInfo.getUserName()
//                            }
//                        }
//                        intent.putExtra("conv_title", notename)
//                        var conv: Conversation? = JMessageClient.getSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
//                        //如果会话为空，使用EventBus通知会话列表添加新会话
//                        if (conv == null) {
//                            conv = Conversation.createSingleConversation(mUserInfo.getUserName(), mUserInfo.getAppKey())
//                            EventBus.getDefault().post(Event.Builder()
//                                    .setType(EventType.createConversation)
//                                    .setConversation(conv)
//                                    .build())
//                        }
//                        startActivity(intent)
//                    }
//                }
//            })
////            val uri = Uri.parse("rong://" + mContext!!.applicationInfo.packageName).buildUpon()
////                    .appendPath("conversation").appendPath(Conversation.ConversationType.PRIVATE.getName().toLowerCase())
////                    .appendQueryParameter("targetId", "${id}").appendQueryParameter("title", info.nickname).build()
////            var intent = Intent(Intent.ACTION_VIEW, uri)
////            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
////            startActivity(intent)
//        }

        url="${BaseUrl.HOST_URL}share/service?id=${data.data.userId}&skillTypeId=${data.data.skillTypeList.skillTypeId}"

        Click.viewClick(titleRight).subscribe { showTitleRight() }
//        Click.viewClick(detailsYueList).subscribe { serveListDialog.show(supportFragmentManager, "") }

        //返回首页
        Click.viewClick(popView.findViewById(R.id.goHome)).subscribe {
            pop.dismiss()
            intentMain()
            ActivityUtils.finishAllActivities()
        }
        //消息中心
        Click.viewClick(popView.findViewById(R.id.goMessage)).subscribe {

        }
        //订单中心
        Click.viewClick(popView.findViewById(R.id.goOrder)).subscribe {
            pop.dismiss()
            intentOrder()
        }
        //分享
        Click.viewClick(popView.findViewById(R.id.goShare)).subscribe {
            sharePresenter.showShareDialogServe(this, "比心娱乐", "你的好友给你分享了一位颜值超高的达人，点击查看~",url,data.data.avatar)
            pop.dismiss()
        }
        //举报
        Click.viewClick(popView.findViewById(R.id.goReport)).subscribe {
            pop.dismiss()
            reportPop.showMatchAtLocation(titleText,Gravity.CENTER,0,0)
        }
        //拉黑
        Click.viewClick(popView.findViewById(R.id.goBlock)).subscribe {
            pop.dismiss()
            if (info.isInBlacklist==1) {
                ShowDialog.showCustomDialog(this, "提示", "拉黑后将不会收到对方任何消息,是否确认?", "确认", "取消", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                blackPresenter.getBlackChange(BlackChangeBean(getUserToken(), id))
                                dialog.dismiss()
                            }
                            DialogInterface.BUTTON_NEGATIVE -> {

                                dialog.dismiss()
                            }
                        }
                    }
                })
            }else{
                blackPresenter.getBlackChange(BlackChangeBean(getUserToken(), id))
            }
        }
        reportPopView.findViewById<EditText>(R.id.report_context).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length >= 120) {
                    ToastUtils.showShort("当前输入内容不能超过120字")
                }
                reportPopView.findViewById<TextView>(R.id.report_num).setText("${s!!.length}/120字")
            }
        })

        Click.viewClick(reportPopView.findViewById(R.id.report_bg)).subscribe {
            reportPop.dismiss()
        }
        Click.viewClick(reportPopView.findViewById(R.id.report_cancel)).subscribe {
            reportPop.dismiss()
            reportPopView.findViewById<EditText>(R.id.report_context).setText("")
        }

        //提交举报内容
        Click.viewClick(reportPopView.findViewById(R.id.report_sure)).subscribe {
            var edt=reportPopView.findViewById<EditText>(R.id.report_context)
            if (edt.text!=null&&edt.text.toString()!=""){
                reportPop.dismiss()
                presenter.getReport(ReportBody(user.getUserToken(),data.data.userId,edt.text.toString()))
            }else{
                Toast.Tips("请输入举报内容")
            }
        }

    }
    override fun getServeDetailsError() {
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
        nac_root.visibility=View.GONE
        bottom.visibility=View.GONE
        errorLayout.visibility=View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getServeDetails(ServeDetailsBody(getUserToken(), id, businessId, typeID))
        }
    }

    private var id = 0
    private var businessId = ""
    private var typeID = 0
    private var url=""

    private val serveYueDialog = ServeYueDialog()
    private val addsselectdialog = AddsSelectDialog(this)
    private val serveListDialog = ServeListDialog(this)
    private lateinit var pop: PopupWindowHelper
    private lateinit var popView: View
    var stringJoin = ArrayList<String>()
    private val sharePresenter by lazy { SharePresenter(this, this, this) }

    private lateinit var reportPop:PopupWindowHelper
    private lateinit var reportPopView:View

    override fun openEventBus(): Boolean = false

    override fun onSavedInstanceState(bundle: Bundle?) {
        super.onSavedInstanceState(bundle)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = window.decorView
            val option = ( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            decorView.systemUiVisibility = option
            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        }
        val actionBar = getSupportActionBar()
        actionBar!!.hide()
//        nac_layout.alpha = 0.toFloat()
//        nac_root.setFadingView(nac_layout)
//        nac_root.setFadingHeightView(detailsBanner)
        var miuiutils = MiuiUtils()
        if (miuiutils.isMIUI()){
            SystemUtils.setMiUiLightStatusBar(this,false)
        }else if (SystemUtils.isFlyme()){
            SystemUtils.setFlymeLightStatusBar(this,false)
        }else{
            SystemUtils.setAndroidLightStatusBar(this,false)
        }
    }

    override fun getActivityLayout(): Int = R.layout.activity_screen_details

    override fun setActivityTitle() {
    }

    override fun initActivityData() {
        id = intent.getIntExtra("id", 0)
        businessId = intent.getStringExtra("businessId")
        ViewSize.ViewSize(detailsLayout, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenWidth() / 2)
        typeID = intent.getIntExtra("typeID", 0)
        if (!NetworkUtils.isConnected()) {
            nac_root.visibility=View.GONE
            bottom.visibility=View.GONE
            errorLayout.visibility=View.VISIBLE
        }
//        else{
//            nac_root.visibility=View.VISIBLE
//            bottom.visibility=View.VISIBLE
//            errorLayout.visibility=View.GONE
//        }
        presenter.getServeDetails(ServeDetailsBody(getUserToken(), id, businessId, typeID))

        popView = LayoutInflater.from(mContext).inflate(R.layout.pop_serve_list, null)
        pop = PopupWindowHelper(popView)

        reportPopView= LayoutInflater.from(mContext).inflate(R.layout.pop_report, null)
        reportPop = PopupWindowHelper(reportPopView)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(anewClick).subscribe {
            presenter.getServeDetails(ServeDetailsBody(getUserToken(), id, businessId, typeID))
        }

    }

    private fun showTitleRight() {
        pop.showAsDropDown(titleRight, 0, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(applicationContext)
//        timeutils.onDestroy()
    }

    override fun finish() {
        super.finish()
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)
    }
}