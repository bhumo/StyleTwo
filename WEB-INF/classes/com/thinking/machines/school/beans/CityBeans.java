package com.thinking.machines.school.beans;

public class CityBeans implements java.io.Serializable
{
private int code;
private String name;
public CityBeans()
{
this.code=0;
this.name=" ";
}
public void setCode(int code)
{
this.code=code;
}
public void setName(String name)
{
this.name=name;
}
public int getCode()
{
return this.code;
}
public String getName()
{
return this.name;
}
}