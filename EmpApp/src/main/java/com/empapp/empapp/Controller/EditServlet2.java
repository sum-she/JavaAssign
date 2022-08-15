package com.empapp.empapp.Controller;

import com.empapp.empapp.Model.EmpModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet2", value = "/EditServlet2")
public class EditServlet2 extends HttpServlet {
    final EmpModel empModel = new EmpModel();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        empModel.setId(Integer.parseInt(req.getParameter("Id")));
        empModel.setName(req.getParameter("Name"));
        empModel.setAge(Integer.parseInt(req.getParameter("Age")));
        empModel.setName(req.getParameter("Work_Place"));
        empModel.setAge(Integer.parseInt(req.getParameter("Daily_Income")));

    }
}
