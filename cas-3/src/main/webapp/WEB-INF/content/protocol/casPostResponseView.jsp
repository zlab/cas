<%@page language="java" pageEncoding="utf-8"%>
<html>
<body onload="document.acsForm.submit();">
    <form name="acsForm" action="<c:out value="${originalUrl}" escapeXml="true" />" method="post">
        <div style="display: none">
            <c:forEach items="${parameters}" var="entry">
                <textarea rows=10 cols=80 name="${entry.key}">
                    <c:out value="${entry.value}" escapeXml="true" />
                </textarea>
            </c:forEach>
        </div>
        <noscript>
            <p>
                You are being redirected to
                <c:out value="${originalUrl}" escapeXml="true" />
                . Please click &quot;Continue&quot; to continue your login.
            </p>
            <p>
                <input type="submit" value="Continue" />
            </p>
        </noscript>
    </form>
</body>
</html>