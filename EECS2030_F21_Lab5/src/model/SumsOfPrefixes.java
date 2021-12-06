package model;

public class SumsOfPrefixes extends SeqOperation {

	private int[] integerArray;
	
	public SumsOfPrefixes(int[] ia) {
		this.integerArray = new int[ia.length];
		this.integerArray = ia;
	}
	
	public String sumOfArray() {
		String report = "[0";
		int sum = 0;
		for(int i = 0 ; i < this.integerArray.length ; i++) {
			sum += this.integerArray[i];
			report += ", " + sum;
		}
		return report + "]";
	}
	
	public int[] doYourThing() {
		int[] report = new int[this.integerArray.length + 1];
		report[0] = 0;
		int sum = 0;
		for(int i = 1 ; i < this.integerArray.length + 1 ; i++) {
			sum += this.integerArray[i - 1];
			report[i] = sum;
		}
		
		return report;
	}
	
	public String toString() {
		String report = "Sums of prefixes of " +
				this.intArrIntoString(this.integerArray) +
				" is: " + this.sumOfArray();
		
		return report;
	}
}
