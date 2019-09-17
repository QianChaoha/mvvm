package com.cqian.app.repository.remote;

/**
 * Description:
 * Data: 2018/7/2
 *
 * @author: cqian
 */

public class HttpUrl {
    //public static final String SERVER_URL = "https://api.web.internal-test.blockvalley.io";//UTMX测试环境-shineex测试
    //public static final String WS_SERVERURL_WEB = "api.websocket.internal-test.blockvalley.io";//UTMX测试环境-shineex测试
    public static final String SERVER_URL = "http://shinedev-web-api.blockvalley.io:88";//正式环境
    public static final String WS_SERVERURL_WEB = "shinedev-websocket.blockvalley.io:88";//正式环境
    //public static final String SERVER_URL = "https://api.web.shinex-demo.blockvalley.io";//Demo环境
    //public static final String WS_SERVERURL_WEB = "api.websocket.shinex-demo.blockvalley.io";//Demo环境
    //public static final String SERVER_URL = "http://excalibur-web-api.blockvalley.io:88";//测试环境   winbitex测试
    //public static final String WS_SERVERURL_WEB = "excalibur-websocket.blockvalley.io:88";//测试环境   winbitex测试
    //public static final String SERVER_URL = "https://api.web.miliang99.com";//米交所正式环境
    //public static final String WS_SERVERURL_WEB = "api.websocket.miliang99.com";//米交所正式环境
    //public static final String SERVER_URL = "http://10.0.5.215:8080";
    //public static final String WS_SERVERURL_WEB = "10.0.2.11:8080";
    //public static final String SERVER_URL = "https://api.web.winbitex.pro";//开发环境
    //public static final String WS_SERVERURL_WEB = "api.websocket.winbitex.pro";//开发环境
    public static final String WS_SERVERURL = "ws://" + WS_SERVERURL_WEB + "/ws";
    public static final String KLINE_SERVERURL = "http://" + WS_SERVERURL_WEB;
    public static final String TRADDING_VIEW_KLINE_SERVERURL = KLINE_SERVERURL + "/v1";
    //登录
    public static final String LOGIN = "/v1/user/login";
    //收藏交易对
    public static final String COLLET_TRADING_PAIR = "/v1/authed/market/collect_trading_pair";
    //取消收藏交易对
    public static final String CANCLE_TRADING_PAIR = "/v1/authed/market/cancel_trading_pair";
    //退出登录
    public static final String LOGOUT = "/v1/authed/user/logout";
    //个人信息
    public static final String GET_USER_INFO = "/v1/authed/user/query";
    //交易市场交易对信息
    public static final String GET_TRADING_PAIR = "/v1/market/get_trading_pair";
    //用户收藏交易对列表
    public static final String GET_COLLECT_TRADING_PAIR = "/v1/authed/market/get_trading_pair";
    //我的资产
    public static final String GET_USER_ASSERTS = "/v1/authed/assets/get_user_assets";
    //我的资产
    public static final String SET_HIDE_ZERO = "/v1/authed/assets/set_hide_zero_assets";
    //历史委托
    public static final String HISTORY_ORDER_LIST = "/v1/authed/trade/history_order_list";
    //当前委托
    public static final String ACTIVE_ORDER_LIST = "/v1/authed/trade/active_order_list";
    //创建订单
    public static final String CREATE_ORDER = "/v1/authed/trade/create_order";
    //取消订单
    public static final String CANCLE_ORDER = "/v1/authed/trade/cancel_order";
    //获取国家或区域
    public static final String GET_COUNTRY_CODE = "v1/get_country_code";
    //币种费率
    public static final String GET_CURRENCY_RATE = "/v1/assets/get_currency_rate";
    //根据交易对获取用户可用资产
    public static final String GET_USER_AVAILABLE_ASSERT = "/v1/authed/assets/get_user_available_assest";
    //检查输入的密码
    public static final String CHECK_PASSWORD = "/v1/authed/user/check_passwd";
    //检查输入的密码
    public static final String GET_BARS = "/v1/get_bars";
    //获取所有的币种信息
    public static final String GET_ALL_CURRENCY = "/v1/market/get_all_currency";
    //充值时币种的获取
    public static final String GET_CURRENCYS = "/v1/authed/assets/get_currencys";
    //检查用户是否存在
    public static final String CHECK_USER_EXIST = "/v1/user/check_user_exist";
    //发送验证码
    public static final String SEND_VERIFY_CODE = "/v1/user/send_verify_code";
    //检查验证码的准确性
    public static final String CHECK_VERIFICATION_CODE = "/v1/user/check_verification_code";
    //注册
    public static final String REGISTER = "/v1/user/register";
    //用户提币地址列表
    public static final String GET_WITHDRAWAL_ADDRESS = "/v1/authed/assets/get_withdrawal_address";
    //删除用户提币地址
    public static final String DELETE_WITHDRAWAL_ADDRESS = "/v1/authed/assets/delete_withdrawal_address";
    //获取提币币种及手续费
    public static final String GET_WITHDRAWAL_CURRENCY = "/v1/authed/assets/get_withdrawal_currency";
    //充币记录
    public static final String GET_USER_DEPOSIT_HISTORY = "/v1/authed/assets/get_user_deposit_history";
    //充币记录
    public static final String GET_WITHDRAWAL_HISTORIES = "/v1/authed/assets/get_withdrawal_histories";
    //用户取消提币
    public static final String CANCEL_WITHDRAWAL = "/v1/authed/assets/cancel_withdrawal";
    //根据币种获取充币地址
    public static final String GET_DEPOSIT_ADDRESS = "/v1/authed/assets/get_deposit_address";
    //增加用户提币地址
    public static final String ADD_WITHDRAWAL_ADDRESS = "/v1/authed/assets/add_withdrawal_address";
    //用户发起提币
    public static final String WITHDRAWAL = "/v1/authed/assets/withdrawal";
    //kyc认证
    public static final String KYC_VERI = "/v1/authed/kyc/create_or_update";
    //获取当前认证等级
    public static final String KYC_GET_LEVEL = "/v1/authed/kyc/get_level";
    //获取当前认证等级
    public static final String KYC_SIGN_PATH = "/v1/authed/kyc/sign_path";
    //两步验证-验证码验证
    public static final String VALIDATE_CODE = "/v1/authed/user/validate_2fa_code";
    //手机邮箱绑定
    public static final String UPDATE_AUTH = "/v1/authed/user/update_2fa_auth";
    //开启或关闭谷歌验证器
    public static final String TURN_ON_OFF_GOOGLE = "/v1/authed/user/turn_on_off_google_authenticator";
    //开启或关闭手机验证
    public static final String TURN_ON_OFF_SMS = "/v1/authed/user/turn_on_off_sms_authenticator";
    //绑定修改谷歌验证器
    public static final String BIND_UPDATE_GOOGLE = "/v1/authed/user/bind_or_update_google_authenticator";
    //生成谷歌验证器密钥
    public static final String GENERATE_GOOGLEE_KEY = "/v1/authed/user/generate_google_auth_key";
    //单独校验谷歌验证码
    public static final String VALIDATE_GOOGLE_CODE = "/v1/authed/user/validate_google_code";
    //用户配置
    public static final String KYC_LEVEL_CONFIG = "/v1/authed/kyc/kyc_level_config";
    //忘记密码里面的重置密码
    public static final String RESET_PASSWORD = "/v1/user/reset_password";
    //开启或关闭邮箱验证
    public static final String TURN_ON_OFF_EMAIL = "/v1/authed/user/turn_on_off_mail_authenticator";
    //检测手机配置
    public static final String CHECK_PHONE = "/v1/base_config";
    //发送验证码--带authed
    public static final String SEND_VERIFY_CODE_AUTHED = "/v1/authed/user/send_verification_code";
    //检查验证码的准确性--带authed
    public static final String CHECK_VERIFICATION_CODE_AUTHED = "/v1/authed/user/verification_code";
    //获取APP新版本
    public static final String GET_NEW_APP_VERSION = "/v1/app_version/get_new_app_version";
    //OTC数据列表
    public static final String GET_OTC_LIST = "/v1/simple_otc/list";
    //获取两步验证信息
    public static final String GET_2FACTOR_AUTH = "/v1/user/get_2factor_auth";
    //资产划转
    public static final String ASSET_TRANSFER = "/v1/authed/assets/asset_transfer";
    //划转记录
    public static final String TRANSFER_ORDER = "/v1/authed/assets/get_transfer_order_list";
    //设置昵称
    public static final String SET_NICK_NAME = "/v1/authed/otc/set_nickname";
    //获取OTC用户信息
    public static final String GET_OTC_USER_INFO = "/v1/authed/otc/user_info";
    //设置资金密码
    public static final String SET_ASSET_PASSWORD = "/v1/authed/otc/set_asset_password";
    //查询用户支付方式
    public static final String GET_USER_PAYMENT = "/v1/authed/otc/get_user_payment";
    //查询otc市场
    public static final String GET_OTC_MARKETS = "/v1/otc/get_markets";
    //查询otc交易对
    public static final String GET_OTC_TRADING_PAIRS = "/v1/otc/get_trading_pairs";
    //获取广告配置
    public static final String GET_OTC_AD_CONFIG = "/v1/otc/get_ad_config";
    //设置支付方式
    public static final String SET_PAYMENT = "/v1/authed/otc/set_payment";
    //查询用户联系方式
    public static final String GET_USER_CONTACT = "/v1/authed/otc/get_user_contact";
    //设置联系方式
    public static final String SET_CONTACT = "/v1/authed/otc/set_contact";
    //删除联系方式
    public static final String SELECT_CONTACT = "/v1/authed/otc/delete_contact";
    //查询商户申请状态
    public static final String GET_MERCHANT_STATUS = "/v1/authed/otc/get_merchant_status";
    //获取商户配置
    public static final String GET_MERCHANT_CONFIG = "/v1/otc/get_merchant_config";
    //商户申请
    public static final String APPLY_MERCHANT = "/v1/authed/otc/apply_merchant";
    //发布广告
    public static final String CREATE_ADVERTISEMENT = "/v1/authed/otc/create_advertisement";
    //获取广告列表
    public static final String GET_ADVERTISEMENT = "/v1/otc/get_advertisement";
    //查询商户信息
    public static final String GET_MERCHANT_INFO = "/v1/otc/get_merchant_info";
    //编辑广告
    public static final String EDIT_ADVERTISEMENT = "/v1/authed/otc/edit_advertisement";
    //下架广告
    public static final String UNPUBLISH_ADVERTISEMENT = "/v1/authed/otc/unpublish_advertisement";
}
