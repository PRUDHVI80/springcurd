package com.utildbconfig;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class hibernateutil
{
public static SessionFactory sf=null;
static
{
	try
	{
		Configuration cf=new Configuration();
		cf.configure("hibernate.cfg.xml");
		sf=cf.buildSessionFactory();
	}catch(Exception e)
	{
		System.out.println(e);
	}
}
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}

}
