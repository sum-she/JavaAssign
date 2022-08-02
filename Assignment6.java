import java.sql.*;

public class Assignment6 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            //JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection to sql database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

            Statement stmt = con.createStatement();
            //using employeeinfo database
            stmt.execute("USE employeeinfo");

            // insert data using prepared statement
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO emp VALUES(?, ?, ?)");

            pstmt.setInt(1, 1); //1st parameter
            pstmt.setString(2, "Asch"); //2nd parameter
            pstmt.setInt(3, 27); //3rd parameter
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setString(2, "Pot");
            pstmt.setInt(3, 18);
            pstmt.executeUpdate();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Rawan");
            pstmt.setInt(3, 24);
            pstmt.executeUpdate();

            //insert data using callable statement that's using procedure insertInfo
            CallableStatement cstmt = con.prepareCall("{CALL insertInfo(?, ?, ?)}");

            cstmt.setInt(1, 4);
            cstmt.setString(2, "Love");
            cstmt.setInt(3, 27);
            cstmt.executeUpdate();

            cstmt.setInt(1, 5);
            cstmt.setString(2, "Hanaa");
            cstmt.setInt(3, 26);
            cstmt.executeUpdate();

            System.out.println("Employee List: ");
            //execute for ouput
            ResultSet result = pstmt.executeQuery("SELECT * FROM emp");
            //print table
            while (result.next()) {
                System.out.println(result.getInt(1) + "  " + result.getString(2) + "  " + result.getInt(3));
            }

            //update data
            PreparedStatement upStmt = con.prepareStatement("UPDATE emp set emp_name = ? WHERE id = ?");
            upStmt.setString(1, "Midori");
            upStmt.setInt(2, 3);
            upStmt.executeUpdate();

            System.out.println("Updated List: ");
            //execute for updated output
            ResultSet upList = upStmt.executeQuery("SELECT * FROM emp");
            //print table
            while (upList.next()) {
                System.out.println(upList.getInt(1) + "  " + upList.getString(2) + "  " + upList.getInt(3));
            }

            //delete a record
            PreparedStatement delStmt = con.prepareStatement("DELETE FROM emp WHERE id = ?");
            delStmt.setInt(1, 4);
            delStmt.executeUpdate();

            System.out.println("Deleted Record List: ");
            //execute for deleted output
            ResultSet delList = delStmt.executeQuery("SELECT * FROM emp");
            //print table
            while (delList.next()) {
                System.out.println(delList.getInt(1) + "  " + delList.getString(2) + "  " + delList.getInt(3));
            }

            //find record
            PreparedStatement findStmt = con.prepareStatement("SELECT * FROM emp WHERE id = ?");
            findStmt.setInt(1, 2);
            findStmt.execute();

            System.out.println("Employee record: ");
            //execute for record output
            ResultSet findEmp = findStmt.executeQuery("SELECT * FROM emp");
            System.out.println(findEmp.getInt("id") + "  " + findEmp.getString("emp_name") + "  " + findEmp.getInt(
                    "age"));


            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
