<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<style>
* {
  box-sizing: border-box;
}
    h1{
        background-color : lightblue;
		text-align: center;
    }
  h3{
        background-color : lightpink;
		text-align: center;
    }
	body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: #E1E3F0;
  justify-content: center;
}
 
.bg-1 { 
    background-color:#f7dcf3; /* Green */
    color: black;
  }
  .container {
  border-radius: 5px;
  background-color: #A3ACCC;
  padding: 20px;
}
.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}
.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
<body>
<div id ="container-fluid">
<div class="container">

<h1>A.N.E AUTO SALES</h1>
<h3 class="margin">Car Inventory</h3>

<form action = "editCarServlet" method="post">
Company: <input type ="text" name = "company" value= "${carToEdit.company}">
Car: <input type = "text" name = "car" value= "${carToEdit.car}">
<input type = "hidden" name = "id" value="${carToEdit.id}">
<input type = "submit" value="Save updated Car">
</form>
</div>
</div>
</body>
</html>