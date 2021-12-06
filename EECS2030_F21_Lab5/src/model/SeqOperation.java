package model;

public class SeqOperation {

	
	public String intArrIntoString(int[] intArr) {
		String report = "[";
		for (int i = 0 ; i < intArr.length ; i++) {
			if(i > 0) report += ", ";
			report += intArr[i];
		}
		report += "]";
		return report;
	}
	
	public int[] doYourThing() {
		return null;
	}
}
