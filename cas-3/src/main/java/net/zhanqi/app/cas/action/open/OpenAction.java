package net.zhanqi.app.cas.action.open;

import net.zhanqi.module.model.sys.SysUser;

/**
 * OpenAction
 * 
 * @author zhanqi
 * @since 2012-10-18
 */
public abstract class OpenAction {

    public static final String OPEN_USER = "openUser";
    public static final String SIGN_UP = "signup";

    public static final String USER_LOGIN = "user-login";
    public static final String USER_HOME = "user-home";

    public String execute() throws Exception {
        SysUser user = new SysUser();
        if (user != null && hasBinded(user)) {
            return USER_HOME;
        }
        return oauth();
    }

    protected boolean hasBinded(SysUser user) {
        return false;
    }

    public String oauth() throws Exception {
        return null;
    }

    public String register() throws Exception {
        return null;
    }

}
