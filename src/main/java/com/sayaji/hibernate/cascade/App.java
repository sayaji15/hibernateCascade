package com.sayaji.hibernate.cascade;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.sayaji.hibernate.cascade.model.Account;
import com.sayaji.hibernate.cascade.model.Employee;

public class App 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory()
	{
		final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
    public static void main( String[] args )
    {
        Employee emp = new Employee();
        emp.setFirstName("Sayaji");
        emp.setLastName("Patil");
        
        Account acct = new Account();
        acct.setAccountNumber("111-222-333");
        acct.setEmployee(emp);
        
        Account acct1 = new Account();
        acct1.setAccountNumber("333-444-555");
        acct1.setEmployee(emp);
        
        Set<Account> accounts = new HashSet<Account>();
        accounts.add(acct);
        accounts.add(acct1);
        emp.setAccounts(accounts);
        
        System.out.println(emp);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
       
    }
}
