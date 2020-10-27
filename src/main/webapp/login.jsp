<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form class="form-horizontal"   method="post" >
    <h2 style="text-align: center">用 户 登 录</h2>
    <div class="form-group">
        <label for="d1" class="col-sm-2 control-label">用户名：</label>
        <div class="col-sm-10">
            <input type="text" name="username" style="width: 100%"  class="form-control" id="d1" placeholder="请输入用户名...">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
        <div class="col-sm-10">
            <input type="password" name="pwd" style="width: 100%"  class="form-control" id="inputPassword3" placeholder="请输入密码...">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" id="btn" class="btn btn-primary" style="width: 22%;margin-left: 150px">登 录</button>
        </div>
    </div>
</form>

</div>
</body>
<script>
    //给登录按钮添加点击事件
   $("#btn").click(function(){
       //在发送ajax请求之前，获取用户名和密码
       var name=$("#d1").val();
       var password=$("#inputPassword3").val();
       if(name==null||name==""){
           alert("登录名不能为空!");
           return;
       }
       if(password==null||password==""){
           alert("密码不能为空!");
           return;
       }
       //发送ajax请求   name=ldk&password=123&age=20
       $.post("/toLogin","name="+name+"&"+"password="+password,function(data){
                    if(data==202){
                        alert("该用户不存在");
                        //跳到注册页面
                        location.href="/register.jsp";
                    }
                    if(data==200){
                        alert("登录成功");
                        //成功跳到主页
                        location.href="/toMain";
                    }
                    if(data==203){
                        alert("用户名或者密码错误");
                    }
       });

   });


</script>
</html>
