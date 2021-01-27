package org.example.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 读取本地硬盘文件，输出到响应数据里（文件复制下载）
 */
@WebServlet("/test")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //返回文件（浏览器下载文件）
        resp.setContentType("application/octet-stream");
        //读取本地硬盘文件，再输出
        FileInputStream fis = new FileInputStream("D:\\servlet-blog\\src\\test\\java\\org\\example");
        BufferedInputStream bis = new BufferedInputStream(fis);
        OutputStream os = resp.getOutputStream();
        byte[] input = new byte[1024*24];
        int len;
        while ((len = bis.read(input)) != -1){
            os.write(input,0,len);
        }

    }
}
