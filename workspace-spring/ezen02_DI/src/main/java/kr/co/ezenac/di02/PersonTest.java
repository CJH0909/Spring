package kr.co.ezenac.di02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	public static void main(String[] args) {
		// 실행시 person.xml을 불러와 bean을 생성
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		//id가 personService인 빈
		PersonService personService = (PersonService)factory.getBean("personService");
		//자바 코드에서 객체 직접 생성
		//PersonService personService = new PersonServiceImpl();
		
		//생성된 빈을 이용해 name값 출력
		personService.SayHello();
	}
}
