package model;

public class ForecastApp extends WeatherApp {

	public ForecastApp(String n, int limit) {
		this.name = n;
		this.weatherStations = new WeatherStation[limit];
		this.numOfStations = 0;
	}
	
	public String getName() {
		return "Weather Forecast App " + this.name;
	}

	public String toString() {
		String report = "";

		if(this.numOfStations > 0) {
			report += "Weather Forecast App " + this.name + " is connected to " + 
					this.numOfStations + " stations: <";
			for(int i = 0 ; i < this.numOfStations ; i++) {
				if(i > 0) report += ", ";
				report += this.weatherStations[i].getName();
				report += this.weatherStations[i].getWeather();
			}

			report += ">.";
		}else {
			report += "Weather Forecast App " + this.name + " is connected to no stations.";
		}

		return report;
	}
}
