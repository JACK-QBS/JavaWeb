package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static Connection conn = null;
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=UTF8";
    private static String username = "root";
    private static String password = "123456";

    /**
     * 获取数据库连接的方法
     */
    public static Connection getConn(){
        Connection connection = null;
        try {
            //注册驱动
            Class.forName(driverClass);
            //获取数据库连接
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接，语句对象，结果集对象等的方法
     */
    public static void close(AutoCloseable t){
        try {
            if(t != null){
                t.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
