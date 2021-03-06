package org.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//服务端
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        //作为Tcp的被动连接方，需要监听一个固定的端口（选择8080）
        //端口是随意选择的，只要该端口目前没有被占用

        //监听8080端口
        //下面的语句完成后，TCP端口就完成了LISTEN
        ServerSocket serverSocket = new ServerSocket(8080);

        //每循环一次，完成一次 请求-响应周期
        //服务端进行持续的服务提供
        while (true) {
            //三次握手发生在 accept 的调用过程中
            //我们通过 socket 向 os 要已经建立的TCp连接
            //1、目前有已经建立好的连接，os立即返回
            //2、否则，会一直等，直到 client 过来建立好连接
            Socket socket = serverSocket.accept();
            //socket代表已经建立好的一条Tcp连接（握手结束）
            System.out.println("有一条 TCP 连接已建立");

            //读取 client 发送过来的应用层数据
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream,"utf-8");
            String line = scanner.nextLine();//先读取客户端发来的消息
            System.out.println(line);

            //将数据写入 outputStream， 经过 os 内部的TCP机制，将数据发送给 client
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream,"utf-8");
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.printf("今天天气真好\r\n");
            printWriter.flush();
            //触发这个 socket 关联的 TCP 连接的四次挥手
            socket.close();
            //四次挥手结束
        }

    }
}
