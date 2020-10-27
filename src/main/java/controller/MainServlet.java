package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainServlet",urlPatterns = "/toMain")
public class MainServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        //获取登录时绑定的name值
        String username=(String)session.getAttribute("name");
        //使用req绑定用户名到主页
        req.setAttribute("name",username);
        //跳转到主页  转发
        req.getRequestDispatcher("main.jsp").forward(req,resp);

    }
}
