package com.example.shadow.heartrecreation.base

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.event.LoginStateChangeEvent
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils
import com.example.shadow.heartrecreation.ui.main.dialog.OtherLoginDialog
import com.example.shadow.heartrecreation.utils.dialog.LoadDialog
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import jiguang.chat.activity.LoginActivity
import jiguang.chat.utils.FileHelper
import jiguang.chat.utils.SharePreferenceManager
import org.greenrobot.eventbus.EventBus


/**
 * Created by Administrator on 2017/12/18 0018.
 */
abstract class BaseActivity : BaseAppActivity() {




    override fun onStartActivity(bundle: Bundle?) {
        setContentView(getActivityLayout())
        onSavedInstanceState(bundle)
        openActivityEventBus()
        setActivityTitle()
        initActivityData()
        clickListener()
        //注册sdk的event用于接收各种event事件
        JMessageClient.registerEventReceiver(this)
    }

    protected abstract fun openEventBus(): Boolean

    protected abstract fun getActivityLayout(): Int

    protected abstract fun setActivityTitle()

    protected abstract fun initActivityData()

    protected abstract fun clickListener()


    protected open fun onSavedInstanceState(bundle: Bundle?) {

    }


    private fun openActivityEventBus() {
        if (openEventBus()) {
            EventBus.getDefault().register(this)
        }
    }

    private fun closeActivityEventBus() {
        if (openEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        closeActivityEventBus()
        JMessageClient.unRegisterEventReceiver(this)
    }

//    private fun setTitleColor() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.statusBarColor = resources.getColor(R.color.content_color)
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }
//    }

    fun showLoading() = LoadDialog.show(mContext)


    fun dismissLoading() = LoadDialog.dismiss(mContext)

    fun onEventMainThread(event: LoginStateChangeEvent) {
        val reason = event.reason
        val myInfo = event.myInfo
        if (myInfo != null) {
            val path: String
            val avatar = myInfo.avatarFile
            if (avatar != null && avatar.exists()) {
                path = avatar.absolutePath
            } else {
                path = FileHelper.getUserAvatarPath(myInfo.userName)
            }
            SharePreferenceManager.setCachedUsername(myInfo.userName)
            SharePreferenceManager.setCachedAvatarPath(path)
            //            JMessageClient.logout();
            var dialog= OtherLoginDialog()
            dialog.show(supportFragmentManager,"")
            DbUtils.DelUser()
            DbUtils.delMerchat()
            DrinkUtils.deleteALLDrinks()
            ServeUtils.deleteALLServe()
            OrderServeUtils.deleteAllOrder()
//                    JMessageClient.logout()
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
        }
//        when (reason) {
//            LoginStateChangeEvent.Reason.user_logout ->
//
//                //                JMessageClient.logout();
//                finish()
//            LoginStateChangeEvent.Reason.user_password_change -> {
//                val intent = Intent(this@BaseActivity, LoginActivity::class.java)
//                startActivity(intent)
//            }
//        }
        //                View.OnClickListener listener = new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        switch (v.getId()) {
        //                            case R2.id.jmui_cancel_btn:
        //                                Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
        //                                startActivity(intent);
        //                                break;
        //                            case R2.id.jmui_commit_btn:
        //                                JMessageClient.login(SharePreferenceManager.getCachedUsername(), SharePreferenceManager.getCachedPsw(), new BasicCallback() {
        //                                    @Override
        //                                    public void gotResult(int responseCode, String responseMessage) {
        //                                        if (responseCode == 0) {
        //                                            Intent intent = new Intent(BaseActivity.this, MainActivity.class);
        //                                            startActivity(intent);
        //                                        }
        //                                    }
        //                                });
        //                                break;
        //                        }
        //                    }
        //                };
        //                dialog = DialogCreator.createLogoutStatusDialog(BaseActivity.this, "您的账号在其他设备上登陆", listener);
        //                dialog.getWindow().setLayout((int) (0.8 * mWidth), WindowManager.LayoutParams.WRAP_CONTENT);
        //                dialog.setCanceledOnTouchOutside(false);
        //                dialog.show();
    }

}