<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CAS &#8211; Central Authentication Service</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" type="image/x-icon" href="${ctx}/favicon.ico" />
<spring:theme code="standard.custom.css.file" var="customCssFile" />
<link type="text/css" rel="stylesheet" href="${ctx}${customCssFile}" />
<script type="text/javascript" src="${ctx}/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/cookie/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-ui/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/cas.js"></script>
</head>
<body id="cas" class="fl-theme-iphone">
    <div class="flc-screenNavigator-view-container">
        <div class="fl-screenNavigator-view">
            <div id="header" class="flc-screenNavigator-navbar fl-navbar fl-table">
                <h1 id="company-name">Jasig</h1>
                <h1 id="app-name" class="fl-table-cell">Central Authentication Service (CAS)</h1>
            </div>
            <div id="content" class="fl-screenNavigator-scroll-container">