<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="书籍列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/task/list',method:'post',pageSize:30,toolbar:easyui_toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60,formatter:goNovelInfo">任务ID</th>
            <th data-options="field:'jobCode',width:200">任务编号</th>
            <th data-options="field:'jobDescription',width:300">任务描述</th>
            <th data-options="field:'cronExpression',width:300">执行时间表达式</th>
            <th data-options="field:'targetObject',width:300">任务实现类</th>
            <th data-options="field:'targetMethod',width:100">实现方法</th>
            <th data-options="field:'validStatus',width:100">是否有效</th>
            <th data-options="field:'conCurrent',width:100,align:'right'">是否并发执行</th>
        </tr>
    </thead>
</table>


 
    
    <div  id="easyui_toolbar" region="north" border="false" style="border-bottom: 1px solid #ddd; height: 32px; padding: 2px 5px; background: #fafafa;">  
         <div style="float: left;">  
             <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add">新增</a>  
         </div>  

         <div class="datagrid-btn-separator"></div>  
         <div style="float: left;">  
             <a href="#" class="easyui-linkbutton" onclick="editNovel()" plain="true" icon="icon-save">编辑</a>  
         </div>  
         <div class="datagrid-btn-separator"></div>  
         <div style="float: left;">  
             <a href="#" class="easyui-linkbutton" plain="true"  
                 icon="icon-remove">删除</a>  
         </div>  
         <div id="tb" style="float: right;">  
         <input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:seachNovel,prompt:'Please Input Value',menu:'#mm'"></input>
 			<div id="mm" style="width:120px">
				<div data-options="name:'tittle',iconCls:'icon-ok'">任务编号</div>
 			</div>
         </div>  
  </div> 
        
  <div id="itemEditWindow" class="easyui-window" title="书籍详情" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/novel-info'" style="width:80%;height:80%;padding:10px;">
</div> 
<script>


	function getSelectionsIds() {
		var itemList = $("#itemList");
		var sels = itemList.datagrid("getSelections");
		var ids = [];
		for ( var i in sels) {
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}


	 function editNovel() {
			var ids = getSelectionsIds();
			if (ids.length == 0) {
				$.messager.alert('提示', '必须选择一个书籍才能编辑!');
				return;
			}
			if (ids.indexOf(',') > 0) {
				$.messager.alert('提示', '只能选择一个书籍!');
				return;
			}

			$("#itemEditWindow")
					.window(
							{
								onLoad : function() {
									//回显数据
									var data = $("#itemList").datagrid("getSelections")[0]; 
									$("#itemeEditForm").form("load",data);

									TAOTAO.init({
										"tid" : data.tid
									});
									// 加载商品描述
									$.getJSON('/novel/desc/'+ data.netid  +'/'+data.id,function(_data){
										if(_data.status == 200){
											//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
											itemEditEditor.html(_data.data.introduction);
											$("#imgdiv").append("<li><a href='http://www.kanshuzhong.com"+_data.data.imgpath+"' target='_blank'><img src='http://www.kanshuzhong.com"+_data.data.imgpath+"' width='80' height='50' /></a></li>");
										//	.find("ul").append("<li><a href='http://www.kanshuzhong.com/image/0/905/905s.jpg' target='_blank'><img src=''http://www.kanshuzhong.com/image/0/905/905s.jpg'' width='80' height='50' /></a></li>");
										}
									});
									
								}
							}).window("open");
		}
	 
	var toolbar = [
			{
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					$(".tree-title:contains('新增商品')").parent().click();
				}
			}];
</script>