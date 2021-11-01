package model;

public class Blueprint {
	int floorNum = 0;
	Floor[] floors;
	
	public Blueprint(int floor) {
		this.floors = new Floor[floor];
	}
	
	public Blueprint(Blueprint b) {
		this.floorNum = b.floorNum;
		this.floors = b.floors;
	}
	
	public void addFloorPlan(Floor f) {
		this.floors[this.floorNum] = f;
		this.floorNum++;
	}
	
	public Floor[] getFloors() {
		int counter = 0;
		Floor[] f = new Floor[this.floorNum];

		for(int i = 0 ; i < this.floors.length ; i++) {
			if(this.floors[i] != null) {
				f[counter] = new Floor(this.floors[i].units, this.floors[i].unitsOccupied, this.floors[i].capacity, this.floors[i].usedSpace);
				counter++;
			}
		}
		
		return f;
		
	}
	
	public String toString() {
		String report = "";
		
		report += String.format("%.1f", ((this.floorNum * 100.0 )/ this.floors.length)) + 
				" percents of building blueprint completed (" + this.floorNum +
				" out of " + this.floors.length + " floors)";
		return report;
	}
}
