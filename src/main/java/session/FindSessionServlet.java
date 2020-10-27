package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "FindSessionServlet",urlPatterns = "/findSession")
public class FindSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       HttpSession httpSession= req.getSession();
       Integer count=(Integer) httpSession.getAttribute("count");
       System.out.println("count:"+count);
       String sessionId=httpSession.getId();
       System.out.println("sessionId:"+sessionId);

    }
}
