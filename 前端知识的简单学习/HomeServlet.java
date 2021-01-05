package com.qbs.profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    private int count;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String template =  "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>个人主页</title>\n" +
                "    <style>\n" +
                "        h1{\n" +
                "            color: blue;\n" +
                "            text-align:center;\n" +
                "        }\n" +
                "        #hello{\n" +
                "            color: red;\n" +
                "        }\n" +
                "        li.world{\n" +
                "            color: yellow;\n" +
                "        }\n" +
                "        body{\n" +
                "            background-image: url(\"image/dog.png\");\n" +
                "        }\n" +
                "        div.hobby li{\n" +
                "            color: #4cae4c;\n" +
                "        }\n" +
                "        div.hobby li:hover{\n" +
                "            color: red;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    <h1>:name:</h1>\n" +
                "    <p>是个帅哥</p>\n" +
                "</div>\n" +
                "<div class=\"hobby\">\n" +
                "    <h2>我的爱好</h2>\n" +
                "    <ul>\n" +
                "        <li id=\"hello\">写代码</li>\n" +
                "        <li class=\"world\">运动</li>\n" +
                "        <li class=\"world\">看电影</li>\n" +
                "    </ul>\n" +
                "</div>\n" +
                "<div>\n" +
                "    <h2>我想去的公司</h2>\n" +
                "    <ol>\n" +
                "        <!-- target为打开一个新窗口，href为超链接 -->\n" +
                "        <li><a target=\"_blank\" href=\"https://re.1688.com/?keywords={keywords}&cosite=baidujj_pz&location=re&trackid={trackid}&keywordid={keywordid}&format=normal\"> 阿里巴巴</a></li>\n" +
                "        <li><a target=\"_blank\" href=\"https://www.bilibili.com/\">哔哩哔哩</a></li>\n" +
                "        <li><a target=\"_blank\" href=\"https://v.bitedu.vip/\">比特</a></li>\n" +
                "    </ol>\n" +
                "</div>\n" + "<div><h3>访问次数： :count: </h3></div>" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        String content = template.replace(":name:",name).replace(":count:",String.valueOf(count));
        writer.println(content);
    }
}
