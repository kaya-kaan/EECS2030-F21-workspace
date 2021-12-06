package model;

public class SensorApp extends WeatherApp {

	public SensorApp(String n, int limit) {
		this.name = n;
		this.weatherStations = new WeatherStation[limit];
		this.numOfStations = 0;
	}
	
	public String getName() {
		return "Weather Sensor App " + this.name;
	}
	
	public void updateMeasurements(String n, int temp, int pres) {
		for(int i = 0 ; i < this.numOfStations ; i++) {
			if(this.weatherStations[i].getName().equals(n)) {
				this.weatherStations[i].update(temp, pres);
			}
		}
	}
	
	public String[] getConnectedForcastersOf(String n) {
		String[] cf = new String[0];
		return cf;
	}
	
	public String toString() {
		String report = "";
		
		if(this.numOfStations > 0) {
			report += "Weather Sensor App " + this.name + " is connected to " + 
					this.numOfStations + " stations: <";
			for(int i = 0 ; i < this.numOfStations ; i++) {
				if(i > 0) report += ", ";
				report += this.weatherStations[i].getName();
			}
			
			report += ">.";
		}else {
			report += "Weather Sensor App " + this.name + " is connected to no stations.";
		}
		
		return report;
	}
}
