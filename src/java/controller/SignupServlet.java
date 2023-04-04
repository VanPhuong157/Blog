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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utility.Utilities;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

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
            out.println("<title>Servlet SignupServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
        String fn = request.getParameter("fullname");
        String un = request.getParameter("username");
        String p = request.getParameter("password");
        String cf_p = request.getParameter("cf_pass");
        Utilities val = new Utilities();
        DAO d = new DAO();
        boolean flag= false;
        if (!val.validNotBlank(un) || !val.validNotBlank(p) || !val.validNotBlank(cf_p)
                || !val.validNotBlank(fn)) {
            request.setAttribute("errEmpty", "You must filled all!");  // notify
        } else if (val.checkExistUsername(un)) {
            request.setAttribute("errUserNameExisted", "This user has existed!");  // notify
        } else if (!val.checkRepeatPass(p, cf_p)) {
            request.setAttribute("errPassNotMatch", "Your repeat password is not match!");  // notify
        } else if (val.validInputRequire(un, p, cf_p, fn) != null) {
            String noti = val.validInputRequire(un, p, cf_p, fn);
            request.setAttribute("errInvalidInput", noti);  // notify
        } else {
            d.signup(fn, un, p, 2);
            request.setAttribute("successfully", "Sign up successfull!!!!");
            flag = true;
            response.sendRedirect("login");
        }
        if(!flag)request.getRequestDispatcher("signup.jsp").forward(request, response);

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
