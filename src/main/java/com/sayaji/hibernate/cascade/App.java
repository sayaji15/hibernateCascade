package com.sayaji.hibernate.cascade;

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
        acct.setAccountNumber("111-222-33");
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(acct);
        session.getTransaction().commit();
    }
}
