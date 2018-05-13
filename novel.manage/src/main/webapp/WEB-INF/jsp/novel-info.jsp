<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post">
		<!-- <input type="hidden" id="id" name="id"/>
		<input type="hidden" id="" name="netid"/> -->
 	<input class="easyui-textbox" name="netid" data-options="hidden:true" ></input>
		<input class="easyui-textbox" name="id" data-options="hidden:true"  ></input> 
	    <table cellpadding="5">
	        <tr>
	            <td>书籍类目:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectNovelType">选择类目</a>
	            	<input type="hidden" name="tid" style="width: 280px;"></input>	
	            </td>
	        </tr>
	        <tr>
	            <td>书籍标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>书籍作者:</td>
	            <td><input class="easyui-textbox" name="author" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>书籍状态:</td>
	            <td><input class="easyui-numberbox" type="text" name="status" data-options="formatter:TAOTAO.formatItemStatus,required:true" />
	            	 
	            </td>
	        </tr>
	        <tr>
	            <td>点击量:</td>
	            <td><input class="easyui-numberbox" type="text" name="clicknum" data-options="min:1,max:99999999,precision:0" /></td>
	        </tr>
	         <tr>
	            <td>是否有效:</td>
	            <td><input class="easyui-numberbox" type="text" name="vaild" data-options="formatter:TAOTAO.formatItemVaild,required:true" /></td>
	        </tr>
	         
	        <tr>
	            <td>书籍图片:</td>
	            	<td> 
	                <div id="imgdiv" ></div>
	            </td>
	        </tr>
	        <tr>
	            <td>书籍简介:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>
	        <tr class="params hide">
	        	<td>商品规格:</td>
	        	<td>
	        		
	        	</td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	    <input type="hidden" name="itemParamId"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var itemEditEditor ;
	$(function(){
		//实例化编辑器
		itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=desc]");

		//initDesc();
		/* alert($("#id").val());
		alert($("#itemeEditForm [name=id]")); */
		
	});

	
	function initDesc(){

		// 加载书籍描述
		$.getJSON('/novel/desc/'+ 3  +'/'+905,function(_data){
			if(_data.status == 200){
				//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
				itemEditEditor.html(_data.data);
			}
		});
		}


	//initDesc();
	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$("#itemeEditForm [name=price]").val(eval($("#itemeEditForm [name=priceView]").val()) * 1000);
		itemEditEditor.sync();
		
		var paramJson = [];
		$("#itemeEditForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		paramJson = JSON.stringify(paramJson);
		
		$("#itemeEditForm [name=itemParams]").val(paramJson);
		
		$.post("/rest/item/update",$("#itemeEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#itemEditWindow").window('close');
					$("#itemList").datagrid("reload");
				});
			}
		});
	}
</script>
