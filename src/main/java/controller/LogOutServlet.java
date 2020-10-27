package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogOutServlet",urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 退出系统 要清空session对象  将保存在session 对象里面数据要清空
         */
        HttpSession session=req.getSession();
        String name=(String)session.getAttribute("name");
        //对name数据判断
        if(name!=null){
            //清空session数据
            session.removeAttribute("name");
            //跳转到登录页面 用重定向或转发都行
            resp.sendRedirect("/login");

        }


    }
}
