<%@page language="java" pageEncoding="utf-8"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="${ctx}/">超级程序员</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li><a href="${ctx}/user/home/">个人中心</a></li>
                    <li><a href="${ctx}/user/register/">注册</a></li>
                    <li><a href="${ctx}/user/login/">登录</a></li>
                    <li><a href="${ctx}/blog/">博客</a></li>
                    <li><a href="${ctx}/admin/">后台管理</a></li>
                </ul>
                <ul class="nav pull-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> 个人中心<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="nav-header">操作</li>
                            <li><a href="${ctx}/user/home/">基本信息</a></li>
                            <li><a href="${ctx}/user/logout/">注销登录</a></li>
                        </ul></li>
                </ul>
            </div>
        </div>
    </div>
</div>