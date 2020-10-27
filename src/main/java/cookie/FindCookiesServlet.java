package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查找浏览器中发过来的所有Cookie数据
 */
@WebServlet(name = "FindCookiesServlet",urlPatterns = "/find")
public class FindCookiesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //req.getCookies();  返回Cookie 对象数组
        Cookie[] cookies = req.getCookies();
        //遍历
          for (Cookie c:cookies){
              System.out.println(c.getName()+";"+c.getValue());

          }

    }
}
