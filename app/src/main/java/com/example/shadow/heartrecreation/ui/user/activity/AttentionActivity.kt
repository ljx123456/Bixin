package com.example.shadow.heartrecreation.ui.user.activity

import android.support.v4.app.Fragment
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.user.fragment.AttertionMerchantFragment
import com.example.shadow.heartrecreation.ui.user.fragment.AttertionServeFragment
import com.myproject.myproject.material_design.tablayout.FragmentAdapter
import kotlinx.android.synthetic.main.activity_attention.*
import kotlinx.android.synthetic.main.layout_title.*

class AttentionActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_attention
    private lateinit var mFragmentAdapter: FragmentAdapter
    override fun setActivityTitle() {
        titleText.setText("我的关注")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
        var titles = ArrayList<String>()
        titles.add("关注达人")
        titles.add("关注商家")
        var fragments = ArrayList<Fragment>()
        fragments.add(AttertionServeFragment())//达人
        fragments.add(AttertionMerchantFragment())//商家
        titles.forEach {
            attentionTab.addTab(attentionTab.newTab().setText(it))
        }
        mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
        attentionPager.adapter = mFragmentAdapter
        attentionTab.setupWithViewPager(attentionPager)
        attentionTab.setTabsFromPagerAdapter(mFragmentAdapter)
        attentionPager.setOffscreenPageLimit(1)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }
}