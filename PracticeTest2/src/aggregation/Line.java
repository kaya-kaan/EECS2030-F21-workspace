package aggregation;

public class Line {

	private Point pointA;
	private Point pointB;
	
	public Line(Point a, Point b) {
		this.pointA = a;
		this.pointB = b;
	}
	
	public Line(Line l) {
		this.pointA = l.getStart();
		this.pointB = l.getEnd();
	}
	
	public Point getStart() {
		return this.pointA;
	}
	
	public Point  getEnd() {
		return this.pointB;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		Line other = (Line) obj;
		
		return this.getStart() == other.getStart()
				&& this.getEnd() == other.getEnd();
	}
}
