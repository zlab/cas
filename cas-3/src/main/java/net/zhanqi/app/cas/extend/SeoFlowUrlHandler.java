package net.zhanqi.app.cas.extend;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.web.flow.CasDefaultFlowUrlHandler;

public class SeoFlowUrlHandler extends CasDefaultFlowUrlHandler {

    @Override
    public String getFlowId(HttpServletRequest request) {
        String flowId = super.getFlowId(request);
        if (flowId != null && flowId.endsWith("/")) {
            return flowId.substring(0, flowId.length() - 1);
        }

        return flowId;
    }
}
