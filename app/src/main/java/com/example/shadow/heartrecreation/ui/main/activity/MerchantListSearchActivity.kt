package com.example.shadow.heartrecreation.ui.main.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.ACache
import com.example.shadow.heartrecreation.db.user.getlat
import com.example.shadow.heartrecreation.db.user.getlng
import com.example.shadow.heartrecreation.ui.layoutUtils.getSearchNull
import com.example.shadow.heartrecreation.ui.main.adapter.MerchantListSearchAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantListSearchBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantListSearchBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.MerchantListSearchPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.MerchantListSearchView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMerchantDetails
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_merchant_list_search.*
import kotlinx.android.synthetic.main.layout_error_search.*

class MerchantListSearchActivity : BaseActivity(), MerchantListSearchView {
    //获取到数据
    override fun getMerchantListSearchRequest(data: MerchantListSearchBean) {
//        serarchRefresh.isRefreshing = false
        serarchList.visibility=View.VISIBLE
        History.visibility = View.GONE
        errorLayout.visibility = View.GONE
        if (pageIndex == 1) {
            listAdapter = MerchantListSearchAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            serarchList.layoutManager = manager
            serarchList.adapter = listAdapter
            listAdapter.setEmptyView(getSearchNull())
        } else {
            listAdapter.addData(data.data)
        }
        listAdapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getMerchantListSearch(MerchantListSearchBody(getlng(), getlat(), "${pageIndex}", "${pageSize}", searchEdit.text.toString()))
            }
        }, serarchList)
        if (listAdapter != null) {
            listAdapter!!.disableLoadMoreIfNotFullPage()
            listAdapter!!.setPreLoadNumber(2)
        }
        listAdapter.setOnItemClickListener { adapter, view, position ->
            intentMerchantDetails("${listAdapter.data.get(position).businessId}",0)
        }
    }

    //获取数据失败
    override fun getMerchantListSearchError() {
//        serarchRefresh.isRefreshing = false
        History.visibility = View.GONE
        serarchList.visibility=View.GONE
        errorLayout.visibility = View.VISIBLE
//        Click.viewClick(anewClick).subscribe {
//            pageIndex = 1
//            presenter.getMerchantListSearch(MerchantListSearchBody(getlng(), getlat(), "${pageIndex}", "${pageSize}", searchEdit.text.toString()))
//        }
    }

    override fun openEventBus(): Boolean = false
    private var historyList = ArrayList<String>()
    private var pageIndex: Int = 1
    private var pageSize: Int = 10
    override fun getActivityLayout(): Int = R.layout.activity_merchant_list_search
    private lateinit var listAdapter: MerchantListSearchAdapter
    private val presenter by lazy { MerchantListSearchPresenter(this, this, this) }

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        var mCache = ACache.get(this)
        if (mCache.getAsString("HistoryMerchant") != null && !"".equals(mCache.getAsString("HistoryMerchant"))) {
            historyList = Gson().fromJson(mCache.getAsString("HistoryMerchant"), ArrayList<String>()::class.java)
            if (historyList.size > 0) {
                searchHistory.setList(historyList)
                searchHistory.visibility = View.VISIBLE
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
                    pageIndex = 1
                    presenter.getMerchantListSearch(MerchantListSearchBody(getlng(), getlat(), "${pageIndex}", "${pageSize}", searchEdit.text.toString()))
                }else{
                    Toast.Tips("请输入搜索内容")
                }

            }
            return@setOnEditorActionListener false
        }
        searchHistory.setOnItemClickListener { position, text ->
            searchEdit.setText(text)
            pageIndex = 1
            presenter.getMerchantListSearch(MerchantListSearchBody(getlng(), getlat(), "${pageIndex}", "${pageSize}", searchEdit.text.toString()))
            searchHistory.visibility = View.GONE
        }
        Click.viewClick(delHistory).subscribe {
            historyList.clear()
            searchHistory.setList(historyList)
            searchHistory.visibility = View.GONE
        }
//        serarchRefresh.setOnRefreshListener {
//            pageIndex = 1
//            presenter.getMerchantListSearch(MerchantListSearchBody(getlng(), getlat(), "${pageIndex}", "${pageSize}", searchEdit.text.toString()))
//
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        var mCache = ACache.get(this)
        mCache.put("HistoryMerchant", Gson().toJson(historyList))
    }
}