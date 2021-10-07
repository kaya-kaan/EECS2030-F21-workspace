package model;

public class Account {

	String name;
	AppStore linkedStore;
	String[] downloadedApps = new String[50];
	App[] objectsDownloadedApps = new App[50];

	boolean error = false;
	String errorMessage = "";
	String statusMessage = "";

	public Account(String name, AppStore appStore) {
		this.name = name;
		this.linkedStore = appStore;
		this.statusMessage = "An account linked to the " + this.linkedStore.country + " store is created for " + this.name + ".";
	}

	public void download(String name) {
		boolean doesAppDownloaded = false;
		for(int i = 0; i < this.downloadedApps.length; i++) {
			if(this.downloadedApps[i] == name) {
				doesAppDownloaded = true;
				break;
			}
		}

		if(doesAppDownloaded) {
			this.error = true;
			this.errorMessage = "Error: " + name + " has already been downloaded for " + this.name + ".";

		}else {
			for(int i = 0; i < this.downloadedApps.length; i++) {
				if(this.downloadedApps[i] == null) {
					this.downloadedApps[i] = name;
					this.objectsDownloadedApps[i] = this.linkedStore.getApp(name);
					break;
				}
			}
			this.statusMessage = name + " is successfully downloaded for " + this.name + ".";
		}
	}

	public void uninstall(String appName) {
		boolean isAppDownloaded = false;
		int index = -1;
		for(int i = 0; i < this.downloadedApps.length; i++) {
			if(this.downloadedApps[i] == appName) {
				isAppDownloaded = true;
				index = i;
				break;
			}
		}
		if(isAppDownloaded) {
			this.downloadedApps[index] = null;
			this.objectsDownloadedApps[index] = null;
			this.statusMessage = appName + " is successfully uninstalled for " + this.name + ".";
		}else {
			this.error = true;
			this.errorMessage = "Error: " + appName + " has not been downloaded for " + this.name + ".";
		}
	}


	public void submitRating(String appName, int rating) {
		boolean isAppDownloaded = false;
		int index = -1;
		for(int i = 0; i < this.downloadedApps.length; i++) {
			if(this.downloadedApps[i] == appName) {
				isAppDownloaded = true;
				index = i;
			}
		}

		if(isAppDownloaded) {
			this.objectsDownloadedApps[index].submitRating(rating);
			this.statusMessage = "Rating score " + rating + " of " + this.name + " is successfully submitted for " + appName + ".";
		}else {
			this.error = true;
			this.errorMessage = "Error: " + appName + " is not a downloaded app for " + this.name + ".";
		}
	}

	public void switchStore(AppStore appStore) {
		this.linkedStore = appStore;
		this.statusMessage = "Account for " + this.name + " is now linked to the " + this.linkedStore.country + " store.";
	}

	public String[] getNamesOfDownloadedApps() {
		int numOfDownloaded = 0;
		for(int i = 0; i < this.downloadedApps.length; i++) {
			if(this.downloadedApps[i] != null) {
				numOfDownloaded++;
			}	
		}
		String[] downloadedApps = new String[numOfDownloaded];
		int index = 0;
		for(int i = 0; i < this.downloadedApps.length; i++) {
			if(this.downloadedApps[i] != null) {
				downloadedApps[index] = this.downloadedApps[i];
				index++;
			}	
		}

		return downloadedApps;
	}

	public App[] getObjectsOfDownloadedApps() {
		int numOfDownloaded = 0;
		for(int i = 0; i < this.objectsDownloadedApps.length; i++) {
			if(this.objectsDownloadedApps[i] != null) {
				numOfDownloaded++;
			}	
		}
		App[] objectsOfDownloadedApps = new App[numOfDownloaded];
		int index = 0;
		for(int i = 0; i < this.objectsDownloadedApps.length; i++) {
			if(this.objectsDownloadedApps[i] != null) {
				objectsOfDownloadedApps[index] = this.objectsDownloadedApps[i];
				index++;
			}	
		}

		return objectsOfDownloadedApps;
	}

	public String toString() {
		if(this.error) {
			this.error = false;
			return this.errorMessage;
		}else {
			return this.statusMessage;
		}

	}
}
