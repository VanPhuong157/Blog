package controller;

import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;

@WebServlet(name = "dashboardServlet", urlPatterns = {"/dashboard"})
public class dashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date fromDate = Date.valueOf(request.getParameter("fromDate"));
        Date toDate = Date.valueOf(request.getParameter("toDate"));
        request.setAttribute("maxPost", new DAO().getPostMaxCountCmt(fromDate,toDate));
        request.setAttribute("fDate", request.getParameter("fromDate"));
        request.setAttribute("tDate", request.getParameter("toDate"));
        request.setAttribute("Tpost", new DAO().countPost(fromDate,toDate));
        request.setAttribute("Tcomment", new DAO().countComment(fromDate,toDate));
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

}
