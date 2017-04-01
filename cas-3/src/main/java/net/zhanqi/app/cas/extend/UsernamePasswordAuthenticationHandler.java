package net.zhanqi.app.cas.extend;

import net.zhanqi.lib.component.sys.DaoInfo;
import net.zhanqi.lib.component.sys.impl.SimpleDaoInfoImpl;
import net.zhanqi.module.model.sys.SysUser;

import org.apache.commons.codec.digest.DigestUtils;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.BadPasswordAuthenticationException;
import org.jasig.cas.authentication.handler.UnknownUsernameAuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernamePasswordAuthenticationHandler extends
        AbstractUsernamePasswordAuthenticationHandler {

    private DaoInfo dao;

    @Autowired
    public void setDao(SimpleDaoInfoImpl dao) {
        this.dao = dao;
    }

    @Override
    protected boolean authenticateUsernamePasswordInternal(
            UsernamePasswordCredentials credentials) throws AuthenticationException {

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        SysUser user = dao.unique(SysUser.class, "username", username);

        if (user == null) {
            throw new UnknownUsernameAuthenticationException();
        }

        if (!DigestUtils.md5Hex(password).equals(user.getPassword())) {
            throw new BadPasswordAuthenticationException();
        }

        return true;
    }

}
