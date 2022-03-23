package com.project.harman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Emp_Proj
{

    public static void main(String[] args)
    {

        try
        {
            Scanner input = new Scanner(System.in);

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

            Statement stat = c.createStatement();
            stat.executeUpdate("INSERT INTO `employee`(`emp_code`, `emp_name`, `emp_desig`, `emp_salary`, `emp_mob_no`)" +
                    " VALUES("+emp_code+", '"+emp_name+"', '"+emp_desig+"', "+emp_salary+", "+emp_mob_no+")");

            System.out.println("Inserted sucessfully");

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
