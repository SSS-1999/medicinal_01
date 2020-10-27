package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳到登录页面
 */
@WebServlet(name = "ToLoginPageServlet",urlPatterns = "/login")
public class ToLoginPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转到登录页面
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
