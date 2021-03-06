package org.example.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//客户端
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);

        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream,"utf-8");

        OutputStream outputStream = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(outputStream,"utf-8");
        PrintWriter printWriter = new PrintWriter(writer);

        printWriter.printf("你好，我是帅哥！\r\n");//向服务器发送消息
        printWriter.flush();

        String message = scanner.nextLine();//从服务端读取消息
        System.out.println(message);

        socket.close();
    }
}
