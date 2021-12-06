package model;

public class BinarySeqOperation extends SeqOperation{
	private int[] integerArray1;
	private int[] integerArray2;
	
//	public String intArrIntoString(int[] intArr) {
//		String report = "[";
//		for (int i = 0 ; i < intArr.length ; i++) {
//			if(i > 0) report += ", ";
//			report += intArr[i];
//		}
//		report += "]";
//		return report;
//	}
	
	public int[] doYourThing() {
		return null;
	}
	
	public int[] getintegerArray1() {
		return this.integerArray1;
	}
	
	public int[] getintegerArray2() {
		return this.integerArray2;
	}
	
	public void setintegerArray1(int[] a) {
		this.integerArray1 = a;
	}
	
	public void setintegerArray2(int[] a) {
		this.integerArray2 = a;
	}
}
