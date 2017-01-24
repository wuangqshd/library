<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
$('#person_workerinfo').datagrid({
    height: '100%',
    gridTitle : '工作人员',
    showToolbar: true,
    toolbarItem: 'add,edit,cancel,save, |,del',
    local: 'local',
    dataUrl: '<%=basePath%>getworkerinfo.do',
    columns: [
		{
		    name: 'id',
		    label: '用户id',
		    edit:false,
		    add:false,
		    align: 'center'
		},  
		{
		    name: 'usercode',
		    label: '用户编号',
		    align: 'center'
		},
        {
            name: 'username',
            label: '用户名',
            align: 'center'
        },
        
        {
            name: 'useraccount',
            label: '用户账号',
            align: 'center'
        },
        
        {
            name: 'usermail',
            label: '用户邮箱',
            align: 'center'
        },
        {
            name: 'userphone',
            label: '用户联系方式',
            align: 'center'
        },
        {
            name: 'userage',
            label: '用户年龄',
            align: 'center'
        },
        {
            name: 'userbirthday',
            label: '用户生日',
            align: 'center'
        },
        {
            name: 'usercompany',
            label: '单位',
            align: 'center'
        },
        {
            name: 'userpic',
            label: '用户头像',
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
            name: 'userstate',
            label: '状态',
            align: 'center',
            edit: false,
            add: false,
            items: [{'1':'正常'},{'2':'禁用'}]
        }
        
    ],
    contextMenuB:true,
    showCheckboxcol:true,
    editUrl: '<%=basePath%>editworkerinfo.do',
    delUrl:'<%=basePath%>delworkerinfo.do',
    tableWidth:'100%',
    noremove: false
})

</script>

<div class="bjui-pageContent">
    <table id="person_workerinfo" class="table table-bordered">
    </table>
    
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>