package model;

public class Unit {
	double width;
	double length;

	String type;

	boolean measurementInFeet = true;

	public Unit(String type, int w, int l) {
		this.type = type;
		this.width = w;
		this.length = l;
	}

	public String getArea() {
		if(this.measurementInFeet) {
			return String.format("%.0f", (this.length * this.width));
		}else {
			 return String.format("%.2f", (this.length * this.width));
		}
	}
	
	public void toogleMeasurement() {
		if (this.measurementInFeet) {
			this.length *= 0.3048;
			this.width *= 0.3048;
			this.measurementInFeet = false;
		}else {
			this.length *= 3.2808399;
			this.width *= 3.2808399;
			this.measurementInFeet = true;
		}
	}

	public String toString() {
		String report = "";

		if(this.measurementInFeet) {
			report = "A unit of " + String.format("%.0f", (this.length * this.width)) + " square feet (" + String.format("%.0f", this.width) 
			+ "' wide and " + String.format("%.0f", this.length) + "' long) functioning as " + this.type;
		}else {
			report = "A unit of " + String.format("%.2f", (this.length * this.width)) + " square meters (" + String.format("%.2f", this.width) 
			+ " m wide and " + String.format("%.2f", this.length) + " m long) functioning as " + this.type;
		}

		return report;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		Unit other = (Unit) obj;
		
		return this.width * this.length == other.width * other.length
				&& this.measurementInFeet == other.measurementInFeet 
				&& this.type == other.type;
	}

}
