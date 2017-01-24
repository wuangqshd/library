<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script >

$('#findborrowuser_dialog').click(function(){
	BJUI.dialog({
		id:'finduser_dialog',
	    url:'findborrowuser.do',
	    title:'请选择用户',
	    mask:true,
	    width:600,
	    height:500
	});
});
$('#borrowout_selectbook').click(function(){
	BJUI.dialog({
		id:'findbook_dialog',
	    url:'findborrowbook.do',
	    title:'请选择借阅书籍',
	    mask:true,
	    width:600,
	    height:500
	});
});
$('#borrowout_book').datagrid({
    height: 300,
    gridTitle : '图书信息',
    local: 'local',
    filterThead:false,
    showNoDataTip:false,
    dataUrl: '<%=basePath%>findborrowout_book.do',
    columns: [
		{
		    name: 'bookcode',
		    label: '图书编号',
		    align: 'center'
		},
        {
            name: 'bookname',
            label: '书名',
            align: 'center'
        },
        
        {
            name: 'bookpress',
            label: '出版社',
            align: 'center'
        },
        
        {
            name: 'bookintroduction',
            label: '简介',
            align: 'center'
        },
        {
            name: 'bookclass',
            label: '类别',
            align: 'center'
        },
        {
            name: 'bookpice',
            label: '价格',
            align: 'center'
        },
        {
            name: 'bookwriter',
            label: '作者',
            align: 'center'
        },
        
        {
            name: 'borrownum',
            label: '借阅次数',
            align: 'center'
        },
        {
            name: 'bookstate',
            label: '状态',
            align: 'center',
            items: [{'1':'正常'},{'2':'禁用'}]
        }
    ],
    exportOption:{type:"ajax",options:{url:"export.do"}},
    editUrl: '<%=basePath%>editborrowout_book.do',
    delUrl:'<%=basePath%>delborrowout_book.do',
    tableWidth:'100%',
    noremove: false
})
</script>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					图书借阅 <small>Book Borrow</small>
				</h1>
			</div>
			<div class="row clearfix">
				<div class="col-md-4 column">
					<div class="row clearfix">
						<div class="col-md-8 column">
							<h3 class="text-center">
								借阅者信息
							</h3>
						</div>
						<div class="col-md-4 column">
						</div>
					</div>
					<a type="button" id="findborrowuser_dialog" class="btn btn-primary btn-sm">选择借阅者</a>
					<div class="row clearfix">
						<div class="col-md-6 column">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>
											姓名
										</th>
										<th id="borrow_username">
											
										</th>
								</thead>
								<tbody>
									<tr>
										<td>
											借阅编号
										</td>
										<td id="borrow_userborrowcode">
										
										</td>
									</tr>
									<tr>
										<td>
											身份证号
										</td>
										<td id = "borrow_useridentityid">
											
										</td>
									</tr>
									<tr>
										<td>
											电话
										</td>
										<td id="borrow_userphone">
											
										</td>
									</tr>
									<tr>
										<td>
											单位
										</td>
										<td id="borrow_usercompany">
											
										</td>
									</tr>
									<tr>
										<td>
											可借阅数量
										</td>
										<td id="borrow_usernum">
											
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-6 column">
						<img id="borrow_userpic" width="192px" height="144px" alt="没有头像" src="/library/images/nopic.png">
						</div>
					</div>
				</div>
			
				<div class="col-md-8 column">
					<div class="row clearfix">
						<div class="col-md-8 column">
							<h3 class="text-center">
								借阅书籍
							</h3>
						</div>
						<div class="col-md-4 column">
						</div>
					</div> <button type="button" id="borrowout_selectbook" class="btn btn-sm btn-primary">添加书籍</button>
					<table id="borrowout_book" class="table table-bordered table-hover" >
					</table>
				</div>
				
			</div>
		</div>
	</div>
</div>