<%@ page session="false" contentType="text/plain"%>
<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>
    <cas:authenticationFailure code='${code}'>
		${fn:escapeXml(description)}
	</cas:authenticationFailure>
</cas:serviceResponse>