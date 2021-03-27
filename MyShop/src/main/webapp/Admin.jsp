<%@page import="java.util.List"%>
<%@page import="com.mycompany.Entities.Category"%>
<%@page import="com.mycompany.myshop.FactoryProvider"%>
<%@page import="com.mycompany.Dao.CategoryDao"%>
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
        
        
        <div class="container adminn">
            
            <div class="container-fluid mt-4">
                <%@include file="Components/message.jsp"%>
                
            </div>
            
            <div class="row mt-4">
                <div class="col-md-4">
                    
                    
                    <div class="card">
                        
                        <div class="card-body text-center">
                            <div class="container">
                             <img src="images/usersAdmin.jpg"  class="img-fluid rounded-circle "  width="100" height="100">
                            </div>
                            <h1>USERS</h1>
                            <h1>2000</h1>
                            
                            
                            
                        </div>
                    </div>
                    
                    
                </div>
                <div class="col-md-4">
                    
                     <div class="card">
                        
                        <div class="card-body text-center">
                            <div class="container">
                             <img src="images/Cate.png"  class="img-fluid rounded-circle "  width="100" height="100">
                            </div>
                            <h1>CATEGORIES</h1>
                            <h1>200</h1>
                            
                        </div>
                    </div>
                    
                    
                </div>
                
                <div class="col-md-4">
                    
                     <div class="card">
                        
                        <div class="card-body text-center">
                            <div class="container">
                            <img src="images/download2.png"  class="img-fluid rounded-circle " width="100" height="100">
                            </div>
                            <h1>PRODUCTS</h1>
                            <h1>20</h1>
                            
                        </div>
                    </div>
                    
                    
                </div>
                
            </div>
            
            <div class="row mt-4">
                <div class="col-md-6">
                    <div class="card"  data-toggle="modal" data-target="#add-category">
                        <div class="card-body text-center">
                            <div class="container">
                            <img src="images/addcate.jpg"  class="img-fluid rounded-circle " width="100" height="100">
                            </div>
                            <h1>Add Categories</h1>
                            
                        </div>
                        
                    </div>
                    
                </div>
                <div class="col-md-6">
                    
                    <div class="card" data-toggle="modal" data-target= "#ProcudtModal">
                        <div class="card-body text-center">
                            <div class="container">
                            <img src="images/downloadlist.png"  class="img-fluid rounded-circle " width="100" height="100">
                            </div>
                            <h1>Add prodcuts</h1>
                            
                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
            
        </div>
        
        <!--modal strart addCat-->
        <div>
            <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-category">
 
</button>

<!-- Modal -->
<div class="modal fade" id="add-category" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header custom-bg text-white">
        <h5 class="modal-title" id="exampleModalLabel">Category Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
          <form action="OperationServlet" method="post">
              
              <input type=hidden name="Operation" value="addcategory" >
              
              <div class="form-group">
                  
                  <input type="text" class="form-control" name="catTitle" placeholder="Enter Category Title" required>
                  
                  
                  
              </div>
              
              <div class="form-group">
                  <textarea style = "height:200px ;" class="form-control" placeholder="Add Category Description" name="catDesc" required></textarea>
              </div>
              <div class="container">
                  <button class="btn btn-outline-success" >Add Category</button>
              </div>
          </form>
        
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       
      </div>
    </div>
  </div>
</div>
            
        </div>
        
        
        <!---product modal-->
        
        <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ProcudtModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="ProcudtModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
          
          <form action="OperationServlet" method="post">
                  <input type=hidden name="Operation" value="addproduct" >
              <div class="form-group">
                  
                  <input type="text" class="form-control" name="PTitle" placeholder="Enter Product Title" required>
                  
                  
                  
              </div>
               <div class="form-group">
                  
                  <input type="text" class="form-control" name="Pprice" placeholder="Enter Product Price" required>
                  
                  
                  
              </div>
              
               <div class="form-group">
                  
                  <input type="text" class="form-control" name="pDisc" placeholder="Enter Product Discount" required>
                  
                  
                  
              </div>
              
               <div class="form-group">
                  
                  <input type="text" class="form-control" name="PQuant" placeholder="Enter Product Quant" required>
                  
                  
                  
              </div>
              
               <div class="form-group">
                   <label for="ppic">Select Picture</label>
                  <input type="file"  name="PPic" required>
                  
                  
                  
              </div>
                  
                  
                  
                 <!-- <input type="text" class="form-control" name="PPic" placeholder="Upload Product Pic" required>-->
                 
                 <% 
                  CategoryDao catdao=new CategoryDao(FactoryProvider.getFactory());
                  List<Category> clist=catdao.getCategories();

                 %>
                  <div class="form-group">
                 <select name="catId" class="form-control" id="">
                     <%
                         for(Category c:clist){
                     %>
                     <option value="<%=c.getCategory_id()%>"><%=c.getCategory_Title()%></option>
                     
                     
                     <%}%>
                     
                 </select>
          
                  
                  
                  
              </div>
              
              <div class="form-group">
                  <textarea style = "height:200px ;" class="form-control" placeholder="Add Product Description" name="PDesc" required></textarea>
              </div>
              
              
              
              <div class="container">
                  <button class="btn btn-outline-success" >Add Product</button>
              </div>
          </form>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       
      </div>
    </div>
  </div>
</div>
        
        <!--endp-->
        
        

            
        
    </body>
</html>
