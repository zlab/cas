<%@ page session="false"%>
<cas:clearPassResponse xmlns:cas='http://www.yale.edu/tp/cas'>
    <cas:clearPassSuccess>
        <cas:credentials>${fn:escapeXml(credentials)}</cas:credentials>
    </cas:clearPassSuccess>
</cas:clearPassResponse>