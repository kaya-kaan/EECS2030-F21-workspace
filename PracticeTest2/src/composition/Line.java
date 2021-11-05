package composition;

public class Line {
	private Point pointA;
	private Point pointB;
	
	public Line(Point a, Point b) {
		this.pointA = new Point(a);
		this.pointB = new Point(b);
	}
	
	public Line(Line l) {
		this.pointA = new Point(l.pointA.getX(), l.pointA.getY());
		this.pointB = new Point(l.pointB.getX(), l.pointB.getY());
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
		
		return this.getStart().getX() == other.getStart().getX() && this.getStart().getY() == other.getStart().getY()
				&& this.getEnd().getX() == other.getEnd().getX() && this.getEnd().getY() == other.getEnd().getY();
	}
}
