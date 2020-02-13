<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>interest Calculator</title>
</head>
<body>
<h1>International Dollar Converter</h1>

<form action="interestServlet" method="post">
Enter a dollar amount to calculate Annual interest Rates at 4.25 percent:
<input type="text" name="dollarAmount" size="20">
<input type="submit" value="Calculate Interest" />
</form>
</body>
</html>