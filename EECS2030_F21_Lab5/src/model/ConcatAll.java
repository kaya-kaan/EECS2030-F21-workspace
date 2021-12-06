package model;

public class ConcatAll extends SeqEvaluator {

	public ConcatAll(int i) {
		SeqOperation[] seqOperations = new SeqOperation[i];
		setSeqOperations(seqOperations);
		this.setNumOfOps(0);
		//this.getNumOfOps()
		//this.getSeqOperations()
	}

	public int[] concat() {
		int incOps = 0;
		int[] report = {0, 0};

		for(int i = 0 ; i < this.getNumOfOps() ; i++) {
			if(this.getSeqOperations()[i].intArrIntoString(this.getSeqOperations()[i].doYourThing()).equals("[0]")) {
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
		if(this.concat()[0] == 1) {
			return "Concat cannot be evaluated due to " + this.concat()[1] + " incompatile operations.";
		}else {
			report = "Concat(";

			for(int i = 0 ; i < this.getNumOfOps() ; i++) {
				if(i > 0) report += ", ";
				if(!(this.getSeqOperations()[i] instanceof OccursWithin)) {
					report += this.getSeqOperations()[i].intArrIntoString(this.getSeqOperations()[i].doYourThing());
				}else {

				}

			}

			report += ") = [";

			String intArrInString = "";

			for(int i = 0 ; i < this.getNumOfOps() ; i++) {
				if(i > 0 && !(this.getSeqOperations()[i].intArrIntoString(this.getSeqOperations()[i].doYourThing()).equals("[]"))) intArrInString += ", ";
				intArrInString += intArrIntoString(this.getSeqOperations()[i].doYourThing());

			}

			return report + intArrInString + "]";
		}

	}
}
