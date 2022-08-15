package com.empapp.empapp.Controller;

import com.empapp.empapp.Model.EmpModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveServlet", value = "/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        EmpModel empModel = new EmpModel();

        empModel.setId(Integer.parseInt(req.getParameter("Id")));
        empModel.setName(req.getParameter("Name"));
        empModel.setAge(Integer.parseInt(req.getParameter("Age")));
        empModel.setName(req.getParameter("Work_Place"));
        empModel.setAge(Integer.parseInt(req.getParameter("Daily_Income")));

    }
}
