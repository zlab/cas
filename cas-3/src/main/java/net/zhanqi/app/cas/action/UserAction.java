package net.zhanqi.app.cas.action;

import net.zhanqi.app.cas.service.UserService;
import net.zhanqi.lib.util.CheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UserAction
 * 
 * @author zhanqi
 * @since 2012-09-10
 */
public class UserAction {

    private UserService service;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    /**
     * 用户首页
     */
    public String home() throws Exception {
        return "home";
    }

    /**
     * 发送激活邮件，用于重新发送
     */
    @ResponseBody
    public String sendActiveKey() throws Exception {
        // service.sendActiveKey(getLoginInfo().getUser());
        return "";
    }

    /**
     * 激活邮箱账号，从激活链接进入
     */
    public String active(String email, String activekey) throws Exception {
        service.active(email, activekey);
        return "login";
    }

    /**
     * 修改密码
     */
    public String chgPwd() throws Exception {
        return "chgPwd";
    }

    /**
     * 注册
     */
    public String register() throws Exception {
        CheckUtils.checkNull(null, "目前只能使用开放平台帐号登录");
        return "register";
    }

    /**
     * 登录
     */
    public String login() throws Exception {
        // if (!isPost()) {
        // return LOGIN;
        // }

        // service.login(email, password);

        // 登录成功
        // getSession().setAttribute("login_email", email);

        // setLoginUser(user);

        return "";
    }

    /**
     * 注销登录
     */
    public String logout() throws Exception {
        return "login";
    }

}
