<%@page import="com.mycompany.Entities.User"%>
<%
       
       User u=(User) session.getAttribute("current-user");
       
if(u==null){
    
    session.setAttribute("message", "You need to Login First!");
    response.sendRedirect("login.jsp");
    return;
} else if(u.getUserType().equals("normal")){
    session.setAttribute("message","You are not Admin!");
    response.sendRedirect("login.jsp");
    return;
    
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <%@include file ="Components/common_css_js_all.jsp" %>
    </head>
    
    <body>
        <%@include file="Components/Navbar.jsp" %>
    </body>
</html>
