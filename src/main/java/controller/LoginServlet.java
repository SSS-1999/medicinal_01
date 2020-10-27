package controller;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/toLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收数据
        String username=req.getParameter("name");
        String pwd=req.getParameter("password");
        //根据用户名查找当前用户是否存在
        UserDao dao=new UserDao();
        User user=dao.findUserByUserName(username);
        //得到输出流
        PrintWriter pw=resp.getWriter();
        //告诉浏览器服务端输出的内容
        resp.setContentType("text/html;charset=utf-8");
        //判断user对象
        if(user==null){
           // pw.println("该用户不存在");
            pw.println(202);//1代表用户不存在
            return;
        }else{
            //比较用户名和密码
            if(user.getName().equals(username) && user.getPassword().equals(pwd)){
                //pw.println("登录成功");
                //存储数据
                HttpSession httpSession=req.getSession();
                //将用户名绑定到session中
                httpSession.setAttribute("name",username);
                pw.println(200);//表示登录成功
            }else{
                //pw.println("用户名或者密码错误");
                pw.println(203);//表示用户名或者密码错误
            }

        }





    }
}
