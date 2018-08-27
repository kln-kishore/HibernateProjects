package com.kln.Info;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kln.domain.ApplicantInfo;

public class Test_SAVE_method {

	public static void main(String[] args) {

		Configuration cfg = null;
		cfg =	new Configuration().configure("/com/kln/cfgs/hibernate.cfg.xml"); //Activate Hibernate Framework & read configuration file
		SessionFactory factory =  null;
		factory= cfg.buildSessionFactory(); // create a session factory object
		Session ses = null;
		ses = factory.openSession();//getting a session object
		
		
		ApplicantInfo ed = new ApplicantInfo();
		ed.setAppId(1000);
		ed.setAppName("Naga Kishore");
		ed.setAppAddress("HYD, TS");
		ed.setAppPanNo("CPXPK6039M");//creating domain class object wit data
		
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();
			ses.save(ed); 
			/*		 prototype::   public serializable save(Object obj);
			 * ses.save() method gives instruction to hibernate to save the object 
			 * and also returns the generated identity values back to java application
			 * i.e. return type of persist() method is "serializable" interface
			 */
			tx.commit();
			System.out.println("::::::::Record Inserted Successfully::::::::::::");
			}
		catch(Exception e) {tx.rollback();}
		ses.close(); 
		/*ses.close() method close the hibernate session object by releasing and cleaning up the JDBC connection object
		* that is associated with Session object and also makes the domain class object as detached object from session
		* i.e. it stops representing the DataBase table record 
		*/
		factory.close();
		/*factory.close() method close the hibernate SessionFactory object by releasing the JDBC connection pool
		* that is representing by SessionFactory object
		* It is recommended to close all the session objects before closing SessionFactory object 
		*/
		
		
		
		
	}

}
