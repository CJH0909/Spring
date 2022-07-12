package kr.co.ezenac.di02;

public class PersonServiceImpl implements PersonService {
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	// person.xml에서 인자가 한개인 생성자 설정시 사용
	public PersonServiceImpl(String name) {
		//super();
		this.name = name;
	}
	
	// person.xml에서 인자가 두개인 생성자 설정시 사용
	public PersonServiceImpl(String name, int age) {
		//super();
		this.name = name;
		this.age = age;
	}


	@Override
	public void sayHello() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}

}
