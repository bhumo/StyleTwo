package com.thinking.machines.school.tags;
import com.thinking.machines.school.beans.*;
import com.thinking.machines.school.dao.*;
import java.sql.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;

public class StudentViewTagHandler extends BodyTagSupport
{
private String table;
private String name;
private String orderBy;
private Connection connection;
private Statement statement;
private ResultSet resultSet;
private int index;
public StudentViewTagHandler()
{
reset();
}
public void reset()
{
this.table=" ";
this.name=" ";
this.orderBy=" ";
this.index=0;
}
public void setTable(String table)
{
this.table=table;
}
public String getTable()
{
return this.table;
}

public String getName()
{
return this.name;
}
public String getOrderby()
{
return this.orderBy;
}
public void setName(String name)
{
this.name=name;
}
public void setorderBy(String orderBy)
{
this.orderBy=orderBy;
}

public int doStartTag()
{
try
{
connection=DAOConnection.getConnection();
if(connection==null)System.out.println("not connected");
if(this.table.equalsIgnoreCase(" ")==true)return SKIP_BODY;
String sql=" ";
if(this.table.equalsIgnoreCase("studentView"))
{
sql="select * from "+table.trim();
if(this.orderBy!=null && this.orderBy.trim().length()>0)
{
 sql= "select * from "+table.trim() +" order by "+this.orderBy.toLowerCase().trim();
}
this.statement=connection.createStatement();
resultSet=statement.executeQuery(sql);
if(resultSet.next()==false)return SKIP_BODY;
setupData();
return EVAL_BODY_INCLUDE;
}
}catch(Exception e){
System.out.println("Unable to connect");
System.out.println(e);
}//catch ends
return SKIP_BODY;
}//doStartTag() ends

public int doAfterBody()
{
try
{
if(resultSet.next()==false)return SKIP_BODY;
this.index++;
setupData();
}catch(Exception e)
{
System.out.println("doAfterBody");
System.out.println(e);
}
return EVAL_BODY_AGAIN;

}

public int doEndTag()
{
try
{
resultSet.close();
statement.close();
connection.close();
reset();
}catch(Exception e)
{
System.out.println("doEndTag");
System.out.println(e);

}

return EVAL_PAGE;
}

public void setupData()
{
try
{
pageContext.setAttribute("index",index,PageContext.REQUEST_SCOPE);
StudentBean studentBean=new StudentBean();
studentBean.setRoll_number(resultSet.getInt("roll_number"));
studentBean.setName(resultSet.getString("name").trim());
studentBean.setAddress(resultSet.getString("address").trim());
studentBean.setCity_code(resultSet.getInt("city_code"));
studentBean.setGender(resultSet.getString("gender").trim());
studentBean.setIndian(resultSet.getBoolean("indian"));
studentBean.setDate_of_birth(resultSet.getDate("date_of_birth").toString());
studentBean.setCity_name(resultSet.getString("city_name").trim());

pageContext.setAttribute(name,studentBean,PageContext.REQUEST_SCOPE);

}catch(Exception e)
{
System.out.println("setup");
System.out.println(e);
}

}

}