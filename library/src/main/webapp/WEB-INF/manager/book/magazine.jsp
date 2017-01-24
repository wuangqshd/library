<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
$('#magazine_info').datagrid({
    height: '100%',
    gridTitle : '杂志信息',
    showToolbar: true,
    toolbarItem: 'all',
    local: 'local',
    dataUrl: '<%=basePath%>findmagazine.do',
    columns: [
		{
		    name: 'id',
		    label: '杂志id',
		    edit:false,
		    add:false,
		    align: 'center'
		},  
		{
		    name: 'magazinecode',
		    label: '杂志编号编号',
		    align: 'center'
		},
        {
            name: 'magazinename',
            label: '书名',
            align: 'center'
        },
        
        {
            name: 'magazinepress',
            label: '出版社',
            align: 'center'
        },
        
        {
            name: 'magazineintroduction',
            label: '简介',
            align: 'center'
        },
        {
            name: 'magazineclass',
            label: '类别',
            align: 'center'
        },
        {
            name: 'magazineprice',
            label: '价格',
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
            name: 'magazinestate',
            label: '状态',
            align: 'center',
            items: [{'1':'正常'},{'2':'禁用'}]
        }
    ],
    exportOption:{type:"ajax",options:{url:"export.do"}},
    editUrl: '<%=basePath%>editmagazine.do',
    delUrl:'<%=basePath%>delmagazine.do',
    tableWidth:'100%',
    noremove: false
})
</script>

<div class="bjui-pageContent">
    <table id="magazine_info" class="table table-bordered">
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>