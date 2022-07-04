package kr.co.ezenaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aoptest.xml");
		Calculator cal = (Calculator)context.getBean("proxyCal");
		cal.add(100, 20);
	}

}
