package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="employees")
public class Employee 
{
@Id
@Column(name="empid")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int empid;
@Column(name="EmployeeName" ,length=30)
private String EmployeeName;
@Column(name="salary")
private double salary;
@Column(name="Dateofjoining")
@Temporal(TemporalType.DATE)
private Date dob;


public Employee() {
	super();
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmployeeName() {
	return EmployeeName;
}
public void setEmployeeName(String employeeName) {
	EmployeeName = employeeName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
}
