package com.example.shadow.heartrecreation.ui.user.activity

import android.support.v4.app.Fragment
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.user.fragment.RefundFragment
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.myproject.myproject.material_design.tablayout.FragmentAdapter
import kotlinx.android.synthetic.main.activity_refund.*
import kotlinx.android.synthetic.main.layout_title.*

class RefundActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false
    var mFragmentAdapter: FragmentAdapter? = null
    override fun getActivityLayout(): Int = R.layout.activity_refund

    override fun setActivityTitle() {
        titleText.setText("退款")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRight.setImageResource(R.mipmap.singerdetails_button_doubt)
    }

    override fun initActivityData() {
        var titles = ArrayList<String>()
        titles.add("处理中")
        titles.add("已完成")
        var fragments = ArrayList<Fragment>()
        titles.forEach {
            brokerTab.addTab(brokerTab.newTab().setText(it))
            fragments.add(RefundFragment(it))
        }
        mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
        brokerPager.adapter = mFragmentAdapter
        brokerTab.setupWithViewPager(brokerPager)
        brokerTab.setTabsFromPagerAdapter(mFragmentAdapter)
        brokerPager.setOffscreenPageLimit(1)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(titleRight).subscribe {
            intentUtils.intentHtml(2)
        }
    }
}