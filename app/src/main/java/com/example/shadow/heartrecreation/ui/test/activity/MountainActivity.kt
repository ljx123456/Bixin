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

class MountainActivity:BaseActivity(){
    private var list=ArrayList<Person>()

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int = R.layout.z_activity_swimming

    override fun setActivityTitle() {
        titleText.text="户外登山"
//        titleRightText.text=""
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        var imagelist = ArrayList<ImageBanner>()
        imagelist.add(ImageBanner(R.drawable.m_1,false,2))
        imagelist.add(ImageBanner(R.drawable.m_2,false,2))
        imagelist.add(ImageBanner(R.drawable.m_3,false,2))
        Banner.setBanner(banner,imagelist)
        swipe_swim.isRefreshing=false

        initPerson()

        var adapter= Adapter(list)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        recy_swim.layoutManager = manager
        recy_swim.adapter = adapter
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickListener { adapte, view, position ->
            intentUtils.intentMountainDetails(adapter.data[position].id)
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
            var adapter= Adapter(list)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            recy_swim.layoutManager = manager
            recy_swim.adapter = adapter
            adapter.setOnItemClickListener { adapte, view, position ->
                intentUtils.intentMountainDetails(adapter.data[position].id)
            }
        }

        Click.viewClick(tv_price).subscribe {
            tv_mo.setTextColor(Color.parseColor("#cccccc"))
            tv_price.setTextColor(Color.parseColor("#333333"))
            tv_b.setTextColor(Color.parseColor("#cccccc"))
            list.clear()
            initPerson()
            var adapter= Adapter(list)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            recy_swim.layoutManager = manager
            recy_swim.adapter = adapter
            adapter.setOnItemClickListener { adapte, view, position ->
                intentUtils.intentMountainDetails(adapter.data[position].id)
            }
        }

        Click.viewClick(tv_b).subscribe {
            tv_mo.setTextColor(Color.parseColor("#cccccc"))
            tv_price.setTextColor(Color.parseColor("#cccccc"))
            tv_b.setTextColor(Color.parseColor("#333333"))
            list.clear()
            initPerson()
            var adapter= Adapter(list)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            recy_swim.layoutManager = manager
            recy_swim.adapter = adapter
            adapter.setOnItemClickListener { adapte, view, position ->
                intentUtils.intentMountainDetails(adapter.data[position].id)
            }
        }


    }

    fun initPerson(){
        var list1=ArrayList<String>()
        list1.add("http://pic1.win4000.com/pic/2/eb/40cb53dba5.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/16a7873d41.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/2df1f174de.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/f5bfad0547.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/985ea7dc09.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/414cc0bf0e.jpg")
        list.add(Person(0,"锦瑟、华年",2,26,"健身教练","1800","http://pic1.win4000.com/pic/2/eb/985ea7dc09_250_350.jpg",list1))

        var list2=ArrayList<String>()
        list2.add("http://pic1.win4000.com/pic/4/b9/f5511249470.jpg")
        list2.add("http://pic1.win4000.com/pic/4/b9/f5511249471.jpg")
        list2.add("http://pic1.win4000.com/pic/4/b9/f5511249472.jpg")
//        list2.add("http://pic1.win4000.com/pic/b/20/6c899cf402.jpg")
//        list2.add("http://pic1.win4000.com/pic/b/20/16eb25ff4c.jpg")
//        list2.add("http://pic1.win4000.com/pic/b/20/b42b4ca4c5.jpg")
        list.add(Person(1,"绾痞",2,24,"品酒师","2200","http://pic1.win4000.com/pic/4/b9/f5511249474_250_350.jpg",list2))

        var list3=ArrayList<String>()
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528879.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528894.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528895.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528899.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528901.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528902.jpg")
        list.add(Person(2,"雪儿",2,26,"摄影爱好者","2500","http://pic1.win4000.com/pic/5/cd/5ea71528895_250_350.jpg",list3))

//        var list4=ArrayList<String>()
//        list4.add("http://pic1.win4000.com/pic/3/1e/b5275d9286.jpg")
//        list4.add("http://pic1.win4000.com/pic/3/1e/f2def9ff1d.jpg")
//        list4.add("http://pic1.win4000.com/pic/3/1e/0fdbde05bf.jpg")
//        list4.add("http://pic1.win4000.com/pic/3/1e/9091568770.jpg")
//        list4.add("http://pic1.win4000.com/pic/3/1e/ccf0fdcafc.jpg")
//        list4.add("http://pic1.win4000.com/pic/3/1e/fc345d34b2.jpg")
//        list4.add("http://pic1.win4000.com/pic/3/1e/d7e1925205.jpg")
//        list4.add("http://pic1.win4000.com/pic/3/1e/3c24496601.jpg")
//        list.add(Person(3,"只倾心不倾城",2,24,"上班族","1800","http://pic1.win4000.com/pic/3/1e/fc345d34b2_250_350.jpg",list4))
//
//        var list5=ArrayList<String>()
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311484.jpg")
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311485.jpg")
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311486.jpg")
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311487.jpg")
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311488.jpg")
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311489.jpg")
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311490.jpg")
//        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311491.jpg")
//        list.add(Person(4,"女神大人",2,27,"律师","2000","http://pic1.win4000.com/pic/4/c1/c6fd1311487_250_350.jpg",list5))
    }

}