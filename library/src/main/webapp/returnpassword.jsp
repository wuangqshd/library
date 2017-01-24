<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>图书管理系统登录</title>
<meta name="renderer" content="webkit">
<script type="text/javascript" src="<%=basePath %>assets/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/js/returnpassword.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/dialog/ymPrompt.js"></script>

<script type="text/javascript" src="<%=basePath %>assets/layer/layer.js"></script>
<link href="<%=basePath %>B-JUI/themes/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath %>assets/dialog/black/ymPrompt.css" rel="stylesheet">
<style type="text/css">
html, body { height: 100%; overflow: hidden; }
body {
    font-family: "Verdana", "Tahoma", "Lucida Grande", "Microsoft YaHei", "Hiragino Sans GB", sans-serif;
    background: url(images/loginbg_01.jpg) no-repeat center center fixed;
    background-size: cover;
}
.form-control{height:37px;}
.main_box{position:absolute; top:45%; left:50%; margin:-200px 0 0 -180px; padding:15px 20px; width:360px; height:400px; min-width:320px; background:#FAFAFA; background:rgba(255,255,255,0.5); box-shadow: 1px 5px 8px #888888; border-radius:6px;}
.login_msg{height:30px;}
.input-group >.input-group-addon.code{padding:0;}
#captcha_img{cursor:pointer;}
.main_box .logo img{height:35px;}
@media (min-width: 768px) {
    .main_box {margin-left:-240px; padding:15px 55px; width:480px;}
    .main_box .logo img{height:40px;}
}
</style>
<script type="text/javascript">
var COOKIE_NAME = 'sys_em_username';
$(function() {
    choose_bg();
    changeCode();
    
/*     if ($.cookie(COOKIE_NAME)){
        $("#j_username").val($.cookie(COOKIE_NAME));
        $("#j_password").focus();
        $("#j_remember").attr('checked', true);
    } else {
        $("#j_username").focus();
    } */
    $("#captcha_img").click(function(){
        changeCode();
    });
   /*  $.return(); */
    /* $("#login_form").submit(function(){
        var issubmit = true;
        var i_index  = 0;
        $(this).find('.form-control').each(function(i){
            if ($.trim($(this).val()).length == 0) {
                $(this).css('border', '1px #ff0000 solid');
                issubmit = false;
                if (i_index == 0)
                    i_index  = i;
            }
        });
        if (!issubmit) {
            $(this).find('.form-control').eq(i_index).focus();
            return false;
        }
        var $remember = $("#j_remember");
        if ($remember.attr('checked')) {
            $.cookie(COOKIE_NAME, $("#j_username").val(), { path: '/', expires: 15 });
        } else {
            $.cookie(COOKIE_NAME, null, { path: '/' });  //删除cookie
        }
        
        $("#login_ok").attr("disabled", true).val('登陆中..');
        
        var key = CryptoJS.enc.Base64.parse($("#j_randomKey").val());
        var iv = CryptoJS.enc.Latin1.parse('0102030405060708');
        var password = CryptoJS.AES.encrypt($("#j_password").val(), key, {iv:iv, mode:CryptoJS.mode.CBC, padding:CryptoJS.pad.Pkcs7 });
        
        $("#j_password").val(password)
        
        
        //return true;
        
       // location.href = 'login.do';
    });*/
});
function inputfocus(){
	function keyUp(e) {
        var currKey=0,e=e||event;
        currKey=e.keyCode||e.which||e.charCode;
        if (currKey=="13"){//keyCode=13是回车键
            $("#loginBtn").click();
        }
    }
    document.onkeyup = keyUp;
}

function changeCode(){
    //$("#captcha_img").attr("src", "sys/login/getCaptcha?t="+ (new Date().getTime()));
}
function choose_bg() {
    var bg = Math.floor(Math.random() * 9 + 1);
    $('body').css('background-image', 'url(images/loginbg_0'+ bg +'.jpg)');
}
</script>
</head>
<body id="mybody">
<!--[if lte IE 7]>
<style type="text/css">
#errorie {position: fixed; top: 0; z-index: 100000; height: 30px; background: #FCF8E3;}
#errorie div {width: 900px; margin: 0 auto; line-height: 30px; color: orange; font-size: 14px; text-align: center;}
#errorie div a {color: #459f79;font-size: 14px;}
#errorie div a:hover {text-decoration: underline;}
</style>
<div id="errorie"><div>您还在使用老掉牙的IE，请升级您的浏览器到 IE8以上版本 <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div></div>
<![endif]-->
<div class="container">
    <div class="main_box">
            <p class="text-center logo"><img src="images/logo.png" height="45"></p>
            <div class="login_msg text-center"><font size="1px" color="red">需在系统内验证邮箱，如遗忘请联系管理员</font></div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon-user"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" class="form-control" id="username" onfocus="inputfocus()" name="username" value="" placeholder="请输入姓名" aria-describedby="sizing-addon-user">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon-password"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" class="form-control" onfocus="inputfocus()" id="password" name="passwordhash" placeholder="请输入身份证号" aria-describedby="sizing-addon-password">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon" id="sizing-addon-password"><span class="glyphicon glyphicon-exclamation-sign"></span></span>
                    <input type="text" class="form-control" id="captcha" name="captcha" placeholder="验证码" aria-describedby="sizing-addon-password">
                    <span class="input-group-addon code" id="basic-addon-code"><img id="captcha_img" src="images/pessbtn.png" alt="点击获取" title="点击获取" class="m"></span>
                </div>
            </div>
            <div class="form-group">
                <div class="checkbox">
                    <label for="j_remember" class="m"><input id="remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
                </div>
            </div>
            <div class="text-center">
				&nbsp;&nbsp;
                <button type="reset" class="btn btn-default  btn-lg">&nbsp;重&nbsp;置&nbsp;</button>
            </div>
            <div class="text-center">
            <hr>
                2016 - 2017 <a href="login.jsp">图书管理系统</a> 其实很淡祝您心情愉快！
            </div>
    </div>
</div>
</body>
</html>