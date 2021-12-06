package model;

public class WeatherStation {

	protected String name;
	protected WeatherApp[] weatherApps;
	protected int numOfApps;
	
	private int temp;
	private int pres;
	private double avgTemp;
	private boolean updated;
	private int reads;
	private boolean rain;
	
	public WeatherStation(String n, int limit) {
		this.name = n;
		this.weatherApps = new WeatherApp[limit];
		this.numOfApps = 0;
		
		this.temp = 0;
		this.pres = 0;
		this.avgTemp = 0;
		this.updated = false;
		this.reads = 0;
		this.rain = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public SensorApp[] getSensors() {
		SensorApp[] sa;
		int counter = 0;
		
		for(int i = 0 ; i < this.numOfApps ; i++) {
			if(this.weatherApps[i] instanceof SensorApp) {
			counter++;	
			}
		}
		
		sa = new SensorApp[counter];
		counter = 0;
		
		for(int i = 0 ; i < this.numOfApps ; i++) {
			if(this.weatherApps[i] instanceof SensorApp) {
				sa[counter] = (SensorApp) this.weatherApps[i];
				counter++;	
			}
		}
		
		return sa;
	}
	
	public void connect(WeatherApp wa) {
		this.weatherApps[this.numOfApps] = wa;
		wa.sync(this);
		this.numOfApps++;
	}
	
	public void update(int temp, int pres) {
		this.reads++;
		if(this.temp < temp) this.temp = temp;
		if(this.pres > pres) {
			this.rain = false;
		}else {
			this.rain = true;
		}
		this.pres = pres;
		this.avgTemp = ((this.avgTemp * (this.reads - 1) + (double)temp)) / this.reads;
		this.updated = true;
	}
	
	public String getWeather() {
		String report = "";
		
		if(this.updated) {
			report +=  " {max temperature: " + this.temp + ", avg temperature: "
					+ String.format("%.1f", this.avgTemp);
			if(this.reads > 1) {
				if(this.rain) {
					report += ", unlikely to rain}";
				}else {
					report += ", likely to rain}";
				}	
			}else {
				report += ", unlikely to rain}";
			}
		}
		
		return report;
	}
	
	public String toString() {
		String report = "";
		
		if(this.numOfApps > 0) {
			report += this.name + " is connected by " + this.numOfApps + " apps: <";
			for(int i = 0 ; i < this.numOfApps ; i++) {
				if(i > 0) report += ", ";
				report += this.weatherApps[i].getName();
			}

			report += ">.";
		}else {
			report += this.name + " has no connected apps.";
		}
		
		return report;
	}
	
}
