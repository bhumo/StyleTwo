package com.thinking.machines.common;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;	

public class  EqualsTagHandler extends TagSupport
{

private String name;
private String value;

public EqualsTagHandler()
{
reset();
}

private void reset()
{
this.name="";
this.value="";

}
public void setName(String name)
{

this.name=name;
}

public String getName()
{
return this.name;
}

public void setValue(String val)
{
this.value=val;
}

public String getValue()
{
return this.value;
}


public int doStartTag()
{
String bagData=null;
try{
bagData=(String)pageContext.getAttribute(name,PageContext.REQUEST_SCOPE);
if(bagData==null)
{
bagData=(String)pageContext.getAttribute(name,PageContext.SESSION_SCOPE);
}
if(bagData==null)
{
bagData=(String)pageContext.getAttribute(name,PageContext.APPLICATION_SCOPE);
}
if(bagData==null) return SKIP_BODY;
if(bagData.equals(value))return EVAL_BODY_INCLUDE;

}catch(Exception e)
{
System.out.println(e); //only for testing
}
return SKIP_BODY;

}

public int doEndTag()
{
try
{

reset();
}catch(Exception e)
{
System.out.println(e);

}
return EVAL_PAGE;
}

}