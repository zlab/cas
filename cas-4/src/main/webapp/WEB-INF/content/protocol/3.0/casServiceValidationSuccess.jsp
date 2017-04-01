<%@ page session="false" contentType="application/xml; charset=UTF-8"%>
<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>
    <cas:authenticationSuccess>
        <cas:user>${fn:escapeXml(assertion.primaryAuthentication.principal.id)}</cas:user>
        <c:if test="${not empty pgtIou}">
            <cas:proxyGrantingTicket>${pgtIou}</cas:proxyGrantingTicket>
        </c:if>
        <c:if test="${fn:length(assertion.chainedAuthentications) > 1}">
            <cas:proxies>
                <c:forEach var="proxy" items="${assertion.chainedAuthentications}" varStatus="loopStatus" begin="0"
                    end="${fn:length(assertion.chainedAuthentications)-2}" step="1">
                    <cas:proxy>${fn:escapeXml(proxy.principal.id)}</cas:proxy>
                </c:forEach>
            </cas:proxies>
        </c:if>

        <c:if test="${fn:length(assertion.primaryAuthentication.principal.attributes) > 0}">
            <cas:attributes>
                <c:forEach var="attr" items="${assertion.primaryAuthentication.principal.attributes}">
                    <cas:${fn:escapeXml(attr.key)}>${fn:escapeXml(attr.value)}</cas:${fn:escapeXml(attr.key)}>
                </c:forEach>
            </cas:attributes>
        </c:if>

    </cas:authenticationSuccess>
</cas:serviceResponse>