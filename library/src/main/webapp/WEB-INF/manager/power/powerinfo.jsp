<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">

	$('#power_info').datagrid({
	    height: '100%',
	    gridTitle : '权限管理',
	    showToolbar: true,
	    toolbarItem: 'all',
	    local: 'local',
	    dataUrl: '<%=basePath%>findpower.do',
	    columns: [
			{
			    name: 'id',
			    label: '权限id',
			    align: 'center'
			},  
			{
			    name: 'powername',
			    label: '权限名称',
			    align: 'center'
			},
	        {
	            name: 'pageids',
	            label: '权限页面id',
	            align: 'center'
	        },
	        {
	            name: 'createtime',
	            label: '创建时间',
	            edit: false,
	            add: false,
	            align: 'center',
	            type: 'date',	
	            pattern: 'yyyy-MM-dd HH:mm:ss'
	        },
	        {
	            name: 'startmod',
	            label: '权限菜单模板',
	            align: 'center'
	        }
	    ],
	    editUrl: '<%=basePath%>editpower.do',
	    delUrl:'<%=basePath%>delpower.do',
	    tableWidth:'100%',
	    noremove: false
	})


</script>

<div class="bjui-pageContent">
    <table id="power_info" class="table table-bordered">
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>