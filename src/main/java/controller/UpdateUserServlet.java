package controller;

import com.alibaba.fastjson.JSONObject;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据id查找当前数据
 */
@WebServlet(name = "UpdateUserServlet",urlPatterns = "/findUserForUpdateUserById")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数值

        String id=req.getParameter("id");
        //调用UserDao 的 findUserInfo(String id)方法 将id传入
        UserDao userDao=new UserDao();
        User user=userDao.findUserInfo(id);
        //将user转成json字符串 user="{"id":19,"name":"卢钿开","password":"123","tel":"13411375191"}"
        String json=JSONObject.toJSONString(user);
        //告诉浏览器输出数据格式
        resp.setContentType("application/json;charset=utf-8");
        //获取输出流
        resp.getWriter().write(json);




    }
}
