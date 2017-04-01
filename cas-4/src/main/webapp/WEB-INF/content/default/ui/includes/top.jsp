<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CAS &#8211; Central Authentication Service</title>
<link rel="icon" type="image/x-icon" href="${ctx}/favicon.ico" />
<link rel="stylesheet" href="${ctx}/css/cas.css" />
<spring:theme code="standard.custom.css.file" var="customCssFile" />
<link rel="stylesheet" href="${ctx}${customCssFile}" />

<!--[if lt IE 9]>
    <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js" type="text/javascript"></script>
<![endif]-->
</head>
<body id="cas">
    <div id="container">
        <header>
            <a id="logo" href="http://www.jasig.org">Jasig</a>
            <h1>Central Authentication Service (CAS)</h1>
        </header>
        <div id="content">