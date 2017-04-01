<jsp:directive.include file="includes/top.jsp" />

<div class="box fl-panel" id="login">
    <form:form method="post" id="fm1" cssClass="fm-v clearfix" commandName="${commandName}" htmlEscape="true">
        <form:errors path="*" id="msg" cssClass="errors" element="div" />
        <h2>
            <spring:message code="screen.welcome.instructions" />
        </h2>
        <div class="row fl-controls-left">
            <label for="username" class="fl-label"><spring:message code="screen.welcome.label.netid" /></label>
            <c:if test="${not empty sessionScope.openIdLocalId}">
                <strong>${sessionScope.openIdLocalId}</strong>
                <input type="hidden" id="username" name="username" value="${sessionScope.openIdLocalId}" />
            </c:if>

            <c:if test="${empty sessionScope.openIdLocalId}">
                <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
                <form:input cssClass="required" cssErrorClass="error" id="username" size="25" tabindex="1"
                    accesskey="${userNameAccessKey}" path="username" autocomplete="false" htmlEscape="true" />
            </c:if>
        </div>
        <div class="row fl-controls-left">
            <label for="password" class="fl-label"><spring:message code="screen.welcome.label.password" /></label>
            <spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
            <form:password cssClass="required" cssErrorClass="error" id="password" size="25" tabindex="2"
                path="password" accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
        </div>
        <div class="row check">
            <input id="warn" name="warn" value="true" tabindex="3"
                accesskey="<spring:message code="screen.welcome.label.warn.accesskey" />" type="checkbox" />
            <label for="warn"><spring:message code="screen.welcome.label.warn" /></label>
        </div>
        <div class="row btn-row">
            <input type="hidden" name="lt" value="${loginTicket}" />
            <input type="hidden" name="execution" value="${flowExecutionKey}" />
            <input type="hidden" name="_eventId" value="submit" />

            <input type="checkbox" name="rememberMe" id="rememberMe" value="true" />
            <label for="rememberMe">下次自动登录</label>

            <input class="btn-submit" name="submit" accesskey="l" style="padding: 3px 10px;"
                value="<spring:message code="screen.welcome.button.login" />" tabindex="4" type="submit" />

            <a id="register" href="${ctx}/register">注册</a>
        </div>
    </form:form>
</div>
<div id="sidebar">
    <div class="sidebar-content">
        <div id="list-languages" class="fl-panel">
            <h3 style="margin: 15px 0">开放平台帐号登录</h3>
            <p>
                <a href="${GitHubProviderUrl}">
                    <img alt="" src="${ctx}/images/github_logo.png" width="100" height="41" />
                </a>
            </p>
            <p>
                <a href="${SinaWeiboProviderUrl}">
                    <img alt="" src="${ctx}/images/weibo_03.png" />
                </a>
            </p>
            <p>
                <a href="${QzoneProviderUrl}">
                    <img alt="" src="${ctx}/images/qzone_3.png" />
                </a>
            </p>

            <p>
                <a href="${RenrenProviderUrl}">
                    <img alt="" src="${ctx}/images/renren_login_133_28.png" />
                </a>
            </p>

            <!-- 安全提示 -->
            <div class="fl-panel fl-note fl-bevel-white fl-font-size-80" style="margin-top: 15px; color: #BB0000;">
                <spring:message code="screen.welcome.security" />
            </div>
        </div>
    </div>
</div>

<jsp:directive.include file="includes/bottom.jsp" />