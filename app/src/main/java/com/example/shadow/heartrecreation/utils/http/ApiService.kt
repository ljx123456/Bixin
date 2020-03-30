package com.example.shadow.heartrecreation.utils.http

import com.example.shadow.heartrecreation.ui.login.mvp.bean.*
import com.example.shadow.heartrecreation.ui.login.mvp.body.*
import com.example.shadow.heartrecreation.ui.main.mvp.bean.*
import com.example.shadow.heartrecreation.ui.main.mvp.body.*
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.*
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.*
import com.example.shadow.heartrecreation.ui.order.mvp.bean.*
import com.example.shadow.heartrecreation.ui.order.mvp.body.*
import com.example.shadow.heartrecreation.ui.user.mvp.bean.*
import com.example.shadow.heartrecreation.ui.user.mvp.body.*
import io.reactivex.Observable
import okhttp3.ResponseBody
//import org.mp4parser.aspectj.lang.annotation.Pointcut
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Administrator on 2017/12/18 0018.
 */
interface ApiService {
    //验证码登录
    @POST("rl/login/by/code")
    fun getByCode(@Body body: ByCodeBody): Observable<ByCodeBean>

    //发送验证码接口
    @POST("sms/send/code")
    fun getSendCode(@Body body: SendCodeBody): Observable<SendCodeBean>

    //验证码，验证
    @POST("sms/validationCode")
    fun getValidationCode(@Body body: ValidationCodeBody): Observable<ValidationCodeBean>

    //密码登录
    @POST("rl/login/by/pwd")
    fun getByPwd(@Body body: ByPwdBody): Observable<ByCodeBean>

    //完善用户资料
    @POST("rl/perfected/user/info")
    fun setRegData(@Body body: RegDataBody): Observable<ByCodeBean>

    //昵称校验
    @POST("public/check/name")
    fun getCheckName(@Body body: CheckNameBody): Observable<CheckNameBean>

    //忘记密码
    @POST("rl/forget/pwd")
    fun getResetPwd(@Body body: ResetPwdBody): Observable<ResetPwdBean>

    //KTV列表
    @POST("nearby/find/all")
    fun getMerchant(@Body body: MerchantBody): Observable<MerchantBean>

    //商家详情
    @POST("order/show/box")
    fun getMerchantDetails(@Body body: MerchantDetailsBody): Observable<MerchantDetailsBean>

    //查询商家优惠券
    @POST("coupon/business/find/all")
    fun getCoupons(@Body body: CouponsBody): Observable<CouponsBean>

    //用户领取商家优惠券
    @POST("coupon/user/add")
    fun getCouponUserAdd(@Body body: CouponUserAddBody): Observable<CouponUserAddBean>

    //歌唱达人列表
    @POST("public/query/home/page/user")
    fun getServeList(@Body body: ServeListBody): Observable<ServeListBean>

    //达人详情
    @POST("public/query/service/user/details")
    fun getServeDetails(@Body body: ServeDetailsBody): Observable<ServeDetailsBean>

    //KTV酒水展示(03-酒水其他)
    @POST("wine/find/all")
    fun getDrinks(@Body body: DrinksBody): Observable<DrinksBean>

    //订单列表
    @POST("user/order/orderList")
    fun getOrderList(@Body body: OrderListBody): Observable<OrderListBean>

    //删除订单
    @POST("user/order/delete")
    fun getDelOrder(@Body body: DelOrderBody): Observable<DelOrderBean>

    //订单详情
    @POST("user/order/details")
    fun getOrderDetails(@Body body: OrderDetailsBody): Observable<OrderDetailsBean>

    //首页数据home/page/info
    @POST("home/page/info")
    fun getMainData(): Observable<MainBean>

    //首页侧滑栏红点
    @POST("user/tips")
    fun getTipsData(): Observable<TipsBean>

    //用户关注或取消关注一个达人
    @POST("fans/change")
    fun getFansChange(@Body body: FansChangeBody): Observable<FansChangeBean>

    //用户举报一个达人
    @POST("report/add")
    fun getReport(@Body body: ReportBody): Observable<FansChangeBean>

    //提交订单并选择支付(扫码下单)
    @POST("pay/goPay")
    fun getPay(@Body body: PayBody): Observable<ResponseBody>

    //条件搜索附近服务人员
    @POST("public/query/service/user/like")
    fun getServeListSearch(@Body body: ServeListSearchBody): Observable<ServeListSearchBean>

    //获取职业列表
    @POST("public/occupation/info")
    fun getOccupation(): Observable<OccupationBean>

