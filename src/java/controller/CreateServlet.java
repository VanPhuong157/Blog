/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

import model.Post;
import utility.Utilities;

/**
 *
 * @author ASUS
 */
public class CreateServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("listCate", new DAO().getAllCate());
        request.getRequestDispatcher("homeadmin.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        Utilities uti = new Utilities();
        String hastag = request.getParameter("hastag");
        String status = request.getParameter("status");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        int cateId = Integer.parseInt(request.getParameter("cateId"));
        if (uti.checkFormHastag(hastag) && uti.validNotBlank(content) && uti.validNotBlank(content)) {
            //validate image not empty
            if (image.equals("")) {
                request.setAttribute("errEmptyImage", "You must upload an image");
                request.getRequestDispatcher("homeadmin.jsp").forward(request, response);
            } else {
                Date strDate = Date.valueOf(LocalDate.now());
                DAO d = new DAO();
                Post p = new Post(0,2,cateId, content, status, image, hastag,strDate);
                d.insertPost(p);
                response.sendRedirect("home");
            }
        } else {
            request.setAttribute("errWrongFormHastag", "Your hastag must be like format (ex:#football ...) and no field can be blank");
            request.getRequestDispatcher("homeadmin.jsp").forward(request, response);
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
