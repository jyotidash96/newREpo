/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import com.mycompany.Dao.UserDao;
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

/**
 *
 * @author Guest Account
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
             
                
               String email=request.getParameter("emailid");
               String pass=request.getParameter("password");
               
               //System.out.println(email);
               //System.out.println(pass);
               
               UserDao userdao=new UserDao(FactoryProvider.getFactory());
             User u1= userdao.getuserByemail(email, pass);
             
             //System.out.println(u1);
             HttpSession session= request.getSession();
              
             
            
              if(u1==null){
                  //out.print("<h1>NOT FOUND!!</h1>");
                  session.setAttribute("message", "Invalid Details!! Try Again");
                  response.sendRedirect("login.jsp");
                  return;
              }   
                
             else{
                 out.print("<h1>WELCOME"+" "+u1.getUserName()+"</h1>");
                 
                 
               session.setAttribute("current-user", u1);
               if(u1.getUserType().equals("admin")){
                   response.sendRedirect("Admin.jsp");
                   
                   
               }else if(u1.getUserType().equals("normal")){
                   response.sendRedirect("Normaluser.jsp");
               }
                
               else{
                   out.println("Invalid User");
               }
                       
             }
             
                
                
            }catch(Exception e){
                
                e.printStackTrace();
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
