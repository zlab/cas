<jsp:directive.include file="includes/top.jsp" />

<div class="box" id="login">
    <form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">

        <form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="true" />

        <h2 id="instructions">
            <spring:message code="screen.welcome.instructions" />
        </h2>

        <section class="row">
            <label for="username"><spring:message code="screen.welcome.label.netid" /></label>
            <form:input cssClass="required" cssErrorClass="error" id="username" size="25" tabindex="1" path="username"
                autocomplete="off" htmlEscape="true" />
        </section>

        <section class="row">
            <label for="password"><spring:message code="screen.welcome.label.password" /></label>
            <form:password cssClass="required" cssErrorClass="error" id="password" size="25" tabindex="2"
                path="password" htmlEscape="true" autocomplete="off" />
        </section>

        <c:if test="${empty param.action}">
            <section class="row check">
                <input id="warn" name="warn" value="true" tabindex="3"
                    accesskey="<spring:message code="screen.welcome.label.warn.accesskey" />" type="checkbox" />
                <label for="warn"><spring:message code="screen.welcome.label.warn" /></label>
            </section>
        </c:if>

        <section class="row btn-row check">
            <input type="hidden" name="lt" value="${loginTicket}" />
            <input type="hidden" name="execution" value="${flowExecutionKey}" />

            <c:choose>
                <c:when test="${param.action eq 'register'}">
                    <c:set var="_eventId" value="register" />

                    <input class="btn-submit" name="submit" tabindex="4" type="submit"
                        value="<spring:message code="screen.welcome.button.register" />" />

                    <a href="${ctx}/login">
                        <spring:message code="screen.welcome.button.login" />
                    </a>
                </c:when>

                <c:otherwise>
                    <c:set var="_eventId" value="login" />

                    <input type="checkbox" name="rememberMe" id="rememberMe" value="true" />
                    <label for="rememberMe">下次自动登录</label>

                    <input class="btn-submit" name="submit" tabindex="4" type="submit"
                        value="<spring:message code="screen.welcome.button.login" />" />

                   <%--  <a href="${ctx}/login?action=register">
                        <spring:message code="screen.welcome.button.register" />
                    </a> --%>
                </c:otherwise>
            </c:choose>

            <input type="hidden" name="_eventId" value="${_eventId}" />

        </section>
    </form:form>
</div>

<div id="sidebar">
    <div class="sidebar-content" style="display:none;">
        <h3 style="margin: 5px 0 30px 0">开放平台帐号登录</h3>
        <p>
            <a href="${SinaWeiboClientUrl}">
                <img alt="" src="${ctx}/images/weibo_03.png" />
            </a>
        </p>
        <p>
            <a href="${QzoneClientUrl}">
                <img alt="" src="${ctx}/images/qzone_3.png" />
            </a>
        </p>

        <p>
            <a href="${RenrenClientUrl}">
                <img alt="" src="${ctx}/images/renren_login_133_28.png" />
            </a>
        </p>

        <p>
            <a href="${CasOAuthWrapperClientUrl}">CasOauth2 认证 </a>
        </p>

        <!-- 安全提示 -->
        <div style="margin-top: 15px; color: #BB0000;">
            <spring:message code="screen.welcome.security" />
        </div>
    </div>
</div>

<jsp:directive.include file="includes/bottom.jsp" />