package net.zhanqi.app.cas.extend;

import org.jasig.cas.authentication.AuthenticationException;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;

public class AuthenticationExceptionHandler extends
        org.jasig.cas.web.flow.AuthenticationExceptionHandler {

    public static final String MESSAGE_BUNDLE_PREFIX = "authenticationFailure.";

    @Override
    public String handle(final AuthenticationException e,
            final MessageContext messageContext) {
        String messageCode = "UNKNOWN";
        if (e != null) {
            for (final Class<? extends Exception> handlerError : e.getHandlerErrors()
                    .values()) {
                messageCode = MESSAGE_BUNDLE_PREFIX + handlerError;
                messageContext.addMessage(new MessageBuilder().error().code(messageCode)
                        .build());
            }
        }
        return messageCode;
    }
}
