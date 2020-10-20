<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
   <script>
      
      function validate(){
    	  
    	  var username = document.form.username.value;
    	  var password = document.form.password.value;
    	  
    	  if (username==null || username==""){
    		  alert("Username Cannot Be Blank");
    		  return false;
    	  }
    	  else if(passowrd==null || pasword==""){
    		  alert("Password Cannot Be Blank");
    		  return false;
    	  }
      }
   
   </script>
</head>
<body>
   <div><h1>Login Application</h1></div>
   <br>
   <form name="form" action=LoginRegister method="post" onsubmit="return validate()">
      <table>
         <tr>
         <td><h3 style = "color: red;">${message}</h3>
         <h3 style = "color: red:">${message}</h3></td>
         </tr>
         <tr>
         <td>Username</td>
         <td><input type="text" name="username" /></td>
         </tr>
         <tr>
         <td>Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td><span style="color:red">
         <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
         </tr>
         <tr>
         <td></td>
         <td>
           <input type="submit" name="submit" value="login"></input><input type="reset" value="reset"></input></td></tr>
         <tr>
         <td><a href="Register.jsp">Registration</a></td>
         </tr>
     </table>
  </form>
</body>
</html>