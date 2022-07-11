package com.tcs.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tcs.beans.Student;
import com.tcs.beans.Test;


public class TestClient {
public static void main(String[] args) {
	// start the spring container : container instantiate & initialize the bean objects. 
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			
			System.out.println("*****************");
			/**
			 * Test t=(Test)context.getBean("test");
			 */
			//or
			Test t=context.getBean("test",Test.class);
			t.testWish();
			
			Student s=(Student)context.getBean("student");
			s.studentInfo();
}
}
