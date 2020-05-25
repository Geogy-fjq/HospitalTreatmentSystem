<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp"/>
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>门诊医生</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 门诊医生 <span class="c-gray en">&gt;</span> 门诊病历 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<table class="table">
	<tr>
		<td width="120" class="va-t">		
			<form name="form" id="form" method="post">
				<ul id="treeDemo" class="ztree"></ul>
			</form>
		</td>
		<td class="va-t">
			<iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=390px SRC="system-base.jsp">			
			</iframe>
		</td>
	</tr>
</table>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--使用ztree插件 -->
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript">
//加载选择列表
$(document).ready(function() {
	$.ajax({
		url:"http://localhost:8080/hospital/doctorServlet?number="+Math.random(),//要提交的路径
	    type:"post",//请求方法
	    async:true,
	    dataType:"json",//指定返回数据格式
	    success:function(data){
	    	var nameReady=data[0];
   			var nameAlready=data[1];
            zNodes=new Array(nameReady.length+nameAlready.length+3);
	    	zNodes[0]={ id:1, pId:0, name:"患者分类", open:true};
	    	zNodes[1]={ id:11, pId:1, name:"未诊患者", open:true};
	    	var pId1=11;
	    	var pId2=12;
	    	var k=1;
	    	//待诊患者
            for(var i=0;i<nameReady.length;i++){
            	k++;
            	zNodes[k]={ id:nameReady[i].IDNumber, pId:pId1, name:nameReady[i].name, file:"system-base"};
            }
            k=k+1;
            zNodes[k]={ id:12, pId:1, name:"已诊患者"};
            //已诊患者
	    	for(var i=0;i<nameAlready.length;i++){
	    		k++;
	    		zNodes[k]={ id:nameAlready[i].IDNumber, pId:pId2, name:nameAlready[i].name, file:"system-base"};
            }
            //设置zTree节点   
            var t=$("#treeDemo");
            t=$.fn.zTree.init(t,setting,zNodes);
        	//demoIframe=$("#testIframe");
        	//demoIframe.on("load",loadReady);
        	//var zTree=$.fn.zTree.getZTreeObj("tree");
        	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
		}
	});
});

var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId,treeNode) {
			var zTree=$.fn.zTree.getZTreeObj("tree");
			var demoIframe=$("#testIframe");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				initialClick(treeNode.id);
				//demoIframe.attr("src",treeNode.file+".jsp");
				return true;
			}
		}
	}
}

//初始化system-base界面信息
function initialClick(patientIDNumber){
	$.ajax({
		url:"http://localhost:8080/hospital/initialSystemServlet?number="+Math.random(),//要提交的路径
	    type:"post",//请求方法
	    async:true,
	    dataType:"json",//指定返回数据格式
	    data:{//要发送的数据
            "patientIDNumber":patientIDNumber
        },
	    success:function(data){
	    	//清空文本框和表格
	    	var childWindow=$("#testIframe")[0].contentWindow;
			childWindow.onClick();
	    	//$('#testIframe').contents().find("#tbody").
	    	//重新载入病例页面数据
	    	$('#testIframe').contents().find("#name").val(data[0].name);
	    	$('#testIframe').contents().find("#IDNumber").val(data[0].IDNumber);
            $('#testIframe').contents().find("#age").val(data[0].age);
            $('#testIframe').contents().find("#chiefComplaint").val(data[0].chiefComplaint);
            $('#testIframe').contents().find("#currentMedicalHistory").val(data[0].currentMedicalHistory);
            $('#testIframe').contents().find("#currentMedicalTreatment").val(data[0].currentMedicalTreatment);
            $('#testIframe').contents().find("#pastHistory").val(data[0].pastHistory);
            $('#testIframe').contents().find("#allergyHistory").val(data[0].allergyHistory);
            $('#testIframe').contents().find("#physicalExamination").val(data[0].physicalExamination);
            $('#testIframe').contents().find("#preliminaryDiagnosisCategory").val(data[0].preliminaryDiagnosisCategory);
            $('#testIframe').contents().find("#preliminaryDiagnosis").val(data[0].preliminaryDiagnosis);
            $('#testIframe').contents().find("#examinationSuggestions").val(data[0].examinationSuggestions);
            $('#testIframe').contents().find("#attention").val(data[0].attention);
            $('#testIframe').contents().find("#examinationResult").val(data[0].examinationResult);
            $('#testIframe').contents().find("#diagnosisResult").val(data[0].diagnosisResult);
            $('#testIframe').contents().find("#treatmentOpinion").val(data[0].treatmentOpinion);
            $('#testIframe').contents().find("#diagnosisResult1").val(data[0].diagnosisResult);
            $('#testIframe').contents().find("#feeReady").val(data[0].feeReady);
            $('#testIframe').contents().find("#feeAlready").val(data[0].feeAlready);
            //重新载入费用页面数据
            if(data[1]!=null && data[2]!=null){
     			for(var i=0;i<data[1].length;i++){
     				var status="未缴费";
     				var newRow="<tr class="+"text-c"+"><td>"+data[1][i].name+"</td><td>"+data[1][i].price+"元"+"</td><td>"+data[1][i].quantity+"</td><td class="+"td-status"+"><span class="+"'label label-danger radius'"+">"+status+"</span></td></tr>";
     				$('#testIframe').contents().find("#feeDetails").append(newRow);
            	}
				for(var i=0;i<data[2].length;i++){
					var status="已缴费";
     				var newRow="<tr class="+"text-c"+"><td>"+data[2][i].name+"</td><td>"+data[2][i].price+"元"+"</td><td>"+data[2][i].quantity+"</td><td class="+"td-status"+"><span class="+"'label label-success radius'"+">"+status+"</span></td></tr>";
     				$('#testIframe').contents().find("#feeDetails").append(newRow);
            	}
            }
		}
	});
}	

var code;	
function showCode(str) {
	if (!code) code=$("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
</script>
</body>
</html>