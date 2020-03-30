package com.thinking.machines.school.servlets;
import com.thinking.machines.school.dao.*;
import com.thinking.machines.school.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.sql.*;

public class AddStudent extends HttpServlet
{

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
Connection c=null;
Statement s=null;
ResultSet rs=null;
try
{
c= DAOConnection.getConnection();
s=c.createStatement();
StudentBean sb=(StudentBean)request.getAttribute("studentBean");
if(sb==null)System.out.println("no studentbean");

int rollNumber = sb.getRoll_number();
String name = sb.getName();
String address = sb.getAddress();
String cityName=sb.getCity_name();
int cityCode=sb.getCity_code();
String gender=sb.getGender();
boolean indian=sb.getIndian();

//here we will get the date from the bean in the string format
//parse the string as per as the format
//since the parse method will return Date of java.util.Date format
//therfore we will create a new object of type java.sql.Date by passing the time of java.util.Date()
//finally create the String dob by calling the method of toString() of java.sql.Date object

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
java.util.Date date1=dateFormat.parse(sb.getDate_of_birth());
java.sql.Date date2=new java.sql.Date(date1.getTime());
String dob=date2.toString();
String sqlString="";

sqlString=new String("insert into student(roll_number,name,address,city_code,gender,indian,date_of_birth)"+ "VALUES("+rollNumber+",'"+name+"','"+address+"',"+cityCode+",'"+gender+"',"+indian+",'"+dob+"')");
int i=-1;

i=s.executeUpdate(sqlString);

MessageBean mb=new MessageBean();
mb.setMessage("Successfully Added");
request.setAttribute("messageBean",mb);
request.setAttribute("scenario","added");
RequestDispatcher rqd=request.getRequestDispatcher("/Students.jsp");
rqd.forward(request,response);


}catch(Exception e)
{

System.out.println(e);
}


}


}