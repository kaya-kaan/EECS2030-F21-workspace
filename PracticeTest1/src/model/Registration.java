package model;

public class Registration {

	String name = "";
	int credits;
	int mark;

	public Registration(String name, int credits, int mark){
		this.name = name;
		this.credits = credits;
		this.mark = mark;
	}

	public Registration(String name, int credits) {
		this.name = name;
		this.credits = credits;
		this.mark = 0;
	}

	public String getCourseName() {
		return this.name;
	}

	public int getNumberOfCredits() {
		return this.credits;
	}

	public int getMarks() {
		return this.mark;
	}

	public String getLetterGrade() {
		if(this.mark >= 90) {
			return "A+";
		}else if (this.mark >= 80) {
			return "A";
		}else if (this.mark >= 70) {
			return "B";	
		}else if (this.mark >= 60) {
			return "C";	
		}else if (this.mark >= 50) {
			return "D";	
		}else {			
			return "F";
		}
		
	}
	
	public int getWeightedGradePoint() {
		if(this.getLetterGrade() == "A+") {
			return 9 * this.credits;
		}else if (this.getLetterGrade() == "A") {
			return 8 * this.credits;
		}else if (this.getLetterGrade() == "B") {
			return 7 * this.credits;	
		}else if (this.getLetterGrade() == "C") {
			return 6 * this.credits;	
		}else if (this.getLetterGrade() == "D") {
			return 5 * this.credits;	
		}else {			
			return 0 * this.credits;
		}
	}

	public void setMarks(int mark) {
		this.mark = mark;
	}


}
