<%@page language="java" pageEncoding="utf-8"%>
<zlib:title title="修改密码" />
<%@include file="/WEB-INF/content/common/header.jsp"%>
<div class="container main">
    <ul class="nav nav-pills">
        <li><a href="${home}user/home/">基本信息</a></li>
        <li><a href="${home}open/qq/qzoneUserInfo/">QQ空间</a></li>
        <li><a href="${home}open/qq/weiboUserInfo/">腾讯微博</a></li>
        <li><a href="${home}open/sina/weiboUserInfo/">新浪微博</a></li>
        <li class="active"><a href="${home}user/pwd/">修改密码</a></li>
    </ul>
    <form id="pwd-form" method="POST" class="form form-horizontal clearfix">
        <fieldset class="span12">
            <div class="control-group">
                <label class="control-label" for="password-old">原密码：</label>
                <div class="controls">
                    <input type="password" name="password-old" id="password-old" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="password-new">新密码：</label>
                <div class="controls">
                    <input type="password" name="password-new" id="password-new" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="password-confirm">密码确认：</label>
                <div class="controls">
                    <input type="password" name="password" id="password-confirm" />
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="action" value="pwd" />
                    <input type="button" class="btn btn-primary" id="pwd" data-action="${cas}user/login/" value="修改密码" />
                    <span class="msg">${msg}</span>
                </div>
            </div>
            <div class="control-group align-center hide">
                <div class="span3 offset1 alert alert-info">目前只能使用开放平台帐号登录</div>
            </div>
        </fieldset>
    </form>
</div>
<script type="text/javascript" src="${home}user/js/user.js"></script>
<%@include file="/WEB-INF/content/common/footer.jsp"%>