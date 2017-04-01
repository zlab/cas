<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>操作提示</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" type="image/x-icon" href="${ctx}/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/favicon.ico" />
</head>
<body style="font-size: 12px; padding: 5px 20px;background: #f2f2f2; ">
    <div style="font-size: 16px; font-weight: bold; color: #dd4b39; padding-top: 10px;">
        <s:property value="exception.message" />
    </div>
    <div style="white-space: pre-line; padding:0 15px;">
        <s:property value="exceptionStack" />
    </div>
</body>
</html>