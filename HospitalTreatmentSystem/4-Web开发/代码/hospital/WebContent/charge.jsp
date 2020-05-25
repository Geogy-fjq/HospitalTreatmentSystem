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
<title>患者收费</title>
<style>
    /*背景层*/
    #popLayer {
        display:none;
        background-color:#B3B3B3;
        position:absolute;
        top:0;
        right:0;
        bottom:0;
        left:0;
        z-index:10;
        -moz-opacity:0.8;
        opacity:.80;
        filter:alpha(opacity=80);
    }
    /*弹出层*/
    #popBox {
        display:none;
        background-color:#FFFFFF;
        z-index:11;
        width:500px;
        height:300px;
        position:fixed;
        top:0;
        right:0;
        left:0;
        bottom:0;
        margin:auto;
    }
    #popBox .close{
        text-align:right;
        margin-right:5px;
        background-color:#F8F8F8;
    }
    /*关闭按钮*/
    #popBox .close a {
        text-decoration:none;
        color:#2D2C3B;
    }
</style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 挂号收费 <span class="c-gray en">&gt;</span> 收费 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">患者信息查询</a></label>
	</div>
	<form method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" placeholder="" id="medicalRecordNumber-c" name="medicalRecordNumber-c">
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
				<input type="text" class="input-text" value="" placeholder="" id="patientName-c" name="patientName-c">
			</div>
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>身份证号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="patientIDNumber-c" name="patientIDNumber-c">
			</div>
			<label class="form-label col-xs-2 col-sm-2"><span class="c-red">*</span>家庭住址：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" value="" placeholder="" id="patientAddress-c" name="patientAddress-c">
			</div>
		</div>
	</form>
	<div class="row cl">
		<label class="form-label col-xs-2 col-sm-2"><a style="font-size:16px;">患者消费信息</a></label>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="check-c" id="check-c"></th>
					<th width="60">病历号</th>
					<th width="60">姓名</th>
					<th width="50">处方ID</th>
					<th width="140">项目名称</th>
					<th width="40">单价</th>
					<th width="40">数量</th>
					<th width="110">开立时间</th>
					<th width="40">状态</th>
				</tr>
			</thead>
			<tbody id="charge-c">
			</tbody>
		</table>
	</div>
</div>
<div class="row cl">
	<label class="form-label col-xs-10 col-sm-10"></label>
	<div class="formControls col-xs-1 col-sm-1">
		<button onClick="charge();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe627;</i>收费结算</button>
	</div>
