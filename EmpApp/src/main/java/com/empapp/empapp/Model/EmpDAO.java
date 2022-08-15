package com.empapp.empapp.Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    static final EmpModel empModel = new EmpModel();
    static PreparedStatement pstmt;
    static Connection con;
    int next =0;

    //connection method
    public static Connection getCon(){
        try {
            //driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection url
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Grad05/28");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    //get all employees
    public static List<EmpModel> allEmp() {

        List<EmpModel> list = new ArrayList<>();
        try {
            pstmt = EmpDAO.getCon().prepareStatement("SELECT * FROM emp.employee");
            ResultSet result = pstmt.executeQuery();
            //moves through table rows
            while (result.next()) {
                list.add(new EmpModel(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4),
                        result.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get an employee by id
    public static EmpModel searchEmp(int id) {
        try {
            //select all employee using id
            pstmt = EmpDAO.getCon().prepareStatement("SELECT * FROM " +
                    "emp.employee WHERE Id = ?");
            //set parameter index 1=id column
            pstmt.setInt(1, id);
            //print on web
            ResultSet result = pstmt.executeQuery();
            //moves throw table rows
            while (result.next()){
                //prints id and name based on employee id
                empModel.setId(result.getInt(1));
                empModel.setName(result.getString(2));
                empModel.setAge(result.getInt(3));
                empModel.setWorkPlace(result.getString(4));
                empModel.setDailyIncome(result.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empModel;
    }

    //delete an employee by id
    public static int delEmp(int id) throws SQLException {
        try {
            //select all employee using id
            pstmt = EmpDAO.getCon().prepareStatement("DELETE FROM " +
                    "emp.employee2 WHERE Id = ?");
            //set parameter index 1=id column
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pstmt.executeUpdate();
    }

    //insert an employee
    public static EmpModel insertEmp(){
        int ins = 0;
        try {
            pstmt = EmpDAO.getCon().prepareStatement("INSERT INTO " +
                    "emp.employee2 (Id, Name, Age, Work_Place, Daily_Income)\n" +
                    "VALUES (?, ?, ?, ?, ?)");
            //implementing method for setting values
            int Id = empModel.getId();
            String Name = empModel.getName();
            int Age = empModel.getAge();
            String WorkPlace = empModel.getWorkPlace();
            int DailyIncome = empModel.getDailyIncome();

            pstmt.setInt(1, Id);
            pstmt.setString(2, Name);
            pstmt.setInt(3, Age);
            pstmt.setString(4, WorkPlace);
            pstmt.setInt(5, DailyIncome);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empModel;
    }

    //update an employee
    public static int upEmp(EmpModel empModel){
        int up = 0;
        try {
            pstmt = EmpDAO.getCon().prepareStatement("UPDATE emp.employee2 " +
                    "SET Id=?, Name=?, Age=?, Work_Place=?, Daily_Income=? WHERE Id=?");
            //implementing method for setting values
            pstmt.setInt(1, empModel.getId());
            pstmt.setString(2, empModel.getName());
            pstmt.setInt(3, empModel.getAge());
            pstmt.setString(4, empModel.getWorkPlace());
            pstmt.setInt(5, empModel.getDailyIncome());
            up = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return up;
    }

    //method to setvalues
//    public static int setEmp(EmpModel empModel) throws SQLException {
//       try {
//           pstmt.setInt(1, empModel.getId());
//           pstmt.setString(2, empModel.getName());
//           pstmt.setInt(3, empModel.getAge());
//           pstmt.setString(4, empModel.getWorkPlace());
//           pstmt.setInt(5, empModel.getDailyIncome());
//           pstmt.executeUpdate();
//       } catch (SQLException e) {
//           e.printStackTrace();
//       }
//       return pstmt.executeUpdate();
//    }
}

