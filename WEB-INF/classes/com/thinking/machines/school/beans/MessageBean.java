package com.thinking.machines.school.beans;
import java.util.*;
import java.io.Serializable;
public class MessageBean implements Serializable
{
private String message;
public MessageBean()
{
message="" ;
}
public void setMessage(String msg)
{
this.message=msg;
}
public String getMessage()
{
return this.message;
}

}