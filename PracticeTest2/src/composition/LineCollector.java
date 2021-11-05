package composition;

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
		return new Line(this.lines[index]);
	}

	public Line[] getLines() {
		Line[] ls = new Line[this.lines.length];

		for(int i = 0 ; i < this.nol ; i++) {
			ls[i] = new Line(this.lines[i]);
		}
		return ls;
	}

	public int getNOL() {
		return this.nol;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		LineCollector other = (LineCollector) obj;

		return this.getLines().equals(lines) == other.getLines().equals(obj)
				&& this.getNOL() == other.getNOL();
	}
}
