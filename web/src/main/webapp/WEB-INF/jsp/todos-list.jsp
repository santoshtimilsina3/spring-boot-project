<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<title>hello</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<div class="container">
<h1>List OF TODOS</h1>

<table class="table table-striped table-dark table-hover">
<tr><th>id</th>
<th>name</th>
<th>desc</th>
<th>targetDate</th>
<th>Action</th>
</tr>
 <c:forEach items="${data}" var="todo">
 <tr>
<td> ${todo.id}</td>
<td> ${todo.user}</td>
<td>${todo.desc}</td>
<td> ${todo.targetDate}</td>
<th><button class="button-primary"><a  class="btn btn-delete" href="/delete/?id=${todo.id}"> Delete</a></button>

</tr>
       </c:forEach>
</table>
<a class="button button-primary" href="/todo">add todo</a>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>