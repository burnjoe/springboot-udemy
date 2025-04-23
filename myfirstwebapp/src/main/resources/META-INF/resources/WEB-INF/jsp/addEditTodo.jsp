<!-- Uses Header JSP Fragment -->
<%@ include file="common/header.jspf" %>
  <!-- Uses Navigation JSP Fragment -->
  <%@ include file="common/navigation.jspf" %>

  <div class="container">
    <h1>Enter Todo Details</h1>
    <!-- Usage of form tag library (form: prefix) -->
    <!-- modelAttribute="todo" maps the 'todo' to the TodoController.addTodo(Todo todo) parameter to bind it -->
    <form:form method="post" modelAttribute="todo">
      <!-- Description -->
      <fieldset class="mb-3">
        <form:label path="description">Description</form:label>
        <!-- path="description" maps the 'description' form input to the model's attribute Todo.description to bind it -->
        <form:input type="text" name="description" path="description" required="required" />
        <!-- Binds the BindingResult errors for description -->
        <!-- This is a form tag library, so instead of using class="" attribute, a cssClass="" should work -->
        <form:errors path="description" cssClass="text-warning" />
      </fieldset>

      <!-- Target Date -->
      <fieldset class="mb-3">
        <form:label path="targetDate">Target Date</form:label>
        <form:input type="text" name="targetDate" path="targetDate" required="required" />
        <form:errors path="targetDate" cssClass="text-warning" />
      </fieldset>

      <!-- Added these hidden inputs to fix validation error in 'id' and 'done' attributes -->
      <form:input type="hidden" name="id" path="id" />

      <form:input type="hidden" name="done" path="done" />

      <input type="submit" class="btn btn-success" value="Save" />
    </form:form>
  </div>

<!-- Uses Footer JSP Fragment -->
<%@ include file="common/footer.jspf" %>

<!-- jQuery -->
<script type="text/javascript">
  $('#targetDate').datepicker({
    format: 'yyyy-mm-dd'
  });
</script>