package kr.co.ezenac.di05;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;


public class SpringDiTest02 {

	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("config2.xml");
		
		Car car = (Car) ac.getBean("car");	//by name
		Car car2 = ac.getBean("car", Car.class);	//by name				
		Car car3 = ac.getBean(Car.class);		//by Type
		Engine engine = (Engine)ac.getBean("engine");
		Door door = (Door)ac.getBean("door");
		System.out.println("car= " + car);
		System.out.println("car2= " + car2);
		System.out.println("car3= " + car3);
		System.out.println("engine= " + engine);
		System.out.println("door= " + door);
		
		car.setColor("blue");
		car.setOil(200);
		car.setEngine(engine);
		car.setDoors(new Door[] {ac.getBean("door",Door.class),(Door)ac.getBean("door")});
		System.out.println("car= " + car);

	}

}
















