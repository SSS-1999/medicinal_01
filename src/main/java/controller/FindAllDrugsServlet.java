package controller;


import dao.DrugDao;

import pojo.Drug;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllDrugsServlet",urlPatterns = "/findAllDrugs")
public class FindAllDrugsServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //去数据库查询tb_drug表所有数据

        DrugDao Ddao=new DrugDao();
        List<Drug> Dlist = Ddao.findAllDrugInfo();
        for (Drug drug:Dlist){
            System.out.println(drug.toString());
        }
        //将这个集合绑定到main.jsp页面
        req.setAttribute("Dlist",Dlist);
        //转发到main.jsp页面
        req.getRequestDispatcher("main.jsp").forward(req,resp);



    }
}
