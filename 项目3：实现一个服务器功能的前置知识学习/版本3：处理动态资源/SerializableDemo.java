package org.v3;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filename = "D:\\Code\\JavaWeb\\sessions\\users.obj";

        // 把 u1 和 u2 对应的对象，序列化，并且写入到文件中（序列化）
        /*User u1 = new User(1, "陈沛鑫", "男");
        User u2 = new User(2, "林黛玉", "女");
        try (OutputStream outputStream = new FileOutputStream(filename)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(u1);
            objectOutputStream.writeObject(u2);

            objectOutputStream.flush();
        }*/

        //从文件中读取两个对象（反序列化）
        try (InputStream inputStream = new FileInputStream(filename)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            User user1 = (User) objectInputStream.readObject();
            User user2 = (User) objectInputStream.readObject();

            System.out.println(user1);
            System.out.println(user2);
        }

    }
}
