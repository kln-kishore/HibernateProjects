package com.kln.Info;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kln.domain.ApplicantInfo;

public class Test_LOAD_method {

	public static void main(String[] args) {

		Configuration cfg = null;
		cfg =	new Configuration().configure("/com/kln/cfgs/hibernate.cfg.xml"); //Activates Hibernate Framework & read configuration file
		SessionFactory factory =  null;
		factory= cfg.buildSessionFactory(); // create a session factory object
		Session ses = null;
		ses = factory.openSession();//getting a session object
		
		
		ApplicantInfo ai = ses.load(ApplicantInfo.class, 1001);
		
		
		if(ai!=null)
		{
			System.out.println("Applicant Id::::"+ai.getAppId());
			System.out.println("Applicant Name::::"+ai.getAppName());
			System.out.println("Applicant PANCARD Number ::::::::"+ai.getAppPanNo());
			
			System.out.println("::::::::Employee Details Retrived Successfully::::::::::::");
		}
			else
				System.out.println("::::::::Record is not found ::::::::::::");
		
		
		ses.close();
		factory.close();
		
		
		
	}

}
