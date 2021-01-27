package org.example.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/test2")
public class ServletTest2 extends HttpServlet {
    /**
     * 文件上传：使用二进制流数据格式（只能上传一个文件）
     * 请求 Content-Type: application/octet-stream
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //获取请求文件：
        InputStream is = req.getInputStream();
        //拿到输入流，想打印还是保存再服务器本地，就是自己业务来决定
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] input = new byte[1024*24];
        int len;
        while ((len = bis.read(input)) != -1){
            System.out.println(new String(input,0,len));
        }
        //因为提交是post请求，所以返回json（返回网页没意义，网页都是get请求）
        resp.setContentType("application/json");
        resp.getWriter().println("OK");



    }
}
