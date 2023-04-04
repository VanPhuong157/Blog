/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import utility.Utilities;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String u = request.getParameter("user");
        String p = request.getParameter("pass");
        String r = request.getParameter("rem");
        Utilities val = new Utilities();
        DAO d = new DAO();
        Account a = val.getAccExist(u, p);   // get account if exist

        //khong co account nay
        if (a == null) {
            request.setAttribute("errAccNotExist", "Account is not exist or not active!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {          //ton tai account      
            HttpSession session = request.getSession();
            session.setAttribute("account", a); // when login create session attribute named "account"

            //de luu username, pass
            Cookie cu = new Cookie("user", u);
            Cookie cp = new Cookie("pass", p);
            Cookie cr = new Cookie("rem", r);

            //check xem co tich vao remember me khong
            if (r == null) {
                cu.setMaxAge(0);    // set thoi gian hoat dong cho cookie = 0
                cp.setMaxAge(0);
                cr.setMaxAge(0);
            } else {
                cu.setMaxAge(60 * 60 * 24); // set thoi gian hoat dong cho cookie = 1 ngay
                cp.setMaxAge(60 * 60 * 24);
                cr.setMaxAge(60 * 60 * 24);
            }
            response.addCookie(cu); //add cookie
            response.addCookie(cp);
            response.addCookie(cr);

            // mac dinh chuyen toi trang adminhome, sau do filter se phan quyen
            // neu da dang nhap va role = 1 moi chuyen toi adminhome
            // khong thi chuyen ve home hoac login 
            if (a.getRoleID() == 1) {
                response.sendRedirect("dashboard");
            } else {
                response.sendRedirect("home");
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
