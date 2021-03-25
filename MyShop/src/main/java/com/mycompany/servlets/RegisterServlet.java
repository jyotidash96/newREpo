/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import com.mycompany.Entities.User;
import com.mycompany.myshop.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            try{
                
                String username= request.getParameter("user_name");
                String userEmail= request.getParameter("user_email");
                String userPassword= request.getParameter("user_password");
                String userphone= request.getParameter("user_phone");
                String userAddress= request.getParameter("user_Address");
              // String userType = request.getParameter("user_Type");
                
                User user=new User(username , userEmail , userPassword , userphone , userAddress , "default.jpg" , "normal" );
                
                
                Session hibernatesession = FactoryProvider.getFactory().openSession();
            Transaction t = hibernatesession.beginTransaction();
              int userId= (int) hibernatesession.save(user);
              t.commit();
              hibernatesession.close();
              
              HttpSession session= request.getSession();
              session.setAttribute("message","Sign up successful userID is" +" " +userId);
              response.sendRedirect("Signup.jsp");
              return;
              
                
                
            }catch(Exception e){
            e.printStackTrace();
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
