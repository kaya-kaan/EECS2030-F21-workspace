package aggregation;

public class LineCollector {
	private Line[] lines;
	private int nol;
	
	public LineCollector() {
		this.lines = new Line[4];
		this.nol = 0;
	}
	
	public LineCollector(LineCollector lc) {
		this.lines = lc.getLines();
		this.nol = lc.getNOL();
	}
	
	public void addLine(Line l) {
		this.lines[nol] =  l;
		this.nol++;
	}
	
	public Line getLineAt(int index) {
		return this.lines[index];
	}
	
	public Line[] getLines() {
		return this.lines;
	}
	
	public int getNOL() {
		return this.nol;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		LineCollector other = (LineCollector) obj;
		
		return this.getLines() == other.getLines()
				&& this.getNOL() == other.getNOL();
	}
}
