<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<<script type="text/javascript">
<!--

//-->


BJUI.ajax('doajax', {
    url: 'doGetBookClass.do',
    loadingmask: true,
    okCallback: function(json, options) {
        console.log('返回内容：\n'+ JSON.stringify(json))
    }
})


</script>
<div class="bjui-pageContent">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-2 column">
				</div>
				<div class="col-md-6 column">
					<h3>
						图书录入
					</h3>
					<form class="form-horizontal" action="doBookLogin.do" role="form">
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">书名</label>
							<div class="col-sm-10">
								<input class="form-control" id="bookName" type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">出版社</label>
							<div class="col-sm-10">
								<input class="form-control" id="bookPress" type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
							<div class="col-sm-10">
								<input class="form-control" id="bookIntroduction" type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">类别</label>
							<div class="col-sm-10">
							<select class="form-control" id="bookLogin_selectClass">
							</select>
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">价格</label>
							<div class="col-sm-10">
								<input class="form-control" id="bookPice" type="text" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">作者</label>
							<div class="col-sm-10">
								<input class="form-control" id="bookWriter" type="text" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">添加</button>
							</div>
						</div>
					</form>
					<div class="row clearfix">
						<div class="col-md-4 column">
						</div>
						<div class="col-md-4 column">
							 <button type="button" class="btn btn-lg btn-primary btn-block">导入书籍</button>
						</div>
						<div class="col-md-4 column">
							 <button type="button" class="btn btn-link btn-lg">下载导入模板</button>
						</div>
					</div>
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