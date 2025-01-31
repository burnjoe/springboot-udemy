<!-- Uses Header JSP Fragment -->
<%@ include file="common/header.jspf" %>
  <!-- Uses Navigation JSP Fragment -->
  <%@ include file="common/navigation.jspf" %>

  <!-- Bootstrap recommends to have the page content be inside of the class "container" -->
  <div class="container">
    <h1>Your Todos</h1>
    <!-- List Todos Table -->
    <table class="table">
      <thead>
        <tr>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Done?</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <!-- Uses the custom tag "forEach" of JSTL -->
        <c:forEach items="${todos}" var="todo">
          <tr>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <!-- Passes the 'todo.id' as query parameter -->
            <td>
              <a href="edit-todo?id=${todo.id}" class="btn btn-warning">Edit</a>
              <a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
  </div>

<!-- Uses Footer JSP Fragment -->
<%@ include file="common/footer.jspf" %>
