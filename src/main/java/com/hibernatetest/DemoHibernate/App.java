package com.hibernatetest.DemoHibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
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
      
        //save objects:
      /*  Random rand= new Random();
        
        for(int i=1;i<=50;i++)
        {
        	Student stuent= new Student();
        	stuent.setRollno(i);
        	stuent.setName("name "+ i); 
        	stuent.setMarks(rand.nextInt(100)); 
        	
        	session.save(stuent); 
        }*/
        
        //now fetch list of objects:
        Query query= session.createQuery("from Student");
        List<Student>list= query.list(); 
        
        for(Student student: list)
        {
        	System.out.println(student); 
        }
        
        //Query with conditions: where clause
        Query query2= session.createQuery("from Student where marks>=50");
        List<Student> list2= query2.list();
        for(Student student: list2)
        {
        	System.out.println(student); 
        }
        
        //Query for single, specific row:
        Query query3= session.createQuery("from Student where rollno=7");
        Student student= (Student)query3.uniqueResult();
        System.out.println(student); 
        
        session.getTransaction().commit();
        System.out.println();  
    }
}
