<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><spring:message code="${pageTitle}" text="Logged Out" /></title>
<meta name="version" content="<%=org.jasig.cas.CasVersion.getVersion()%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" href="${ctx}/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="${ctx}/css/services/cas.css" type="text/css" />
<script type="text/javascript" src="${ctx}/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-ui/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/cas.js"></script>
<script type="text/javascript" src="${ctx}/js/MyInfusion.js"></script>
<script type="text/javascript" src="${ctx}/js/services.js"></script>

<style type="text/css">
span {
    background: #fff;
    color: #000;
}
</style>
</head>

<body id="${pageTitle}-body">
    <div id="header">
        <div id="nav-system">
            <ul>
                <li><a href="logout.html" title="logout of current session">
                        <spring:message code="management.services.link.logout" />
                    </a></li>
            </ul>
        </div>
        <p id="tagline">
            <spring:message code="application.title" />
        </p>
        <h1 id="app-name">
            <spring:message code="management.services.title" />
        </h1>
    </div>
    <div id="nav-main">
        <ul>
            <li><a id="addServiceView" href="add.html">
                    <span>
                        <spring:message code="addServiceView" />
                    </span>
                </a></li>
            <li><a id="manageServiceView" href="manage.html">
                    <span>
                        <spring:message code="manageServiceView" />
                    </span>
                </a></li>
            <li><a id="viewStatisticsView" href="viewStatistics.html">
                    <span>
                        <spring:message code="viewStatisticsView" />
                    </span>
                </a></li>
        </ul>
    </div>
    <!-- CONTENT -->
    <div id="content">
        <h1>
            <spring:message code="${pageTitle}" text="Logged Out" />
        </h1>