<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
$(function(){
	$.getJSON("getpersonmsg.do",function(msg){
		var msgjson = JSON.parse(msg);
		$("#person_edit_submit").hide();
		$('input').attr("readonly",true);
//		alert(msgjson);
//		alert(msgjson.username);
		if(msgjson!=""){
				$('#person_id').val(msgjson.id);
				$('#person_username').val(msgjson.username);
				$('#person_usercode').val(msgjson.usercode);
				$('#person_useraccount').val(msgjson.useraccount);
				$('#person_usermail').val(msgjson.usermail);
				$('#person_userphone').val(msgjson.userphone);
				$('#person_userage').val(msgjson.userage);
				$('#person_usercompany').val(msgjson.usercompany);
		}
	})
})

$('#person_edit').click(
		function(){
			$('input').attr("readonly",false)
			$("#person_edit_submit").show();
		});
$('#person_edit_submit').click(
		function(){
			$('input').attr("readonly",true);
			$("#person_edit_submit").hide();
	/*var data ={
		username:$('#person_username').val(),
		usercode:$('#person_usercode').val(),
		useraccount:$('#person_useraccount').val(),
		usermail:$('#person_usermail').val(),
		userphone:$('#person_userphone').val(),
		userage:$('#person_userage').val(),
		usercompany:$('#person_usercompany').val()
		};
	//	alert(data);
	   $.post("editpersonmsg_self.do",data,function(json, options) {
		   BJUI.alertmsg('info', json);
		   $('input').attr("readonly",true);
			$("#person_edit_submit").hide();
	    })*/	
		})
</script>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					个人信息 <small>Message of yourself</small>
				</h1>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column">
					 <button type="button" id="person_edit" class="btn btn-default btn-block ">编辑</button>
				</div>
				<div class="col-md-6 column">
					<form class="form-horizontal" id="editperson_form" action="editpersonmsg_self.do" data-toggle="ajaxform" >
						<div class="form-group" style="visibility: hidden;">
							 <label for="inputEmail3" class="col-sm-4 control-label">姓名</label>
							<div class="col-sm-8">
								<input id="person_id" name="id" type="text">
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-4 control-label">姓名</label>
							<div class="col-sm-8">
								<input id="person_username" name="username" type="text">
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-4 control-label">编号</label>
							<div class="col-sm-8">
								<input class="form-control" id="person_usercode" name="usercode"   type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-4 control-label">账号</label>
							<div class="col-sm-8">
								<input class="form-control" id="person_useraccount" name="useraccount"  type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-4 control-label">Email</label>
							<div class="col-sm-8">
								<input class="form-control" id="person_usermail" name="usermail"   type="email" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-4 control-label">联系方式</label>
							<div class="col-sm-8">
								<input class="form-control" id="person_userphone"  name="userphone"  type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-4 control-label">年龄</label>
							<div class="col-sm-8">
								<input class="form-control" id="person_userage" name="userage"  type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-4 control-label">单位</label>
							<div class="col-sm-8">
								<input class="form-control" id="person_usercompany" name="usercompany"  type="text" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8">
								 <button type="submit"  id="person_edit_submit"  class="btn btn-default btn-block">修改</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-4 column">
				</div>
			</div>
		</div>
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>