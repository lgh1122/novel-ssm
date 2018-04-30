<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="书籍列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/novel/list',method:'post',pageSize:30,toolbar:easyui_toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	 
        	<th data-options="field:'id',width:60,formatter:goNovelInfo">书籍ID</th>
            <th data-options="field:'tittle',width:200">书籍标题</th>
            <th data-options="field:'tid',width:200,hidden:'true'">书籍类目ID</th>
            <th data-options="field:'netid',width:200,hidden:'true'">书籍网站ID</th>
            <th data-options="field:'tname',width:100">书籍类目</th>
            <th data-options="field:'author',width:100">作者</th>
            <th data-options="field:'latestchaptername',width:100">最新章节</th> 
            <th data-options="field:'status',width:70,align:'right',formatter:TAOTAO.formatItemStatus">状态</th>
            <th data-options="field:'clicknum',width:70,align:'right'">点击量</th>
            <th data-options="field:'downnum',width:100">下载量</th>
            <th data-options="field:'vaild',width:60,align:'center',formatter:TAOTAO.formatItemVaild">是否有效</th>
            <th data-options="field:'addtime',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updatetime',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
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
				<div data-options="name:'tittle',iconCls:'icon-ok'">书籍名称</div>
				<div data-options="name:'author'">作者</div>
				<div data-options="name:'tname'">类型</div>
 			</div>
         </div>  
  </div> 
        
  <div id="itemEditWindow" class="easyui-window" title="书籍详情" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/novel-info'" style="width:80%;height:80%;padding:10px;">
</div> 
<script>
function  goNovelInfo(val,row){
	return '<a href="#" onclick="constructionManager(\'' + row.id+ '\',\''+row.netid+'\')">'+ row.id+'</a>  '
} 

function constructionManager(id,netId){
	//alert(id);
	//alert(netId);
	var tabs = $("#tabs");
	var tab = tabs.tabs("getTab","书籍详情");
	if(tab){
		tabs.tabs("add",{
		    title:"书籍详情",
		    href: '/novel-info/'+netId+'/'+id,
		    closable:true,
		    bodyCls:"content"
		});
	}else{
		tabs.tabs('add',{
		    title:"书籍详情",
		    href: '/novel/info/'+netId+'/'+id,
		    closable:true,
		    bodyCls:"content"
		});
	}
	
}
	function seachNovel(value, name) {
		var novel = {};
		novel[name] = value;
		// comparativePriceVO["provinceId"]  =  $("#provinceId").val();  
		//alert(value + ":" + name);
		$('#itemList').datagrid('load', novel);
	}

	/* function doSearch(){
	 $('#itemList').datagrid('load',{
	 itemid: $('#itemid').val(),
	 productid: $('#productid').val()
	 });
	 } */
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