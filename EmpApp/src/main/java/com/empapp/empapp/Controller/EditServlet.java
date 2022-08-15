package com.empapp.empapp.Controller;

import com.empapp.empapp.Model.EmpDAO;
import com.empapp.empapp.Model.EmpModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet", value = "/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Employee</h1>");

        int id = Integer.parseInt(request.getParameter("id"));
        EmpModel empId = EmpDAO.searchEmp(id);
        //insert an employee
        out.println("Insert New Employee");
        out.println("<form action = 'EmpController' method = 'post' name = 'insertEmp'>");
        out.println("<tr><td></td><td>" + "<input type = 'hidden' name = 'Id' value = '" + "'/>"
                + empId.getId() + "</td></tr>");
        out.println("<tr><td>Name:</td><td><input type='text' name='Name' value='" +
                empId.getName() + "'/></td></tr>");
        out.println("<tr><td>Age:</td><td><input type='text' name='Age' value='" +
                empId.getAge() + "'/></td></tr>");
        out.println("<tr><td>Work place:</td><td>");
        out.println("<select name='Work_Place' style='width:150px'>");
        out.println("<option>Home</option>");
        out.println("<option>Outside</option>");
        out.println("</select>");
        out.println("</td></tr>");
        out.println("<tr><td>Daily Income:</td><td><input type='text' name='Daily Income' value='" +
                empId.getDailyIncome() + "'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}

