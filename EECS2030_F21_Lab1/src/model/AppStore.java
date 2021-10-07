package model;

public class AppStore {
	String country;
	App[] apps;
	int numOfApps = 0;
	
	public AppStore(String country, int maxNumOfApps) {
		this.country = country;
		apps = new App[maxNumOfApps];
	}
	
	public void addApp(App addedApp) {
		this.apps[this.numOfApps] = addedApp;
		this.numOfApps++;
	}
	public String getBranch() {
		return this.country;
	}
	
	public App getApp(String appName) {
		int index = -1;
		for(int i = 0; i < this.apps.length; i++) {
			if(this.apps[i] != null && this.apps[i].getName() == appName) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			return null;
		}else {
			return this.apps[index];
		}
		
	}
	
	public String[] getStableApps(int numOfUpdates) {
		int numOfStableApps = 0;
		for(int i = 0; i < this.numOfApps; i++) {
			if(this.apps[i].updatesReleased >= numOfUpdates) {
				numOfStableApps++;
			}
			
		}
		String[] stableApps = new String[numOfStableApps];
		int index = 0;
		for(int i = 0; i < this.numOfApps; i++) {
			if(this.apps[i].updatesReleased >= numOfUpdates) {
				stableApps[index] = this.apps[i].getName() + " (" + this.apps[i].updatesReleased +
						" versions; Current Version: " + this.apps[i].getWhatIsNew() + ")";
				index++;
			}
			
		}
		return stableApps;
	}
	
}
