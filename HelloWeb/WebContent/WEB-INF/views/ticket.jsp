<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>ticket</h2>
<form:form method="POST" action="/HelloWeb/purchase">
	<table>${ti}</table>
   <table>
    <tr>
        <td><form:label path="place">Place</form:label></td>
        <td><form:input path="place" /></td>
    </tr>
    <tr>
        <td><form:label path="cost">Cost</form:label></td>
        <td><form:input path="cost" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>