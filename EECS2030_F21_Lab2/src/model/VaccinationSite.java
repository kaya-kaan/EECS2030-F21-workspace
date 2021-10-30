package model;

public class VaccinationSite {
	String placeName;
	int doseSupply;
	int doseLimit;
	
	HealthRecord[] appointments = new HealthRecord[200];
	int numOfAppointments = 0;

	VaccineDistribution[] vaccines = new VaccineDistribution[4];
	int numOfDoses = 0;

	public VaccinationSite(String place, int limit) {
		this.placeName = place;
		this.doseLimit = limit;
		this.doseSupply = 0;
	}

	public int getNumberOfAvailableDoses() {
		return this.doseSupply;
	}

	public int getNumberOfAvailableDoses(String name) {
		if(this.doseSupply == 0) {
			return 0;
		}else {
			int index = -1;

			for (int i = 0; i < this.numOfDoses; i++) {
				if(this.vaccines[i].vaccine.name == name) index = i;
			}

			if(index == -1) {
				return 0;
			}else {
				return this.vaccines[index].numOfDoses;
			}
		}
	}

	public void addDistribution(Vaccine vac, int doses) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException{
		if (vac.name != "mRNA-1273" && vac.name != "BNT162b2" && vac.name != "Ad26.COV2.S" && vac.name != "AZD1222") {
			throw new UnrecognizedVaccineCodeNameException("Unrecognized name");
		}
		if (this.doseLimit < this.doseSupply + doses) {
			throw new TooMuchDistributionException("Dose limit exceeded");
		}
		int index = -1;

		for (int i = 0; i < this.numOfDoses; i++) {
			if(this.vaccines[i].vaccine == vac) index = i;
		}
		if(index == -1) {
			this.vaccines[this.numOfDoses] = new VaccineDistribution(vac, doses);
			this.doseSupply += doses;
			this.numOfDoses++;
		}else {
			this.vaccines[index].numOfDoses += doses;
			this.doseSupply += doses;
		}

	}
	
	public void bookAppointment(HealthRecord patient) throws InsufficientVaccineDosesException {
		if (this.numOfAppointments >= this.doseSupply) {
			patient.appointmentBooked = 2;
			patient.appointmentStatus = "Last vaccination appointment for " + patient.name + " with " + this.placeName + " failed";
			throw new InsufficientVaccineDosesException("No more dose stock");
		}else {
			this.appointments[this.numOfAppointments] = patient;
			this.numOfAppointments++;
			patient.appointmentBooked = 1;
			patient.appointmentStatus = "Last vaccination appointment for " + patient.name + " with " + this.placeName + " succeeded";
		}
	}
	
	public void administer(String date) {
		int vaccineIndex = 0;
		for(int i = 0; i < this.numOfDoses; i++) {
			if(this.vaccines[i].numOfDoses <= 0) vaccineIndex++;
		}
		
		for(int i = 0; i < this.numOfAppointments; i++) {
			this.appointments[i].addRecord(this.vaccines[vaccineIndex].vaccine, this.placeName, date);
			this.vaccines[vaccineIndex].numOfDoses--;
			this.doseSupply--;
			this.appointments[i] = null;
			if(this.vaccines[vaccineIndex].numOfDoses == 0) vaccineIndex++;
		}
		this.numOfAppointments = 0;
	}

	public String toString() {
		String report = this.placeName + " has " + this.doseSupply + " available doses: <";

		for (int i = 0; i < this.numOfDoses; i++) {
			if(i > 0) {
				report += ", ";
			}
			report += this.vaccines[i].numOfDoses + " doses of " + this.vaccines[i].vaccine.manufacturer;
		}

		report += ">";
		return report;
	}
}
