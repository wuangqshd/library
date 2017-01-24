<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
$('#manger_mymenu').datagrid({
    height: '100%',
    gridTitle : '我的菜单页面',
    showToolbar: true,
    toolbarItem: 'add,edit,cancel,save, |,del',
    local: 'local',
    dataUrl: '<%=basePath%>findmypage.do',
    columns: [
		{
		    name: 'id',
		    label: '页面id',
		    add:false,
		    edit:false,
		    align: 'center'
		},  
        {
            name: 'menuname',
            label: '菜单名称',
            align: 'center'
        },
        
        {
            name: 'menuabout',
            label: '页面说明',
            align: 'center'
        },
        
        {
            name: 'menuurl',
            label: '功能指向',
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
            name: 'createid',
            label: '创建人',
            align: 'center',
            edit: false,
            add: false
        },
        {
            name: 'pagetarget',
            label: '页面展示方式',
            align: 'center'
        }
    ],
    editUrl: '<%=basePath%>editmypage.do',
    delUrl:'<%=basePath%>delmypage.do',
    tableWidth:'100%',
    noremove: false
})
</script>

<div class="bjui-pageContent">
    <table id="manger_mymenu" class="table table-bordered">
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>