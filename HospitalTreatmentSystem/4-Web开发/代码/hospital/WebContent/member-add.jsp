<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,java.util.*"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
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
<!--/meta 作为公共模版分离出去-->
<title>现场挂号</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body onload="initial()">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 挂号收费 <span class="c-gray en">&gt;</span> 现场挂号 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form method="post" class="form form-horizontal">
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>发票号：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="invoiceNumber" id="invoiceNumber">
		</div>
	    <label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>病历号：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="medicalRecordNumber" id="medicalRecordNumber" onchange="changeInformation()">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>挂号ID：</label>
		<div class="formControls col-xs-1 col-sm-1">
			<input type="text" class="input-text" name="registrationID" id="registrationID">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>应收金额：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="fee" id="fee">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>年龄：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="patientAge" id="patientAge">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>年龄类型：</label>
		<div class="formControls col-xs-1 col-sm-1">
			<input type="text" class="input-text" name="patientAgeType" id="patientAgeType">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>挂号员：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="registeredStaff" id="registeredStaff">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>看诊日期：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="dateOfConsultation" id="dateOfConsultation">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>午别：</label>
		<div class="formControls col-xs-1 col-sm-1">
			<input type="text" class="input-text" name="noon" id="noon">
		</div>
	</div>		
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">挂号信息</a></label>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>身份证号：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="patientIDNumber" id="patientIDNumber" onchange="patientIDNumber()">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>姓名：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" class="input-text" name="patientName" id="patientName" onchange="patientName()">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>性别：</label>
		<div class="formControls col-xs-1 col-sm-1">
			<span class="select-box"><select class="select" name="patientSex" id="patientSex">
				<option>男</option>
				<option>女</option>
			</select></span>
		</div>
		<label class="form-label col-xs-1 col-sm-1"></label>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>出生日期：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'patientBirthday\')||\'%y-%M-%d\'}'})" id="patientBirthday" name="patientBirthday"  onchange="patientBirthday()" class="input-text Wdate" style="width:120px;">
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>家庭住址：</label>
		<div class="formControls col-xs-5 col-sm-5">
			<input type="text" class="input-text" name="patientAddress" id="patientAddress" onchange="patientAddress()">
		</div>
		<label class="form-label col-xs-1 col-sm-1"></label>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>挂号科室：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<span class="select-box"><select class="select" name="department" id="department" onchange="changeDoctor()">
				<option value="0">---请选择---</option>
			</select></span>
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>挂号级别：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<span class="select-box"><select class="select" name="registeredGrade" id="registeredGrade" onchange="changeDoctor();changeFee()" >
				<option value="0">---请选择---</option>
			</select></span>
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>病历本：</label>
		<div class="form-label col-xs-1 col-sm-1">
			<input type="checkbox" name="medicalRecordNeeded" id="medicalRecordNeeded" onchange="changeFee()">
		</div>
		<label class="form-label col-xs-1 col-sm-1"></label>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>挂号医生：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<span class="select-box"><select class="select" name="doctor" id="doctor">
				<option value="0">---请选择---</option>
			</select></span>
		</div>
		<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>结算类别：</label>
		<div class="formControls col-xs-2 col-sm-2">
			<span class="select-box"><select class="select" name="settlementCategory" id="settlementCategory">
				<option>自费</option>
				<option>公费</option>
			</select></span>
		</div>
		<label class="form-label col-xs-1 col-sm-1"></label>
		<div class="formControls col-xs-1 col-sm-1">	
			<button class="btn btn-primary radius" name="register" id="register" type="button"><i class="Hui-iconfont">&#xe6a7;</i>挂号</button>
		</div>
		<div class="formControls col-xs-1 col-sm-1">
			<button class="btn btn-default radius" name="clear" id="clear" type="button"><i class="Hui-iconfont">&#xe66b;</i>清空</button>
		</div>		
	</div>
</form>
		
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			sex:{
				required:true,
			},
			mobile:{
				required:true,
				isMobile:true,
			},
			email:{
				required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});
