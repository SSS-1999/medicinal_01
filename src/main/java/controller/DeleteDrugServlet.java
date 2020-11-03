package controller;

import dao.DrugDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据id删除用户
 *
 * */
@WebServlet(name = "DeleteDrugServlet",urlPatterns = "/deleteDrugById")
public class DeleteDrugServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数值
        String drugId =req.getParameter("drugId");
        //根据drugId删除用户
        DrugDao drugDao=new DrugDao();
        int row=drugDao.deleteDrugById(drugId);
        //对row判断
        if(row>0){
        //删除成功去哪里
            //重定向  告诉浏览器应该找谁处理   302状态码
            //如何实现重定向
            resp.sendRedirect("/findAllDrugs");

        }else{
            //删除失败去哪里 跳到出错页面
            //转发到错误页面
            req.getRequestDispatcher("error.jsp").forward(req,resp);


        }

    }
}
