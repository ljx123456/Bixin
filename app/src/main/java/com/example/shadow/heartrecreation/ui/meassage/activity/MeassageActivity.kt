package com.example.shadow.heartrecreation.ui.meassage.activity

import android.content.DialogInterface
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import android.widget.TextView
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.model.Conversation
import cn.jpush.im.android.api.model.UserInfo
import com.example.shadow.heartrecreation.JMessage.ConversationListFragment
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
//import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MainBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.TipsBean
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.MainPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.MainView
import com.example.shadow.heartrecreation.ui.meassage.fragment.NotificationFragment
import com.example.shadow.heartrecreation.ui.meassage.mvp.presenter.MessagePresenter
import com.example.shadow.heartrecreation.ui.meassage.mvp.view.MessageView
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.flyco.tablayout.listener.CustomTabEntity
import com.myproject.myproject.material_design.tablayout.FragmentAdapter
import kotlinx.android.synthetic.main.activity_meassage.*
import kotlinx.android.synthetic.main.layout_title.*
import java.lang.Exception

class MeassageActivity : BaseActivity() ,MainView,MessageView{
    override fun getClearNotificationRequest() {
        messageTab.hideMsg(0)
        (fragments[messageLayout.currentItem] as NotificationFragment).init()
    }

    override fun getClearNotificationError() {

    }


    override fun getMainDataRequest(data: MainBean) {

    }

    override fun getMainDataErroe() {

    }

    override fun getTipsDataRequest(data: TipsBean) {
        if (data!=null&&data.data!=null){
            if (data.data.isMessageTips){
                messageTab.showDot(0)
            }else{
                messageTab.hideMsg(0)
            }
        }
    }

    override fun openEventBus(): Boolean = false
    var mFragmentAdapter: FragmentAdapter? = null
    private val presenter by lazy { MainPresenter(this,this,this) }
    var fragments = ArrayList<Fragment>()
    private val messagePresenter by lazy { MessagePresenter(this,this,this) }

    override fun getActivityLayout(): Int = R.layout.activity_meassage

    override fun setActivityTitle() {
        titleText.setText("消息中心")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRightText.visibility=View.VISIBLE
        titleRightText.text="清空"
    }

    override fun initActivityData() {
        var titles = ArrayList<String>()
        titles.add("通知")
        titles.add("聊天")


//        titles.forEach {
//            var tab=messageTab.newTab()
//            tab.setCustomView(R.layout.layout_tab_message)
//            var title=tab.customView!!.findViewById<TextView>(R.id.tabTitle)
//            title.text=it
//            var v=tab.customView!!.findViewById<View>(R.id.tabView)
//            v.visibility=View.VISIBLE
//            messageTab.addTab(tab)
//            messageTab.addTab(messageTab.newTab().setText(it))
//        }
        fragments.add(NotificationFragment())
        fragments.add(ConversationListFragment())

        mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
        messageLayout.adapter = mFragmentAdapter
        messageTab.setViewPager(messageLayout, arrayOf("通知","聊天"))
//        messageTab.setupWithViewPager(messageLayout)
//        messageTab.setTabsFromPagerAdapter(mFragmentAdapter)
        messageLayout.setOffscreenPageLimit(1)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(titleRightText).subscribe {

            ShowDialog.showCustomDialogs(this,"是否清空所有通知信息？","清空","取消",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
//                            presenter.getDelServices(DelServicesBody("${data.data.listId}"))
                            try {
                                if(fragments[messageLayout.currentItem] is NotificationFragment){
                                    messagePresenter.clearNotification()
                                }else if (fragments[messageLayout.currentItem] is ConversationListFragment){
                                    if (JMessageClient.getConversationList()!=null&&JMessageClient.getConversationList().size>0) {
                                        JMessageClient.getConversationList().forEach {
                                            var user=it.targetInfo as UserInfo
                                            JMessageClient.deleteSingleConversation(user.userName,user.appKey)
                                        }
                                        (fragments[messageLayout.currentItem] as ConversationListFragment).init()
                                        messageTab.hideMsg(1)
                                    }
                                }
                            }catch (e:Exception){
                                e.printStackTrace()
                            }
                            dialog.dismiss()
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }

            })


        }
    }

    override fun onResume() {
        super.onResume()
        if (JMessageClient.getAllUnReadMsgCount()>0){
            messageTab.showDot(1)
        }else{
            messageTab.hideMsg(1)
        }
        presenter.getTipsData()
    }

    fun init(){
        messageTab.hideMsg(0)
//        Log.e("测试","刷新")
    }
}