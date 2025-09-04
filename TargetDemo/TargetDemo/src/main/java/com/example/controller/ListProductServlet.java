package com.example.controller;

import com.example.dao.ProductDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ListProductServlet extends HttpServlet {
    private final ProductDAO dao = ProductDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", dao.getAll());
        RequestDispatcher rd = req.getRequestDispatcher("listProducts.jsp");
        rd.forward(req, resp);
    }
}