    //条件搜索附近ktv
    @POST("nearby/find/like")
    fun getMerchantListSearch(@Body body: MerchantListSearchBody): Observable<MerchantListSearchBean>

    //用户关注或取消关注一个商家
    @POST("follow/change")
    fun getFollowChange(@Body body: FollowChangeBody): Observable<FollowChangeBean>

    //获取预约时间范围
    @POST("order/show/time")
    fun getOrderShowTime(@Body body: OrderShowTimeBody): Observable<OrderShowTimeBean>

    //用户可使用优惠卷查询
    @POST("coupon/user/find")
    fun getUserFind(@Body body: UserFindBody): Observable<UserFindBean>

    //查询用户关注过的所有达人
    @POST("fans/find/all")
    fun getAttertionServe(@Body body: AttertionServeBody): Observable<AttertionServeBean>

    //查询用户关注过的所有商家
    @POST("follow/find/all")
    fun getAttertionMerchant(@Body body: AttertionMerchantBody): Observable<AttertionMerchantBean>

    //黑名单列表
    @POST("user/black/list")
    fun getBlackList(@Body body: BlackListBody): Observable<BlackListBean>

    //提交意见反馈
    @POST("feedback/add")
    fun getFeedbackAdd(@Body body: FeedbackAddBody): Observable<FeedbackAddBean>

    //存酒列表
    @POST("wine/find/storage/list")
    fun getWine(@Body body: WineBody): Observable<WineBean>

    //存酒列表-详情
    @POST("wine/find/storage/info")
    fun getBusiness(@Body body: BusinessBody): Observable<BusinessBean>

    //退款页面
    @POST("user/order/refundPage")
    fun getRefund(@Body body: RefundBody): Observable<RefundBean>

    //退款详情
    @POST("user/order/refundDetail")
    fun getRefundMerchant(@Body body: RefundMerchantBody): Observable<RefundMerchantBean>

    //退款详情
    @POST("user/order/refundDetail")
    fun getRefundServe(@Body body: RefundServeBody): Observable<RefundServeBean>

    //获取七牛token
    @POST("public/qiniu/upload/token")
    fun getQiniuToken(): Observable<QiniuTokenBean>

    //编辑用户信息
    @POST("user/edit")
    fun getUserEdit(@Body body: UserEditBody): Observable<UserEditBean>

    //取消订单
    @POST("user/order/cancelOrder")
    fun getCancelOrder(@Body body: CancelOrderBody): Observable<CancelOrderBean>

    //订单详情_查看邀请列表
    @POST("user/order/services")
    fun getOrderServices(@Body body: OrderServicesBody): Observable<OrderServicesBean>

    //邀请名单_重新邀请
    @POST("pay/reInvite")
    fun getPayReInvite(@Body body: PayReInviteBody): Observable<PayReInviteBean>

    //邀请名单_删除全部邀请（只会删除未支付的）
    @POST("user/order/delServices")
    fun getDelServices(@Body body: DelServicesBody): Observable<DelServicesBean>

    //通知_消息
    @POST("user/userNotice")
    fun getNotification(@Body body: NotificationBody): Observable<NotificationBean>

    //读取通知
    @POST("user/userNotice/read")
    fun getReadNotification(@Body body: ReadNotificationBody): Observable<ReadNotificationBean>

    //清空通知
    @POST("user/userNotice/clear")
    fun getClearNotification(): Observable<ClearNotificationBean>

    //举报详情
    @POST("user/userNotice/reportDetails")
    fun getReportDetails(@Body body: ReportDetailsBody): Observable<ReportDetailsBean>

    //反馈详情
    @POST("user/userNotice/feedbackDetails")
    fun getFeedBackDetails(@Body body: FeedBackDetailsBody): Observable<FeedBackDetailsBean>

    //条件搜索经纪人
    @POST("public/query/broker/user/like")
    fun getBroker(@Body body: BrokerBody): Observable<BrokerBean>

    //添加点单达人
    @POST("user/order/addPointListService")
    fun getAddPointListService(@Body body: AddPointListServiceBody): Observable<AddPointListServiceBean>

    //订单支付
    @POST("pay/payAgain")
    fun getPayAgain(@Body body: PayAgainBody): Observable<ResponseBody>

    //取消服务
    @POST("user/order/cancelService")
    fun getCancelService(@Body body: CancelServiceBody): Observable<CancelServiceBean>

    //退出登录
    @POST("public/logout")
    fun getLogout(@Body logoutBody: LogoutBody): Observable<LogoutBean>

