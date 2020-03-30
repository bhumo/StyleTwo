package com.thinking.machines.school.beans;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.io.Serializable;
public class StudentBean implements Serializable
{
private int roll_number ;
private String name;
private String address;
private int city_code;
private String gender;
private boolean indian;
private String date_of_birth;
private String city_name;
public StudentBean()
{
reset();
}

public void reset()
{
roll_number=0;
name=" ";
address=" ";
city_code=0;
gender=" ";
indian=false;
date_of_birth="0000-00-00";
city_name=" ";
}
public void setRoll_number(int roll_number)
{
this.roll_number=roll_number;
}

public int getRoll_number()
{
return this.roll_number;
}

public void setName(String name)
{
this.name=name;
}

public String getName()
{
return this.name;
}

public void setAddress(String address)
{
this.address= address;
}

public String getAddress()
{
return this.address;
}


public void setCity_code(int code)
{
 this.city_code=code;
}

public int getCity_code()
{
return this.city_code;
}

public void setGender(String gender)
{
this.gender=gender;
}

public String getGender()
{
return this.gender;

}



public void setIndian(boolean indian)
{
this.indian=indian;
}


public boolean getIndian()
{
return this.indian;
}

public void setDate_of_birth(String date_of_birth)
{
this.date_of_birth=date_of_birth;
}
public String getDate_of_birth()
{
return this.date_of_birth;
}


public void setCity_name(String name)
{
this.city_name=name;
}

public String getCity_name()
{
return this.city_name;
}

}