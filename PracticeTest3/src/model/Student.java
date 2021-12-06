package model;

public class Student {
	protected String name;

	protected Course[] courses;
	protected int numOfCourses;

	protected double rate;

	public Student() {
		this.courses = new Course[10];
		this.numOfCourses = 0;
		this.rate = 1;

	}

	public Course[] getCourses() {
		Course[] c;
		int count = 0;
		for(int i = 0 ; i < this.numOfCourses ; i++) {
			if(this.courses[i] != null) {
				count++;
			}
		}

		c = new Course[count];
		count = 0;
		for(int i = 0 ; i < this.numOfCourses ; i++) {
			if(this.courses[i] != null) {
				c[count] = this.courses[i];
				count++;
			}
		}

		return c;
	}

	public void register(Course c) {
		this.courses[this.numOfCourses] = c;
		this.numOfCourses++;
	}

	public void drop(Course c) {
		Course[] cs = new Course[this.courses.length];
		boolean dropped = false;

		for(int i = 0 ; i < this.numOfCourses ; i++) {
			if(this.courses[i].equals(c)) {
				this.courses[i] = null;
				dropped = true;
				break;
			}
		}

		if(dropped) {

			int count = 0;

			for(int i = 0 ; i < this.numOfCourses ; i++) {
				if(this.courses[i] != null) {
					cs[count] = this.courses[i];
					count++;
				}
			}

			this.courses = cs;
		}

	}

	public double getTuition() {
		double tui = 0;
		for(int i = 0 ; i < this.numOfCourses ; i++) {
			if(this.courses[i] != null) {
				tui += this.courses[i].getFee();
			}
		}

		return tui * this.rate;
	}
}
