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

/**
 * 模糊查询
 */
@WebServlet(urlPatterns = "/selectUserForLike",name = "LikeSearchServlet")
public class LikeSearchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收参数
        String name=req.getParameter("name");
        //将name传给UserDao的selectUserForLike(String name) 方法
        UserDao userDao=new UserDao();
        List<User> list = userDao.selectUserForLike(name);
        System.out.println(list.toString());
              //? 有数据了怎么办
        //将述绑定到main.jsp
        req.setAttribute("list",list);
        //转发
        req.getRequestDispatcher("main.jsp").forward(req,resp);






    }
}
