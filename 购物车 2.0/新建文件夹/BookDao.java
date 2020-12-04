package Dao;

import database.DB;
import entity.Book;
import entity.Buy_goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    /**
     * 查询所有书籍的方法
     * @return
     */
    public List<Book> findALlBooks() {
        List<Book> books = new ArrayList<>();
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;

        try {
            String sql = "select * from good";
            prst = conn.prepareStatement(sql);
            rs = prst.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setPrice(rs.getFloat(3));
                book.setNumber(rs.getInt(4));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(prst);
            DB.close(rs);
            DB.close(conn);
        }
        return books;
    }

    public Book findIdBuyBook(Integer id) {
        Book book = null;
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from good where id = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,id);
            rs = prst.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setPrice(rs.getFloat(3));
                book.setNumber(rs.getInt(4));
            }else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(prst);
            DB.close(rs);
            DB.close(conn);
        }
        return book;
    }

    public void addBuyBooks(Buy_goods buy_goods) {
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;

        try {
            String sql = "insert into cart(id,name,buy_numbers) values (?,?,?)";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,buy_goods.getId());
            prst.setString(2,buy_goods.getName());
            prst.setFloat(3,buy_goods.getBuy_numbers());
            prst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn);
            DB.close(prst);
            DB.close(rs);
        }
    }

    public List<Buy_goods> showGoods() {
        List<Buy_goods> goods = new ArrayList<>();
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;

        try {
            String sql = "select * from cart";
            prst = conn.prepareStatement(sql);
            rs = prst.executeQuery();
            while (rs.next()) {
                Buy_goods buy_goods = new Buy_goods();
                buy_goods.setId(rs.getInt(1));
                buy_goods.setName(rs.getString(2));
                buy_goods.setBuy_numbers(rs.getInt(3));
                goods.add(buy_goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(prst);
            DB.close(rs);
            DB.close(conn);
        }
        return goods;
    }


    public void findIdChanget_booksNumber(Integer buy_numbers,Integer id,Integer numbers) {
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;

        try {
            String sql = "update good set numbers=? where id=? ";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,numbers - buy_numbers);
            prst.setInt(2,id);
            prst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DB.close(conn);
            DB.close(prst);
            DB.close(rs);
        }
    }

    public void findIdChangebuy_goodsNumber(Integer buy_numbers, Integer id,Integer Prebuy_numbers) {
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;

        try {
            String sql = "update cart set buy_numbers=? where id = ? ";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,Prebuy_numbers + buy_numbers);
            prst.setInt(2,id);
            int i = prst.executeUpdate();
            if (i > 0){

            }else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DB.close(conn);
            DB.close(prst);
            DB.close(rs);
        }
    }

    public Integer findIdQueryt_booksNumber(Integer id) {

        Book book = null;
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from good where id = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,id);
            rs = prst.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setPrice(rs.getFloat(3));
                book.setNumber(rs.getInt(4));
            }else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(prst);
            DB.close(rs);
            DB.close(conn);
        }
        Integer number = book.getNumber();
        return number;
    }

    public Integer findIdQuerybuy_goodsNumber(Integer id) {
        Book book = null;
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from cart where id = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,id);
            rs = prst.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setNumber(rs.getInt(3));
            }else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(prst);
            DB.close(rs);
            DB.close(conn);
        }
        Integer number = 0;
        if (book != null) {
            number = book.getNumber();
        }
        return number;
    }

    public void FindIdAmendBuy_goodsNumber(Integer id,Integer buy_goodsNumbers) {
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;

        try {
            String sql = "update cart set buy_numbers=? where id = ? ";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,buy_goodsNumbers);
            prst.setInt(2,id);
            prst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DB.close(conn);
            DB.close(prst);
            DB.close(rs);
        }
    }

    public void FindIdAmendBooksNumber(Integer id,Integer bookNumbers,Integer buy_goodsNumbers,Integer number) {
        //连接数据库
        Connection conn = DB.getConn();
        PreparedStatement prst = null;
        ResultSet rs = null;

        try {
            String sql = "update good set numbers=? where id = ? ";
            prst = conn.prepareStatement(sql);
            prst.setInt(1,bookNumbers - number + buy_goodsNumbers);
            prst.setInt(2,id);
            prst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DB.close(conn);
            DB.close(prst);
            DB.close(rs);
        }
    }

}
