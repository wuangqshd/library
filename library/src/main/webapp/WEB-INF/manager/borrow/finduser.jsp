<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
$('#finduser_info').datagrid({
    height: '100%',
    gridTitle : '请选择用户（多选默认为第一个）',
    local: 'local',
    dataUrl: '<%=basePath%>getborrowuserinfo.do',
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
    tableWidth:'100%',
    noremove: false,
    hScrollbar:true
})
$('#finduser_selected').click(function(){
	var data = $('#finduser_info').data('selectedDatas');
	if (data==undefined) {
		layer.msg("请选择用户");
	}
	$('#borrow_userpic').attr('src','/library/images/loginbg_01.jpg');
	$('#borrow_username').text(data[0].username);
	$('#borrow_userborrowcode').text(data[0].userborrowcode);
	$('#borrow_useridentityid').text(data[0].useridentityid);
	$('#borrow_userphone').text(data[0].userphone);
	$('#borrow_usercompany').text(data[0].usercompany);
	$('#borrow_usernum').text(data[0].usernum);
	layer.msg("您选择了"+data[0].username);
	BJUI.dialog('close','finduser_dialog');
	changetext();
})
function changetext(){
	
}
</script>

<div class="bjui-pageContent">
    <table id="finduser_info" class="table table-bordered">
    </table>
</div>
 <div class="bjui-pageFooter">
    <ul>
    	<li><button type="button" id="finduser_selected" class="btn-blue" data-icon="check">确定</button></li>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
	</div> 
