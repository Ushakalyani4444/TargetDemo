package com.example.controller;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateProductServlet extends HttpServlet {
    private final ProductDAO dao = ProductDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("product", dao.getById(id));
        RequestDispatcher rd = req.getRequestDispatcher("updateProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        Product p = new Product(id, name, price);
        dao.update(p);
        resp.sendRedirect("listProducts");
    }
}
