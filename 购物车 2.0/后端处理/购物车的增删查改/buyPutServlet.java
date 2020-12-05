package servlet;

import Dao.BookDao;
import entity.Buy_goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "buyPutServlet",urlPatterns = "/buyPut")
public class buyPutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer buy_numbers = Integer.parseInt(request.getParameter("buy_numbers"));
        int numbers = new BookDao().findIdQueryt_booksNumber(id);
        int Prebuy_numbers = new BookDao().findIdQuerybuy_goodsNumber(id);
        new BookDao().findIdChanget_booksNumber(buy_numbers,id,numbers);
        new BookDao().findIdChangebuy_goodsNumber(buy_numbers,id,Prebuy_numbers);
        Buy_goods buy_goods = new Buy_goods();
        buy_goods.setId(id);
        buy_goods.setName(name);
        buy_goods.setBuy_numbers(buy_numbers);
        new BookDao().addBuyBooks(buy_goods);
        request.getRequestDispatcher("/bookList").forward(request,response);
    }
}
