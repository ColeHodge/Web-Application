<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<script>
function validate()
{
	var firstname = document.form.firstname.value;
	var lastname = document.form.lastnamename.value;
	var email  = document.form.email.value;
	var username = document.form.email.value;
	var password = document.form.password.value;
	var conpassword = document.form.conpassword.value;
	
	if (firstname==null || firstname==""){
		alert("First Name Cannot Be Blank");
		return false;
	}
	else if (email==null || email==""){
		alert("Email Cannot Be Blank");
		return false;
	}
	else if (lastname==null || lastname==""){
		alert("Last Name Cannot Be Blank");
		return false;
	}
	else if (username==null || username==""){
		alert("Username Cannot Be Blank");
		return false;
	}
	else if (password.length<6){
		alert("Password Must Be At Least 6 Characters Long");
		return false;
	}
	else if (password!=conpassword){
		alert("Passwords Dont Match");
		return false;
	}
}

</script>
</head>
<body>
    <h2>Java Registration Application Using MVC and MySQL</h2>
    <form name="form" action="ProjectServlet" method="post" onsubmit="return validate()">
       <table align="center">
          <tr>
          <td>Username</td>
          <td><input type="text" name="username" /></td>
          </tr>
          <tr>
          <td>First Name</td>
          <td><input  type="text" name="firstname" /></td>
          </tr>
          <tr>
          <td>Last Name</td>
          <td><input type="text" name="lastname" /></td>
          </tr>
          <tr>
          <td>Email</td>
          <td><input  type="text" name="email" /></td>
          </tr>
          <tr>
          <td>Password</td>
          <td><input type="password" name="password" /></td>
          </tr>
          <tr>
          <td>Confirm Password</td>
          <td><input  type="password" name="conpassword" /></td>
          </tr>
          <tr>
          <td>Introduction</td>
          <td><input type="text" name="intro" /></td>
          </tr>
          <tr>
          <td>Hobbies</td>
          <td><input  type="text" name="hobbies" /></td>
          </tr>
          <tr>
          <td>
          <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
          </td>
          </tr>
          <tr>
          <td>
          </td>
          <td>
             <input type="submit" name="submit" value="register"></input><input type="reset" value="reset"></input>
          </td>
          </tr>
        </table>
    </form>
</body>
</html>