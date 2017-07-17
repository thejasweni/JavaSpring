package com.src.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.src.service.impl.ConfigurationClass;

public class ExecutionServiceImpl {
	private static ApplicationContext applicationContext ;
	static{
	applicationContext= new AnnotationConfigApplicationContext(ConfigurationClass.class);
		//applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	

	public static void main(String args[]) throws ClassNotFoundException{
		DBConnection dbConnection=(DBConnection) applicationContext.getBean("DBConnection");
		DBOperations dbOperationService=(DBOperations)applicationContext.getBean("DBOperations");
		dbOperationService.setbean(dbConnection);
		dbOperationService.createtable();
		dbOperationService.insertvalues();
		dbOperationService.selectvalues();
		 
	}
	
}
