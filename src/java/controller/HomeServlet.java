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
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import model.PageInfor;
import utility.Utilities;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
            out.println("<title>Servlet HomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession ses = request.getSession();
        DAO dao = new DAO();
        boolean reload = true;
        if (ses.getAttribute("reload") != null) {
            reload = (boolean) ses.getAttribute("reload");
        }
        if (reload) {
            dao.loadListPost();
            ses.setAttribute("reload", false);
        }
        // fixxed
        int size = dao.loadListPost().size();
        int cp = 0;
        int nrpp = 1; // update

        if (ses.getAttribute("nrpp") != null) {
            nrpp = (int) ses.getAttribute("nrpp");
        }

        Utilities uti = new Utilities();
        PageInfor page = new PageInfor(cp, nrpp, size);
        page.calc();
        request.setAttribute("cp", page);

        request.setAttribute("cf_delete", request.getAttribute("confirmDelete")); //set attribute to display confirm delete box
        if (!uti.getPost().isEmpty()) {
            request.setAttribute("listpost", uti.getPost());
        }
        //set attribute to send listpost data to home.jsp
        request.setAttribute("listCate", new DAO().getAllCate());
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        HttpSession ses = request.getSession();
        DAO dao = new DAO();
        boolean reload = true;
        if (ses.getAttribute("reload") != null) {
            reload = (boolean) ses.getAttribute("reload");
        }
        Utilities uti = new Utilities();
        if (request.getParameter("date") != null) {
            if (reload) {
                dao.loadListPost();
                ses.setAttribute("reload", false);
            }
            // fixxed
            int size = dao.loadListPost().size();
            int cp = 0;
            int nrpp = 1; // update

            if (ses.getAttribute("nrpp") != null) {
                nrpp = (int) ses.getAttribute("nrpp");
            }

            PageInfor page = new PageInfor(cp, nrpp, size);
            page.calc();
            request.setAttribute("cp", page);
            request.setAttribute("listpost", dao.getPostByDate(Date.valueOf(request.getParameter("date"))));
           request.setAttribute("listCate", new DAO().getAllCate());
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else if (request.getParameter("cateId") != null) {
            if (reload) {
                dao.loadListPost();
                ses.setAttribute("reload", false);
            }
            // fixxed
            int size = dao.loadListPost().size();
            int cp = 0;
            int nrpp = 1; // update

            if (ses.getAttribute("nrpp") != null) {
                nrpp = (int) ses.getAttribute("nrpp");
            }

            PageInfor page = new PageInfor(cp, nrpp, size);
            page.calc();
            request.setAttribute("cp", page);
            request.setAttribute("listpost", dao.getPostByCateID(Integer.parseInt(request.getParameter("cateId"))));
            request.setAttribute("listCate", new DAO().getAllCate());
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {

            int np = Integer.parseInt(request.getParameter("np"));
            int cp = Integer.parseInt(request.getParameter("cp"));
            int nrpp = 3; //update later
            nrpp = Integer.parseInt(request.getParameter("nrpp"));
            ses.setAttribute("nrpp", nrpp);

            if (reload) {
                dao.loadListPost();
                ses.setAttribute("reload", false);
            }
            if (request.getParameter("home") != null) {//click home btn
                cp = 0;
            }
            if (request.getParameter("pre") != null) {//click pre btn
                cp = cp - 1;
            }
            if (request.getParameter("next") != null) {//click next btn
                cp = cp + 1;
            }
            if (request.getParameter("end") != null) {//click end btn
                cp = np - 1;
            }
            for (int i = 0; i < np; i++) {
                if (request.getParameter("btn" + i) != null) {//click i btn
                    cp = i;
                }
            }
            PageInfor page = new PageInfor(cp, nrpp, dao.loadListPost().size());
            page.calc();
            request.setAttribute("listpost", uti.getPost()); //set attribute to send listpost data to home.jsp
            request.setAttribute("cp", page);
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
