package com.example.shadow.heartrecreation.base

import android.app.Notification
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import cn.jpush.android.api.BasicPushNotificationBuilder
import cn.jpush.android.api.JPushInterface
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.event.NotificationClickEvent
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.eventbus.EventBus
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.db.GreenDaoHelper.initDatabase
import com.example.shadow.heartrecreation.qiniu.SendAppFile.initConfiguration
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig
import jiguang.chat.activity.ChatActivity
import jiguang.chat.application.JGApplication
import jiguang.chat.entity.Event
import jiguang.chat.entity.EventType
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.bugly.crashreport.CrashReport.UserStrategy
import io.reactivex.plugins.RxJavaPlugins
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


//import com.squareup.leakcanary.LeakCanary.refWatcher
//import com.squareup.leakcanary.RefWatcher
//import com.squareup.leakcanary.LeakCanary




/**
 * Created by Administrator on 2017/12/18 0018.
 */
class AppProject : BaseApplication() {

//    private var refWatcher: RefWatcher? = null

    override fun initCreate() {
        //context初始化
        BaseContext.initContext(this)

        //RxJava异常处理
        RxJavaPlugins.setErrorHandler {
            Log.e("测试","onRxJavaErrorHandler ---->: $it")
        }
        //初始化数据库
        initDatabase(this)
        //初始化极光
        initJPush(this)
        initUMeng()

        initBugly()
        //内存泄漏检测
//        refWatcher= setupLeakCanary()
    }

    fun initJPush(context: Context) {
        JPushInterface.init(context)
        setStyleBasic(context)
        JPushInterface.setDebugMode(true)
        JMessageClient.setDebugMode(true)
        JMessageClient.init(context,false)
        JMessageClient.registerEventReceiver(this)
//        setTag(context)
    }

    fun initUMeng(){
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "5ce3ff350cafb21233000605")
        // 选用AUTO页面采集模式
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO)
        // 支持在子进程中统计自定义事件
        UMConfigure.setProcessEvent(true)
    }

    /**
     * 激光推送设置通知提示方式 - 基础属性
     */
    private fun setStyleBasic(context: Context) {
//        val builder = BasicPushNotificationBuilder(context)
//        builder.statusBarDrawable = R.mipmap.ic_launcher
//        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
//        builder.notificationDefaults = Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS
//        JPushInterface.setPushNotificationBuilder(1, builder)

        val builder = BasicPushNotificationBuilder(context)
        builder.statusBarDrawable = R.mipmap.ic_app
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL or Notification.FLAG_SHOW_LIGHTS  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = (Notification.DEFAULT_SOUND
                or Notification.DEFAULT_VIBRATE
                or Notification.DEFAULT_LIGHTS)  // 设置为铃声、震动、呼吸灯闪烁都要
        JPushInterface.setPushNotificationBuilder(1, builder)

    }

    //初始化bugly
    fun initBugly(){
        CrashReport.initCrashReport(getApplicationContext(), "8e39f422c6", false)
//        val context = applicationContext
//        // 获取当前包名
//        val packageName = context.packageName
//        // 获取当前进程名
//        val processName = getProcessName(android.os.Process.myPid())
//        // 设置是否为上报进程
//        val strategy = UserStrategy(context)
//        strategy.setUploadProcess(processName == null || processName == packageName)
//        // 初始化Bugly
//        CrashReport.initCrashReport(context, "8e39f422c6", true, strategy)
    }


//    fun setTag(context: Context) {
//        val userId = JPushInterface.getRegistrationID(applicationContext)
//        if (!TextUtils.isEmpty(userId)) {
//            JPushInterface.setLatestNotificationNumber(context, 20)// 初始化 JPush
//            JPushInterface.setAlias(context, userId) { i, s, set ->
//                if (i == 0) {
//                    Log.d("123456", "成功")
//                    Log.d("123456", "JPush成功" + userId)
////                    setRegistrationID(applicationContext, userId)
//                } else if (i == 6002) {
//                    setTag(context)
//                    Log.d("123456", "JPush失败")
//                } else {
//                    Log.d("123456", (i).toString() + "JPush")
//                }
//            }
//        }
//    }

    override fun initLibrary() {
        //七牛云初始化
        initConfiguration()
        //初始化融云
//        initRongYunSDk()
    }

    override fun initDataSave() {
//        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE,"5ce3ff350cafb21233000605")
//        UMConfigure.setLogEnabled(true)
        PlatformConfig.setWeixin("wx4d89639ebf5bc12a", "pB1xFCoIgx3xfPhV1kQPQ3qWFmP1WkCO")
    }



    fun initRongYunSDk() {
//        if (applicationInfo.packageName == getCurProcessName(applicationContext) || "io.rong.push" == getCurProcessName(applicationContext)) {
//            RongIM.init(this)//主进程初始化
//        }
    }

    public fun onEvent(event: NotificationClickEvent){
        var mUserInfo=event.message.fromUser
        var intent= Intent()
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


//    private fun setupLeakCanary(): RefWatcher {
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//           return RefWatcher.DISABLED
//        }
//       return LeakCanary.install(this)
//    }
//    companion object {
//        fun getRefWatcher(context: Context): RefWatcher {
//            val leakApplication = context.applicationContext as AppProject
//            return leakApplication.refWatcher!!
//        }
//    }

    /**
 * 获取进程号对应的进程名
 *
 * @param pid 进程号
 * @return 进程名
 */
    private fun getProcessName(pid:Int):String?{
        var reader:BufferedReader?=null
        try {
            reader = BufferedReader(FileReader("/proc/" + pid + "/cmdline"));
            var processName = reader.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim()
            }
            return processName
        }catch (t:Throwable){
            t.printStackTrace()
        }finally {
            try {
                if (reader != null) {
                    reader.close()
                }
            } catch (exception: IOException) {
                exception.printStackTrace()
            }
        }

        return null

    }



}