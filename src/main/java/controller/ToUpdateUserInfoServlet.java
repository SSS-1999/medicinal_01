package controller;
/**
 * 执行更新操作
 */

import dao.UserDao;

import javax.servlet.ServletException;


import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToUpdateUserInfoServlet",urlPatterns = "/toUpdateUserInfo")
public class ToUpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收参数
        String id=req.getParameter("id");
        String username=req.getParameter("name");
        String pwd= req.getParameter("password");
        String tel=req.getParameter("tel");
        System.out.println(tel);
        //调用UserDao的方法toUpdateUserInfo()，将参数值传给这个
        UserDao dao=new UserDao();
        int row=dao.toUpdateUserInfo(id,username,pwd,tel);
        if(row>0){
            //刷新页面
            //重定向
            resp.sendRedirect("/findAllUsers");
        }else {
            //跳到错误页面
            //转发到错误页面
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }
}
