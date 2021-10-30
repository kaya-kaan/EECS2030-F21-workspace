package model;

public class VaccineDistribution {
	
	Vaccine vaccine;
	int numOfDoses;

	public VaccineDistribution(Vaccine vac, int amount) {
		this.numOfDoses = amount;
		this.vaccine = vac;
	}
	
	public String toString() {
		return this.numOfDoses + " doses of " + this.vaccine.name + " by " + this.vaccine.manufacturer;
	}
}
