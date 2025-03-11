package Bt3;

public class Point implements Shape {
	private double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Point midPoint(Point other) {
		return new Point((other.getX() + this.x) / 2, (other.getY() + this.y) / 2);
	}

	@Override
    public double area() {
        return 0; // Điểm không có diện tích
    }

    @Override
    public double perimeter() {
        return 0; // Điểm không có chu vi
    }

    @Override
    public double distanceTo(Shape other) {
        if (other instanceof Point) {
        	Point p = (Point)other;
            return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
            
        } else if (other instanceof Circle) {
        	Circle c = (Circle)other;
        	return this.distanceTo(c.getPoint());
        	
        } else if (other instanceof Line) {
        	Line l = (Line)other;
        	
        	double x1 = l.getP1().x, y1 = l.getP1().y;
            double x2 = l.getP2().x, y2 = l.getP2().y;

            double numerator = Math.abs((y2 - y1) * this.x - (x2 - x1) * this.y + x2 * y1 - y2 * x1);
            double denominator = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));

            return numerator / denominator;
        }
        return 0;
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }

	@Override
	public void rotate(double da) {}

	@Override
	public void zoom(double dr) {}
}
