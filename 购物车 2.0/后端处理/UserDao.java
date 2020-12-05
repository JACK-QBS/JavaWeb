package Dao;

import entity.User;
import database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public User findByName(String name) {
        User user = null;
        Connection connection = DB.getConn();

        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from usertable where name = ?";
            prst = connection.prepareStatement(sql);
            prst.setString(1,name);
            rs = prst.executeQuery();//得到查询结果
            if(rs.next()){
                user = new User();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(prst);
        }
        return user;
    }

}
