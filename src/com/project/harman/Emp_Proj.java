package com.project.harman;

import java.security.spec.ECField;
import java.sql.*;
import java.util.Scanner;

public class Emp_Proj
{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int option;
        while (true)
        {
            System.out.println("Enter any Option to Perform: ");

            System.out.println("1. Add an Employee: ");
            System.out.println("2. View all Employee: ");
            System.out.println("3. Delete an Employee: ");
            System.out.println("4. Search an Employee: ");
            System.out.println("5. Update an Employee: ");
            System.out.println("6. Exit: ");

            option = input.nextInt();

            switch (option)
            {
                case 1:

                    try
                    {


                        String emp_code, emp_name, emp_desig, emp_salary, emp_mob_no;


                        System.out.println("Enter the code: ");
                        emp_code = input.next();
                        System.out.println("Enter the name: ");
                        emp_name = input.next();
                        System.out.println("Enter the designation: ");
                        emp_desig = input.next();
                        System.out.println("Enter the salary: ");
                        emp_salary = input.next();
                        System.out.println("Enter the mobile no: ");
                        emp_mob_no = input.next();


                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");

                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employee`(`emp_code`, `emp_name`, `emp_desig`, `emp_salary`, `emp_mob_no`)" +
                                " VALUES("+emp_code+", '"+emp_name+"', '"+emp_desig+"', "+emp_salary+", "+emp_mob_no+")");

                        System.out.println("Inserted sucessfully");

                    }
                    catch (SQLException e)
                    {
                        System.out.println(e);
                    }


                    break;

                case 2:

                    System.out.println("View all the Employee Details: ");
                    try
                    {

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");

                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `emp_code`, `emp_name`, `emp_desig`, `emp_salary`, `emp_mob_no` FROM `employee` WHERE 1");


                        while (rs.next())
                        {

                            System.out.println("emp_code =" +rs.getInt("emp_code"));
                            System.out.println("emp_name =" +rs.getString("emp_name"));
                            System.out.println("emp_desig =" +rs.getString("emp_desig"));
                            System.out.println("emp_salary =" +rs.getInt("emp_salary"));
                            System.out.println("emp_mob_no =" +rs.getBigDecimal("emp_mob_no"));

                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;



                case 3:

                    try
                    {
                        int emp_code;
                        System.out.println("Enter the Employee Code to be Deleted: ");
                        emp_code = input.nextInt();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("DELETE FROM `employee` WHERE `emp_code`=" +emp_code);

                        System.out.println("The Details Deleted Successfully !!!");

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;



                case 4:

                    try
                    {
                        int emp_code;
                        System.out.println("Enter the Employee Code to be Searched: ");
                        emp_code = input.nextInt();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `employee` WHERE `emp_code`=" +emp_code);

                        while (rs.next())
                        {
                            System.out.println("emp_name =" +rs.getString("emp_name"));
                            System.out.println("emp_desig =" +rs.getString("emp_desig"));
                            System.out.println("emp_salary =" +rs.getInt("emp_salary"));
                            System.out.println("emp_mob_no =" +rs.getBigDecimal("emp_mob_no"));
                        }
                    }

                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;



                case 5:

                    try
                    {
                        int emp_code;
                        System.out.println("Enter the Employee Code to be Update the full Details: ");
                        emp_code = input.nextInt();

                        String emp_name, emp_desig, emp_salary, emp_mob_no;
                        System.out.println("Enter the name to be Updated: ");
                        emp_name = input.next();
                        System.out.println("Enter the designation to be Updated: ");
                        emp_desig = input.next();
                        System.out.println("Enter the salary to be Updated: ");
                        emp_salary = input.next();
                        System.out.println("Enter the mobile no to be Updated: ");
                        emp_mob_no = input.next();


                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("UPDATE `employee` SET `emp_name`='"+emp_name+"',`emp_desig`='"+emp_desig+"',`emp_salary`="+emp_salary+",`emp_mob_no`="+emp_mob_no+" WHERE `emp_code`="+emp_code);

                        System.out.println("Employee Details Updated Successfully !!!");

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;



                case 6:

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice !!! Re-enter the Choice !!!");

            }
        }
    }
}

