package com.sayaji.hibernate.cascade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	
	@Id
	@Column(name = "ACCOUNT_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column(name = "ACCOUNT_NUM", nullable = false, unique = true, length = 100)
	private String accountNumber;
	
	@OneToOne(mappedBy = "accounts", fetch = FetchType.LAZY)
	private Employee employee;

	public Account(){}
	
	public Account(String accountNumber, Employee employee)
	{
		this.accountNumber = accountNumber;
		this.employee = employee;
	}

	public int getAccountId()
	{
		return accountId;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	@Override
	public String toString()
	{
		return "Account [accountId=" + accountId + ", accountNumber="
				+ accountNumber + ", employee=" + employee + "]";
	}

}
