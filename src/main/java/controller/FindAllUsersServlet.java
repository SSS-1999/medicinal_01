package controller;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllUsersServlet",urlPatterns = "/findAllUsers")
public class FindAllUsersServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //去数据库查询tb_user表所有数据
        UserDao dao =new UserDao();
        List<User> list = dao.findAllUserInfo();
        for (User user:list){
            System.out.println(user.toString());
        }
        //将这个集合绑定到main.jsp页面
        req.setAttribute("list",list);
        //转发到main.jsp页面
        req.getRequestDispatcher("main.jsp").forward(req,resp);



    }
}
