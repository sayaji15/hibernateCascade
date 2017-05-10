package com.sayaji.hibernate.cascade.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Column(name = "FIRST_NAME", nullable = false, unique = false, length = 100)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false, unique = false, length = 100)
	private String lastName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Set<Account> accounts;

	public Employee(){}
	
	public Employee(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getEmployeeId()
	{
		return employeeId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString() 
	{
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", accounts="
				+ accounts + "]";
	}
}
