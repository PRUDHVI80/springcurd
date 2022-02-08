package com.Dao;

import java.util.List;

import org.hibernate.Session;

import com.model.Employee;
import com.utildbconfig.hibernateutil;
public class EmployeeDao {

	/**
	 * @param emp
	 */
	public void insert(Employee emp) {
		// TODO Auto-generated method stub
		
		Session session=hibernateutil.getSessionFactory().openSession();
		try
		{
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		}catch(Exception df)
		{
			session.getTransaction().rollback(); 
			System.out.println(df);
		}
		session.close();
	}

     public List<Employee> getAllRows()
     {
    	 Session session=hibernateutil.getSessionFactory().openSession();
    	 List<Employee> empList=session.createCriteria(Employee.class).list();
		return  empList;
    	 
     }
     public Employee find(int empid)
     {
    	 Session session=hibernateutil.getSessionFactory().openSession();
    	 Employee employee=(Employee)session.get(Employee.class, empid);
		return employee;
    	 
     }
     public void update(Employee emp1)
     {
    	 Session session=hibernateutil.getSessionFactory().openSession();
    	 try
 		{
 		session.beginTransaction();
 		session.update(emp1);
 		session.getTransaction().commit();
 		}catch(Exception df)
 		{
 			session.getTransaction().rollback(); 
 			System.out.println(df);
 		}
 		session.close();
     }
     
     
     public void delete(Employee emp2)
     {
    	 
    	 Session session=hibernateutil.getSessionFactory().openSession();
    	 try
 		{
 		session.beginTransaction();
 		session.delete(emp2);
 		session.getTransaction().commit();
 		}catch(Exception df)
 		{
 			session.getTransaction().rollback(); 
 			System.out.println(df);
 		}
 		session.close();
    	 
     }
}
