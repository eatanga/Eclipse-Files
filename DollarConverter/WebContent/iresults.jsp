<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interest Display</title>
</head>
<body>
<p>
${i.getDollars()} Dollars annual interest will be: <br/>
${i.getInterest()} Dollars <br/>
</p>
<a href ="interestCalculate.jsp"> Calculate another interest?</a> <br />
<a href ="index.jsp"> Convert Dollars to international Currency?</a>

</body>
</html>