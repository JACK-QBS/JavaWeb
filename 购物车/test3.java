package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "test3",urlPatterns = "/Test/test3")
public class test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        HttpSession session = request.getSession(true);
        String  item = request.getParameter("item"),
                mount = request.getParameter("mount"),
                unit = request.getParameter("unit");
        String str = "Name:" +item+ "   Mount:" + mount + "   Unit:" + unit;
        session.setAttribute(item,str);
        pw.println("goods in your car :");
        Enumeration e = session.getAttributeNames();
        while(e.hasMoreElements()){
            String name = (String) e.nextElement();
            pw.println("<br>" + session.getAttribute(name));
        }
        pw.println("</body>");
        pw.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
