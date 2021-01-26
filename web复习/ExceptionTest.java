package org.example.util;

public class ExceptionTest {
    public static void main(String[] args) {
     //    try {
             /*System.out.println("start");
             int i = 1/0;
             System.out.println("OK");*/
       //  } catch (Exception e) {
  //           e.printStackTrace();
         //}

        new Thread(()->{
            try {
                System.out.println("start");
                int i = 1/0;
                System.out.println("OK");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }
}
