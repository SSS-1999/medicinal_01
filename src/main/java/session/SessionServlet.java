package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet",urlPatterns = "/newSession")
public class SessionServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建HttpSession对象
        HttpSession session=req.getSession();
        //使用HttpSession 存储数据
        session.setAttribute("count",1000);

        String id= session.getId();
        System.out.println("sessionid:"+id);






    }
}
