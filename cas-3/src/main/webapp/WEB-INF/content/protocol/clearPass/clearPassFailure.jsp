<%@ page session="false" contentType="text/plain"%>
<cas:clearPassResponse xmlns:cas='http://www.yale.edu/tp/cas'>
    <cas:clearPassFailure>${fn:escapeXml(description)}</cas:clearPassFailure>
</cas:clearPassResponse>