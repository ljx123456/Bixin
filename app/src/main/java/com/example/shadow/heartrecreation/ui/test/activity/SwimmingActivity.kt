package com.example.shadow.heartrecreation.ui.test.activity

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.test.util.*
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.layout_title.*
import kotlinx.android.synthetic.main.z_activity_swimming.*

class SwimmingActivity:BaseActivity(){

    private var list=ArrayList<Person>()

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.z_activity_swimming

    override fun setActivityTitle() {
        titleText.text="深海潜游"
//        titleRightText.text=""
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        var imagelist = ArrayList<ImageBanner>()
        imagelist.add(ImageBanner(R.drawable.b_1,false,2))
        imagelist.add(ImageBanner(R.drawable.b_2,false,2))
        imagelist.add(ImageBanner(R.drawable.b_3,false,2))
        Banner.setBanner(banner,imagelist)
        swipe_swim.isRefreshing=false

        initPerson()

        var adapter=Adapter(list)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        recy_swim.layoutManager = manager
        recy_swim.adapter = adapter
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickListener { adapte, view, position ->
            intentUtils.intentSwimmingDetails(adapter.data[position].id)
        }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe {
            finish()
        }
        swipe_swim.setOnRefreshListener {
            swipe_swim.isRefreshing=false
//            list.clear()
//            initPerson()
//
//            var adapter=Adapter(list)
//            var manager = LinearLayoutManager(mContext)
//            manager.orientation = LinearLayout.VERTICAL
//            recy_swim.layoutManager = manager
//            recy_swim.adapter = adapter
//            adapter.notifyDataSetChanged()
        }

        Click.viewClick(tv_mo).subscribe {
            tv_mo.setTextColor(Color.parseColor("#333333"))
            tv_price.setTextColor(Color.parseColor("#cccccc"))
            tv_b.setTextColor(Color.parseColor("#cccccc"))
            list.clear()
            initPerson()
            var adapter=Adapter(list)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            recy_swim.layoutManager = manager
            recy_swim.adapter = adapter
            adapter.setOnItemClickListener { adapte, view, position ->
                intentUtils.intentSwimmingDetails(adapter.data[position].id)
            }
        }

        Click.viewClick(tv_price).subscribe {
            tv_mo.setTextColor(Color.parseColor("#cccccc"))
            tv_price.setTextColor(Color.parseColor("#333333"))
            tv_b.setTextColor(Color.parseColor("#cccccc"))
            var list1=ArrayList<Person>()
            list1.add(list[0])
            list1.add(list[2])
            list1.add(list[1])
            list1.add(list[3])
            list1.add(list[4])
            var adapter=Adapter(list1)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            recy_swim.layoutManager = manager
            recy_swim.adapter = adapter
            adapter.setOnItemClickListener { adapte, view, position ->
                intentUtils.intentSwimmingDetails(adapter.data[position].id)
            }
        }

        Click.viewClick(tv_b).subscribe {
            tv_mo.setTextColor(Color.parseColor("#cccccc"))
            tv_price.setTextColor(Color.parseColor("#cccccc"))
            tv_b.setTextColor(Color.parseColor("#333333"))
            var list1=ArrayList<Person>()
            list1.add(list[3])
            list1.add(list[1])
            list1.add(list[4])
            list1.add(list[0])
            list1.add(list[2])
            var adapter=Adapter(list1)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            recy_swim.layoutManager = manager
            recy_swim.adapter = adapter
            adapter.setOnItemClickListener { adapte, view, position ->
                intentUtils.intentSwimmingDetails(adapter.data[position].id)
            }
        }


    }

    fun initPerson(){
        var list1=ArrayList<String>()
        list1.add("http://pic1.win4000.com/pic/4/9b/d9e57869f6.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/77cbefd82b.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/bdf864567c.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/59ef339334.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/c417a71e7b.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/14f47fbe3a.jpg")
        list.add(Person(0,"伊芙甜甜",2,22,"人事","1200","http://pic1.win4000.com/pic/4/9b/14f47fbe3a_250_350.jpg",list1))

        var list2=ArrayList<String>()
        list2.add("http://pic1.win4000.com/pic/b/20/ad5a2e0042.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/802b1f2238.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/2de6d4a808.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/6c899cf402.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/16eb25ff4c.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/b42b4ca4c5.jpg")
        list.add(Person(1,"秋秋哦",2,19,"驻唱","1500","http://pic1.win4000.com/pic/b/20/ad5a2e0042.jpg",list2))

        var list3=ArrayList<String>()
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521006.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521010.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521011.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521012.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521013.jpg")
//        list3.add("http://pic1.win4000.com/pic/b/20/b42b4ca4c5.jpg")
        list.add(Person(2,"╰ 沐子",2,21,"大学生","1350","http://pic1.win4000.com/pic/4/74/bc1d1521016_250_350.jpg",list3))

        var list4=ArrayList<String>()
        list4.add("http://pic1.win4000.com/pic/3/1e/b5275d9286.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/f2def9ff1d.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/0fdbde05bf.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/9091568770.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/ccf0fdcafc.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/fc345d34b2.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/d7e1925205.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/3c24496601.jpg")
        list.add(Person(3,"只倾心不倾城",2,24,"上班族","1800","http://pic1.win4000.com/pic/3/1e/fc345d34b2_250_350.jpg",list4))

        var list5=ArrayList<String>()
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311484.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311485.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311486.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311487.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311488.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311489.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311490.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311491.jpg")
        list.add(Person(4,"女神大人",2,27,"律师","2000","http://pic1.win4000.com/pic/4/c1/c6fd1311487_250_350.jpg",list5))
    }

}