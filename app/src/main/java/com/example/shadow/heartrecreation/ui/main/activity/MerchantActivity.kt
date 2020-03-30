package com.example.shadow.heartrecreation.ui.main.activity

import android.support.v4.app.Fragment
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.fragment.MerchantFragment
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMerchantListSearch
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.myproject.myproject.material_design.tablayout.FragmentAdapter
import kotlinx.android.synthetic.main.activity_merchant.*
import kotlinx.android.synthetic.main.layout_title.*

class MerchantActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false

    var mFragmentAdapter: FragmentAdapter? = null

    override fun getActivityLayout(): Int = R.layout.activity_merchant

    override fun setActivityTitle() {
        titleText.setText("选择约玩场地")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRight.setImageResource(R.mipmap.nav_button_search_pre)
    }

    override fun initActivityData() {
        var titles = ArrayList<String>()
        titles.add("距离最近")
//        titles.add("按消费")

        var fragments = ArrayList<Fragment>()

        titles.forEach {
            merchantTab.addTab(merchantTab.newTab().setText(it))
            fragments.add(MerchantFragment(it))
        }
        mFragmentAdapter = FragmentAdapter(getSupportFragmentManager(), fragments, titles)
        merchantPager.adapter = mFragmentAdapter
        merchantTab.setupWithViewPager(merchantPager)
        merchantTab.setTabsFromPagerAdapter(mFragmentAdapter)
        merchantPager.setOffscreenPageLimit(1)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(titleRight).subscribe { intentMerchantListSearch() }
    }

    override fun onDestroy() {
        super.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(mContext)//清除图片所有缓存
    }
}