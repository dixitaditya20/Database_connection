import javax.swing.*;
import java.sql.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //create database connectivity

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("mysql Connection failed ");
            throw new RuntimeException(e);
        }

        /*
        // Adding connection with Database Schema Name
        // Be careful while adding the Schema and the password
         */
        Connection conn = null;
        try {
            conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Testing","root","1234");

            // create SQL Query
            String query = "Select * from Employee_details";

            /*
            // Opening the Connection
             */
            Statement st = conn.createStatement();
            /*
            Handling the Request
             */
            ResultSet rs = st.executeQuery(query);

            /*
            Displaying the data
             */
            while (rs.next()){
                String age = rs.getString("emp_age");
                String dept_id = rs.getString("emp_dept_id");
                String id = rs.getString("emp_id");
                String name = rs.getString("emp_name");

                System.out.format("%s, %s, %s, %s \n",age, dept_id, id, name);
            }

            /*
            Remember to close the connection
             */
            st.close();

        } catch (SQLException e) {
            System.out.println("Schema name is not correct");
            throw new RuntimeException(e);
        }

    }
}