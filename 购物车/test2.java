package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "test2",urlPatterns = "/Test/test2")
public class test2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String passowrd = request.getParameter("password");
        String saveLoginState = request.getParameter("saveLoginState");

        if (name != null && !(name.equals("")) && passowrd != null
                && !(passowrd.equals(""))) {
            //若用户选择
            if (saveLoginState != null && saveLoginState.equals("1")) {
                Cookie cookie1 = new Cookie("name", name);
                cookie1.setMaxAge(1209600);
                response.addCookie(cookie1);
                Cookie cookie2 = new Cookie("password", passowrd);
                cookie2.setMaxAge(1209600);
                response.addCookie(cookie2);
            }
            response.getWriter().println(name + " :" + passowrd);
        } else {
            response.sendRedirect("test2.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
