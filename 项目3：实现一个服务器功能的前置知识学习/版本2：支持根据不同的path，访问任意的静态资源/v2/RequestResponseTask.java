package org.example.v2;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestResponseTask implements Runnable{

    private static final String DOC_BASE = "D:\\Code\\JavaWeb\\docBase";
    private final Socket socket;

    //Map<suffix,contentType>
    private static final Map<String,String> mimeTypeMap = new HashMap<>();
    static {
        mimeTypeMap.put("txt","txt/plain");
        mimeTypeMap.put("html","text/html");
        mimeTypeMap.put("js","application/javascript");
        mimeTypeMap.put("jpg","image/jpeg");
    }

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            System.out.println("一条TCP连接已经建立！");

            //1、进行 HTTP 请求解析 -> 解析出路径
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream,"UTF-8");
            scanner.next();//读取出来的是方法，暂时不用，所以不保存
            String path = scanner.next();
            System.out.println(path);

            //welcome文件
            if (path.equals("/")) {
                path = "/index.html";
            }

            //用户请求的静态资源对应的路径
            String filePath = DOC_BASE + path;
            //（1）暂时先不考虑文件是一个目录的情况
            //（2）判断该文件是否存在 - File
            File resource = new File(filePath);
            if (resource.exists()) {
                //读取文件内容，并写入 response body 中

                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                String contentType = "text/plain";//默认后缀名
                //找到路径对应的后缀（字符串处理）
                if (path.contains(".")) {
                    int i = path.lastIndexOf(".");
                    String suffix = path.substring(i+1);
                    mimeTypeMap.getOrDefault(suffix,contentType);
                }
                //如果 contentType 是"text/.."，代表是文本
                //我们都把字符集统一设定成 utf-8
                if (contentType.startsWith("text/")) {
                    contentType = contentType + ";charset=utf-8";
                }

                //写响应行
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                //写响应头
                printWriter.printf("Content-Type: %s\r\n",contentType);
                //写入空行，代表响应头结束
                printWriter.printf("\r\n");
                printWriter.flush();
                //写响应体，html 内容
                try (InputStream resourceInputStream = new FileInputStream(resource)){
                    byte[] buffer = new byte[1024];
                    while (true) {
                        //拿桶（大小1024）接水龙头（文件）流下来的水
                        int len = resourceInputStream.read(buffer);
                        //文件内容全部读完
                        if (len == -1) {
                            break;
                        }
                        //把桶里水倒入下水道（TCP发送缓冲池）
                        outputStream.write(buffer,0,len);
                    }
                    outputStream.flush();
                }
                socket.close();
                System.out.println("一条TCP连接已经释放！");
            } else {
                //response 404
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream,"UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                //写响应行
                printWriter.printf("HTTP/1.0 404 NOT Found\r\n");
                //写响应头
                printWriter.printf("Content-Type: text/html;charset=utf-8\r\n");
                //写入空行，代表响应头结束
                printWriter.printf("\r\n");
                //写响应体，html 内容
                printWriter.printf("<h1>%s对于资源不存在<h1>",path);
                printWriter.flush();
                socket.close();
                System.out.println("一条TCP连接已经释放！");
            }
        } catch (IOException e) {
            //
            e.printStackTrace(System.out);
        }
    }
}
