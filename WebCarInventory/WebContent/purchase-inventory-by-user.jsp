<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Inventory</title>
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

<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allInventory}" var="currentinventory">
<tr>
   <td><input type="radio" name="id" value="${currentinventory.id}"></td>
   <td><h2>${currentinventory.purchName}</h2></td></tr>
   <tr><td colspan="3">date: ${currentinventory.purchDate}</td></tr>
   <tr><td colspan="3">Buyer: ${currentinventory.buyer.buyerName}</td></tr>
   <c:forEach var = "purchVal" items = "${currentinventory.carInventory}">
            <tr><td></td><td colspan="3">
                ${purchVal.company}, ${purchVal.car}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<br /><br/>
<input type = "submit" value = "edit" name="doThisToCar">
<input type = "submit" value = "delete" name="doThisToCar">
<input type="submit" value = "add" name = "doThisToCar">
</form>
<br /><br/>
<a href="addCarsForInventoryServlet">Create a new Inventory</a>
<br /><br/>
<a href="ci_index.html">Insert a new car</a>
</div>
</div>
</body>
</html>