/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.ejb.EJB;
import Beans.PostBean;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zach
 */
@WebServlet(name = "PostProcess", urlPatterns = {"/PostProcess"})
public class PostProcess extends HttpServlet {

    @EJB
    private PostBean postbean;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostProcess</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostProcess at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String code = request.getParameter("status_code");
        String status = request.getParameter("status");

        if (!(code.matches("^S[0-9]{4}$"))) {
            request.setAttribute("error", "<p style=\"color : red;\">Invalid Post Code, Please use format S0000</p>");
            RequestDispatcher view = request.getRequestDispatcher("post.jsp");
            view.forward(request, response);
        } else {
            if (!(postbean.checkCode(code))) {
                postbean.createPost(code, status);

                request.setAttribute("error", "<p style=\"color : blue;\">Post stored succesfully</p>");
                RequestDispatcher view = request.getRequestDispatcher("post.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("error", "<p style=\"color : red;\">Code already exists, please select another</p>");
                RequestDispatcher view = request.getRequestDispatcher("post.jsp");
                view.forward(request, response);
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
