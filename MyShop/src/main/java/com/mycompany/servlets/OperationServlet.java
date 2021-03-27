/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import com.mycompany.Dao.CategoryDao;
import com.mycompany.Entities.Category;
import com.mycompany.myshop.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Guest Account
 */
@WebServlet(name = "OperationServlet", urlPatterns = {"/OperationServlet"})
public class OperationServlet extends HttpServlet {

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
            
            String op=request.getParameter("Operation");
            if(op.trim().equals("addcategory")){
             String CatTitle1=request.getParameter("catTitle");
            String CatDesc1=request.getParameter("catDesc");
            
            Category category=new Category();
            category.setCategory_Title(CatTitle1);
            category.setCatrgory_Description(CatDesc1);
            
            CategoryDao catdao=new CategoryDao(FactoryProvider.getFactory());
            //categories save
           int catIdd= catdao.saveCategory(category);
            HttpSession session= request.getSession();
              session.setAttribute("message","Category added with id:" +" " +catIdd);
              response.sendRedirect("Admin.jsp");
              return;
            
            //endcat
            
            
            //Session hibernatesession = FactoryProvider.getFactory().Opensession();
            
            }
            
           
            
            
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
        processRequest(request, response);
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
