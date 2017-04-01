<%@page language="java" pageEncoding="utf-8"%>
<title>${title}</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" type="image/x-icon" href="${ctx}/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/favicon.ico" />
<js:package name="source.pack.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/jquery-ui/themes/base/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/jquery-ui/themes/redmond/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/jquery-ui/themes/custom/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/ztree/css/zTreeStyle/zTreeStyle.css" />
</js:package>
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<js:package name="source.pack.js">
    <script type="text/javascript" src="${ctx}/scripts/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/jquery-ui/js/jquery-ui.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/json/json2.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/form/jquery.form.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/tmpl/jquery.tmpl.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/validation/jquery.validate.js"></script>
    <%--<script type="text/javascript" src="${ctx}/scripts/validation/additional-methods.js"></script>--%>
    <script type="text/javascript" src="${ctx}/scripts/ztree/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/jquery-ui/js/jquery.ui.datepicker-zh-CN.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/validation/messages_zh.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/jquery.util.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/jquery.custom.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/jquery.tag.js"></script>
</js:package>
<script type="text/javascript">
    var ctx = '${ctx}';
</script>
