<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
$('#borrow_info').datagrid({
    height: '100%',
    gridTitle : '借阅信息',
    showToolbar: true,
    toolbarItem: 'all',
    local: 'local',
    dataUrl: '<%=basePath%>findborrowinfo.do',
    columns: [
		{
		    name: 'bookid',
		    label: '所借书籍',
		    align: 'center'
		},
        {
            name: 'userid',
            label: '借阅者',
            align: 'center'
        },
        {
            name: 'borrowtime',
            label: '借阅时间',
            edit: false,
            add: false,
            align: 'center',
            type: 'date',	
            pattern: 'yyyy-MM-dd HH:mm:ss'
        },
        {
            name: 'stilltime',
            label: '到期时间',
            edit: false,
            add: false,
            align: 'center',
            type: 'date',	
            pattern: 'yyyy-MM-dd HH:mm:ss'
        },
        {
            name: 'mangerid',
            label: '创建人',
            align: 'center',
            edit: false,
            add: false
        },
        {
            name: 'borrowstate',
            label: '状态',
            align: 'center',
            items: [{'1':'正常'},{'2':'超时'}]
        },
        {
            name: 'borrowoverprice',
            label: '超时计费',
            align: 'center',
            edit: false,
            add: false
        },
    ],
    exportOption:{type:"ajax",options:{url:"export.do"}},
    editUrl: '<%=basePath%>editborrowinfo.do',
    delUrl:'<%=basePath%>delborrowinfo.do',
    tableWidth:'100%',
    noremove: false
})
</script>

<div class="bjui-pageContent">
    <table id="borrow_info" class="table table-bordered">
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>
