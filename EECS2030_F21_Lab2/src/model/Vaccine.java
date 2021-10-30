package model;

//import junit_tests.UnrecognizedVaccineCodeNameException;

public class Vaccine {
	
	String name, type, manufacturer;

	public Vaccine (String name, String type, String manufacturer) {
		this.manufacturer = manufacturer;
		this.name = name;
		this.type = type;
	}
	
	public String toString() {
		if(this.name == "mRNA-1273" || this.name == "BNT162b2" || this.name == "Ad26.COV2.S" || this.name == "AZD1222") {
			return "Recognized vaccine: " + this.name + " (" + this.type + "; " + this.manufacturer + ")";
		}else {
			return "Unrecognized vaccine: " + this.name + " (" + this.type + "; " + this.manufacturer + ")";
		}
	}
}
