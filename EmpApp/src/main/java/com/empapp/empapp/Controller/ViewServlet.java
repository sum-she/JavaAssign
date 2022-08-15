package com.empapp.empapp.Controller;

import com.empapp.empapp.Model.EmpDAO;
import com.empapp.empapp.Model.EmpModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ViewServlet", value = "/ViewServlet")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='index.jsp'>Add New Employee</a>");
        out.println("<h1>Employees List</h1>");

        List<EmpModel> list = EmpDAO.allEmp();
         //display all employees
        out.println("<table border='1' width = '100%'");
        out.println("<tr><th>Id</th><th>Name</th><th>Age</th><th>Work Place</th><th>Daily Income</th><th>Edit</th><th>Delete</th></tr>");
        out.println("Employee List");
        for (EmpModel empModel: list){
            out.println("<tr>" +
                    "<td>" + empModel.getId() + "</td>" +
                    "<td>" + empModel.getName() + "</td>" +
                    "<td>" + empModel.getAge() + "</td>" +
                    "<td>" + empModel.getWorkPlace() + "</td>" +
                    "<td>" + empModel.getDailyIncome() + "</td>" +
                    "<td><a href='${pageContext.request.contextPath}/EditServlet" + empModel.getId() + "'>edit</a></td>" +
                    "<td><a href='${pageContext.request.contextPath}/DeleteServlet" + empModel.getId() + "'>delete</a></td>" +
                    "</tr>");
        }
        out.println("</table>");
        out.close();

    }

}
