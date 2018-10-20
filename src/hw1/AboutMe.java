package hw1;

public class AboutMe {
	
	//init fields
	String name;
	String school;
	int age;
	
	//Constructor
	public AboutMe(String name,String school, int age){
		this.name = name;
		this.school = school;
		this.age = age;
	}
	
	//Methods
	public String myName() {
		return name;
	}
	
	public String mySchool() {
		return school;
	}
	
	public int myAge() {
		return age;
	}
	
	public static void main(String[] args) {
		AboutMe me = new AboutMe("Phil", "Purdue University", 36);
		
		System.out.println("My name is "+ me.myName() + 
				",and I attend "+ me.mySchool() + 
				". I am "+ me.myAge() + " years old");
		
	}

}
