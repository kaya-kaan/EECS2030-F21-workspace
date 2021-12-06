package model;

public class Projection extends BinarySeqOperation {
	
	public Projection(int[] ia1, int[] ia2) {
		int[] integerArray1 = new int[ia1.length];
		integerArray1 = ia1;
		this.setintegerArray1(integerArray1);
		int[] integerArray2 = new int[ia2.length];
		integerArray2 = ia2;
		this.setintegerArray2(integerArray2);
	}
	
	public int[] project() {
		int[] projection;
		int count = 0;
		
		for(int i = 0 ; i < this.getintegerArray2().length ; i++) {
			for(int j = 0 ; j < this.getintegerArray1().length ; j++) {
				if(this.getintegerArray2()[i] == this.getintegerArray1()[j]) {
					count++;
					j = this.getintegerArray1().length;
				}
			}
		}
		
		projection = new int[count];
		count = 0;
		for(int i = 0 ; i < this.getintegerArray2().length ; i++) {
			for(int j = 0 ; j < this.getintegerArray1().length ; j++) {
				if(this.getintegerArray2()[i] == this.getintegerArray1()[j]) {
					projection[count] = this.getintegerArray2()[i];
					count++;
					j = this.getintegerArray1().length;
				}
			}
		}
		return projection;
	}
	
	public int[] doYourThing() {
		return this.project();
	}
	
	public String toString() {
		String report = "";
		
		report += "Projecting " + this.intArrIntoString(this.getintegerArray1()) + " to " + this.intArrIntoString(this.getintegerArray2()) 
		+ " results in: " + this.intArrIntoString(this.project());
		return report;
	}
}
