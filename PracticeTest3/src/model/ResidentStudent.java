package model;

public class ResidentStudent extends Student {
	
	
	public ResidentStudent(String n) {
		this.name = n;
	}
	
	public void setPremiumRate(double r) {
		this.rate = r;
	}
	
	public double getPremiumRate() {
		return this.rate;
	}
}
