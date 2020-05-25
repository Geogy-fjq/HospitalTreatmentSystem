﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>东软云医院HIS系统</title>
<meta name="loginName" id="loginName" content="">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="index.jsp">东软云医院HIS系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li><a id="loginName-i"></a></li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">						
						<li><a href="#">退出</a></li>
					</ul>
				</li>				
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 挂号收费<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="member-add.jsp" data-title="现场挂号" href="javascript:void(0)">现场挂号</a></li>
					<li><a data-href="member-delete.jsp" data-title="退号" href="javascript:void(0)">退号</a></li>
					<li><a data-href="charge.jsp" data-title="收费" href="javascript:void(0)">收费</a></li>
					<li><a data-href="article-list.jsp" data-title="退费" href="javascript:void(0)">退费</a></li>
					<li><a data-href="article-list.jsp" data-title="发票补打" href="javascript:void(0)">发票补打</a></li>
					<li><a data-href="article-list.jsp" data-title="发票重打" href="javascript:void(0)">发票重打</a></li>
					<li><a data-href="article-list.jsp" data-title="患者费用查询" href="javascript:void(0)">患者费用查询</a></li>
					<li><a data-href="article-list.jsp" data-title="日结" href="javascript:void(0)">日结</a></li>
					<li><a data-href="article-list.jsp" data-title="日结查询" href="javascript:void(0)">日结查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe613;</i> 门诊医生<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="doctor-category.jsp" data-title="门诊病历" href="javascript:void(0)">门诊病历</a></li>
					<li><a data-href="product-category.jsp" data-title="医技模板管理" href="javascript:void(0)">医技模板管理</a></li>
					<li><a data-href="product-category.jsp" data-title="西药处方模板" href="javascript:void(0)">西药处方模板</a></li>
					<li><a data-href="product-category.jsp" data-title="中药处方模板" href="javascript:void(0)">中药处方模板</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 医技处置<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="product-category.jsp" data-title="患者检验" href="javascript:void(0)">患者检验</a></li>
					<li><a data-href="product-category.jsp" data-title="患者检查" href="javascript:void(0)">患者检查</a></li>
					<li><a data-href="product-category.jsp" data-title="患者处置" href="javascript:void(0)">患者处置</a></li>
					<li><a data-href="product-category.jsp" data-title="医技管理" href="javascript:void(0)">医技管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe622;</i> 药房管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="dispensing.jsp" data-title="药房发药" href="javascript:;">药房发药</a></li>
					<li><a data-href="article-list.jsp" data-title="药房退药" href="javascript:void(0)">药房退药</a></li>
					<li><a data-href="article-list.jsp" data-title="药品管理" href="javascript:void(0)">药品管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 财务管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="article-list.jsp" data-title="门诊医生工作量统计" href="javascript:;">门诊医生工作量统计</a></li>
					<li><a data-href="article-list.jsp" data-title="开单科室工作量统计" href="javascript:;">开单科室工作量统计</a></li>
					<li><a data-href="article-list.jsp" data-title="执行科室工作量统计" href="javascript:;">执行科室工作量统计</a></li>
					<li><a data-href="article-list.jsp" data-title="费用科目管理" href="javascript:;">费用科目管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 系统信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="article-list.jsp" data-title="常数类别管理" href="javascript:void(0)">常数类别管理</a></li>
					<li><a data-href="article-list.jsp" data-title="科室管理" href="javascript:void(0)">科室管理</a></li>
					<li><a data-href="article-list.jsp" data-title="用户管理" href="javascript:void(0)">用户管理</a></li>
					<li><a data-href="article-list.jsp" data-title="挂号级别管理" href="javascript:void(0)">挂号级别管理</a></li>
					<li><a data-href="article-list.jsp" data-title="结算类别管理" href="javascript:void(0)">结算类别管理</a></li>
					<li><a data-href="article-list.jsp" data-title="诊断目录管理" href="javascript:void(0)">诊断目录管理</a></li>
					<li><a data-href="article-list.jsp" data-title="非药品收费项目管理" href="javascript:void(0)">非药品收费项目管理</a></li>
					<li><a data-href="article-list.jsp" data-title="医生排班管理" href="javascript:void(0)">医生排班管理</a></li>
				</ul>
			</dd>
		</dl>		
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="现场挂号" data-href="member-add.jsp">现场挂号</span>
					<em></em>
				</li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="member-add.jsp"></iframe>
		</div>
	</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
//获取登录身份，并显示
$(document).ready(function() {
	//使用正则表达式去读取
	var reg=new RegExp("(^|&)"+ "loginName" +"=([^&]*)(&|$)","i"); 
	var html=window.location.search.substr(1).match(reg);
	var txt=document.getElementById("loginName-i");
	if(txt.innerHTML==""){
		if(html!=null){
			txt.innerHTML=html[2];
			if(txt.innerHTML=="caiwu"){
				document.getElementById("menu-picture").style.display="none";
				document.getElementById("menu-product").style.display="none";
				document.getElementById("menu-comments").style.display="none";
				document.getElementById("menu-admin").style.display="none";
			}
		}
		else{
			alert("请先登录！");
			window.location.href="login.jsp";
		}
	}
});
</script>
</body>
</html>