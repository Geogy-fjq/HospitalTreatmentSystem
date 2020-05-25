<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--_meta 作为公共模版分离出去-->
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
<!--/meta 作为公共模版分离出去-->
<title>医生看诊</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 门诊医生 <span class="c-gray en">&gt;</span> 看诊 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form class="form form-horizontal" name="base" id="base">
		<div id="tab-system" class="HuiTab">
			<div class="tabBar cl">
				<span>病历首页</span>
				<span>检查申请</span>
				<span>检验申请</span>
				<span>门诊确诊</span>
				<span>处置申请</span>
				<span>成药处方</span>
				<span>草药处方</span>
				<span>费用查询</span>
			</div>
			<div class="tabCon" id="s1">
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">基本信息</a></label>
				</div>
				<div class="row cl" >
					<label class="form-label col-xs-2 col-sm-2">姓名：</label>
					<div class="formControls col-xs-2 col-sm-2">
						<input type="text" class="input-text"placeholder="" id="name" name="name">
					</div>
					<label class="form-label col-xs-2 col-sm-2">身份证号：</label>
					<div class="formControls col-xs-3 col-sm-3">
						<input type="text" class="input-text" placeholder="" id="IDNumber" name="IDNumber">
					</div>
					<label class="form-label col-xs-1 col-sm-1">年龄：</label>
					<div class="formControls col-xs-1 col-sm-1">
						<input type="text" class="input-text" placeholder="" id="age" name="age">
					</div>
				</div>		
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">病史内容</a></label>
				</div>
				<div class="row cl" >
					<label class="form-label col-xs-2 col-sm-2">主诉：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="chiefComplaint" name="chiefComplaint">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">现病史：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="currentMedicalHistory" name="currentMedicalHistory">
					</div>
				</div>			
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">现病治疗情况：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="currentMedicalTreatment" name="currentMedicalTreatment">
					</div>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">既往史：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="pastHistory" name="pastHistory">
					</div>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">过敏史：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="allergyHistory" name="allergyHistory">
					</div>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">体格检查：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="physicalExamination" name="physicalExamination">
					</div>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">评估/诊断</a></label>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">初步诊断类别：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="preliminaryDiagnosisCategory" name="preliminaryDiagnosisCategory">
					</div>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">初步诊断：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="preliminaryDiagnosis" name="preliminaryDiagnosis">
					</div>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">检查建议：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="examinationSuggestions" name="examinationSuggestions">
					</div>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">注意事项：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="attention" name="attention">
					</div>
				</div>				
			</div>
			<div class="tabCon" id="s2">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">检查申请：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text"  class="input-text" value="" id="inspectionApplication" name="inspectionApplication">
					</div>
				</div>				
			</div>
			<div class="tabCon" id="s3">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">检验申请：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text"  class="input-text" value="" id="checkApplication" name="checkApplication">
					</div>
				</div>				
			</div>
			<div class="tabCon" id="s4">
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">检查结果：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="examinationResult" name="examinationResult">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">诊断结果：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="diagnosisResult" name="diagnosisResult">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">处理意见：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text" class="input-text" value="" placeholder="" id="treatmentOpinion" name="treatmentOpinion">
					</div>
				</div>			
			</div>
			<div class="tabCon" id="s5">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">处置申请：</label>
					<div class="formControls col-xs-9 col-sm-9">
						<input type="text"  class="input-text" value="" id="disposalApplication" name="disposalApplication">
					</div>
				</div>				
			</div>
			<div class="tabCon" id="s6">
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">门诊诊断</a></label>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">诊断结果：</label>
					<div class="formControls col-xs-10 col-sm-10">
						<input type="text" class="input-text" value="" placeholder="" id="diagnosisResult1" name="diagnosisResult1">
					</div>
				</div>		
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">门诊处方</a></label>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">处方名称：</label>
					<div class="formControls col-xs-4 col-sm4">
						<input type="text" class="input-text" value="" placeholder="" id="prescriptionName" name="prescriptionName">
					</div>
					<label class="form-label col-xs-2 col-sm-2">处方状态：</label>
					<div class="formControls col-xs-4 col-sm4">
						<input type="text" class="input-text" value="" placeholder="" id="prescriptionStatus" name="prescriptionStatus">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">开置处方</a></label>
				</div>	
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">药品名称：</label>
					<div class="formControls col-xs-2 col-sm2">
						<input type="text" class="input-text" value="" placeholder="" id="drugName" name="drugName">
					</div>
					<label class="form-label col-xs-2 col-sm-2">用法：</label>
					<div class="formControls col-xs-2 col-sm2">
						<input type="text" class="input-text" value="" placeholder="" id="drugUsage" name="drugUsage">
					</div>
					<label class="form-label col-xs-2 col-sm-2">用量：</label>
					<div class="formControls col-xs-2 col-sm2">
						<input type="text" class="input-text" value="" placeholder="" id="drugDosage" name="drugDosage">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">频次：</label>
					<div class="formControls col-xs-2 col-sm2">
						<input type="text" class="input-text" value="" placeholder="" id="frequency" name="frequency">
					</div>
					<label class="form-label col-xs-2 col-sm-2">数量：</label>
					<div class="formControls col-xs-2 col-sm2">
						<input type="text" class="input-text" value="" placeholder="" id="quantity" name="quantity">
					</div>
					<label class="form-label col-xs-3 col-sm-3"></label>
					<div class="formControls col-xs-1 col-sm1">
						<button class="btn btn-default radius" type="button" name="add" id="add"><i class="Hui-iconfont">&#xe600;</i>增方</button>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">处方明细</a></label>
				</div>	
				<div class="mt-20">
					<table class="table table-border table-bordered table-bg table-hover table-responsive">
						<thead>
							<tr class="text-c">
								<th width="25"><input type="checkbox" name="checkDrugs" id="checkDrugs"></th>
								<th width="130">药品名称</th>
								<th width="80">规格</th>
								<th width="50">单价</th>
								<th width="50">用法</th>
								<th width="50">用量</th>
								<th width="70">频次</th>
								<th width="50">数量</th>
							</tr>
						</thead>
						<tbody id="tbody">
						</tbody>
					</table>
				</div>
			</div>
			<div class="tabCon" id="s7">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">草药处方：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>				
			</div>
			<div class="tabCon" id="s8">
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">费用明细</a></label>
				</div>
				<div class="mt-20">
					<table class="table table-border table-bordered table-bg table-hover table-responsive">
						<thead>
							<tr class="text-c">
								<th width="130">项目名称</th>
								<th width="50">单价</th>
								<th width="50">数量</th>
								<th width="80">状态</th>
							</tr>
						</thead>
						<tbody id="feeDetails">
						</tbody>
					</table>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">费用情况</a></label>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-2 col-sm-2">已支付费用：</label>
					<div class="formControls col-xs-2 col-sm-2">
						<input type="text"  class="input-text" id="feeAlready" name="feeAlready">
					</div>
					<label class="form-label col-xs-2 col-sm-2">待支付费用：</label>
					<div class="formControls col-xs-2 col-sm-2">
						<input type="text"  class="input-text" id="feeReady" name="feeReady">
					</div>
				</div>				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-5 col-sm-5"></label>
			<div class="formControls col-xs-2 col-sm-2">
				<button class="btn btn-primary radius" type="button" name="save" id="save"><i class="Hui-iconfont">&#xe632;</i>保存</button>
			</div>
			<div class="formControls col-xs-2 col-sm-2">
				<button class="btn btn-primary radius" type="button" name="submit" id="submit"><i class="Hui-iconfont">&#xe6a7;</i>提交</button>
			</div>
			<div class="formControls col-xs-2 col-sm-2">
				<button class="btn btn-default radius" type="button" name="clear1" id="clear1" onclick="onClick()"><i class="Hui-iconfont">&#xe66b;</i>清空</button>
			</div>	
		</div>
	</form>
