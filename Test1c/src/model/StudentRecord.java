package model;

public class StudentRecord {
	String courseName;
	Assessment[] assessments = new Assessment[10];
	int assessmentNum = 0;

	public StudentRecord(String name) {
		this.courseName = name;
	}

	public String getCourse() {
		return this.courseName;
	}

	public String getAssessmentReport() {
		String report = "";

		report += "Number of assessments in " + this.courseName + ": " + this.assessmentNum + " [";

		boolean comma = false;
		for (int i = 0; i < this.assessments.length; i++) {
			if(this.assessments[i] != null) {
				if(comma) report += ", ";
				report += "" + this.assessments[i].name + " (weight: " + String.format("%.3f",  100 * this.assessments[i].weight) +
						" percents; marks: "+ this.assessments[i].mark + ")";
				comma = true;
			}
		}
		report += "]";
		return report;
	}

	public double getCompletionRate() {
		double completionSum = 0;

		for (int i = 0; i < this.assessments.length; i++) {
			if(this.assessments[i] != null) {
				completionSum += this.assessments[i].weight;
			}
		}

		return completionSum;
	}

	public double getRawMarks() {
		double rawMarks = 0;

		for (int i = 0; i < this.assessments.length; i++) {
			if(this.assessments[i] != null) {
				rawMarks += this.assessments[i].weight * this.assessments[i].mark;
			}
		}

		return rawMarks;
	}

	public void addAssessment(String name, double weight, int mark) {
		this.assessments[this.assessmentNum] = new Assessment(name, weight);
		this.assessments[this.assessmentNum].setMarks(mark);
		this.assessmentNum++;
	}

	public void addAssessment(Assessment assessment) {
		this.assessments[this.assessmentNum] = assessment;
		this.assessmentNum++;
	}

	public void changeMarksOf(String name, int mark) {
		for (int i = 0; i < this.assessments.length; i++) {
			if(this.assessments[i] != null && this.assessments[i].name == name) {
				this.assessments[i].setMarks(mark);
			}
		}
	}

	public void removeAssessment(String name) {
		boolean removed = false;
		for (int i = 0; i < this.assessments.length; i++) {
			if(this.assessments[i] != null && this.assessments[i].name == name) {
				this.assessments[i] = null;
				this.assessmentNum--;
				removed = true;
			}	
		}

		if(removed) {
			Assessment[] orderedAssessments = new Assessment[this.assessments.length];
			int counter = 0;

			for (int i = 0; i < this.assessments.length; i++) {
				if(this.assessments[i] != null) {
					orderedAssessments[counter] = this.assessments[i];
					counter++;
				}	
			}

			this.assessments = orderedAssessments;
		}
	}


}
