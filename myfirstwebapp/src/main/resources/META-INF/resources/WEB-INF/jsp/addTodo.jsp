<!-- Directive in JSPs to import or declare a tag library -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!-- Imports a form tag library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
    <title>Add Todo Page</title>
  </head>
  <body>
    <div class="container">
      <h1>Enter Todo Details</h1>
      <!-- Usage of form tag library (form: prefix) -->
      <!-- modelAttribute="todo" maps the 'todo' to the TodoController.addTodo(Todo todo) parameter to bind it -->
			<form:form method="post" modelAttribute="todo">
        <!-- path="description" maps the 'description' form input to the model's attribute Todo.description to bind it -->
				Description: <form:input type="text" name="description" path="description" required="required" />
        <!-- Added these hidden inputs to fix validation error in 'id' and 'done' attributes -->
				<form:input type="hidden" name="id" path="id" />
        <form:input type="hidden" name="done" path="done" />
				<input type="submit" class="btn btn-success" value="Save" />
			</form:form>
    </div>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
