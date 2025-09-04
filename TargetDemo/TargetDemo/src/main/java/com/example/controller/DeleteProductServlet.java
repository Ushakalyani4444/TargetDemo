package com.example.controller;

import com.example.dao.ProductDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    private final ProductDAO dao = ProductDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect("listProducts");
    }
}
