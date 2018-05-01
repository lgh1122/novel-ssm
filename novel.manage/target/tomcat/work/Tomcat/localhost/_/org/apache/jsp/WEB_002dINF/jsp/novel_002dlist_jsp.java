/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-01 02:14:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class novel_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<table class=\"easyui-datagrid\" id=\"itemList\" title=\"书籍列表\" \r\n");
      out.write("       data-options=\"singleSelect:false,collapsible:true,pagination:true,url:'/novel/list',method:'post',pageSize:30,toolbar:easyui_toolbar\">\r\n");
      out.write("    <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("        \t<th data-options=\"field:'ck',checkbox:true\"></th>\r\n");
      out.write("        \t \r\n");
      out.write("        \t<th data-options=\"field:'id',width:60,formatter:goNovelInfo\">书籍ID</th>\r\n");
      out.write("            <th data-options=\"field:'tittle',width:200\">书籍标题</th>\r\n");
      out.write("            <th data-options=\"field:'tid',width:200,hidden:'true'\">书籍类目ID</th>\r\n");
      out.write("            <th data-options=\"field:'netid',width:200,hidden:'true'\">书籍网站ID</th>\r\n");
      out.write("            <th data-options=\"field:'tname',width:100\">书籍类目</th>\r\n");
      out.write("            <th data-options=\"field:'author',width:100\">作者</th>\r\n");
      out.write("            <th data-options=\"field:'latestchaptername',width:100\">最新章节</th> \r\n");
      out.write("            <th data-options=\"field:'status',width:70,align:'right',formatter:TAOTAO.formatItemStatus\">状态</th>\r\n");
      out.write("            <th data-options=\"field:'clicknum',width:70,align:'right'\">点击量</th>\r\n");
      out.write("            <th data-options=\"field:'downnum',width:100\">下载量</th>\r\n");
      out.write("            <th data-options=\"field:'vaild',width:60,align:'center',formatter:TAOTAO.formatItemVaild\">是否有效</th>\r\n");
      out.write("            <th data-options=\"field:'addtime',width:130,align:'center',formatter:TAOTAO.formatDateTime\">创建日期</th>\r\n");
      out.write("            <th data-options=\"field:'updatetime',width:130,align:'center',formatter:TAOTAO.formatDateTime\">更新日期</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("    \r\n");
      out.write("    <div  id=\"easyui_toolbar\" region=\"north\" border=\"false\" style=\"border-bottom: 1px solid #ddd; height: 32px; padding: 2px 5px; background: #fafafa;\">  \r\n");
      out.write("         <div style=\"float: left;\">  \r\n");
      out.write("             <a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" icon=\"icon-add\">新增</a>  \r\n");
      out.write("         </div>  \r\n");
      out.write("\r\n");
      out.write("         <div class=\"datagrid-btn-separator\"></div>  \r\n");
      out.write("         <div style=\"float: left;\">  \r\n");
      out.write("             <a href=\"#\" class=\"easyui-linkbutton\" onclick=\"editNovel()\" plain=\"true\" icon=\"icon-save\">编辑</a>  \r\n");
      out.write("         </div>  \r\n");
      out.write("         <div class=\"datagrid-btn-separator\"></div>  \r\n");
      out.write("         <div style=\"float: left;\">  \r\n");
      out.write("             <a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\"  \r\n");
      out.write("                 icon=\"icon-remove\">删除</a>  \r\n");
      out.write("         </div>  \r\n");
      out.write("         <div id=\"tb\" style=\"float: right;\">  \r\n");
      out.write("         <input id=\"ss\" class=\"easyui-searchbox\" style=\"width:300px\" data-options=\"searcher:seachNovel,prompt:'Please Input Value',menu:'#mm'\"></input>\r\n");
      out.write(" \t\t\t<div id=\"mm\" style=\"width:120px\">\r\n");
      out.write("\t\t\t\t<div data-options=\"name:'tittle',iconCls:'icon-ok'\">书籍名称</div>\r\n");
      out.write("\t\t\t\t<div data-options=\"name:'author'\">作者</div>\r\n");
      out.write("\t\t\t\t<div data-options=\"name:'tname'\">类型</div>\r\n");
      out.write(" \t\t\t</div>\r\n");
      out.write("         </div>  \r\n");
      out.write("  </div> \r\n");
      out.write("        \r\n");
      out.write("  <div id=\"itemEditWindow\" class=\"easyui-window\" title=\"书籍详情\" data-options=\"modal:true,closed:true,iconCls:'icon-save',href:'/novel-info'\" style=\"width:80%;height:80%;padding:10px;\">\r\n");
      out.write("</div> \r\n");
      out.write("<script>\r\n");
      out.write("function  goNovelInfo(val,row){\r\n");
      out.write("\treturn '<a href=\"#\" onclick=\"constructionManager(\\'' + row.id+ '\\',\\''+row.netid+'\\')\">'+ row.id+'</a>  '\r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("function constructionManager(id,netId){\r\n");
      out.write("\t//alert(id);\r\n");
      out.write("\t//alert(netId);\r\n");
      out.write("\tvar tabs = $(\"#tabs\");\r\n");
      out.write("\tvar tab = tabs.tabs(\"getTab\",\"书籍详情\");\r\n");
      out.write("\tif(tab){\r\n");
      out.write("\t\ttabs.tabs(\"add\",{\r\n");
      out.write("\t\t    title:\"书籍详情\",\r\n");
      out.write("\t\t    href: '/novel-info/'+netId+'/'+id,\r\n");
      out.write("\t\t    closable:true,\r\n");
      out.write("\t\t    bodyCls:\"content\"\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\ttabs.tabs('add',{\r\n");
      out.write("\t\t    title:\"书籍详情\",\r\n");
      out.write("\t\t    href: '/novel/info/'+netId+'/'+id,\r\n");
      out.write("\t\t    closable:true,\r\n");
      out.write("\t\t    bodyCls:\"content\"\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\tfunction seachNovel(value, name) {\r\n");
      out.write("\t\tvar novel = {};\r\n");
      out.write("\t\tnovel[name] = value;\r\n");
      out.write("\t\t// comparativePriceVO[\"provinceId\"]  =  $(\"#provinceId\").val();  \r\n");
      out.write("\t\t//alert(value + \":\" + name);\r\n");
      out.write("\t\t$('#itemList').datagrid('load', novel);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* function doSearch(){\r\n");
      out.write("\t $('#itemList').datagrid('load',{\r\n");
      out.write("\t itemid: $('#itemid').val(),\r\n");
      out.write("\t productid: $('#productid').val()\r\n");
      out.write("\t });\r\n");
      out.write("\t } */\r\n");
      out.write("\tfunction getSelectionsIds() {\r\n");
      out.write("\t\tvar itemList = $(\"#itemList\");\r\n");
      out.write("\t\tvar sels = itemList.datagrid(\"getSelections\");\r\n");
      out.write("\t\tvar ids = [];\r\n");
      out.write("\t\tfor ( var i in sels) {\r\n");
      out.write("\t\t\tids.push(sels[i].id);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tids = ids.join(\",\");\r\n");
      out.write("\t\treturn ids;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t function editNovel() {\r\n");
      out.write("\t\t\tvar ids = getSelectionsIds();\r\n");
      out.write("\t\t\tif (ids.length == 0) {\r\n");
      out.write("\t\t\t\t$.messager.alert('提示', '必须选择一个书籍才能编辑!');\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (ids.indexOf(',') > 0) {\r\n");
      out.write("\t\t\t\t$.messager.alert('提示', '只能选择一个书籍!');\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#itemEditWindow\")\r\n");
      out.write("\t\t\t\t\t.window(\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\tonLoad : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//回显数据\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar data = $(\"#itemList\").datagrid(\"getSelections\")[0]; \r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#itemeEditForm\").form(\"load\",data);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\tTAOTAO.init({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"tid\" : data.tid\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t// 加载商品描述\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$.getJSON('/novel/desc/'+ data.netid  +'/'+data.id,function(_data){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif(_data.status == 200){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\titemEditEditor.html(_data.data.introduction);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#imgdiv\").append(\"<li><a href='http://www.kanshuzhong.com\"+_data.data.imgpath+\"' target='_blank'><img src='http://www.kanshuzhong.com\"+_data.data.imgpath+\"' width='80' height='50' /></a></li>\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//\t.find(\"ul\").append(\"<li><a href='http://www.kanshuzhong.com/image/0/905/905s.jpg' target='_blank'><img src=''http://www.kanshuzhong.com/image/0/905/905s.jpg'' width='80' height='50' /></a></li>\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}).window(\"open\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t \r\n");
      out.write("\tvar toolbar = [\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\ttext : '新增',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-add',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t$(\".tree-title:contains('新增商品')\").parent().click();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}];\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
