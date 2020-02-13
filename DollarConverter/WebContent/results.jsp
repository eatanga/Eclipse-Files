<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Dollar Conversion</title>
</head>
<body>
<p>
${d.getDollars()} dollars is equivalent to: <br/>
${d.getPesos()} Pesos <br/>
${d.getEuros()} Euros <br/>
${d.getPounds()} Pounds <br/>
${d.getFranc()} Franc <br/>
${d.getYen()} Yen <br/>
</p>
<a href ="index.jsp"> Convert another Dollar amount?</a> <br />
<a href ="interestCalculate.jsp"> Calculate interest?</a>
</body>
</html>