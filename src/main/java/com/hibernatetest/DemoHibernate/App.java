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
        
        Allien allien= new Allien();
       /* allien.setAid(103);
        allien.setName("testname33");
        allien.setColor("red"); */
        
        Configuration conf= new Configuration().configure().addAnnotatedClass(Allien.class);
        
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        
        SessionFactory sf= conf.buildSessionFactory(reg); 
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();
        allien= (Allien)session.get(Allien.class, 101);
        
      //  session.save(allien);
        tx.commit();
        System.out.println(allien); 
    }
}
