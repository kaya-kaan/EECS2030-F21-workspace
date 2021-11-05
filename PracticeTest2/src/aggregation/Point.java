package aggregation;

public class Point {
	private int xAxis;
	private int yAxis;
	
	public Point(int x, int y) {
		this.xAxis = x;
		this.yAxis = y;
	}
	
	public Point(Point p) {
		this.xAxis = p.getX();
		this.yAxis = p.getY();
	}
	
	public int getX() {
		return this.xAxis;
	}
	
	public int getY() {
		return this.yAxis;
	}
	
	public void setX(int x) {
		this.xAxis = x;
	}
	
	public void setY(int y) {
		this.yAxis = y;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		Point other = (Point) obj;
		
		return this.getX() == other.getX()
				&& this.getY() == other.getY();
	}

}
