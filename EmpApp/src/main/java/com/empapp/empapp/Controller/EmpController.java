package com.empapp.empapp.Controller;

import com.empapp.empapp.Model.EmpDAO;
import com.empapp.empapp.Model.EmpModel;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/")
public class EmpController extends HttpServlet {
    //create a model object
    EmpModel empModel;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //content type of web page
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        //request value to set for Insert
        empModel.setId(Integer.parseInt(req.getParameter("Id")));
        empModel.setName(req.getParameter("Name"));
        empModel.setAge(Integer.parseInt(req.getParameter("Age")));
        empModel.setName(req.getParameter("Work_Place"));
        empModel.setAge(Integer.parseInt(req.getParameter("Daily_Income")));


        //forward request to get response
        req.getRequestDispatcher("index.jsp").include(req, resp);

        //create table
        out.println("<table border='1' width = '100%'");
        //table headers
        out.println("<tr><th>Id</th><th>Name</th><th>Age</th><th>Work Place" +
                "</th><th>Daily Income</th>");
        out.println("Employee List");
        //loop through list and print all employees
        for (EmpModel empModel: EmpDAO.allEmp()){
            out.println("<tr>" +
                    "<td>" + empModel.getId() + "</td>" +
                    "<td>" + empModel.getName() + "</td>" +
                    "<td>" + empModel.getAge() + "</td>" +
                    "<td>" + empModel.getWorkPlace() + "</td>" +
                    "<td>" + empModel.getDailyIncome() + "</td>" +
                    "</tr>");
        }
        out.println("</table>");

        int id = Integer.parseInt(req.getParameter("Id"));
        //print by id
        out.println("Get an Employee by ID");
        out.println("<form action = 'EmpController' method = 'post' " +
                "name = 'searchEmp'>");
        out.println("<tr><td></td><td>" + "<input type = 'hidden' name = 'Id' " +
                "value = ''  '" + "'/>"
                + EmpDAO.searchEmp(id) + "</td></tr>");

        //insert an employee
        out.println("Insert New Employee");
        out.println("<form action = 'EmpController' method = 'post' name = 'insertEmp'>");
        //print values
        out.println("<tr><td></td><td>" + "<input type = 'hidden' name = 'Id' value = '" + "'/>"
                + empModel.getName() + "</td></tr>");
        out.println("<tr><td>Name:</td><td><input type='text' name='Name' value='" +
                empModel.getName() + "'/></td></tr>");
        out.println("<tr><td>Age:</td><td><input type='text' name='Age' value='" +
                empModel.getAge() + "'/></td></tr>");
        out.println("<tr><td>Work place:</td><td>");
        out.println("<select name='Work_Place' style='width:150px'>");
        //drop down menu for workplace: Home or Outside
        out.println("<option>Home</option>");
        out.println("<option>Outside</option>");
        out.println("</select>");
        out.println("</td></tr>");
        out.println("<tr><td>Daily Income:</td><td><input type='text' name='Daily Income' value='" +
                empModel.getDailyIncome() + "'/></td></tr>");
        //enter button to submit
        out.println("<input type='submit' value='enter'/></td></tr>");
        out.print("</form>");

        //Delete an employee
        out.println("Delete an Empoyee by ID");
        out.println("<form action = 'EmpController' method = 'post'>");
        try {
            out.println("<tr><td></td><td>" + "<input type = 'hidden' name = 'Id' " +
                    "value = '" + "'/>"
                    + EmpDAO.delEmp(id) + "</td></tr>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // New employee list
        out.println("<table border='1' width = '100%'");
        //table header
        out.println("<tr><th>Id</th><th>Name</th><th>Age</th><th>Work Place</th><th>Daily Income</th>");
        out.println("New Employee List");
        //loop through list and print all updated employees
        for (EmpModel empModel2 : EmpDAO.allEmp()) {
            out.println("<tr>" +
                    "<td>" + empModel2.getId() + "</td>" +
                    "<td>" + empModel2.getName() + "</td>" +
                    "<td>" + empModel2.getAge() + "</td>" +
                    "<td>" + empModel2.getWorkPlace() + "</td>" +
                    "<td>" + empModel2.getDailyIncome() + "</td>" +
                    "</tr>");
        }
        out.println("</table>");
    }

    public void destroy() {   }
}