</div>

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
	$("#tab-system").Huitab({
		index:0
	});
});

//增方
$("#add").click(function() {
	var drugName=document.getElementById("drugName").value;
	var drugUsage=document.getElementById("drugUsage").value;
	var drugDosage=document.getElementById("drugDosage").value;
	var frequency=document.getElementById("frequency").value;
	var quantity=document.getElementById("quantity").value;
    $.ajax({
       	url:"http://localhost:8080/hospital/addServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"drugName":drugName
        },
        success:function(data){
        	var drugSpecification=data.drugSpecification;
        	var unitPriceOfDrugs=data.unitPriceOfDrugs;
        	if(drugSpecification!="default" && unitPriceOfDrugs!="default"){
        		var newRow="<tr class="+"text-c"+"><td><input type="+"checkbox"+" name="+"c"+" id="+"c"+"></td><td>"+drugName+"</td><td>"+drugSpecification+"</td><td>"+unitPriceOfDrugs+"</td><td>"+drugUsage+"</td><td>"+drugDosage+"</td><td>"+frequency+"</td><td>"+quantity+"</td></tr>";
                $("#tbody").append(newRow);
        	}
        	else{
        		alert("该药品不存在!");
        	}
        }
    });
});

//保存看诊数据
$("#save").click(function() {
	var name=document.getElementById("name").value;
	var chiefComplaint=document.getElementById("chiefComplaint").value;
	var currentMedicalHistory=document.getElementById("currentMedicalHistory").value;
	var currentMedicalTreatment=document.getElementById("currentMedicalTreatment").value;
	var pastHistory=document.getElementById("pastHistory").value;
	var allergyHistory=document.getElementById("allergyHistory").value;
	var physicalExamination=document.getElementById("physicalExamination").value;
	var preliminaryDiagnosisCategory=document.getElementById("preliminaryDiagnosisCategory").value;
	var preliminaryDiagnosis=document.getElementById("preliminaryDiagnosis").value;
	var examinationSuggestions=document.getElementById("examinationSuggestions").value;
	var attention=document.getElementById("attention").value;
	var examinationResult=document.getElementById("examinationResult").value;
	var diagnosisResult=document.getElementById("diagnosisResult").value;
	var treatmentOpinion=document.getElementById("treatmentOpinion").value;
    $.ajax({
       	url:"http://localhost:8080/hospital/saveServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"name":name,
        	"chiefComplaint":chiefComplaint,
        	"currentMedicalHistory":currentMedicalHistory,
        	"currentMedicalTreatment":currentMedicalTreatment,
        	"pastHistory":pastHistory,
        	"allergyHistory":allergyHistory,
        	"physicalExamination":physicalExamination,
        	"preliminaryDiagnosisCategory":preliminaryDiagnosisCategory,
        	"preliminaryDiagnosis":preliminaryDiagnosis,
        	"examinationSuggestions":examinationSuggestions,
        	"attention":attention,
        	"examinationResult":examinationResult,
        	"diagnosisResult":diagnosisResult,
        	"treatmentOpinion":treatmentOpinion
        },
        success:function(data){
        	if(data.result=="success!"){
        		$("#diagnosisResult1").val(diagnosisResult);
        		alert("保存看诊信息成功！");
        	}
        	else{
        		alert("保存看诊信息失败！");
        	}
        }
    });
});

