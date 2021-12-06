package model;

public class SeqEvaluator {

	private SeqOperation[] seqOperations;
	private int numOfOps;
	
	public void addOperation(String op, int[] ia1, int[] ia2) throws IllegalOperationException{
		if(op.equals("op:projection")) {
			this.seqOperations[this.numOfOps] = new Projection(ia1, ia2);
			this.numOfOps++;
		}else if(op.equals("op:sumsOfPrefixes")) {
			this.seqOperations[this.numOfOps] = new SumsOfPrefixes(ia1);
			this.numOfOps++;
		}else if(op.equals("op:occursWithin")) {
			this.seqOperations[this.numOfOps] = new OccursWithin(ia1, ia2);
			this.numOfOps++;
		}else {
			throw new IllegalOperationException("error");
		}
	}
	
	public String intArrIntoString(int[] intArr) {
		String report = "";
		for (int i = 0 ; i < intArr.length ; i++) {
			if(i > 0) report += ", ";
			report += intArr[i];
		}
		return report;
	}
	
	public SeqOperation[] getSeqOperations() {
		return this.seqOperations;
	}
	
	public int getNumOfOps() {
		return this.numOfOps;
	}
	
	public void setSeqOperations(SeqOperation[] sq) {
		this.seqOperations = sq;
	}
	
	public void setNumOfOps(int i) {
		this.numOfOps = i;
	}
}
