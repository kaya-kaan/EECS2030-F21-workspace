package model;

public class StudentManagementSystem {
	
	private Student[] students;
	private int numOfStudents;
	
	public StudentManagementSystem() {
		this.students = new Student[5];
		this.numOfStudents = 0;
	}
	
	public Student[] getStudents() {
		Student[] s;
		int count = 0;
		for(int i = 0 ; i < this.numOfStudents ; i++) {
			if(this.students[i] != null) {
				count++;
			}
		}

		s = new Student[count];
		count = 0;
		for(int i = 0 ; i < this.numOfStudents ; i++) {
			if(this.students[i] != null) {
				s[count] = this.students[i];
				count++;
			}
		}

		return s;
	}
	
	public void addStudent(Student s) {
		this.students[this.numOfStudents] = s;
		this.numOfStudents++;
	}
	
	public void registerAll(Course c) {
		for(int i = 0 ; i < this.numOfStudents ; i++) {
			if(this.students[i] != null) {
				this.students[i].register(c);
			}
		}
	}

}
