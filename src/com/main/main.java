package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.IOException;

import com.Dao.EmployeeDao;
import com.model.Employee;
import com.utildbconfig.hibernateutil;

public class main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException 
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		//hibernateutil.getSessionFactory().openSession();
   do {
	   System.out.println("menu");
	   System.out.println("1.Add Employee");
	   System.out.println("2.Fech Employee");
	   System.out.println("3.update Employee");
	   System.out.println("4.delete Employee");
	   System.out.println("5.EXIST");
	   System.out.println("Enter your Choice");
	   
	   try {
		switch(Integer.parseInt(br.readLine()))
		   {
		case 1:
			
			Employee emp= new Employee();
			EmployeeDao d1= new EmployeeDao();
			System.out.println("enter employee neme");
			emp.setEmployeeName(br.readLine());
			//System.out.println("enter the employeeId");
			//emp.setEmpid(br.read());
			System.out.println("enter the salary");
			emp.setSalary(Double.parseDouble(br.readLine()));
			System.out.println("enter the date of joining");
			emp.setDob(sdf.parse(br.readLine()));
			d1.insert(emp);
			System.out.println("information saved sucefully");
			break;
		case 2:
			EmployeeDao d2= new EmployeeDao();
			List<Employee> elist=d2.getAllRows();
            
			if(elist.size()==0)
            {
            	System.out.println("empty list");
            	
            }
            else
            {
            	System.out.printf(" %-15s %-15s %-15s %-15s %s\n","empid","EmployeeName","Dateofjoining","salary");
            	for(Employee ef:elist)
            	{
    System.out.printf(" %-15s %-15s %-15s %-15s %s\n" ,ef.getEmpid(),ef.getEmployeeName(),sdf.format(ef.getDob()),ef.getSalary());         		
            	}
            }
			break;
		case 3:
			EmployeeDao d3= new EmployeeDao();
			Employee c3=new Employee();
			System.out.println("select which record you wont change");
			int empid=(Integer.parseInt(br.readLine()));
			Employee emp1=d3.find(empid);
			if(emp1  ==null)
			{
				System.out.println("employee does not exit");
			}
			else
			{
				System.out.println("enter your salaray");
				emp1.setSalary(Double.parseDouble(br.readLine()));
				System.out.println("Enter your name");
				emp1.setEmployeeName(br.readLine());
				d3.update(emp1);
				System.out.println("employee details update sucessfully");
			}
			break;
		case 4:
			EmployeeDao d4= new EmployeeDao();
			System.out.println("select which record you wont  delete");
			int empid1=(Integer.parseInt(br.readLine()));
			Employee emp2=d4.find(empid1);
			if(emp2  ==null)
			{
				System.out.println("employee does not exit");
			}
			else
			{
			d4.delete(emp2);
			System.out.println("record delete sucessfully");
			}
			
			break;
		case 5:
			System.exit(0);
			break;
		default:
		System.out.println("Invalid choice..");
		
		
		   }
	} catch (NumberFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }while(true);
	   
	}

}
