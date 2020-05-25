<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>患者退号</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 挂号收费 <span class="c-gray en">&gt;</span> 退号 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">患者信息查询</a></label>
	</div>
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" id="medicalRecordNumber-d" name="medicalRecordNumber-d">
			</div>
			<div class="formControls col-xs-1 col-sm-1">
				<button onClick="search();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe709;</i>搜索</button>
			</div>	
			<label class="form-label col-xs-8 col-sm-8"></label>
		</div>
	</form>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">患者信息确认</a></label>
	</div>
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" id="patientName-d" name="patientName-d">
			</div>
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>身份证号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" id="patientIDNumber-d" name="patientIDNumber-d">
			</div>
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>家庭住址：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" id="patientAddress-d" name="patientAddress-d">
			</div>
		</div>
	</form>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">患者挂号信息</a></label>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-responsive">
			<thead>
				<tr class="text-c">
					<th width="80">病历号</th>
					<th width="80">姓名</th>
					<th width="160">身份证号</th>
					<th width="120">挂号日期</th>
					<th width="60">挂号午别</th>
					<th width="80">看诊科室</th>
					<th width="60">状态</th>
					<th width="60">操作</th>
				</tr>
			</thead>
			<tbody id="delete-d">
			</tbody>
		</table>
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
<script type="text/javascript">
//查询患者信息
function search() {
	var medicalRecordNumber=document.getElementById("medicalRecordNumber-d").value;
    $.ajax({
       	url:"http://localhost:8080/hospital/deleteSearchServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"medicalRecordNumber":medicalRecordNumber
        },
        success:function(data){
        	if(data.patientName!=""){
        		$("#patientName-d").val(data.patientName);
            	$("#patientIDNumber-d").val(data.patientIDNumber);
            	$("#patientAddress-d").val(data.patientAddress);
            	$("#delete-d").empty();
            	var status="";
            	var newRow="";
            	if(data.statusOfConsultation=="1"){
            		status="已挂号";
       				newRow="<tr class="+"text-c"+"><td>"+medicalRecordNumber+"</td><td>"+data.patientName+"</td><td>"+data.patientIDNumber+"</td><td>"+data.registrationTime+"</td><td>"+data.noon+"</td><td>"+data.department+"</td><td class="+"td-status"+"><span class="+"'label label-success radius'"+">"+status+"</span></td><td class="+"'f-14 td-manage'"+"><input class="+"'btn btn-primary radius'"+"type="+"'button'"+"onClick="+"withdraw();"+" value="+"'&nbsp;&nbsp;退号&nbsp;&nbsp;'"+"></td>";
            	}
            	else if(data.statusOfConsultation=="2"){
            		status="已就诊";
       				newRow="<tr class="+"text-c"+"><td>"+medicalRecordNumber+"</td><td>"+data.patientName+"</td><td>"+data.patientIDNumber+"</td><td>"+data.registrationTime+"</td><td>"+data.noon+"</td><td>"+data.department+"</td><td class="+"td-status"+"><span class="+"'label label-danger radius'"+">"+status+"</span></td><td class="+"'f-14 td-manage'"+"><input class="+"'btn btn-primary radius'"+"type="+"'button'"+"onClick="+"withdraw();"+" value="+"'&nbsp;&nbsp;退号&nbsp;&nbsp;'"+"></td>";
            	}
            	else if(data.statusOfConsultation=="3"){
            		status="已开药";
       				newRow="<tr class="+"text-c"+"><td>"+medicalRecordNumber+"</td><td>"+data.patientName+"</td><td>"+data.patientIDNumber+"</td><td>"+data.registrationTime+"</td><td>"+data.noon+"</td><td>"+data.department+"</td><td class="+"td-status"+"><span class="+"'label label-danger radius'"+">"+status+"</span></td><td class="+"'f-14 td-manage'"+"><input class="+"'btn btn-primary radius'"+"type="+"'button'"+"onClick="+"withdraw();"+" value="+"'&nbsp;&nbsp;退号&nbsp;&nbsp;'"+"></td>";
            	}
            	else if(data.statusOfConsultation=="4"){
            		status="已退号";
       				newRow="<tr class="+"text-c"+"><td>"+medicalRecordNumber+"</td><td>"+data.patientName+"</td><td>"+data.patientIDNumber+"</td><td>"+data.registrationTime+"</td><td>"+data.noon+"</td><td>"+data.department+"</td><td class="+"td-status"+"><span class="+"'label label-danger radius'"+">"+status+"</span></td><td class="+"'f-14 td-manage'"+"><input class="+"'btn btn-primary radius'"+"type="+"'button'"+"onClick="+"withdraw();"+" value="+"'&nbsp;&nbsp;退号&nbsp;&nbsp;'"+"></td>";
            	}
   				$("#delete-d").append(newRow);
        	}
        	else{
        		alert("该患者信息不存在！");
        	}	
        }
    });
}

//退号操作
function withdraw(){
	//获取选择的病历号和挂号日期
	var trList=$("#delete-d").children("tr");
	var tdArr=trList.eq(0).find("td");
	var medicalRecordNumber=tdArr.eq(0).html();
	var status=tdArr.eq(6).html();
	if(status="已挂号"){
		$.ajax({
	       	url:"http://localhost:8080/hospital/withdrawServlet?number="+Math.random(),//要提交的路径
	        type:"post",//请求方法
	        async:true,
	        dataType:"json",//指定返回数据格式
	        data:{//要发送的数据
	        	"medicalRecordNumber":medicalRecordNumber
	        },
	        success:function(data){
	        	if(data.result=="success!"){
	        		alert("退号成功！");
	        		search();
	        	}
	        	else{
	        		alert("已就诊，不允许退号！");
	        	}
	        }
	    });
	}
	else{
		alert("已就诊，不允许退号！");
	}
}


function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

</script> 
</body>
</html>