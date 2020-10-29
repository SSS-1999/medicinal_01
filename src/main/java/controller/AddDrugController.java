package controller;


import dao.DrugDao;

import pojo.Drug;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddDrugController",urlPatterns = "/addDrugInfo")
public class AddDrugController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String mediname=req.getParameter("mediname");
        String price= req.getParameter("price");
        String DUser=req.getParameter("DUser");

        //将拿到的数据封装到Drug对象
        Drug drug=new Drug();//alt + Enter 导包
        drug.setDrugName(mediname);
        drug.setDrugPrice(price);
        drug.setDrugUser(DUser);
        //创建DrugDao 对象 ，调用其中DrugDao(drug)
        DrugDao drugDao=new DrugDao();

        int row= drugDao.addDrugInfo(drug);
        if(row>0){
            //成功刷新页面
            //重定向
            resp.sendRedirect("/findAllDrugs");
        }else{

            //跳到错误页面
            //转发
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }







    }
}
