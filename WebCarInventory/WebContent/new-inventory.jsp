<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new inventory</title>
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

<form action = "createNewInventoryServlet" method="post">
Inventory Name: <input type ="text" name = "purchName"><br /><br/>
Date created : <input type ="text" name = "month" placeholder="mm"
size="4"> <input type ="text" name = "day" placeholder="dd"
size="4"> <input type ="text" name = "year" placeholder="yyyy"
size="4"><br /><br/>
Buyer Name: <input type = "text" name = "buyerName"><br /><br/>
Available Cars:<br /><br/>
<select name="allCarsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCars}" var="currentcar">
<option value = "${currentcar.id}">${currentcar.company} |
${currentcar.car}</option>
</c:forEach>
</select>
<br /><br/>
<input type = "submit" value="Create Inventory and Add Cars"><br /><br/>
</form>
<a href = "ci_index.html">Go add new cars instead.</a>

</div>
</div>

</body>
</html>