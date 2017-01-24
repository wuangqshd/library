<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">

	$('#power_otherpower').datagrid({
	    height: '100%',
	    gridTitle : '其他权限管理',
	    showToolbar: true,
	    toolbarItem: 'all',
	    local: 'local',
	    dataUrl: '<%=basePath%>findotherpower.do',
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
	    editUrl: '<%=basePath%>editotherpower.do',
	    delUrl:'<%=basePath%>delotherpower.do',
	    tableWidth:'100%',
	    noremove: false
	})


</script>

<div class="bjui-pageContent">
    <table id="power_otherpower" class="table table-bordered">
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>