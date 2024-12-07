<!-- Directive in JSPs to import or declare a tag library --> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
  <head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>List Todos Page</title>
  </head>
  <body>
    <!-- Bootstrap recommends to have the page content be inside of the class "container" -->
    <div class="container">
      <div>Welcome ${name}!</div> 
      <hr>
      <h1>Your Todos</h1>
      <!-- List Todos Table -->
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
          </tr>
        </thead>
        <tbody>
          <!-- Uses the custom tag "forEach" of JSTL -->
          <c:forEach items="${todos}" var="todo">
            <tr>
              <td>${todo.id}</td>
              <td>${todo.description}</td>
              <td>${todo.targetDate}</td>
              <td>${todo.done}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
