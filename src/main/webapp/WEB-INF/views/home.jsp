<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Calculator</title>
</head>
<body>
	<h1>Calculator</h1>
	<form:form action="" method="POST" commandName="form">
		<table>
			<tr>
				<td><form:input path="number1" size="10" /></td>
				<td><form:errors path="number1" /></td>
			</tr>
			<tr>
				<td><form:input path="number2" size="10" /></td>
				<td><form:errors path="number2" /></td>
			</tr>
		</table>

		<table>
			<tr>
				<td><input type="submit" name="add" value="+" /></td>
			
				<td><input type="submit"name="subtract" value="-" /></td>
			</tr>
			<tr>
				<td><input type="submit"name="multiply" value="*" /></td>
			
				<td><input type="submit"name="divide" value="/" /></td>
			</tr>
		</table>
	</form:form>

<form:form action="clean" method="POST">
	<input type="submit"name="clean" value="C" />
</form:form>

<h4>Wynik to: ${calculate}</h4>

<c:forEach var="entry" items="${history}">
<span>${entry.number1} ${entry.operation} ${entry.number2} = ${entry.result}</span><br/>
</c:forEach>





</body>
</html>
