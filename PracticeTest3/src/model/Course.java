package model;

public class Course {
	private String name;
	private double  tuition;
	
	public Course(String n, double t) {
		this.name = n;
		this.tuition = t;
	}
	
	public double getFee() {
		return this.tuition;
	}
}
