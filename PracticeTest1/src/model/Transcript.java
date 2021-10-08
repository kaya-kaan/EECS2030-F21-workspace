package model;

public class Transcript {
	
	String name;
	Registration[] registrations = new Registration[60];
	int regNumber = 0;
	
	public Transcript(String name) {
		this.name = name;
	}
	
	public String getStudentName() {
		return this.name;
	}
	
	public Registration[] getReport() {
		Registration[] report;
		
		int counter = 0;
		
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i] != null) {
				counter++;
			}
		}
		
		report = new Registration[counter];
		counter = 0;
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i] != null) {
				report[counter] = this.registrations[i];
				counter++;
			}
		}
		
		return report;
	}
	
	public int getMarks(String name) {
		int mark = -1;
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i] != null && this.registrations[i].getCourseName() == name) {
				mark = this.registrations[i].getMarks();
			}
		}
		
		return mark;
	}
	
	public void setMarks(String name, int mark) {
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i] != null && this.registrations[i].getCourseName() == name) {
				this.registrations[i].setMarks(mark);
			}
		}
	}
	
	public void addRegistration(Registration reg) {
		this.registrations[this.regNumber] = reg;
		this.regNumber++;
	}
	
	public void addRegistration(String name, int credit) {
		this.registrations[this.regNumber] = new Registration(name, credit);
		this.regNumber++;
	}
	
	public void addRegistrations(Registration[] regs) {
		for (int i = 0; i < regs.length; i++) {
			this.registrations[this.regNumber] = regs[i];
			this.regNumber++;
		}
	}
	
	public double getWeightedGPA() {
		int sumOfMarks = 0;
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i] != null) {
				sumOfMarks += this.registrations[i].getWeightedGradePoint();
			}
		}
		
		return (double)sumOfMarks / (double)this.regNumber;
	}
}