//提交处方数据
$("#submit").click(function() {
	//获取输入的数据
	var doctorID="1";
	var name=document.getElementById("name").value;
	var prescriptionName=document.getElementById("prescriptionName").value;
	//设置ajax数据
	var drugNameArr="";
	var drugUsageArr="";
	var drugDosageArr="";
	var frequencyArr="";
	var quantityArr="";
	//获取勾选的药品明细
	var trList=$("#tbody").children("tr");
	for(var i=0;i<trList.length;i++) {
		var tdArr=trList.eq(i).find("td");
		var check=tdArr.eq(0).find('input');
		if(check.is(':checked')){
			var drugName=tdArr.eq(1).html();
		    var drugUsage=tdArr.eq(4).html();
		    var drugDosage=tdArr.eq(5).html();
		    var frequency=tdArr.eq(6).html();
		    var quantity=tdArr.eq(7).html();
		    drugNameArr=drugNameArr+drugName+",";
		    drugUsageArr=drugUsageArr+drugUsage+",";
			drugDosageArr=drugDosageArr+drugDosage+",";
			frequencyArr=frequencyArr+frequency+",";
			quantityArr=quantityArr+quantity+",";
		}
	}
    $.ajax({
       	url:"http://localhost:8080/hospital/submitServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"name":name,
        	"doctorID":doctorID,
        	"prescriptionName":prescriptionName,
        	"drugNameArr":drugNameArr,
        	"drugUsageArr":drugUsageArr,
        	"drugDosageArr":drugDosageArr,
        	"frequencyArr":frequencyArr,
        	"quantityArr":quantityArr
        },
        success:function(data){
        	if(data.result=="success!"){
        		$("#prescriptionStatus").val(data.prescriptionStatus);
        		alert("提交开药信息成功！");
        	}
        	else{
        		alert("提交开药信息失败！");
        	}
        }
    });
});

//清空页面数据
function onClick() {
	for(i=0;i<document.getElementsByTagName("input").length;i++){
		if(document.getElementsByTagName("input")[i].type=="text"){
			document.getElementsByTagName("input")[i].value="";
		}
	}
	$("table tbody").html("");
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
