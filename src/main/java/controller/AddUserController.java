package controller;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserController",urlPatterns = "/addUserInfo")
public class AddUserController  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //处理中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收参数
        String name=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        String tel=req.getParameter("phone");

        //将拿到的数据封装到User对象
        User user=new User();//alt + Enter 导包
        user.setTel(tel);
        user.setPassword(pwd);
        user.setName(name);
        //创建UserDao 对象 ，调用其中addUser(user)
        UserDao userDao=new UserDao();
       int row= userDao.addUserInfo(user);
       if(row>0){
           //成功刷新页面
           //重定向
           resp.sendRedirect("/findAllUsers");
       }else{

           //跳到错误页面
           //转发
           req.getRequestDispatcher("error.jsp").forward(req,resp);
        }



    }
}
