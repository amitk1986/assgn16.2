package com.diablo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.diablo.Entity.Employee;
import com.diablo.HibernateUtility.HibernateUtility;

public class EmployeeDapImpl {
SessionFactory sf = HibernateUtility.getSessionFactory();
Session session;

 public void updateEmployee(Integer eid, String ename){
	 session = sf.openSession();
	 session.beginTransaction();
	 Query query = session.createQuery("update Employee set name = :name" +
				" where id = :id");
	 query.setParameter("name", ename);
	 query.setParameter("id", eid);
	 int result = query.executeUpdate();
	 session.getTransaction().commit();
	 session.close();
	 System.out.println("Sucessefully inserted");
 }
 public Integer deleteEmployee(Integer eid){
	 session = sf.openSession();
	 session.beginTransaction();
	 Query query = session.createQuery("delete Employee where id = :id");
	 
	 query.setParameter("id", eid);
	 int result = query.executeUpdate();
	 session.getTransaction().commit();
	 session.close();
	 System.out.println("Sucessefully deleted");
	 return result;
 }
 public Integer insertEmployee(){
	 session = sf.openSession();
	 session.beginTransaction();
	 Query query = session.createQuery("insert into Employee(id,name)" +
             "select id, name from EmployeeBaccup");
	 
	 
	 int result = query.executeUpdate();
	 session.getTransaction().commit();
	 session.close();
	 System.out.println("Sucessefully inserted");
	 return result;
 }
 public void listEmployee(){
	 session = sf.openSession();
	 session.beginTransaction();
	 List<Employee> l = session.createQuery("from Employee").list();
	 for(Employee e: l){
		 System.out.println("Id is "+e.getId());
		 System.out.println("Name is "+e.getName());
	 }
	 session.getTransaction().commit();
	 session.close();
	 
	 
 }
}