    //付款服务订单
    @POST("pay/payService")
    fun getPayService(@Body body: PayServiceBody): Observable<ResponseBody>

    //重新付款服务订单
    @POST("pay/payAgainService")
    fun getPayServiceAgain(@Body body: PayServiceAgainBody): Observable<ResponseBody>

    //订单中心_评价
    @POST("user/order/evaluateOrder")
    fun getEvaluateOrder(@Body body: EvaluateOrderBody): Observable<EvaluateOrderBean>

    //订单中心_投诉理由
    @POST("user/order/complaints/service/reason")
    fun getReason(@Body body: ReasonBody): Observable<ReasonBean>

    //订单中心_提交投诉
    @POST("user/order/complaints/service")
    fun getComplaint(@Body body: ComplaintBody): Observable<ComplaintBean>

    //订单中心_投诉详情
    @POST("user/order/complaints/service/details")
    fun getComplaintDetails(@Body body: ComplaintDetailsBody): Observable<ComplaintDetailsBean>

    //APP 是否更新
    @POST("app/is/update")
    fun getUpdate(@Body body: UpdateBody): Observable<UpdateBean>

    //更新用户城市
    @POST("user/updateCityInfo")
    fun getUpdateCity(@Body body: UpdateCityBody): Observable<UpdateCityBean>

    //添加或移除黑名单
    @POST("user/black/change")
    fun getBlackChange(@Body body: BlackChangeBean): Observable<BlackChangeBean>

    //城市列表
    @POST("public/query/city/list/new")
    fun getCityList(): Observable<CityListBean>

    //获取酒水套餐详情
    @POST("wine/details/info")
    fun getDrinkDetails(@Body body: DrinkDetailsBody): Observable<DrinkDetailsBean>

    //发起更多邀请
    @POST("pay/moreInvite")
    fun getMoreInvite(@Body body: MoreInviteBody): Observable<MoreInviteBean>

    //添加酒水
    @POST("pay/addWine")
    fun getAddWine(@Body body: AddWineBody): Observable<ResponseBody>

    //取酒列表
    @POST("wine/find/take/record/list")
    fun getTakeRecordList(@Body takeRecordListBody: TakeRecordListBody): Observable<TakeRecordListBean>

    //存酒列表-详情-存酒记录
    @POST("wine/find/storage/record")
    fun getStorageRecord(@Body body: StorageRecordBody): Observable<StorageRecordBean>

    //存酒列表-详情-取酒记录
    @POST("wine/find/take/record")
    fun getTakeRecord(@Body body: StorageRecordBody): Observable<StorageRecordBean>

    //存酒列表-详情-过期记录
    @POST("wine/find/expire/record")
    fun getExpireRecord(@Body body: ExpireRecordBody): Observable<ExpireRecordBean>


    //存酒记录列表
    @POST("wine/find/sto/record/list")
    fun getRecordLists(@Body takeRecordListBody: TakeRecordListBody): Observable<TakeRecordListBean>


    //存酒记录详情
    @POST("wine/find/sto/record/info")
    fun getRecordDetailsOne(@Body body: RecordDetailsOneBody): Observable<RecordDetailsOneBean>

    //取酒记录列表
    @POST("wine/find/take/record/list")
    fun getRecordList(@Body takeRecordListBody: TakeRecordListBody): Observable<TakeRecordListBean>

    //取酒记录详情
    @POST("wine/find/take/record/info")
    fun getRecordInfo(@Body recordDetailsOneBody: RecordDetailsOneBody): Observable<RecordInfoBean>

    //过期记录列表
    @POST("wine/find/expire/record/list")
    fun getExpireRecordList(@Body takeRecordListBody: TakeRecordListBody): Observable<TakeRecordListBean>

    //过期记录详情
    @POST("wine/find/expire/record/info")
    fun getExpireRecordInfo(@Body body: ExpireRecordInfoBody): Observable<ExpireRecordInfoBean>

    //扫码获取包房信息
    @POST("public/find/business/box/info")
    fun getKTVBox(@Body body: KTVBoxBody): Observable<KTVBoxBean>

    //扫码获取订单信息
    @POST("user/order/makeOrderData")
    fun getOrderCode(@Body body: OrderCodeBody): Observable<OrderCodeBean>

    //扫码获取酒水信息
    @POST("user/order/makeWineOrderData")
    fun getWineCode(@Body body: WineCodeBody): Observable<WineCodeBean>


    //修改密码
    @POST("user/change/login/pwd")
    fun getChangePW(@Body body: ChangePWBody): Observable<ChangePWBean>
}