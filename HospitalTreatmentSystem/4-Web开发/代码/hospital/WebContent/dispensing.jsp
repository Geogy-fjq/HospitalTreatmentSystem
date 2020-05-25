<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<title>药房发药</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 药方管理 <span class="c-gray en">&gt;</span> 药房发药 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">患者信息查询</a></label>
	</div>
	<form class="form form-horizontal">
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" id="medicalRecordNumber-p" name="medicalRecordNumber-p">
			</div>
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>时间：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" id="time-p" name="time-p" class="input-text Wdate" style="width:120px;">
			</div>
			<div class="formControls col-xs-1 col-sm-1">
				<button onClick="find();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe709;</i>搜索</button>
			</div>	
			<label class="form-label col-xs-5 col-sm-5"></label>
		</div>
	</form>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">发药</a></label>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox"></th>
					<th width="80">药品名称</th>
					<th width="60">单价</th>
					<th width="60">数量</th>
					<th width="60">药品状态</th>
					<th width="80">开立医生</th>
					<th width="80">处方名称</th>
					<th width="120">开立时间</th>			
				</tr>
			</thead>
			<tbody id="tbody-p">
			</tbody>
		</table>
	</div>
</div>
<div class="row cl">
	<label class="form-label col-xs-10 col-sm-10"></label>
	<div class="formControls col-xs-1 col-sm-1">
		<button onClick="dispensing();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe6a7;</i>发药</button>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
//查询药品信息
function find() {
	$("#tbody-p").empty();
	var medicalRecordNumber=document.getElementById("medicalRecordNumber-p").value;
	var time=document.getElementById("time-p").value;
    $.ajax({
       	url:"http://localhost:8080/hospital/dispensingSearchServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"medicalRecordNumber":medicalRecordNumber,
        	"time":time
        },
        success:function(data){
        	if(data!=null){
       			for(var i=0;i<data.length;i++){
       				var newRow="<tr class="+"text-c"+"><td><input type="+"checkbox"+" name="+"c"+" id="+"c"+"></td><td>"+data[i].drugName+"</td><td>"+data[i].unitPrice+"</td><td>"+data[i].quantity+"</td><td>"+data[i].drugStatus+"</td><td>"+data[i].doctor+"</td><td>"+data[i].prescriptionName+"</td><td>"+data[i].prescriptionTime+"</td></tr>";
       				$("#tbody-p").append(newRow);
               	}
        	}
        }
    });
}

//发药
function dispensing() {
	//获取勾选的药品明细
	var prescription="";
	var trList=$("#tbody-p").children("tr");
	for(var i=0;i<trList.length;i++) {
		var tdArr=trList.eq(i).find("td");
		var check=tdArr.eq(0).find('input');
		if(check.is(':checked')){
			prescription=prescription+tdArr.eq(6).html()+",";
		}
	}
	var medicalRecordNumber=document.getElementById("medicalRecordNumber-p").value;
	$.ajax({
       	url:"http://localhost:8080/hospital/dispensingServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"medicalRecordNumber":medicalRecordNumber
        },
        success:function(data){
        	if(data.result=="success!"){
        		alert("发药成功！");
        		find();
        	}
        	else{
        		alert("发药失败！");
        	}
        }
    });
}
</script> 
</body>
</html>