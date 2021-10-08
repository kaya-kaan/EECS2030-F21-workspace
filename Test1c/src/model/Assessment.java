package model;

public class Assessment {
	String name;
	double weight;
	int mark;
	
	String statusMessage = "";

	public Assessment(String name, double weight) {
		this.name = name;
		this.weight = weight;
		this.mark = 0;
		
		this.statusMessage = "Assessment created: " + this.name + " accounts for "
				+ String.format("%.3f",  100 * this.weight) + " percents of the course.";
	}
	
	public void setMarks(int mark) {	
		this.statusMessage = "Marks of assessment " + this.name + " (accounting for " + String.format("%.3f",  100 * this.weight) +
				" percents of the course) is changed from " + this.mark + " to " + mark + ".";
		
		this.mark = mark;
	}
	
	public void setWeight(double weight) {
		this.statusMessage = "Weight of assessment " + this.name + " (with marks " + this.mark + ") is changed from " + 
		 String.format("%.3f",  100 * this.weight) + " percents to " + String.format("%.3f",  100 * weight) + " percents.";
		
		this.weight = weight;
	}
	
	public String toString() {
		return this.statusMessage;
	}
}
