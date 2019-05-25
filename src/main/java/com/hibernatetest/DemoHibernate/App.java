package com.hibernatetest.DemoHibernate;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 * @author DIPU
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        Configuration conf= new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class); 
        
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        
        SessionFactory sf= conf.buildSessionFactory(reg); 
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();
      
        Random rand= new Random();
        
        for(int i=1;i<=50;i++)
        {
        	Student stuent= new Student();
        	stuent.setRollno(i);
        	stuent.setName("name "+ i); 
        	stuent.setMarks(rand.nextInt(100)); 
        	
        	session.save(stuent); 
        }
        
        
        session.getTransaction().commit();
        System.out.println();  
    }
}
