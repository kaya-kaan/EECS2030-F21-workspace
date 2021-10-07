package model;

public class App {
	
	String name;
	Log[] logs = new Log[20];
	int updatesReleased = 0;
	//String versionInfo;
	//String currentVersion = "n/a";
	
	String avgRating = "n/a";
	double avgRatingInDouble;
	int ratingsSubmitted = 0;
	int[] ratings;
	
	public App(String name, int maxNumOfRatings) {
		this.name = name;
		ratings = new int[maxNumOfRatings];
	}
	
	public void releaseUpdate(String verNum) {
		this.logs[this.updatesReleased] = new Log(verNum);
		this.updatesReleased++;
	}
	
	public void submitRating(int rating) {
		this.ratings[this.ratingsSubmitted] = rating;
		this.ratingsSubmitted++;
		
		double sumOfRatings = 0;
		for(int i = 0; i < this.ratingsSubmitted; i++) {
			sumOfRatings += this.ratings[i];
		}
		
		this.avgRatingInDouble = sumOfRatings / this.ratingsSubmitted;
		this.avgRating = String.format("%.1f", this.avgRatingInDouble);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getWhatIsNew() {
		if(this.updatesReleased == 0) {
			return "n/a";
		}else {
			return this.logs[this.updatesReleased - 1].toString();
		}
	}
	
	public Log[] getUpdateHistory() {
		int logLength = 0;
		for(int i = 0; i < this.logs.length; i++) {
			if(this.logs[i] != null) {
				logLength++;
			}
		}
		
		Log[] filledLogs = new Log[logLength];
		for(int i = 0; i < logLength; i++) {
			filledLogs[i] = this.logs[i];
		}
		return filledLogs;
	}
	
	public Log getVersionInfo(String verNum) {
		int index = -1;
		for(int i = 0; i < this.logs.length; i++) {
			if(this.logs[i] != null && this.logs[i].getVersion() == verNum) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			return null;
		}else {
			return this.logs[index];
		}
		
	}
	
	public String getRatingReport() {
		if(this.ratingsSubmitted == 0) {
			return "No ratings submitted so far!";
		}else {
			int score1 = 0, score2 = 0, score3 = 0, score4 = 0, score5 = 0;
			for(int i = 0; i < this.ratingsSubmitted; i++) {
				switch (this.ratings[i]) {
				case 1: score1++;
				break;
				case 2: score2++;
				break;
				case 3: score3++;
				break;
				case 4: score4++;
				break;
				case 5: score5++;
				break;
				}
			}
			return "Average of " + this.ratingsSubmitted + " ratings: " + String.format("%.1f", this.avgRatingInDouble) + 
					" (Score 5: " + score5 + ", Score 4: " + score4 + ", Score 3: " + score3 + ", Score 2: " + score2 + ", Score 1: " + score1 + ")";
		}
	}
	
	public String toString() {
		if(this.updatesReleased == 0) {
			return this.name + " (Current Version: n/a; Average Rating: " + this.avgRating + ")";
		}else {
			return this.name + " (Current Version: " + this.logs[this.updatesReleased - 1] + "; Average Rating: " + String.format("%.1f", this.avgRatingInDouble) + ")";
		}
		
	}
}
