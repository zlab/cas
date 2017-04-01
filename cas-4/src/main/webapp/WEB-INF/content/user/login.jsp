<%@page language="java" pageEncoding="utf-8"%>
<ui:window>
    <ui:config title="用户登录">
        <script type="text/javascript" src="${ctx}/js/home/User.js"></script>
        <js:init func="user.initLogin" />
    </ui:config>
    <ui:content>
        <jsp:include page="/WEB-INF/content/common/header.jsp" />
        <form id="login-form" method="POST" action="${ctx}/user/login/" class="row form form-horizontal">
            <fieldset class="span7">
                <legend class="">用户登录</legend>
                <div class="control-group">
                    <label class="control-label" for="email">邮 箱：</label>
                    <div class="controls">
                        <input type="text" name="email" id="email" value="${email}" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="password">密 码：</label>
                    <div class="controls">
                        <input type="password" name="password" id="password" />
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="submit" class="btn btn-primary" id="login" data-url="${ctx}/user/home/" value="登 录" />
                        <span class="msg">${msg}</span>
                    </div>
                </div>
                <div class="control-group align-center hide">
                    <div class="span3 offset1 alert alert-info">目前只能使用开放平台帐号登录</div>
                </div>
            </fieldset>
            <fieldset class="span5">
                <legend class="">开放平台帐号</legend>
                <div class="control-group">
                    <a href="${ctx}/open/qq/oauth/">
                        <img alt="" src="${ctx}/user/images/qzone_4.png" />
                    </a>
                </div>
                <div class="control-group">
                    <a href="${ctx}/open/sina/oauth/">
                        <img alt="" src="${ctx}/user/images/weibo_32.png" />
                    </a>
                </div>
                <div class="control-group">
                    <button type="button" class="btn btn-success input-medium" id="user-register">注 册</button>
                </div>
            </fieldset>
        </form>
    </ui:content>
</ui:window>

