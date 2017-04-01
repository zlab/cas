package net.zhanqi.app.cas.action.open;

import net.zhanqi.app.cas.service.UserService;

/**
 * QqAction
 * 
 * @author zhanqi
 * @since 2012-10-18
 */
public class QqAction extends OpenAction {

    // private static final String QQ_CLIENT = "QQClient";

    public static final String QZONE_USER_INFO = "qzone-user-info";
    public static final String WEIBO_USER_INFO = "weibo-user-info";

    // private ConnectService service;
    // private UserService userService;

    public void setUserService(UserService userService) {
        // this.userService = userService;
    }

    // public String oauth() throws Exception {
    //
    // // 正在绑定
    // if (getSession().getAttribute(OPEN_USER) != null) {
    // return SIGN_UP;
    // }
    //
    // OauthRequest req = new OauthRequest();
    //
    // // 检测 AuthorizationCode
    // String code = rc.getParam("code");
    // if (StringUtils.isBlank(code)) {
    // // 获取AuthorizationCode
    // req.setState(rc.getToken("qzoneState"));
    // rc.redirect(qc.authorize(req));
    // return null;
    // }
    //
    // // CSRF
    // checkInvalid(!rc.validateToken("qzoneState", "state", true),
    // "CSRF ATTACK ING");
    //
    // // 获取AccessToken
    // req.setCode(code);
    //
    // Result<OpenUser> rs = qc.accessToken(req);
    // checkInvalid(!rs.isSuccess(), rs.getMsg());
    //
    // String accessToken = rs.getData().getAccessToken();
    // req.setAccessToken(accessToken);
    //
    // // OpenId
    // rs = qc.me(req);
    // checkInvalid(!rs.isSuccess(), rs.getMsg());
    //
    // String openId = rs.getData().getOpenId();
    // SysUser loginUser = getLoginUser();
    // SysUser user = null;
    //
    // // 已登录
    // if (loginUser != null) {
    //
    // // 要绑定的正好是当前登录用户
    // if (openId.equals(loginUser.getQqOpenId())) {
    // // 更新 DB accessToken
    // if (!accessToken.equals(loginUser.getQqAccessToken())) {
    // loginUser.setQqAccessToken(accessToken);
    // userService.update(loginUser);
    // }
    // return USER_HOME;
    // }
    //
    // // 已被绑定，先解除绑定
    // user = new SysUser();
    // user.setQqOpenId(openId);
    // user = userService.queryUser(user);
    // if (user != null) {
    // user.setQqOpenId("");
    // user.setQqAccessToken("");
    // userService.update(user);
    // }
    //
    // // 重新与当前已登录帐号绑定
    // loginUser.setQqOpenId(openId);
    // loginUser.setQqAccessToken(accessToken);
    // userService.update(loginUser);
    //
    // return USER_HOME;
    // }
    //
    // // 没有登录，但是已被绑定
    // user = new SysUser();
    // user.setQqOpenId(openId);
    // user = userService.queryUser(user);
    // if (user != null) {
    // // 更新 DB accessToken
    // if (!accessToken.equals(user.getQqAccessToken())) {
    // user.setQqAccessToken(accessToken);
    // userService.update(user);
    // }
    //
    // // 已绑定帐号，登录成功！
    // setLoginUser(user);
    //
    // return USER_HOME;
    // }
    //
    // // 没有登录，也没有被绑定
    // // 1：绑定到已有帐号
    // // 2：创建新帐号
    // Result<String> irs = getQzoneUserInfo(accessToken, openId);
    // checkInvalid(!irs.isSuccess(), irs.getMsg());
    //
    // JSONObject json = JSONObject.fromObject(irs.getData());
    // OpenUser openUser = new OpenUser();
    // openUser.setPlatform("qq");
    // openUser.setOpenId(openId);
    // openUser.setAccessToken(accessToken);
    // openUser.setNickname(json.getString("nickname"));
    // openUser.setAvatar(json.getString("figureurl_2"));
    //
    // getSession().getAttribute(OPEN_USER, openUser);
    //
    // return SIGN_UP;
    // }
    //
    // /**
    // * 注册并绑定
    // */
    // @Override
    // public String register() throws Exception {
    //
    // OpenUser openUser = (OpenUser) getSession().getAttribute(OPEN_USER);
    //
    // checkNull(openUser, "请重新登录QQ申请授权");
    //
    // String email = rc.getParam("email");
    // String password = rc.getParam("password");
    //
    // checkBlank(email, "邮箱不能为空");
    // checkInvalid(!ValidateUtils.validateEmail(email), "邮箱格式不合法");
    // checkBlank(password, "密码不能为空");
    //
    // SysUser user = new SysUser();
    // user.setEmail(email);
    // user = userService.queryUser(user);
    // checkInvalid(user != null, "该邮箱帐号已被注册");
    //
    // user = new SysUser();
    // user.setEmail(email);
    // user.setPassword(DigestUtils.md5Hex(password));
    // user.setQqOpenId(openUser.getOpenId());
    // user.setQqAccessToken(openUser.getAccessToken());
    // user.setActiveKey(CommonUtils.getMd5());
    // user.setUsername(user.getEmail());
    // user.setStatus(0);
    //
    // userService.save(user);
    //
    // setLoginUser(user);
    //
    // getSession().getAttribute(OPEN_USER, null);
    //
    // // 发送激活邮件
    // EmailUtils.sendActiveEmail(user.getEmail(), user.getActiveKey());
    //
    // rc.renderSuccess("注册成功，请登陆邮箱激活账号");
    //
    // return null;
    // }
    //
    // /**
    // * 绑定已有帐号
    // */
    // public String bind() throws Exception {
    //
    // OpenUser openUser = (OpenUser) getSession().getAttribute(OPEN_USER);
    //
    // checkNull(openUser, "请重新登录QQ申请授权");
    //
    // String email = rc.getParam("email");
    // String password = rc.getParam("password");
    //
    // checkBlank(email, "邮箱不能为空");
    // checkInvalid(!ValidateUtils.validateEmail(email), "邮箱格式不合法");
    // checkBlank(password, "密码不能为空");
    //
    // SysUser user = new SysUser();
    // user.setEmail(email);
    // user = userService.queryUser(user);
    // checkNull(user, "该邮箱帐号未注册");
    // CheckUtils.checkInvalid(DigestUtils.md5Hex(password).equals(user.getPassword()),
    // "密码错误");
    //
    // user.setQqOpenId(openUser.getOpenId());
    // user.setQqAccessToken(openUser.getAccessToken());
    // userService.update(user);
    //
    // setLoginUser(user);
    // getSession().getAttribute(OPEN_USER, null);
    //
    // rc.renderSuccess("绑定成功");
    //
    // return null;
    // }
    //
    // /**
    // * 解除绑定
    // */
    // public String unbind() throws Exception {
    //
    // SysUser user = getLoginUser();
    //
    // checkNull(user, "请先登录");
    // checkInvalid(!hasBinded(user), "未绑定，无需解除绑定");
    //
    // user.setQqOpenId("");
    // user.setQqAccessToken("");
    // userService.update(user);
    //
    // rc.renderSuccess("成功取消绑定，如需彻底解除绑定，请登录QQ空间操作");
    //
    // return null;
    // }
    //
    // public String qzoneUserInfo() throws Exception {
    //
    // SysUser user = getLoginUser();
    //
    // checkNull(user, "请先登录");
    // checkInvalid(!hasBinded(user), "未绑定QQ帐号");
    //
    // Result<String> rs = getQzoneUserInfo(user.getQqAccessToken(),
    // user.getQqOpenId());
    // checkInvalid(!rs.isSuccess(), rs.getMsg());
    //
    // getRequest().setAttribute("qzoneUser",
    // JSONObject.toBean(JSONObject.fromObject(rs.getData()), QzoneUser.class));
    //
    // return QZONE_USER_INFO;
    // }
    //
    // public String weiboUserInfo() throws Exception {
    //
    // SysUser user = getLoginUser();
    //
    // checkNull(user, "请先登录");
    // checkInvalid(!hasBinded(user), "未绑定QQ帐号");
    //
    // OauthRequest req = new OauthRequest();
    // req.setAccessToken(user.getQqAccessToken());
    // req.setOpenId(user.getQqOpenId());
    //
    // Result<String> rs = qc.getWeiboUserInfo(req);
    // checkInvalid(!rs.isSuccess(), rs.getMsg());
    //
    // JsonConfig config = new JsonConfig();
    // config.setExcludes(new String[] { "comp", "edu", "tag", "tweetinfo" });
    // getRequest().setAttribute(
    // "weiboUser",
    // JSONObject.toBean(JSONObject.fromObject(rs.getData(), config),
    // WeiboUser.class));
    //
    // return WEIBO_USER_INFO;
    // }
    //
    // /**
    // * ajax
    // */
    // public String getQzoneUserInfo() throws Exception {
    //
    // SysUser user = getLoginUser();
    //
    // checkNull(user, "请先登录");
    // checkInvalid(!hasBinded(user), "未绑定QQ帐号");
    //
    // rc.renderJSONObject(getQzoneUserInfo(user.getQqAccessToken(),
    // user.getQqOpenId()));
    //
    // return null;
    // }
    //
    // /**
    // * private
    // */
    // private Result<String> getQzoneUserInfo(String accessToken, String
    // openId)
    // throws Exception {
    // OauthRequest req = new OauthRequest();
    // req.setAccessToken(accessToken);
    // req.setOpenId(openId);
    // return qc.getQzoneUserInfo(req);
    // }
    //
    // protected boolean hasBinded(SysUser user) {
    // if (StringUtils.isBlank(user.getQqOpenId())) {
    // return false;
    // }
    // if (StringUtils.isBlank(user.getQqAccessToken())) {
    // return false;
    // }
    // return true;
    // }

}
