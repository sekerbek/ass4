package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.SpecialtyRepository;
import com.company.repositories.interfaces.IEmployeeRepository;
import com.company.repositories.interfaces.ISpecialtyRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IDB db = new PostgresDB();
        IEmployeeRepository repoEmp = new EmployeeRepository(db);
        ISpecialtyRepository repoSpec = new SpecialtyRepository(db);
        EmployeeApp appEmp = new EmployeeApp(repoEmp, repoSpec);
        SpecialtyApp appSpec = new SpecialtyApp(repoEmp, repoSpec);


        System.out.println("Hello, this is IT hierarcy  to company");
        System.out.println("1. Specialty");
        System.out.println("2. Employee");
        System.out.print("Enter option (1-2): ");
        int option = scanner.nextInt();
        if (option == 1) {
            appSpec.start();
        } else if (option == 2) {
            appEmp.start();
        }
    }
}

//        String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            // Here we load the driver’s class file into memory at the runtime
//            Class.forName("org.postgresql.Driver");
//
//            // Establish the connection
//            con = DriverManager.getConnection(connectionUrl, "postgres", "0000");
//
//            // The object of statement is responsible to execute queries with the database
//            stmt = con.createStatement();
//
//            // The executeQuery() method of Statement interface is used to execute queries
//            // to the database. This method returns the object of ResultSet that can be
//            // used to get all the records of a table that matches the sql statement
//            rs = stmt.executeQuery("select * mistake from users");
//
//            while (rs.next()) // Processing the result
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            try { // Close connection - clean up the system resources
//                rs.close();
//                stmt.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code

//        app.start();
//        app2.start();


