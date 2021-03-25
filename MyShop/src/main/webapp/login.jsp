

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <%@include file ="Components/common_css_js_all.jsp" %>
    </head>
    <body>
        <%@include file="Components/Navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card mt-3">
                        <div class="card-header custom-bg text-white">
                            <h4>Login</h4>
                            
                            </div>
                            <div class="card-body">
                                
                                <form action="LoginServlet" method="post">
                                     <%@include file="Components/message.jsp"%>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input name= "emailid" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
                                    
                                   
  
                                    <div class="container text-center">
                                        <button type="submit" class="btn btn-primary custom-bg text-white" >Submit</button>
                                        <button type="reset"class="btn btn-primary custom-bg text-white" >TryAgain</button>
                                    </div>
                                    
  
                                    <div class="container text-center mt-2">
                                        <a href="Signup.jsp">SignUP if not registred!!</a>
                                    </div>
      

   
</form>
                                
                                </div>
                               
                            
                        
                    </div>
                    
                </div>
            </div>
        </div>
    </body>
</html>
