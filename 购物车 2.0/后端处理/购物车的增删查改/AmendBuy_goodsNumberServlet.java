package servlet;

import Dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AmendBuy_goodsNumberServlet",urlPatterns = "/amend")
public class AmendBuy_goodsNumberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer number = Integer.parseInt(request.getParameter("number"));
        Integer buy_goodsNumbers = new BookDao().findIdQuerybuy_goodsNumber(id);
        Integer bookNumbers = new BookDao().findIdQueryt_booksNumber(id);
        new BookDao().FindIdAmendBooksNumber(id,bookNumbers,buy_goodsNumbers,number);
        new BookDao().FindIdAmendBuy_goodsNumber(id,number);
        request.getRequestDispatcher("/showGoods").forward(request,response);
    }
}
