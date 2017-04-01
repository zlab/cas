<%@page language="java" pageEncoding="utf-8"%>
<zlib:title title="个人中心" />
<%@include file="/WEB-INF/content/common/header.jsp"%>
<div class="container main">
    <ul class="nav nav-pills">
        <li class="active"><a href="${home}user/home/">基本信息</a></li>
        <li><a href="${home}open/qq/qzoneUserInfo/">QQ空间</a></li>
        <li><a href="${home}open/qq/weiboUserInfo/">腾讯微博</a></li>
        <li><a href="${home}open/sina/weiboUserInfo/">新浪微博</a></li>
        <li><a href="${home}user/pwd/">修改密码</a></li>
    </ul>
    <table class="table table-hover table-bordered align-center">
        <colgroup width="20%" />
        <colgroup width="40%" />
        <colgroup width="40%" />
        <tbody>
            <tr>
                <td>帐号</td>
                <td>${loginUser.id}</td>
                <td></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td>${loginUser.email}</td>
                <td><a class="btn btn-info" href="#">修改</a></td>
            </tr>
            <tr class="qzone">
                <td>QQ空间</td>
                <td class="nickname"><img alt="" src="${static}images/loading-small.gif" /></td>
                <td><a class="btn btn-info bind hide" href="${home}open/qq/oauth/">去绑定</a>
                    <button class="btn btn-warning unbind hide">解除绑定</button></td>
            </tr>
            <tr class="weibo">
                <td>新浪微博</td>
                <td class="nickname"><img alt="" src="${static}images/loading-small.gif" /></td>
                <td><a class="btn btn-info bind hide" href="${home}open/sina/oauth/">去绑定</a>
                    <button class="btn btn-warning unbind hide">解除绑定</button></td>
            </tr>
            <tr class="status">
                <td>账号状态</td>
                <c:choose>
                    <c:when test="${loginUser.status eq 0}">
                        <td>未激活</td>
                        <td><button class="btn btn-primary" href="javascript:void(0)">发送激活邮件</button></td>
                    </c:when>
                    <c:when test="${loginUser.status eq 1}">
                        <td>正常</td>
                        <td></td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                        <td></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </tbody>
    </table>
    <div class="btn-toolbar align-center">
        <button class="btn">退出系统</button>
    </div>
</div>
<script type="text/javascript">
    jQuery(function() {

        $('.status .btn-primary').click(function() {
            $.getJSON('user/sendActiveKey/', function(rs) {
                alert(rs.msg);
                if (rs.success !== true) {
                }
            });
        });

        $.getJSON('open/qq/getQzoneUserInfo/', function(rs) {
            if (rs.success !== true) {
                $('.qzone .nickname').text(rs.msg);
                $('.qzone .bind').show();
            } else {
                $('.qzone .nickname').text(rs.data.nickname);
                $('.qzone .unbind').show().click(function() {
                    $.getJSON('open/qq/unbind/', function(rs) {
                        alert(rs.msg);
                        if (rs.success === true) {
                            location.reload();
                        }
                    });
                });
            }
        });

        $.getJSON('open/sina/getWeiboUserInfo/', function(rs) {
            if (rs.success !== true) {
                $('.weibo .nickname').text(rs.msg);
                $('.weibo .bind').show();
            } else {
                $('.weibo .nickname').text(rs.data.screen_name);
                $('.weibo .unbind').show().click(function() {
                    $.getJSON('open/sina/unbind/', function(rs) {
                        alert(rs.msg);
                        if (rs.success === true) {
                            location.reload();
                        }
                    });
                });
            }
        });
    });
</script>
<%@include file="/WEB-INF/content/common/footer.jsp"%>