</script>
<script type="text/javascript">
//根据是否要病历本切换应收金额
function changeFee() {
    var registeredGrade=document.getElementById("registeredGrade").options[document.getElementById("registeredGrade").selectedIndex].value;
	var medicalRecordNeeded=null;
    if($('#medicalRecordNeeded').is(':checked')) {
    	medicalRecordNeeded="1";
    }
    else{
    	medicalRecordNeeded="0";

    }
    $.ajax({
       	url:"http://localhost:8080/hospital/changeFeeServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"text",//指定返回数据格式
        data:{//要发送的数据
        	"registeredGrade":registeredGrade,
        	"medicalRecordNeeded":medicalRecordNeeded
        },
        success:function(result){
            $("#fee").val(result);
        }
    });
}
//初始化界面(初始化挂号级别、挂号科室和挂号医生的下拉框)
function initial(){
	$.ajax({
		url:"http://localhost:8080/hospital/initialRegisterServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",
   		success:function(data){
   			var gradeNames=data[0];
   			var departmentNames=data[1];
   			var doctorNames=data[2];
   			//挂号级别
   			$("#registeredGrade").empty();
   			$("#registeredGrade").append("<option value='0'>---请选择---</option>")
 			for(var i=0;i<gradeNames.length;i++){
 				$("#registeredGrade").append("<option value='"+gradeNames[i].gradeName+"'>"+gradeNames[i].gradeName+"</option>");
 			} 
   			//挂号科室
   			$("#department").empty();
   			$("#department").append("<option value='0'>---请选择---</option>")
 			for(var i=0;i<departmentNames.length;i++){
 				$("#department").append("<option value='"+departmentNames[i].departmentName+"'>"+departmentNames[i].departmentName+"</option>");
 			} 
   			//挂号医生
   			$("#doctor").empty();
   			$("#doctor").append("<option value='0'>---请选择---</option>")
 			for(var i=0;i<doctorNames.length;i++){
 				$("#doctor").append("<option value='"+doctorNames[i].doctorName+"'>"+doctorNames[i].doctorName+"</option>");
 			} 
   		}
   	})
}
//切换挂号科室和挂号级别,更新医生列表
function changeDoctor() {
    var registeredGrade=document.getElementById("registeredGrade").options[document.getElementById("registeredGrade").selectedIndex].value;
    var department=document.getElementById("department").options[document.getElementById("department").selectedIndex].value;
    $.ajax({
   		url:"http://localhost:8080/hospital/changeDoctorServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"registeredGrade":registeredGrade,
            "department":department
        },
        success:function(data){
   			$("#doctor").empty();
   			$("#doctor").append("<option value='0'>---请选择---</option>")
 			for(var i=0;i<data.length;i++){
 				$("#doctor").append("<option value='"+data[i].doctorName+"'>"+data[i].doctorName+"</option>");
 			}          
   		}
    });
}
//刷新页面
$("#clear").click(function() {
	location.replace(location.href);
});
</script>
<script type="text/javascript">
function patientIDNumber() {
    //验证身份证号
    var patientIDNumber=document.getElementById("patientIDNumber").value;
    var reg=/^\d{18}|\d{17}(\d|X|x)$/i;
    if(patientIDNumber=="") {
    	alert("身份证号不能为空！"); 
        return false;
    }
    else if(!reg.test(patientIDNumber)) {
    	alert("身份证号应为18位！"); 
        return false;
    }
    else {
        return true;
    }
}
function patientName() {
    //验证姓名
    var patientName=document.getElementById("patientName").value;
    if(patientName=="") {
    	alert("姓名不能为空！"); 
        return false;
    }
    else {
        return true;
    }
}
function patientBirthday() {
    //验证出生日期
    var patientBirthday=document.getElementById("patientBirthday").value;
    if(patientBirthday=="") {
    	alert("出生日期不能为空！"); 
        return false;
    }
    else {
        return true;
    }
}
function patientAddress() {
    //验证家庭地址
    var patientAddress=document.getElementById("patientAddress").value;
    if(patientAddress=="") {
    	alert("家庭住址不能为空！"); 
        return false;
    }
    else {
        return true;
    }
}
//JS表单验证
function toSubmit(){
    if(patientIDNumber()==true && patientName()==true && patientBirthday()==true && patientAddress()==true) {
    	return true;
    }
    else{
    	return false;
    }
}
</script>
<script type="text/javascript">
//若之前已经使用该病历号挂过号,输入病历号,直接列出患者信息
function changeInformation() {
    var medicalRecordNumber=document.getElementById("medicalRecordNumber").value;
    $.ajax({
   		url:"http://localhost:8080/hospital/changeInformServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"medicalRecordNumber":medicalRecordNumber
        },
        success:function(data){
        	$("#patientIDNumber").val(data[0]);
            $("#patientName").val(data[1]);
            $("#patientSex").val(data[2]);
            $("#patientBirthday").val(data[3]);
            $("#patientAddress").val(data[4]);        
   		}
    });
}
//挂号
$("#register").click(function() {
    var patientIDNumber=document.getElementById("patientIDNumber").value;
    var patientName=document.getElementById("patientName").value;
    var patientSex=document.getElementById("patientSex").options[document.getElementById("patientSex").selectedIndex].value;
    var patientBirthday=document.getElementById("patientBirthday").value;
    var patientAddress=document.getElementById("patientAddress").value;
    var department=document.getElementById("department").options[document.getElementById("department").selectedIndex].value;
    var doctor=document.getElementById("doctor").options[document.getElementById("doctor").selectedIndex].value;
    var medicalRecordNeeded=null;
    var registeredGrade=document.getElementById("registeredGrade").options[document.getElementById("registeredGrade").selectedIndex].value;
    var settlementCategory=document.getElementById("settlementCategory").options[document.getElementById("settlementCategory").selectedIndex].value;
    if($('#medicalRecordNeeded').is(':checked')) {
    	medicalRecordNeeded="1";
    }
    else{
    	medicalRecordNeeded="0";

    }
    //JS表单验证
    if(toSubmit()==true) {
        if(department!=0 && registeredGrade!=0 && doctor!=0) {
        	$.ajax({
    	   		url:"http://localhost:8080/hospital/registerServlet?number="+Math.random(),//要提交的路径
    	        type:"post",//请求方法
    	        async:true,
    	        dataType:"json",//指定返回数据格式
    	        data:{//要发送的数据
    	            "patientIDNumber":patientIDNumber,
    	            "patientName":patientName,
    	            "patientSex":patientSex,
    	            "patientBirthday":patientBirthday,
    	            "patientAddress":patientAddress,
    	            "department":department,
    	            "doctor":doctor,
    	            "medicalRecordNeeded":medicalRecordNeeded,
    	            "registeredGrade":registeredGrade,
    	            "settlementCategory":settlementCategory
    	        },
    	        success:function(data){
    	        	$("#invoiceNumber").val(data[0]);
    	            $("#medicalRecordNumber").val(data[1]);
    	            $("#registrationID").val(data[2]);
    	            $("#patientAge").val(data[3]);
    	            $("#patientAgeType").val(data[4]);
    	            $("#registeredStaff").val(data[5]);
    	            $("#dateOfConsultation").val(data[6]);
    	            $("#noon").val(data[7]);   
    	            alert("挂号成功！");
    	   	    }
	    	});
        }
        else{
        	alert("挂号科室、级别、医生为必选选项!");
        }
	}
});


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>