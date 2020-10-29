<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="resources/bootstrap-3.3.7-dist/js/jquery-1.9.1.min.js"></script>
    <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


</head>
<body>
    <!-- 作为body的直接子元素-->
<div class="modal fade" id="mymodel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form >
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">用户ID</label>
                        <input type="text" class="form-control" readonly="readonly" id="recipient-name">
                    </div>

                    <div class="form-group">
                        <label for="recipient-name" class="control-label">用户名</label>
                        <input type="text" class="form-control" readonly="readonly" id="username">
                    </div>

                    <div class="form-group">
                        <label for="recipient-name" class="control-label">密码</label>
                        <input type="text" class="form-control" id="pwd">
                    </div>


                    <div class="form-group">
                        <label for="recipient-name" class="control-label">电话</label>
                        <input type="text" class="form-control" id="tel">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary"  id="btn1">确定</button>
            </div>
        </div>
    </div>
</div>



    <!-- 添加用户信息的模态框-->
    <div class="modal fade" id="my" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" >添加用户信息</h4>
                </div>
                <div class="modal-body">
                    <form action="/addUserInfo" method="post">

                        <div class="form-group">
                            <label for="recipient-name" class="control-label">用户名</label>
                            <input type="text" name="username" class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="recipient-name" class="control-label">密码</label>
                            <input type="password" class="form-control" name="pwd">
                        </div>


                        <div class="form-group">
                            <label for="recipient-name" class="control-label">电话</label>
                            <input type="text" class="form-control" name="phone">
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-primary"  id="btn2">确定</button>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>




    <nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
           <%-- <a class="navbar-brand" href="#">药品类型</a>--%>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li >
                    <a href="/findAllDrugs">药品信息</a>
                </li>
                <li><a href="#">器材归类</a></li>
                <li><a href="/findAllUsers">查询用户</a></li>
                <li><a href="#"  data-toggle="modal" data-target="#my">添加用户</a></li>
                <li><a href="#">我的设置</a></li>
                <li><a href="#" data-toggle="modal" data-target="#medi">药品管理</a></li>
                <li><a href="#">信息中心</a></li>
                <li><a href="#">价格详情</a></li>
                <li><a href="#">我的设置</a></li>
                <li><a href="#" style="font-size: 20px">欢迎:&nbsp;&nbsp;${name}&nbsp;&nbsp;&nbsp;登录系统</a></li>
                <li><a href="/logout" style="font-size: 20px"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退出系统</a></li>

            </ul>
            <form class="navbar-form navbar-right" action="/selectUserForLike" method="post">
            <div class="form-group">
                <input type="text" name="name" class="form-control" placeholder="检索姓...">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
            <table class="table table-striped table-bordered table-hover table-condensed">
                <h2 style="text-align: center">个人信息一览表</h2>
                <tr>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>密码</td>
                    <td>电话</td>
                    <td>操作</td>

                </tr>

                <c:forEach items="${list}" var="i">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.name}</td>
                        <td>${i.password}</td>
                        <td>${i.tel}</td>
                        <td><a href="/deleteUserById?id=${i.id}">删除</a>|<a  onclick="findUserById('${i.id}')" data-toggle="modal" data-target="#mymodel">修改</a></td>

                    </tr>
                </c:forEach>

        </table>







    <!-- 添加药品信息的模态框-->
    <div class="modal fade" id="medi" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" >添加药品信息</h4>
                </div>
                <div class="modal-body">
                    <form action="/addDrugInfo" method="post">

                        <div class="form-group">
                            <label for="recipient-name" class="control-label">药品名称</label>
                            <input type="text" name="mediname" class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="recipient-name" class="control-label">药品价格</label>
                            <input type="text" class="form-control" name="price">
                        </div>


                        <div class="form-group">
                            <label for="recipient-name" class="control-label">药品适合人群</label>
                            <input type="text" class="form-control" name="DUser">
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-primary"  id="btn3">确定</button>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>

    <table class="table table-striped table-bordered table-hover table-condensed">
        <h2 style="text-align: center">药品信息一览表</h2>
        <tr>
            <td>药品编号</td>
            <td>药品名称</td>
            <td>药品价格</td>
            <td>药品适合人群</td>
            <td>操作</td>

        </tr>


        <c:forEach items="${Dlist}" var="Di">
            <tr>
                <td>${Di.drugId}</td>
                <td>${Di.drugName}</td>
                <td>${Di.drugPrice}</td>
                <td>${Di.drugUser}</td>
                <!--<td><a href="/deleteDrugBydrugId?drugId=${Di.drugId}">删除</a>|<a  onclick="findDrugBydrugId('${Di.drugId}')" data-toggle="modal" data-target="#Dmymodel">修改</a></td>
                    -->
                <td><a href="#">删除</a>|<a href="#"></a><a onclick="findDrugById('${Di.drugId}')" data-toggle="modal" data-target="#medimodel">修改</a> </td>
            </tr>
        </c:forEach>




    </table>




</body>

<script>

    function findUserById(userid){
        //href="/findUserForUpdateUserById?id=${i.id}"

        //alert(id);

        $.get("/findUserForUpdateUserById","id="+userid,function(data){
                //返回json数据格式
            //  {"name":"ludiankai","id":1,"age":20,"address":"江湖"}
            //data="{"id":19,"name":"ludinaki","password":"123","tel":"15365760776"}"
          $("#recipient-name").val(data.id);
          $("#username").val(data.name);
          $("#pwd").val(data.password);
          $("#tel").val(data.tel);



        });



    }

    //给确定按钮添加点击事件
    $("#btn1").click(function(){
        //获取表单数据
        var id=$("#recipient-name").val();//获取id值
        var name=$("#username").val();//获取name值
        var pwd=$("#pwd").val();//获取密码
        var tel=$("#tel").val();//获取电话
        //这个是url传参数   多个参数使用&符号连接起来
        location.href="/toUpdateUserInfo?id="+id+"&name="+name+"&password="+pwd+"&tel="+tel;
    });






</script>




</html>

