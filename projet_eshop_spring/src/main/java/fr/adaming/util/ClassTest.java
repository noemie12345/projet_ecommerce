package fr.adaming.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//R�cup�ration du contexte
		ApplicationContext cxt = new ClassPathXmlApplicationContext("application-context.xml");
		
	}

}
