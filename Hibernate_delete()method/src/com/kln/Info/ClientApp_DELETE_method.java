package com.kln.Info;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kln.domain.EmployeeDetails;

public class ClientApp_DELETE_method {

	public static void main(String[] args) {

		Configuration cfg = null;
		cfg =	new Configuration().configure("/com/kln/cfgs/hibernate.cfg.xml"); //Activate Hibernate Framework & read configuration file
		SessionFactory factory =  null;
		factory= cfg.buildSessionFactory(); // create a session factory object
		Session ses = null;
		ses = factory.openSession();//getting a session object
		
		//------------------------		Approach - 1  ------------------------------------

/*		EmployeeDetails ed = new EmployeeDetails();
		ed.setEmpId(50002);
				
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();
			ses.delete(ed); 
			
			tx.commit();
			System.out.println("::::::::Record deleted Successfully::::::::::::");
			}
		catch(Exception e) {tx.rollback();}
*/
		//----------------------------------------------------------

		//------------------------		Approach - 2  ------------------------------------
		
		EmployeeDetails ed = ses.get(EmployeeDetails.class, 50002);
		if(ed!=null)
		{
			Transaction tx=null;
			try
			{
				tx=ses.beginTransaction();
				ses.delete(ed);
				tx.commit();
				System.out.println("::::::::Record deleted Successfully::::::::::::");
			}
			catch(Exception e) {tx.rollback();}
		}
		else
		{
			System.out.println("::::::::Record not found::::::::::::");
		}
		
		
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
