/**
 * 登录
 */
$.ajaxSetup({
	cache : false,
	async : false,
	type : 'POST',
	dataType : 'json',
	contentType : 'application/json'
});

$.extend({
	login : function() {
		$("#loginBtn").click(
			
				function() {
					
					var username = $.trim($("#username").val());
					var password = $("#password").val();
					if (username == "") {
//						alert("账号不能为空，请输入您的账号！");
						layer.tips('账号不能为空，请输入您的账号!',$("#username"));
						return false;
					}
					if (password == "") {
//						alert("密码不能为空，请输入您的密码！");
						layer.tips('密码不能为空，请输入您的密码！',$("#password"));
						return false;
					}
					var opts = "{\"username\":\"" + username
							+ "\",\"password\":\"" + password
							+ "\"}";
//					 alert(opts);
						layer.msg('加载中……',{icon:16});
					$.post("login.do", opts, function(msg) {
//						alert(msg);
						
						if (msg == "null") {
							layer.msg('账号输入错误（不存在）');
							return false;
						} else if (msg == "fail") {
//							alert("输入的密码不正确，请重新输入！");
							layer.msg('输入的密码不正确，请重新输入！');
							return false;
						} else {
//							alert(msg);
							window.location.href = "index.do";
						}
					});
				});
	}
});
