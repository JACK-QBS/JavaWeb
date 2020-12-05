package servlet;

import Dao.BookDao;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet",urlPatterns = "/bookList")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books= new BookDao().findALlBooks();
        if (books!=null) {
            request.setAttribute("books", books);
        }else {

        }
        request.getRequestDispatcher("/css/goods.jsp").forward(request,response);
    }
}
