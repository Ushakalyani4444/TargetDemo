package com.example.controller;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddProductServlet extends HttpServlet {
    private final ProductDAO dao = ProductDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        double price = 0;
        try { price = Double.parseDouble(priceStr); } catch (Exception ignored) {}
        Product p = new Product(0, name, price);
        dao.addProduct(p);
        resp.sendRedirect("listProducts");
    }
}
