package model;

public class Log {

	String versionNumber;
	int numberOfFixes = 0;
	final int MAXNUMOFFIXES = 10;
	String fixes = ""; 

	public Log(String verNum) {
		this.versionNumber = verNum;
	}

	public void addFix(String fix) {
		if(this.numberOfFixes < this.MAXNUMOFFIXES) {
			if(this.numberOfFixes > 0) {
				this.fixes += ", ";
			}
			this.fixes += fix;
			this.numberOfFixes++;
		}
	}

	public String getVersion() {
		return versionNumber;
	}
	public int getNumberOfFixes() {
		return this.numberOfFixes;
	}

	public String getFixes() {
		return "[" + this.fixes + "]";
	}

	public String toString() {
		return "Version " + this.versionNumber + " contains " + this.numberOfFixes + " fixes [" + this.fixes + "]";
	}
}
