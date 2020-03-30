package com.example.shadow.heartrecreation.ui.user.activity

import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout

import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.ACache
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.DrinkUtils
import com.example.shadow.heartrecreation.db.ServeUtils.deleteALLServe
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.UIUtils

import com.example.shadow.heartrecreation.ui.user.adapter.BrokerHistoryAdapter
import com.example.shadow.heartrecreation.ui.user.dialog.BrokerAddsDialog
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BrokerBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BrokerBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.BrokerPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.BrokerView
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.activity_broker.*
import kotlinx.android.synthetic.main.item_search_list.*
import kotlinx.android.synthetic.main.layout_error_search.*

class BrokerActivity : BaseActivity(), BrokerView {

    override fun getBrokerRequest(data: BrokerBean) {
        if (data!=null&&data.data!=null&&data.data.nickname!=null&&!data.data.nickname.equals("")) {
            errorLayout.visibility = View.GONE
            History.visibility = View.GONE
            var item = data.data
            if (item != null) {
                if (item.nickname != null && !item.nickname.equals("")) {
                    itemSearchList.visibility = View.VISIBLE
                    searchLayout.visibility=View.VISIBLE
                    searchName.text = item.nickname
                    searchAge.text = "${item.age}"
                    searchBx.text="(ID:${item.bixinId})"
                    var occ=""
                    if (item.occupationName!=null&&item.occupationName!="") {
                        occ=item.occupationName
                        searchJoin.text = item.occupationName
                        searchJoin.visibility=View.VISIBLE
                    }else{
                        searchJoin.visibility=View.GONE
                    }
//                    searchAdds.text = item.km
//                    searchType.text = item.state
                    yue.text = "设置经纪人"
//                when (item.sex) {
//                    1 -> searchAge.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//                    else -> searchAge.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//                }
                    UIUtils.setAgeUtils(searchAge, item.sex, "${item.age}")
                    ImageLoad.setUserHead(item.avatar, serveImage as RoundedImageView)
                    Click.viewClick(yue).subscribe {
                        if (item.businessInfo!=null&&item.businessInfo.size>0&&item.businessInfo[0]!=null) {
                            DbUtils.delMerchat()//删除服务地址
                            DrinkUtils.deleteALLDrinks()//删除所有酒水
                            deleteALLServe()//删除所有服务人员
                            user.setNum("0")
                            brokeraddsdialog.setData("纵享欢唱", 1, 1, "${item.userId}",
                                    item.avatar,
                                    item.nickname,
                                    "${item.age}",
                                    "${item.sex}",
                                    occ,
                                    item.businessInfo)
                            brokeraddsdialog.show(supportFragmentManager, "")
//                intentYue("纵享欢唱", 1, 1, "${item.userId}",
//                        item.avatar,
//                        item.nickname,
//                        "${item.age}",
//                        "${item.sex}",
//                        item.occupationName,
//                        "${item.businessId}",
//                        item.businessName)
                        }else{
                            Toast.Tips("该经纪人未开启商家服务")
                        }
                    }
                }
            }
        }else{
            History.visibility = View.GONE
            errorLayout.visibility = View.VISIBLE
            workTextView.text="该经济人不存在，请输入正确的经纪人id"
//            Click.viewClick(anewClick).subscribe {
//                presenter.getBroker(BrokerBody(searchEdit.getText().toString()))
//            }
        }
    }

    override fun getBrokerError() {
        History.visibility = View.GONE
        errorLayout.visibility = View.VISIBLE
//        Click.viewClick(anewClick).subscribe {
//            presenter.getBroker(BrokerBody(searchEdit.getText().toString()))
//        }
    }

    override fun openEventBus(): Boolean = false
    private var historyList = ArrayList<String>()
    private val brokeraddsdialog = BrokerAddsDialog()
    private val presenter by lazy { BrokerPresenter(this, this, this) }
    override fun getActivityLayout(): Int = R.layout.activity_broker
    private lateinit var history: BrokerHistoryAdapter

    override fun setActivityTitle() {
        ShowDialog.showCustomDialog(this, "达人经纪人", "达人经纪人为达人管理员，当您在约玩过程中有任何与达人相关的疑问或需求都可以和达人经纪人沟通联系，会及时为您做出安排调整。 祝您约玩愉快！", "我知道了", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, which: Int) {
                dialog.dismiss()
            }
        })
    }

    override fun initActivityData() {
        itemSearchList.visibility = View.GONE

        var mCache = ACache.get(this)
        if (mCache.getAsString("BrokerHistory") != null && !"".equals(mCache.getAsString("BrokerHistory"))) {
            historyList = Gson().fromJson(mCache.getAsString("BrokerHistory"), ArrayList<String>()::class.java)
            if (historyList.size > 0) {
                searchHistory.setList(historyList)
                searchHistory.visibility=View.VISIBLE
//                history = BrokerHistoryAdapter(historyList)
//                var manager = LinearLayoutManager(this)
//                manager.orientation = LinearLayout.VERTICAL
//                searchHistory.layoutManager = manager
//                searchHistory.adapter = history
//                History.visibility = View.VISIBLE
//                history.setOnItemClickListener { adapter, view, position ->
//                    History.visibility = View.GONE
//                    searchEdit.setText(history.data.get(position))
//                    presenter.getBroker(BrokerBody(history.data.get(position)))
//                }
            } else {
                searchHistory.visibility = View.GONE
            }
        } else {
            searchHistory.visibility = View.GONE
        }
    }

    override fun clickListener() {
        Click.viewClick(searchOver).subscribe { finish() }
        searchEdit.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (searchEdit.text!=null&&searchEdit.text.toString()!=null&&!searchEdit.text.toString().equals("")){
                    if (!historyList.contains(searchEdit.getText().toString())) {
                        historyList.add(searchEdit.getText().toString())
                    }
                    presenter.getBroker(BrokerBody(searchEdit.getText().toString()))
                }else{
                    Toast.Tips("请输入搜索内容")
                }
            }
            return@setOnEditorActionListener false
        }

        searchHistory.setOnItemClickListener { position, text ->
            History.visibility = View.GONE
            searchEdit.setText(text)
            presenter.getBroker(BrokerBody(searchEdit.getText().toString()))
        }


        Click.viewClick(delHistory).subscribe {
            historyList.clear()
            searchHistory.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        var mCache = ACache.get(this)
        mCache.put("BrokerHistory", Gson().toJson(historyList))
    }
}