package controller;
// 处理用户名检查业务

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckUserNameServlet",urlPatterns = "/checkUserName")
public class CheckUserNameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收参数
        String name=req.getParameter("username");
        System.out.println(name);
        //根据用户名查询当前用户是否存在
        UserDao userDao=new UserDao();
        User user=userDao.findUserByUserName(name);
        //获取输出流
        PrintWriter out=resp.getWriter();
        //告诉浏览器服务端的输出内容
        resp.setContentType("text/html;charset=utf-8");
        //对user进行判断
        if(user==null){
            //说明注册的用户是不存在的，允许注册
           //昵称，用户名可用
            out.println("用户名可用");


        }else{
            //说明 注册该用户的用户名已经存在，不可在进行注册了。可以登录
            out.println("用户名已存在");
        }



    }
}
