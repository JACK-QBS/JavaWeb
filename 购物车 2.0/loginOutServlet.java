package Pratice1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginOutServlet" )
public class loginOutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();//获取session
        if (session==null){
            response.sendRedirect("index.jsp");
            return;
        }
        //注销session，移除session中的数据
        session.removeAttribute("name");
        session.removeAttribute("psw1");
        session.removeAttribute("sex");
        session.removeAttribute("mesg");
        session.removeAttribute("favorite");
        //删除数据后跳转至success界面
        response.sendRedirect("css/seccess.jsp");
    }
}
