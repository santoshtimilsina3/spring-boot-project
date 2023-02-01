<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Add todo</title>
<form:form method="post" modelAttribute="todo">
<form:label path="desc" >Description</form:label>
<input path="desc" type ="text" name ="desc"><br>
<form:errors path="desc" />
<input type="submit" name="submit"/>
</form:form>
</head>
<body>
Add todo
</body>
</body>
</html>