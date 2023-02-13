  <%@ include file=" /WEB-INF/jsp/nav.jspf" %>
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
<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/YYYY"/></td>
<th><button class="button-primary"><a  class="btn btn-delete" href="/delete/?id=${todo.id}"> Delete</a>
<button class="button-primary"><a  class="btn btn-update" href="/update/?id=${todo.id}"> Update</a>
</button>

</tr>
       </c:forEach>
</table>
<a class="button button-primary" href="/todo">add todo</a>
</div>

<%@ include file=" /WEB-INF/jsp/footer.jspf" %>