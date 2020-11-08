package Pratice1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取出帐号，密码
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        String keep = request.getParameter("keep");

        String chknumber = request.getParameter("chknumber");
        //从session中取出验证码
        String checkcode = (String) request.getSession().getAttribute("checkcode");
        //获取用户信息
        //验证帐号和密码
        if(checkcode.equals(chknumber)){
            if (keep != null) {
                // 当前时间 和 上次访问时间
                Cookie time = new Cookie("visitTime",""+ System.currentTimeMillis());
                time.setMaxAge(60 * 60 * 24 * 14);
                response.addCookie(time);

                // 两周免登录
                Cookie name = new Cookie("user", user);
                name.setMaxAge(60 * 60 * 24 * 14);
                response.addCookie(name);
            }
            // 跳转到购物页面
            request.getRequestDispatcher("/css/shopping.jsp").forward(request, response);
        }else {
            // 返回登录页面
            request.getRequestDispatcher("/css/login.jsp").forward(request,response);
        }
    }

}

