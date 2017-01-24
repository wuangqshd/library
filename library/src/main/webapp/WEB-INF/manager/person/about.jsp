<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					关于我们 <small>About OurSystem</small>
				</h1>
			</div>
			<div class="jumbotron">
				<h1>
					图书管理系统
				</h1>
				<p>
					随着社会经济的迅速发展，计算机管理信息系统已成为管理科学化和现代化的重要标志。
					图书管理系统使人们摆脱了手工、纸质的传统管理方式，给图书管理带来了巨大效益，
					具有成本低廉，可扩展性强、查询借阅快捷准确、人员管理方便等优点。
					新时期我军信息化建设对军校信息化提出了更高要求。图书管理系统作为学校信息管理系统的重要构件，
					一方面可使学员，教员更方便、快捷地阅读到感兴趣的图书，另一方面可降低收集、整理、归类队内图书的工作量，
					实现图书在学员队内的有序循环使用。
				</p>
				<p>
					 <a class="btn btn-primary btn-large" href="http://wpa.qq.com/msgrd?v=3&uin=1021640745&site=qq&menu=yes">联系我们</a>
				</p>
			</div>
		</div>
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>