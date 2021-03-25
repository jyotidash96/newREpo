<%-- 
    Document   : index
    Created on : 16-Mar-2021, 12:13:58 PM
    Author     : Guest Account
--%>

<%@page import="com.mycompany.myshop.FactoryProvider"%>
<%@page contentType="MyShop-Home" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Myshop</title>
        
        
        
        <%@include file ="Components/common_css_js_all.jsp" %>
    </head>
    <body>
        <%@include file="Components/Navbar.jsp" %>
        
        
        <h1>Session Factory Creating</h1>
        
      <% 

out.println(FactoryProvider.getFactory());

      %>
      
      


    </body>
</html>
