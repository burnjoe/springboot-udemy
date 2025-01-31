<!-- Uses Header JSP Fragment -->
<%@ include file="common/header.jspf" %>
  <!-- Uses Navigation JSP Fragment -->
  <%@ include file="common/navigation.jspf" %>
  
  <div class="container">
    <h1>Welcome to Mojo!</h1>
    <h2>Your Name: ${name}</h2>
    <a href="http://localhost:8080/list-todos">See List Todos</a>
  </div>

<!-- Uses Footer JSP Fragment -->
<%@ include file="common/footer.jspf" %>