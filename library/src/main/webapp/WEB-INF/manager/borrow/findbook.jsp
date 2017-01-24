<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
$('#findbook_selected').click(function(){
	var data = $('#bookinfo_bookstable').data('selectedDatas');
	if (data==undefined) {
		layer.msg("请选择用户");
	}
	var i = 0;
	while (i<data.length) {
		alert(data[i].bookname);
		alert("下一个");
		i++;
	}
	BJUI.dialog('close','findbook_dialog');
})
$('#bookinfo_bookstable').datagrid({
    height: '100%',
    gridTitle : '图书信息',
    local: 'local',
    dataUrl: '<%=basePath%>findbook.do',
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
            name: 'bookstate',
            label: '状态',
            align: 'center',
            items: [{'1':'正常'},{'2':'禁用'}]
        }
    ],
    showCheckboxcol:true,
    tableWidth:'100%',
    noremove: false,
    hScrollbar:true
})
</script>

<div class="bjui-pageContent">
    <table id="bookinfo_bookstable" class="table table-bordered">
    </table>
</div>
<div class="bjui-pageFooter">
    <ul>
   		<li><button type="button" id="findbook_selected" class="btn-blue" data-icon="check">借出</button></li>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>
