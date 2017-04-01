package net.zhanqi.app.cas.extend;

import org.jasig.cas.authentication.handler.AuthenticationException;

public class SsoAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public SsoAuthenticationException(String code) {
        super(code);
    }

    public SsoAuthenticationException(String code, String msg, String type) {
        super(code, msg, type);
    }

    public SsoAuthenticationException(String code, String msg) {
        super(code, msg);
    }

    public SsoAuthenticationException(String code, Throwable throwable) {
        super(code, throwable);
    }
}
