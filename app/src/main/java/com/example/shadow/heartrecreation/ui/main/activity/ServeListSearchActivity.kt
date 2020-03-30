package com.example.shadow.heartrecreation.ui.main.activity

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.ACache
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.layoutUtils.getSearchNull
import com.example.shadow.heartrecreation.ui.main.adapter.SearchListAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListSearchBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeListSearchBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.ServeListSearchPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.ServeListSearchView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_serve_list_search.*
import kotlinx.android.synthetic.main.layout_error_search.*

class ServeListSearchActivity : BaseActivity(), ServeListSearchView {
    //搜索成功
    override fun getServeListSearchRequest(data: ServeListSearchBean) {
//        serarchRefresh.isRefreshing = false
        dismissLoading()
        History.visibility = View.GONE
        errorLayout.visibility = View.GONE
        if (pageIndex == 1) {
            serchAdapter = SearchListAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            serarchList.layoutManager = manager
            serarchList.adapter = serchAdapter
            serchAdapter.setEmptyView(getSearchNull())
        } else {
            serchAdapter.addData(data.data)
        }
        serchAdapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getServeListSearch(ServeListSearchBody(getUserToken(), searchEdit.getText().toString(), businessId, id, pageIndex, pageSize))
            }
        }, serarchList)
//        if (serchAdapter != null) {
//            serchAdapter.disableLoadMoreIfNotFullPage()
//            serchAdapter.setPreLoadNumber(1)
//        }
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                serchAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                serchAdapter!!.loadMoreComplete()
            }
        }else{
            serchAdapter!!.loadMoreComplete()
        }

        serchAdapter.setOnItemClickListener { adapter, view, position ->
            intentUsils.intentServeDetails(serchAdapter.data[position].userId,businessId,id)
        }


    }

    //搜索失败
    override fun getServeListSearchError() {
//        serarchRefresh.isRefreshing = false
        var h= Handler()
        h.postDelayed(object :Runnable{
            override fun run() {
                dismissLoading()
//                Log.e("点击","dismiss了")
                h.removeCallbacksAndMessages(null)
            }

        },1000)
        History.visibility = View.GONE
        errorLayout.visibility = View.VISIBLE
//        Click.viewClick(anewClick).subscribe {
//            pageIndex = 1
//            showLoading()
//            presenter.getServeListSearch(ServeListSearchBody(getUserToken(), searchEdit.getText().toString(), businessId, id, pageIndex, pageSize))
//        }
    }

    override fun openEventBus(): Boolean = false
    private val presenter by lazy { ServeListSearchPresenter(this, this, this) }
    private var pageIndex: Int = 1
    private var pageSize: Int = 10
    private var historyList = ArrayList<String>()
    private var id = 0
    private var businessId = ""
    private lateinit var serchAdapter: SearchListAdapter

    override fun getActivityLayout(): Int = R.layout.activity_serve_list_search

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        id = intent.getIntExtra("id", 0)
        var merchat = GreenDaoHelper.getDaoSessions().merchantDBDao
        if (merchat != null) {
            if (merchat.loadAll() != null && merchat.loadAll().size > 0) {
                businessId = merchat.loadAll().get(0).merchantID
            }
        }
        var mCache = ACache.get(this)
        mCache.getAsString("HistoryServe")
        if (mCache.getAsString("HistoryServe") != null && !"".equals(mCache.getAsString("HistoryServe"))) {
            historyList = Gson().fromJson(mCache.getAsString("HistoryServe"), ArrayList<String>()::class.java)
            searchHistory.setList(historyList)
            History.visibility = View.VISIBLE
        } else {
            History.visibility = View.GONE
        }
    }

    override fun clickListener() {
        Click.viewClick(searchOver).subscribe { finish() }
        searchEdit.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (searchEdit.text!=null&&searchEdit.text.toString()!=null&&!searchEdit.text.toString().equals("")) {
                    if (!historyList.contains(searchEdit.getText().toString())) {
                        historyList.add(searchEdit.getText().toString())
                    }
                    pageIndex = 1
//                LogUtils.a("${getUserToken() + searchEdit.getText().toString()}${businessId.toInt()}")
                    showLoading()
                    presenter.getServeListSearch(ServeListSearchBody(getUserToken(), searchEdit.getText().toString(), businessId, id, pageIndex, pageSize))
                }else {
                    Toast.Tips("请输入搜索内容")
                }
            }
            return@setOnEditorActionListener false
        }
        searchHistory.setOnItemClickListener { position, text ->
            searchEdit.setText(text)
            pageIndex = 1
            showLoading()
            presenter.getServeListSearch(ServeListSearchBody(getUserToken(), text, businessId, id, pageIndex, pageSize))
            History.visibility = View.GONE
        }
        Click.viewClick(delHistory).subscribe {
            historyList.clear()
            searchHistory.setList(historyList)
        }
//        serarchRefresh.setOnRefreshListener {
//            pageIndex = 1
//            presenter.getServeListSearch(ServeListSearchBody(getUserToken(), searchEdit.getText().toString(), businessId, id, pageIndex, pageSize))
//
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        var mCache = ACache.get(this)
        mCache.put("HistoryServe", Gson().toJson(historyList))
    }
}