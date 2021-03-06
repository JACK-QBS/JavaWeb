package org.example.v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer {
    /*public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            new Thread(task).start();
        }
    }*/

    //采取固定大小的线程池：（简单，不是最优）
    public static void main(String[] args) throws IOException{

        ExecutorService threadPool = Executors.newFixedThreadPool(10);//10个线程
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            threadPool.execute(task);
        }
    }
}
