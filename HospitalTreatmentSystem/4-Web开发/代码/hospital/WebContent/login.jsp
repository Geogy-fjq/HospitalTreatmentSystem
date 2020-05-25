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
<title>登录</title>
<style> 
body{text-align:center} 
</style>
</head>
<body>
<div class="div">
	<h1><a style="font-size:25px;" class="c-red">欢迎登录东软云HIS医院管理系统！</a></h1><br/>
	<div>
		<label style="width:120px"><span class="c-red">*</span>账号：</label>
		<span>
		<input type="text" class="input-text" name="loginName" id="loginName" style="width:250px">
		</span>
	</div><br/>
	<div>
		<label style="width:120px"><span class="c-red">*</span>密码：</label>
		<span>
			<input type="password" class="input-text" name="password" id="password" style="width:250px">
		</span>
	</div><br/>
	<div>
		<button class="btn btn-primary radius" name="login" id="login"  type="submit"><i class="Hui-iconfont">&#xe642;</i>登录</button>
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
$("#login").click(function(){
    if($("input[name='loginName']").val()==""){
 	    alert("账号不能为空！");
    }
    else if($("input[name='password']").val()==""){
 	    alert("密码不能为空！");
    }
    else{      
        $.ajax({
	        url:"http://localhost:8080/hospital/loginServlet?number="+Math.random(),//要提交的路径
	        type:"post",//请求方式
	        async:false,
	        data:{//要发送的数据
	        	"loginName":$("input[name='loginName']").val(),
                "password":$("input[name='password']").val()
            },
	        dataType:"json",//指定返回数据格式
	        success:function(result){
	        	var flag=result.flag;
	        	if(flag==true){ 
	        		window.location.href="index.jsp?loginName="+$("#loginName").val();
	        	}
	        	else{
	        		alert("账号或密码错误！");
	        	}
     		}
   		}); 
 	}
    return false;
})
</script>
</body>
</html>