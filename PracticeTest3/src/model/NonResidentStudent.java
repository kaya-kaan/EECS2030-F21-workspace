package model;

public class NonResidentStudent extends Student {

	protected double discRate;
	
	public NonResidentStudent(String n) {
		this.name = n;
	}
	
	public void setDiscountRate(double r) {
		this.rate = r;
	}
	
	public double getDiscountRate() {
		return this.rate;
	}
}
