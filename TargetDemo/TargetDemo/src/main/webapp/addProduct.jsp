<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="header.jsp" %>
<div class="card shadow p-4" style="max-width:600px; margin:auto;">
    <h2 class="text-center mb-4 text-primary">Add Product</h2>
    <form action="addProduct" method="post">
        <div class="mb-3">
            <label class="form-label">Product Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Product Price</label>
            <input type="number" step="0.01" name="price" class="form-control" required>
        </div>
        <div class="d-flex justify-content-between">
            <button class="btn btn-primary">Add</button>
            <a href="listProducts" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>
<%@ include file="footer.jsp" %>
