package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 给浏览器添加cookie数据
 */
@WebServlet(name = "CookieServlet",urlPatterns = "/addcookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建Cookie对象
        Cookie cookie=new Cookie("ludiankai","is a teacher");
        //将已经添加内容cookie发送都给浏览器
        resp.addCookie(cookie);




    }
}
