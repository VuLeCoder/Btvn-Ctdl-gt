package Bt3;

public class Circle implements Shape, Center {
	Point p;
	private double r;
	
	public Circle(double x, double y, double r) {
		p = new Point(x, y);
		this.r = r;
	}
	
	@Override
    public String toString() {
        return String.format("Circle(%.2f, %.2f, %.2f)", p.getX(), p.getY(), r);
    }

	public Point getPoint() {
		return p;
	}

	public double getR() {
		return r;
	}

	@Override
	public double area() {
		return Math.PI * this.r * this.r;
	}

	@Override
	public double perimeter() {
		return Math.PI * this.r * 2;
	}

	@Override
	public double distanceTo(Shape other) {
        return this.p.distanceTo(other);
	}

	@Override
	public void move(double dx, double dy) {
		p.move(dx, dy);
	}

	@Override
	public void rotate(double da) {}

	@Override
	public void zoom(double dr) {
		r *= dr;
	}

	@Override
	public Shape getCenter() {
		return p;
	}

	@Override
	public Shape getBoundary() {
		return new Rectangle(p.getX() - r, p.getY() - r, r, r);
	}
}
