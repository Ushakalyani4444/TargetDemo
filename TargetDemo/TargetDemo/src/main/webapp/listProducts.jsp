<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*,com.example.model.Product" %>
<%@ include file="header.jsp" %>
<h2 class="text-primary mb-3">Product List</h2>
<a href="addProduct" class="btn btn-success mb-3">+ Add Product</a>
<table class="table table-bordered table-striped">
  <thead>
    <tr><th>ID</th><th>Name</th><th>Price</th><th>Actions</th></tr>
  </thead>
  <tbody>
  <%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products == null || products.isEmpty()) {
  %>
    <tr><td colspan="4" class="text-center">No products yet.</td></tr>
  <%
    } else {
      for (Product p : products) {
  %>
    <tr>
      <td><%= p.getId() %></td>
      <td><%= p.getName() %></td>
      <td><%= p.getPrice() %></td>
      <td>
        <a class="btn btn-sm btn-warning" href="updateProduct?id=<%=p.getId()%>">Edit</a>
        <a class="btn btn-sm btn-danger" href="deleteProduct?id=<%=p.getId()%>" onclick="return confirm('Delete this product?')">Delete</a>
      </td>
    </tr>
  <%
      }
    }
  %>
  </tbody>
</table>
<%@ include file="footer.jsp" %>