</div>
<div id="popLayer"></div>
<div id="popBox">
    <div class="close">
		<a onClick="closeBox();" type="button"> X </a>
    </div>
    <div class="content">
	    <div class="row cl">
	    	<label class="form-label col-xs-4 col-sm-4"> </label>
			<label class="form-label col-xs-4 col-sm-4"><a style="font-size:18px;">发票信息（交费）</a></label>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-5 col-sm-5">.</label>					
		</div>
	    <div class="row cl">
	    	<label class="form-label col-xs-1 col-sm-1"> </label>
			<label class="form-label col-xs-2 col-sm-2">病历号：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" id="ID-p" name="ID-p">
			</div>
			<label class="form-label col-xs-2 col-sm-2">姓名：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" id="name-p" name="name-p">
			</div>					
		</div>
		<div class="row cl">
	    	<label class="form-label col-xs-1 col-sm-1"> </label>
	    	<label class="form-label col-xs-2 col-sm-2">应收：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" id="spay-p" name="spay-p">
			</div>	
			<label class="form-label col-xs-2 col-sm-2">实收：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" id="rpay-p" name="rpay-p" onchange="payChange()">
			</div>
			
		</div>
		<div class="row cl">
	    	<label class="form-label col-xs-1 col-sm-1"> </label>
			<label class="form-label col-xs-2 col-sm-2">支付：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<span class="select-box"><select class="select" name="chargeMehod" id="chargeMehod">
					<option value="1">现金</option>
					<option value="2">网上支付</option>
				</select></span>			
			</div>
			<label class="form-label col-xs-2 col-sm-2">找零：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" id="zpay-p" name="zpay-p">
			</div>					
		</div>
		<div class="row cl">
	    	<label class="form-label col-xs-1 col-sm-1"> </label>
			<label class="form-label col-xs-2 col-sm-2">发票号：</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" id="iID-p" name="iID-p">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-5 col-sm-5">.</label>					
		</div>
		<div class="row cl">
			<label class="form-label col-xs-5 col-sm-5"> </label>
			<div class="formControls col-xs-3 col-sm-3">
				<button class="btn btn-default radius" type="button" name="chargep" id="chargep" onclick="chargep()"><i class="Hui-iconfont">&#xe6a7;</i>收费</button>
			</div>					
		</div>
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
	var medicalRecordNumber=document.getElementById("medicalRecordNumber-c").value;
    $.ajax({
       	url:"http://localhost:8080/hospital/chargeSearchServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"medicalRecordNumber":medicalRecordNumber
        },
        success:function(data){
        	if(data.patientName!=""){
        		$("#patientName-c").val(data[0].patientName);
            	$("#patientIDNumber-c").val(data[0].patientIDNumber);
            	$("#patientAddress-c").val(data[0].patientAddress);
       			for(var i=0;i<data[1].length;i++){
       				var status="已开立";
       				var newRow="<tr class="+"text-c"+"><td><input type="+"checkbox"+" name="+"check-c"+" id="+"check-c"+"></td><td>"+medicalRecordNumber+"</td><td>"+data[0].patientName+"</td><td>"+data[1][i].prescriptionID+"</td><td>"+data[1][i].name+"</td><td>"+data[1][i].price+"</td><td>"+data[1][i].quantity+"</td><td>"+data[1][i].time+"</td><td class="+"td-status"+"><span class="+"'label label-success radius'"+">"+status+"</span></td></tr>";
       				$("#charge-c").append(newRow);
               	}
        	}
        	else{
        		alert("该患者信息不存在！");
        	}	
        }
    });
}
//收费结算
function charge() {
	popBox();
	var patientName=document.getElementById("patientName-c").value;
	var medicalRecordNumber=document.getElementById("medicalRecordNumber-c").value;
	var fee=0.00;
	//获取勾选的药品明细
	var trList=$("#charge-c").children("tr");
	for(var i=0;i<trList.length;i++) {
		var tdArr=trList.eq(i).find("td");
		var check=tdArr.eq(0).find('input');
		if(check.is(':checked')){
			fee=fee+tdArr.eq(5).html()*tdArr.eq(6).html();
		}
	}
	$("#name-p").val(patientName);
	$("#ID-p").val(medicalRecordNumber);
	$("#spay-p").val(parseFloat(fee).toFixed(2));
	

}

//根据实付金额实时计算找零金额
function payChange(){
	var rpay=document.getElementById("rpay-p").value;
	var spay=document.getElementById("spay-p").value;
	if(rpay!=null){
		var zhao=parseFloat(rpay-spay).toFixed(2);
		$("#zpay-p").val(zhao);
	}
}

//收费
function chargep(){
	var chargingOrRefundStaffID="8";
	var chargeMethod=document.getElementById("chargeMehod").options[document.getElementById("chargeMehod").selectedIndex].value;
	//设置ajax数据
	var IDArr="";
	//获取勾选的药品明细
	var trList=$("#charge-c").children("tr");
	for(var i=0;i<trList.length;i++) {
		var tdArr=trList.eq(i).find("td");
		var check=tdArr.eq(0).find('input');
		if(check.is(':checked')){
		    var ID=tdArr.eq(3).html();
		    IDArr=IDArr+ID+",";
		}
	}
	$.ajax({
       	url:"http://localhost:8080/hospital/chargeServlet?number="+Math.random(),//要提交的路径
        type:"post",//请求方法
        async:true,
        dataType:"json",//指定返回数据格式
        data:{//要发送的数据
        	"chargingOrRefundStaffID":chargingOrRefundStaffID,
        	"chargeMethod":chargeMethod,
        	"IDArr":IDArr
        },
        success:function(data){
        	 for(var i=0;i<data.length;i++){
        		 if(data[i].result=="success!"){
        			$("#iID-p").val(data[i].invoiceNumber);
        		 }
        		 else{
        			 alert("缴费失败!");
        		 }
        	 }
        }
    });
}
//点击弹出按钮
function popBox(){
	var popBox=document.getElementById("popBox");
	var popLayer=document.getElementById("popLayer");
	popBox.style.display="block";
	popLayer.style.display="block";
};

//点击关闭按钮
function closeBox(){
	var popBox=document.getElementById("popBox");
	var popLayer=document.getElementById("popLayer");
	popBox.style.display="none";
	popLayer.style.display="none";
}
</script> 
</body>
</html>