package model;

public class RegistrationSystem {
	Transcript[] transcripts = new Transcript[500];
	int transcriptNumber = 0;
	
	public Transcript[] getReport() {
		Transcript[] report;
		
		int counter = 0;
		
		for (int i = 0; i < this.transcripts.length; i++) {
			if (this.transcripts[i] != null) {
				counter++;
			}
		}
		
		report = new Transcript[counter];
		counter = 0;
		for (int i = 0; i < this.transcripts.length; i++) {
			if (this.transcripts[i] != null) {
				report[counter] = this.transcripts[i];
				counter++;
			}
		}
		
		return report;
	}
	
	public void addTranscript(Transcript transcript) {
		this.transcripts[this.transcriptNumber] = transcript;
		this.transcriptNumber++;
	}
	
	public int getMarks(String stuName, String courseName) {
		int mark = -1;
		for (int i = 0; i < this.transcripts.length; i++) {
			if (this.transcripts[i] != null && this.transcripts[i].getStudentName() == stuName) {
				mark = this.transcripts[i].getMarks(courseName);
			}
		}
		
		return mark;
	}
	
}
