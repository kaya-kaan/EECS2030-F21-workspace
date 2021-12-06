package model;

public class OccursWithin extends BinarySeqOperation {

	public OccursWithin(int[] ia1, int[] ia2) {
		int[] integerArray1 = new int[ia1.length];
		integerArray1 = ia1;
		this.setintegerArray1(integerArray1);
		int[] integerArray2 = new int[ia2.length];
		integerArray2 = ia2;
		this.setintegerArray2(integerArray2);
	}

	public boolean occurs() {
		boolean report = false;

		if(this.getintegerArray1().length == 0) {
			report = true;
		}else if((this.getintegerArray2().length == 0 && this.getintegerArray1().length > 0) ||
				this.getintegerArray2().length < this.getintegerArray1().length){
		}else {
			for(int i = 0 ; i < (this.getintegerArray2().length - (this.getintegerArray1().length - 1)) ; i++) {
				for(int j = 0 ; j < this.getintegerArray1().length ; j++) {
					if(this.getintegerArray2()[(i+j)] == this.getintegerArray1()[j]) {
						report = true;
						if(j == this.getintegerArray1().length - 1) i = this.getintegerArray2().length;
					}else {
						report = false;
						j = this.getintegerArray1().length;
					}
				}
			}
		}
		return report;
	}
	
	public int[] doYourThing() {
		int[] i = new int[1];
		if(this.occurs()){
			i[0] = 1;
		}else {
			i[0] = 0;
		}
		
		return i;
	}
	
	public String toString() {
		String report = "";
		
		report += this.intArrIntoString(this.getintegerArray1());
		if(this.occurs()) {
			report += " occurs within ";
		}else {
			report += " does not occur within ";
		}
		report += this.intArrIntoString(getintegerArray2());
		
		return report;
	}
}
