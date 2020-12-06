package servlet;

import Dao.BookDao;
import entity.Buy_goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showGoodsServlet",urlPatterns = "/showGoods")
public class showGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Buy_goods> goods = new BookDao().showGoods();
        if (goods!=null) {
            request.setAttribute("goods",goods);
        }else {

        }
        request.getRequestDispatcher("/css/shopcar.jsp").forward(request,response);
    }
}

