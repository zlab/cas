package net.zhanqi.app.cas.extend;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import net.zhanqi.app.cas.model.CasUser;

import net.zhanqi.sshe.frame.component.DaoInfo;
import net.zhanqi.sshe.frame.component.impl.SimpleDaoInfoImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernamePasswordAuthenticationHandler extends
        AbstractUsernamePasswordAuthenticationHandler {

    private DaoInfo dao;

    @Autowired
    public void setDao(SimpleDaoInfoImpl dao) {
        this.dao = dao;
    }

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(
            UsernamePasswordCredential credential) throws GeneralSecurityException,
            PreventedException {

        String username = credential.getUsername();
        String password = credential.getPassword();

        if (StringUtils.isBlank(username)) {
            throw new GeneralSecurityException("required.username");
        }

        if (StringUtils.isBlank(password)) {
            throw new GeneralSecurityException("required.password");
        }

        CasUser user = dao.unique(CasUser.class, "username", username);

        if (user == null) {
            throw new GeneralSecurityException("bad.username");
        }

        if (!DigestUtils.md5Hex(password).equals(user.getPassword())) {
            throw new GeneralSecurityException("bad.password");
        }

        Map<String, Object> attrs = new HashMap<String, Object>();
        attrs.put("uid", user.getUid());
        attrs.put("username", username);

        return createHandlerResult(credential, new SimplePrincipal(username), null);
    }

}
