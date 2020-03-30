package com.thinking.machines.school.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.school.dao.*;
import com.thinking.machines.school.beans.*;
import java.sql.*;
import java.io.*;

public class DeleteStudent extends HttpServlet
{

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
Connection c =null;
Statement s =null;
ResultSet rs =null;
try
{
StudentBean sb = (StudentBean)request.getAttribute("studentBean");
int rl = sb.getRoll_number();
c = DAOConnection.getConnection();
s =c.createStatement();
String sql = "select * from studentView where roll_number="+rl;
rs = s.executeQuery(sql);
String responseString="";
int isDeleted=-1;
if(rs.next()) 
{
isDeleted=s.executeUpdate("delete from student where roll_number="+rl);
}
else
{
responseString="roll number doesn't exsists";
}

responseString="roll number"+rl+"successfully deleted";

MessageBean mBean =new MessageBean();
mBean.setMessage(responseString);
request.setAttribute("messageBean",mBean);
RequestDispatcher rqd;
rqd=request.getRequestDispatcher("/Students.jsp");
rqd.forward(request,response);

rs.close();
s.close();
c.close();
}catch(Exception e)
{
System.out.println(e);
}

}
}