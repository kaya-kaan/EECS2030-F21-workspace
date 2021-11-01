package model;

//import junit_tests.InsufficientFloorSpaceException;

public class Floor {

	Unit[] units = new Unit[20];
	int unitsOccupied = 0;

	double capacity;
	double usedSpace = 0;

	public Floor(double c) {
		this.capacity = c;
	}
	
	public Floor(Unit[] u, int uo, double cap, double us) {
		this.capacity = cap;
		this.units = u;
		this.unitsOccupied = uo;
		this.usedSpace = us;
	}

	public void addUnit(String type, int w, int l) throws InsufficientFloorSpaceException {
		if ( (w * l) > this.capacity) {
			throw new InsufficientFloorSpaceException("Not enough space");
		}else {
			this.units[this.unitsOccupied] = new Unit(type, w, l);
			this.unitsOccupied++;
			this.capacity -= (w * l);
			this.usedSpace += (w * l);
		}
	}

	public String toString() {
		String report = "";
		report += "Floor's utilized space is " + String.format("%.0f", this.usedSpace) + 
				" sq ft (" + String.format("%.0f", this.capacity)+ " sq ft remaining): [";

		boolean comma = false;
		for (int i = 0 ; i < this.units.length ; i++) {
			if(this.units[i] != null) {
				if(comma) report += ", ";
				report += this.units[i].type + ": " + String.format("%.0f", this.units[i].width * this.units[i].length) + 
						" sq ft (" + (int)this.units[i].width + "' by " + (int)this.units[i].length + "')";
				comma = true;
			}
		}

		return report + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Floor other = (Floor) obj;

			boolean unitsEqual = true;

			for (int i = 0 ; i < this.units.length ; i++) {
				if (this.units[i] != null){
					for (int j = 0 ; j < other.units.length ; j++) {
						if (this.units[i].equals(other.units[j])) {
							unitsEqual = true;
							break;
						}
						unitsEqual = false;
					}
				}
			}
			return this.capacity == other.capacity && unitsEqual;
	}
}
