/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
/**
 *
 * @author User
 */
public class Driver 
{
    public static void main (String[] args)
    {
        try
        {
            Connection myConn = DriverManager.getConnection("jdbc:mysqpl://localhost:3310/demo","SPAManager", "spa12345");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
