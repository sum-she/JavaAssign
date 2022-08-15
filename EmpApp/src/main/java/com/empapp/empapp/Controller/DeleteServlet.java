package com.empapp.empapp.Controller;

import com.empapp.empapp.Model.EmpDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            EmpDAO.delEmp(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("ViewServlet");
    }

}
