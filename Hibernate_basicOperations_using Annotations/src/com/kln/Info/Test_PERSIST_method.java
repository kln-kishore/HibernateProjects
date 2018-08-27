package com.kln.Info;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kln.domain.ApplicantInfo;

public class Test_PERSIST_method {

	public static void main(String[] args) {

		Configuration cfg = null;
		cfg =	new Configuration().configure("com/kln/cfgs/hibernate.cfg.xml"); //Activate Hibernate Framework & read configuration file
		SessionFactory factory =  null;
		factory= cfg.buildSessionFactory(); // create a session factory object
		Session ses = null;
		ses = factory.openSession();//getting a session object
		

		ApplicantInfo ed = new ApplicantInfo();
		ed.setAppId(1002);
		ed.setAppName("Suman");
		ed.setAppAddress("GNT, AP");
		ed.setAppPanNo("AXBCY6040N"); //creating domain class object wit data
		
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();
			ses.persist(ed);
			/*
			 * ses.persist() method gives instruction to hibernate to save the object 
			 * and it DOES NOT return the identity values back to java application
			 * i.e. return type of persist() method is "void"
			 */
			tx.commit();
			System.out.println("::::::::Record Inserted Successfully::::::::::::");
			}
		catch(Exception e) {tx.rollback();}
		ses.close();
		factory.close();
		
		
		
		
		
	}

}
