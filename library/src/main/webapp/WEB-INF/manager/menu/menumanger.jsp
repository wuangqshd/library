<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">

	$('#manger_manger').datagrid({
	    height: '100%',
	    gridTitle : '菜单模板',
	    showToolbar: true,
	    toolbarItem: 'all',
	    local: 'local',
	    dataUrl: '<%=basePath%>findmenuformod.do',
	    columns: [
			{
			    name: 'createid',
			    label: '模板类型',
			    align: 'center'
			},
			{
			    name: 'id',
			    label: '菜单id',
			    align: 'center'
			},  
			{
			    name: 'menuroot',
			    label: '菜单层级',
			    align: 'center'
			},
	        {
	            name: 'menuname',
	            label: '菜单名称',
	            align: 'center'
	        },
	        
	        {
	            name: 'menufatherid',
	            label: '父级id',
	            align: 'center'
	        },
	        
	        {
	            name: 'menupagedo',
	            label: '功能指向',
	            align: 'center'
	        },
	        {
	            name: 'menutarget',
	            label: '打开方式',
	            align: 'center'
	        },
	        {
	            name: 'createtime',
	            label: '创建时间',
	            width :140,
	            edit: false,
	            add: false,
	            align: 'center',
	            type: 'date',	
	            pattern: 'yyyy-MM-dd HH:mm:ss'
	        },
	        
	        {
	            name: 'sort',
	            label: '排序',
	            align: 'center'
	        }
	    ],
	    editUrl: '<%=basePath%>editmodmenu.do',
	    delUrl:'<%=basePath%>delmodmenu.do',
	    tableWidth:'100%',
	    noremove: false
	})


</script>

<div class="bjui-pageContent">
    <table id="manger_manger" class="table table-bordered">
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>