package model;

public class HealthRecord {
	String name;
	Vaccine[] doses;
	int numOfDosesDone = 0;
	String record = "";
	
	String appointmentStatus = "";
	int appointmentBooked = 0;
	
	public HealthRecord(String name, int limit) {
		this.name = name;
		this.doses = new Vaccine[limit];
	}
	
	public String getVaccinationReceipt() {
		if (this.numOfDosesDone == 0){
			return this.name + " has not yet received any doses.";
		}else {
			return "Number of doses " + this.name + " has received: " + this.numOfDosesDone + " [" + this.record + "]";
		}
	}
	
	public void addRecord(Vaccine vac, String place, String date) {
		this.doses[this.numOfDosesDone] = vac;
		if(this.numOfDosesDone != 0) {
			this.record += "; ";
		}
		this.record += this.doses[this.numOfDosesDone].toString() + " in " + place + " on " + date;
		this.numOfDosesDone++;
		//this.appointmentStatus = "Last vaccination appointment for " + this.name + " with " + place + " succeeded";
	}
	
	public String getAppointmentStatus() {
		if(this.appointmentBooked == 0) {
			return "No vaccination appointment for " + this.name + " yet";
		}else if(this.appointmentBooked == 2) {
			return this.appointmentStatus;
		}else {
			return this.appointmentStatus;
		}
		
	}
}
