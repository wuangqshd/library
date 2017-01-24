<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="bjui-pageContent">
    <form action="login.do" data-toggle="validate" method="post" data-close-current="true">
        <div class="bjui-row col-1">
            <label class="row-label">用户名:</label>
            <div class="row-input required">
                <input type="text" id="timeout_username" name="username" value="" >
            </div>
            <label class="row-label">密码:</label>
            <div class="row-input required">
                <input type="password" id="timeout_passwd" name="password" value="" >
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn-default" data-icon="check">登录</button></li>
    </ul>
</div>
