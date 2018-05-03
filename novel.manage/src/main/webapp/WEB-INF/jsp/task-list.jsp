<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="taskList" title="定时任务列表" 
       data-options="singleSelect:true,collapsible:true,pagination:true , pageSize:30,toolbar:itemParamListToolbar">
    <thead>
        <tr>
            <th field="ck"></th>
			<th field="id" width="100">任务id</th>
			<th field="name" width="100">任务名称</th>
			<th field="tasknet" width="100">所属网站</th>
			<th field="task" width="100">操作</th>
			 
		</tr>                          
    </thead>
    	<tbody>                            
		<tr>  
		<td><input type="checkbox" ></td>                         
			<td>3001</td>            
			<td>初始小说书籍数据</td>            
			<td>看书中</td>            
			<td>插入</td>
		</tr>                          
		<tr> 
		<td><input type="checkbox" ></td>                                  
			<td>3002</td>            
			<td>更新小说书籍数据</td>            
			<td>看书中</td>            
			<td>更新</td>            
			           
		</tr>                                                   
	</tbody>                           
    
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

	function formatItemParamData(value , index){
		var json = JSON.parse(value);
		var array = [];
		$.each(json,function(i,e){
			array.push(e.group);
		});
		return array.join(",");
	}

    function getSelectionsIds(){
    	var itemList = $("#taskList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var itemParamListToolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	TAOTAO.createWindow({
        		url : "/item-param-add",
        	});
        }
    },{
        text:'执行',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个任务才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定执行ID为 '+ids+' 的任务吗？',function(r){
        	    if (r){
        	    	var params = {"id":ids};
                	$.post("/novel/spider",params, function(data){
            			//if(data.status == 200){
            				$.messager.alert('提示', data);
            			//}
            		});
        	    }
        	});
        	
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品规格!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品规格吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/item/param/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品规格成功!',undefined,function(){
            					$("#itemParamList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>