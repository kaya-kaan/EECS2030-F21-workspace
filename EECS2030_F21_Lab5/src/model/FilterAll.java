package model;

public class FilterAll extends SeqEvaluator {

	public FilterAll(int i) {
		SeqOperation[] seqOperations = new SeqOperation[i];
		setSeqOperations(seqOperations);
		this.setNumOfOps(0);
		//this.getNumOfOps()
		//this.getSeqOperations()
	}

	public int[] filter() {
		int incOps = 0;
		int[] report = {0, 0};

		for(int i = 0 ; i < this.getNumOfOps() ; i++) {
			if(!(this.getSeqOperations()[i] instanceof OccursWithin)) {
				incOps++;
			}
		}

		if(incOps > 0) {
			report[0] = 1;
			report[1] = incOps;
			return report;
		}else {
			report[0] = 0;
			report[1] = 0;
			return report;
		}
	}

	public String toString() {
		String report = "";
		if(this.filter()[0] == 1) {
			return "Filter cannot be evaluated due to " + this.filter()[1] + " incompatile operations.";
		}else {
			report = "Filter result is: ";

			for(int i = 0 ; i < this.getNumOfOps() ; i++) {
				if(i > 0) report += ", ";
				if((this.getSeqOperations()[i] instanceof OccursWithin)) {
					if(this.getSeqOperations()[i].intArrIntoString(this.getSeqOperations()[i].doYourThing()).equals("[1]")) {
						report += "true";
					}else {
						report += "_";
					}
				}else {

				}

			}

			return report;
		}

	}
}
