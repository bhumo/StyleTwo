package com.thinking.machines.school.dao;
import com.thinking.machines.school.dao.*;
import java.sql.*;
public class DAOConnection
{

public static Connection getConnection() throws DAOException
{
try
{
Class.forName("org.apache.derby.jdbc.ClientDriver");
Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/studentdb");
return c;
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
}



