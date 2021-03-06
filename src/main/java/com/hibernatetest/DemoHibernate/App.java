package com.hibernatetest.DemoHibernate;

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
        
       Laptop laptop= new Laptop();
       laptop.setLid(101);
       laptop.setLname("HP");
       
       Laptop lp2= new Laptop();
       lp2.setLid(102);
       lp2.setLname("Dell");
       
       Laptop lp3= new Laptop();
       lp3.setLid(103);
       lp3.setLname("MAC");
       
       
       Student student= new Student();
       student.setName("Dipu");
       student.setRollno(1);
       student.setMarks(99); 
       student.getLaptop().add(laptop); 
       student.getLaptop().add(lp2);
       student.getLaptop().add(lp3);
       
       laptop.setStudent(student); 
       lp2.setStudent(student);
       lp3.setStudent(student);
       
       
        
        Configuration conf= new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class); 
        
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        
        SessionFactory sf= conf.buildSessionFactory(reg); 
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();
       
       // session.save(laptop);
        session.save(student);
        
      //  session.save(allien);
        session.getTransaction().commit();
        System.out.println();  
    }
}
