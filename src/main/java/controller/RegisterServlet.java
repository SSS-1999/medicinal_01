package controller;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * tomcat 自带了HttpServlet的jar包
 * 所以要导包：
 * Servlet-api
 * jsp-api
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/toReg")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收参数
        String username = req.getParameter("username");
        String pwd=req.getParameter("pwd");
        //调用UserDao的添加用户信息的方法
        UserDao dao=new UserDao();
        int row=dao.addUserInfo(username,pwd);
        //判断
        if(row>=1){
            //成功 跳转到登录页面
            //转发
            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }else{
            //停留在注册页面同时给出提醒信息
            //绑定数据到注册页面
            req.setAttribute("msg","服务器异常!请稍后重试...");
            req.getRequestDispatcher("register.jsp").forward(req,resp);


        }


    }
}
