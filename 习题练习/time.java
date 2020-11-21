package Pratice1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "time")
public class time extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK"); //设定中文
        PrintWriter out = response.getWriter(); // 使用输出流，输出信息
        out.println("<HTML>");
        out.println("<BODY>");
        Calendar calendar = Calendar.getInstance(); // 创建一个日历对象
        calendar.setTime(new Date()); // 用当前时间初始化日历时间
        int hour = calendar.get(Calendar.HOUR_OF_DAY),
                mintue = calendar.get(Calendar.MINUTE),
                second = calendar.get(Calendar.SECOND);
        if (hour >= 24) {
            response.sendRedirect("Night"); // 重定向
        } else if (hour >= 8 && hour <= 12) {
            out.print("现在时间是：");
            out.print(hour + ":" + mintue + ":" + second);
            out.print("上午好");
        } else if (hour > 22) {
            out.print("现在时间是：");
            out.print(hour + ":" + mintue + ":" + second);
            out.print("早点休息");
            out.println("</BODY>");
            out.println("</HTML>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
