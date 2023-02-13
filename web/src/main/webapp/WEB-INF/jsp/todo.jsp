
<html>
<head>
<title>Add todo</title>
<body>
</head>
<form:form method="post" modelAttribute="todo">
<form:label path="desc" >Description</form:label>
<input path="desc" type ="text" name ="desc"><br>
<form:errors path="desc" />
<form:label path="targetDate" >Target Date</form:label>
<input path="targetDate" type ="text" name ="targetDate"><br>
<form:errors path="targetDate" />
<input type="submit" name="submit"/>
</form:form>
Add todo

</body>
</html>