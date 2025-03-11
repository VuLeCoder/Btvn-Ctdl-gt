package Bt2;

public class Point_2D {
	private double x, y;
	
	public Point_2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point_2D [x=" + x + ", y=" + y + "]";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double distanceTo(Point_2D point) {
		return Math.sqrt((this.x - point.getX()) * (this.x - point.getX()) + (this.y - point.getY()) * (this.y - point.getY()));
	}
	
	public Point_2D symmetricAboutOrigin() {
		return new Point_2D(0 - this.x, 0 - this.y);
	}
	
	public void move(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
}
