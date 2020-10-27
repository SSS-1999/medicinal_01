<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="resources/bootstrap-3.3.7-dist/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <style>
        body{
              background-image: url("resources/image/bg.jpg");
          }
        #div1{
            border:  1px solid #cccccc;
            margin:  100px auto;
            width: 35%;
          background-color: rgba(255,255,255,0.3);



        }
    </style>

</head>
<body>
<div id="div1">
<form class="form-horizontal" action="/toReg"  method="post" >
    <h2 style="text-align: center">用 户 注 册</h2>
    <div class="form-group">
    <label for="d1" class="col-sm-2 control-label">用户&nbsp;名：</label>
    <div class="col-sm-10">
        <input type="text" name="username" style="width: 100%"  class="form-control" id="d1" placeholder="请输入用户名...">
        <span id="sp"></span><span>${msg}</span>
    </div>
</div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密&nbsp;码：</label>
        <div class="col-sm-10">
            <input type="password" name="pwd" style="width: 100%"  class="form-control" id="inputPassword3" placeholder="请输入密码...">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary" style="width: 22%;margin-left: 150px">注册</button>
        </div>
    </div>
</form>

</div>
</body>
<script>
    //给用户名输入框绑定失去焦点事件
    $("#d1").blur(function(){
        //获取用户名输入框的值
        var name=$("#d1").val();
        //发ajax 请求
        $.ajax({
            "url":"/checkUserName",//请求路径
            "data":"username="+name,//我们要发什么数据给服务端(Servlet)
            "type":"post",//请求类型
           // "dataType":"json",//服务端返回数据格式类型  默认返回文本
            "success": function(data){  //data 封装服务端返回的数据
                    //这里可以暂时不写  因为 后台要回传json数据才能使用
                   // alert(data);
                $("#sp").html(data);
            }
        });
    });


</script>




</html>
