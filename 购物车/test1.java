package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "test1",urlPatterns = "/Test/test1")
public class test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] fav = request.getParameterValues("fav");

        PrintWriter pw = response.getWriter();

        pw.print("<html><body>");
        pw.print("<br>表单提交到servlet的数据如下：<br>");
        pw.print("姓名：" + name + "<br>"  );
        pw.print("密码：" + password + "<br>");
        pw.print("性别："+ sex+ "<br>" );
        pw.print( "爱好："+ Arrays.asList(fav)+"<br>" );
        pw.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
