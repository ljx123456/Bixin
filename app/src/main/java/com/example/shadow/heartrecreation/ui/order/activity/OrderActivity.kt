package com.example.shadow.heartrecreation.ui.order.activity

import android.support.v4.app.Fragment
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.order.fragment.OrderFragment
import com.myproject.myproject.material_design.tablayout.FragmentAdapter
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.layout_title.*

class OrderActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false
    var mFragmentAdapter: FragmentAdapter? = null
    override fun getActivityLayout(): Int = R.layout.activity_order

    override fun setActivityTitle() {
        titleText.setText("订单中心")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
        var titles = ArrayList<String>()
        titles.add("全部")
        titles.add("待支付")
        titles.add("进行中")
        titles.add("已完成")


        var fragments = ArrayList<Fragment>()

        titles.forEach {
            orderTab.addTab(orderTab.newTab().setText(it))
            fragments.add(OrderFragment(it))
        }
        mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
        orderPager.adapter = mFragmentAdapter
        orderTab.setupWithViewPager(orderPager)
        orderTab.setTabsFromPagerAdapter(mFragmentAdapter)
        orderPager.setOffscreenPageLimit(1)
//        orderPager.currentItem=0
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }
}