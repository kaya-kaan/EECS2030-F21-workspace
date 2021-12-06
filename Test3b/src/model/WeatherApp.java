package model;

public class WeatherApp {
	
	protected String name;
	protected WeatherStation[] weatherStations;
	protected int numOfStations;
	
//	public WeatherApp(String n, int limit) {
//		this.name = n;
//		this.weatherStations = new WeatherStation[limit];
//		this.numOfStations = 0;
//	}
	
	public String getName() {
		return "";
	}
	
	public void sync(WeatherStation ws) {
		this.weatherStations[this.numOfStations] = ws;
		this.numOfStations++;
	}
}
