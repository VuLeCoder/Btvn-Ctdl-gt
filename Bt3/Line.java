package Bt3;

public class Line implements Shape{
	
	private Point p1, p2;
	private double A, B; // Ax + By + C = 0

    public Line(Point p1, Point p2) {
    	this.p1 = p1;
    	this.p2 = p2;
    	
        this.A = p2.getY() - p1.getY();
        this.B = p1.getX() - p2.getX();
    }
    
    @Override
    public String toString() {
        return "Line(" + p1.toString() + " " + p2.toString() + ")";
    }
    
    public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return p1.distanceTo(p2);
	}

    public boolean isParallel(Line other) {
        return this.A * other.B == this.B * other.A;
    }
	
	@Override
	public double distanceTo(Shape other) {
		if (other instanceof Line) {
			Line l = (Line)other;
			
        	if(!this.isParallel(l)) { 
        		return 0;
        	}
        	
        	return p1.distanceTo(l);
        }
        return p1.distanceTo(other);
	}

	@Override
	public void move(double dx, double dy) {
		p1.move(dx, dy);
		p2.move(dx, dy);
	}

	@Override
	public void rotate(double da) {
		double cosTheta = Math.cos(da);
        double sinTheta = Math.sin(da);
        Point pivot = p1.midPoint(p2);
        
        double newX = pivot.getX() + (p1.getX() - pivot.getX()) * cosTheta - (p1.getY() - pivot.getY()) * sinTheta;
        double newY = pivot.getY() + (p1.getX() - pivot.getX()) * sinTheta + (p1.getY() - pivot.getY()) * cosTheta;
        p1 = new Point(newX, newY);
        
        newX = pivot.getX() + (p2.getX() - pivot.getX()) * cosTheta - (p2.getY() - pivot.getY()) * sinTheta;
        newY = pivot.getY() + (p2.getX() - pivot.getX()) * sinTheta + (p2.getY() - pivot.getY()) * cosTheta;
        p2 = new Point(newX, newY);
	}

	@Override
	public void zoom(double dr) {}
}
