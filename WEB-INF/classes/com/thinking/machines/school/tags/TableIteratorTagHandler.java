package com.thinking.machines.school.tags;
import com.thinking.machines.school.beans.*;
import com.thinking.machines.school.dao.*;
import java.sql.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class TableIteratorTagHandler extends BodyTagSupport
{
private String table;
private String name;
private String orderBy;
private Connection connection;
private Statement statement;
private ResultSet resultSet;
private int index;
public TableIteratorTagHandler()
{
reset();
}
public void reset()
{
this.table=" ";
this.name=" ";
this.orderBy=" ";
this.connection = null;
this.statement=null;
this.resultSet=null;
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
public String name()
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
if(this.table.equalsIgnoreCase(" ")==true)return SKIP_BODY;
String sql=" ";
if(this.table.equalsIgnoreCase("City"))
{
sql="select * from city";
if(this.orderBy!=null && this.orderBy.trim().length()>0)
{
 sql= "select * from city" +" order by "+this.orderBy.toLowerCase().trim();
}
this.statement=connection.createStatement();
resultSet=statement.executeQuery(sql);
if(resultSet.next()==false)return SKIP_BODY;
setupData();
return EVAL_BODY_INCLUDE;
}
}catch(Exception e){
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

}catch(Exception e)
{
System.out.println(e);

}

return EVAL_PAGE;
}

public void setupData()
{
try
{
pageContext.setAttribute("index",index,PageContext.REQUEST_SCOPE);
CityBeans city=new CityBeans();
city.setCode(resultSet.getInt("code"));
city.setName(resultSet.getString("name").trim());
pageContext.setAttribute(name,city,PageContext.REQUEST_SCOPE);

}catch(Exception e)
{
System.out.println(e);
}

}

}