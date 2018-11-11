package com.sparta.sdg;

import java.sql.*;

public class EmployeeDAO {
    private final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String query = "SELECT e.FIRST_NAME, e.LAST_NAME AS Employee, e.SALARY FROM EMPLOYEES e WHERE e.SALARY > ?";
    private final String USER = "hr";
    private final String PASSWORD = "hr";
    public void getEmployee(String id) {
        try(Connection connection = DriverManager.getConnection (PATH,USER,PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()) {
                String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                String salary = resultSet.getString (3);
                System.out.println ("Name: " +firstName +" "+ lastName +" , Salary: "+salary);
            }

        }catch (SQLException e) {

        }
    }
}
