package com.jsp.HibernateProject_OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
       Employee e1 = new Employee();
       e1.setEmployeeId(101);
       e1.setEmployeName("Aslam");
       e1.setEmployeeSalary(35000);
       
       Employee e2 = new Employee();
       e2.setEmployeeId(102);
       e2.setEmployeName("Singh");
       e2.setEmployeeSalary(30000);
       
       Company c = new Company();
       c.setCompanyId(1);
       c.setCompanyName("WIPRO");
       
       c.getEmployees().add(e1);
       c.getEmployees().add(e2);
       
       
       Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);
       SessionFactory sf = cfg.buildSessionFactory();
       Session see = sf.openSession();
       Transaction tr = see.beginTransaction();
       
       see.save(c);
       see.save(e1);
       see.save(e2);
       
       tr.commit();
       see.close();
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    }
}
