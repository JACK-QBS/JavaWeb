package calculatorServlets;

import Dao.CalculatorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstParameter = request.getParameter("firstParameter");
        String operator = request.getParameter("operator");
        String secondParameter = request.getParameter("secondParameter");
        Double num = new CalculatorDao().operator(firstParameter, operator, secondParameter);
        request.setAttribute("num",num);
        request.setAttribute("firstParameter",firstParameter);
        request.setAttribute("operator",operator);
        request.setAttribute("secondParameter",secondParameter);
        request.getRequestDispatcher("/calculatorJsp/calculator.jsp").forward(request,response);
    }
}
