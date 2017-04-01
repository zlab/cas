<%@ page session="false" contentType="text/plain" %>
<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>
	<cas:proxyFailure code='${code}'>
		${fn:escapeXml(description)}
	</cas:proxyFailure>
</cas:serviceResponse>