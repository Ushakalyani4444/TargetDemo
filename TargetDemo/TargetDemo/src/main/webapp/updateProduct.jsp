<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.model.Product" %>
<%@ include file="header.jsp" %>
<%
  Product p = (Product) request.getAttribute("product");
%>
<div class="card shadow p-4" style="max-width:600px; margin:auto;">
    <h2 class="text-center mb-4 text-primary">Update Product</h2>
    <form action="updateProduct" method="post">
        <input type="hidden" name="id" value="<%= p != null ? p.getId() : 0 %>">
        <div class="mb-3">
            <label class="form-label">Product Name</label>
            <input type="text" name="name" class="form-control" value="<%= p != null ? p.getName() : "" %>" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Product Price</label>
            <input type="number" step="0.01" name="price" class="form-control" value="<%= p != null ? p.getPrice() : 0 %>" required>
        </div>
        <div class="d-flex justify-content-between">
            <button class="btn btn-primary">Save</button>
            <a href="listProducts" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>
<%@ include file="footer.jsp" %>
