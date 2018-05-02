<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post">
		<!-- <input type="hidden" id="id" name="id"/>
		<input type="hidden" id="" name="netid"/> -->
 	<input class="easyui-textbox" name="netid" data-options="hidden:true" ></input>
	    <table cellpadding="5">
	        <tr>
	            <td>书籍类目:</td>
	            <td>
	            	${tbNovel.tname }
	            </td>
	        </tr>
	        <tr>
	            <td>书籍标题:</td>

	            <td><h3 style="text-align: left; color: red;">${tbNovel.tittle} </h3> </td>
	        </tr>
	        <tr>
	            <td>书籍作者:</td>
	            <td>${tbNovel.author}</td>
	        </tr>
	        <tr>
	            <td>书籍状态:</td>
	            <td>${tbNovel.status == 1 ? '连载':'完结'}
	            </td>
	        </tr>
	        <tr>
	            <td>点击量:</td>
	            <td>${tbNovel.clicknum} </td>
	        </tr>
			<tr>
	            <td>是否有效:</td>
	            <td>${tbNovel.vaild == 1 ? '无效':'有效'} </td>
	        </tr>
			<tr>
				<td>章节目录:</td>
				<td><a href="" onclick="constructionManager(${tbNovel.id},${tbNovel.netid})">章节目录</a> </td>
			</tr>
	        <tr>
	            <td>书籍图片:</td>
	            	<td> 
	                <div id="imgdiv" >
					</div>
	            </td>
	        </tr>
	        <tr>
	            <td>书籍简介:</td>
	            <td>
	                <textarea  style="width:800px;height:300px;visibility:hidden;" name="tbNovel.desc"></textarea>
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
	itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=tbNovel.desc]");

	initDesc();
		
	});

	
	function initDesc(){

		// 加载书籍描述
        $.getJSON('/novel/desc/'+ ${tbNovel.netid}  +'/'+${tbNovel.id},function(_data){
            if(_data.status == 200){
				 itemEditEditor.html(_data.data.introduction);

                $("#imgdiv").append("<li><a href='http://www.kanshuzhong.com"+_data.data.imgpath+"' target='_blank'><img src='http://www.kanshuzhong.com"+_data.data.imgpath+"' width='80' height='50' /></a></li>");
            }
        });
		}


	//initDesc();
    function constructionManager(id,netId){
        alert(id);
        alert(netId);
        var tabs = $("#tabs");
        var tab = tabs.tabs("getTab","章节目录");
        if(tab){
            tabs.tabs("add",{
                title:"章节目录",
                href: '/novel/chapter/'+netId+'/'+id,
                closable:true,
                bodyCls:"content"
            });
        }else{
            tabs.tabs('add',{
                title:"书籍详情",
                href: '/novel/chapter/'+netId+'/'+id,
                closable:true,
                bodyCls:"content"
            });
        }

    }

</script>
