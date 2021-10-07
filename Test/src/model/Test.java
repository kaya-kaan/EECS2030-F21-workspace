package model;

public class Test {

	public static void main(String[] args) {
		
		Person p0 = new Person("Suyeon");
		Person p1 = new Person("Yuna");
		Person p2 = new Person("Sunhye");
		Person p3 = new Person("Jihye");
		
		p3 = p0;
		p1 = p2;
		
		Person[] persons = {p3, p0, p1, p2};
		p3 = persons[0];
		persons[1] = p2;
		System.out.println("Done!");
		
	}
	


}
