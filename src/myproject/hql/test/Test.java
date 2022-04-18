package myproject.hql.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import myproject.hql.entity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/myproject/hql/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = cfg.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from Employee");
			/*List<Employee> emps = query.list();
			System.out.println("Using list() method");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------------------");
			for(Employee emp : emps) {
				System.out.println(emp.getEno()+" \t "+emp.getEname()+" \t "+ emp.getEsal()+ " \t "+emp.getEaddr());
			}
			*/
			/*Iterator<Employee> itr = query.iterate();
			System.out.println("Using iterate() method");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------------------");
			while(itr.hasNext()) {
				Employee emp = itr.next();
				System.out.println(emp.getEno()+" \t "+emp.getEname()+" \t "+ emp.getEsal()+ " \t "+emp.getEaddr());
			}*/
			/*
			ScrollableResults results = query.scroll();
			System.out.println("Using scroll() method");
			System.out.println("Employee Details in Forward Direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------------------");
			while(results.next()) {
				Object[] obj = results.get();
				for(Object o : obj) {
					Employee emp = (Employee)o;
					System.out.print(emp.getEno()+"\t");
					System.out.print(emp.getEname()+"\t");
					System.out.print(emp.getEsal()+"\t");
					System.out.println(emp.getEaddr());
				}
			}
			
			System.out.println("Using scroll() method");
			System.out.println("Employee Details in Backward Direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------------------");
			while(results.previous()) {
				Object[] obj = results.get();
				for(Object o : obj) {
					Employee emp = (Employee)o;
					System.out.print(emp.getEno()+"\t");
					System.out.print(emp.getEname()+"\t");
					System.out.print(emp.getEsal()+"\t");
					System.out.println(emp.getEaddr());
				}
			}*/
			System.out.println("Using uniqueResult() method");
			System.out.println("Employee Details");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------------------");
			Employee emp = (Employee)query.uniqueResult();
			System.out.print(emp.getEno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getEsal()+"\t");
			System.out.println(emp.getEaddr());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
