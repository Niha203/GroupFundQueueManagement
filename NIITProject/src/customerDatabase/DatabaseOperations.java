/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerDatabase;

import java.sql.*;
import java.util.Scanner;

/**

 @author Arko
 */
public final class DatabaseOperations
{
    // Variable declaration.
    String url = "jdbc:derby://localhost:1527/NIITProject";
    String userName = "GroupFund";
    String password = "123456789";
    
    // Object declaration.
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    Scanner input;
    
    /**
    Used to initialize objects.
    */
    public DatabaseOperations()
    {
        input=new Scanner(System.in);
        connect();
    }
    /**
    Establishes a connection between the database and the user.
    */
    public final void connect()
    {
        try
        {
            // Connecting to database.
            connection=DriverManager.getConnection(url, userName, password);
            // On connection -> preparing the statement to execute queries.
            statement = connection.createStatement();
        }
        catch (SQLException ex)
        {
            System.out.println("Exception: "+ex.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
    }
    
    /**
    Method to get the account details of the customer based on the account number.
    */
    int getCash(long accountNumber)
    {
        int balance = 0;
        
        
        try
        {
            // Construct the query.
            String searchQuery = "SELECT * FROM GROUPFUND.CUSTOMER WHERE ACCOUNTNUMBER=" +accountNumber; 
            // Execute the query and store the output in a result set.
            resultSet = statement.executeQuery(searchQuery);
            balance = resultSet.getInt(3);
        }
        catch (SQLException ex)
        {
            System.out.println("Exception: "+ex.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        return balance;
    }
    
    
    String getName(long accountNumber)
    {
        String name = null;
        
        try
        {
            // Construct the query.
            String searchQuery = "SELECT * FROM GROUPFUND.CUSTOMER WHERE ACCOUNTNUMBER=" +accountNumber; 
            // Execute the query.
            resultSet = statement.executeQuery(searchQuery);
            // Store the result.
            name = resultSet.getString(2);
        }
        catch(SQLException e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        
        return name;
    }
}
