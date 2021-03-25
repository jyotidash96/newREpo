
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>SignUp</title>
        
         <%@include file ="Components/common_css_js_all.jsp" %>
    </head>
    <body>
         <%@include file="Components/Navbar.jsp" %>
         
         <nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
    
    <li class="breadcrumb-item active" aria-current="page">Sign Up</li>
  </ol>
</nav>
         
         
       <div class="container-fluid">  
         <div class="row mt-5">
             <div class="col-md-4 offset-md-4">
                 
                
                 
                 <div class="card">
                     <div class="alert alert-primary" role="alert">
                          <%@include file="Components/message.jsp"%>
 
</div>
                     
                     <div class="card-body px-5">
                         
                        
                             
                       <img src="images/man.jpg"  class="img-thumbnail">
                        
                 <h3 class="text-center my-3">Sign Up</h3>
                 <form action="RegisterServlet" method="post">
                     <div class="form-group">
    <label for="name">User Name</label>
    <input name="user_name" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
    
  </div>
                 
                 
                
                     <div class="form-group">
    <label for="email">Enter Email</label>
    <input name="user_email" type="Email" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter email">
    
  </div>
                
                 
                
                     <div class="form-group">
    <label for="password">Enter Password</label>
    <input  name="user_password" type="Password" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter password">
    
  </div>
                 
                     <div class="form-group">
    <label for="Phone">Enter PhoneNo</label>
    <input name="user_phone" type="number" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter phoneNo">
    
  </div>
                 
                     <div class="form-group">
    <label for="Address">Enter Address</label>
    <textarea name="user_Address" "style="height:200px" class="form-control"  placeholder="Enter Address"></textarea>
                     </div>
                     
                     
                     
                     <div class="container text-center">
                         
                         <button class="btn btn-outline-success">Sign Up</button>
                         <button class="btn btn-outline-warning">Try Again</button>
                     </div>
  
                 </form>
                     </div>
                 </div>


                 
             </div>
             
         </div>
       </div>
         
    </body>
</html>
