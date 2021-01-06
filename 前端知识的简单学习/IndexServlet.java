package com.qbs.profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class IndexServlet extends HttpServlet {
    static int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String template = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>首页</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p id=\"content\">::count::</p>\n" +
                "<script src=\"js/index.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        String content = template.replace("::count::",String.valueOf(count));
        writer.println(content);
    }
}
