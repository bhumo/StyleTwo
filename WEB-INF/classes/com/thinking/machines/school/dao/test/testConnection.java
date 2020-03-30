import java.sql.*;
import ../DAOConnection;

class psp
{
public static void main (String gg[])
{
try
{
Connection c = DAOConnection.getConnection();
System.out.println();
}catch(Exception e)
{
System.out.println(e);
}
}
}