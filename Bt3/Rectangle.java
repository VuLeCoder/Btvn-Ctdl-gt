package Bt3;

import java.util.Arrays;

public class Rectangle implements Shape{
	private Point[] point = new Point[4];
	private double w, h;
	public Rectangle(double x, double y, double w, double h) {
		this.w = w;
		this.h = h;
		
		point[0] = new Point(x, y);
		point[1] = new Point(x + w, y);
		point[2] = new Point(x + w, y + h);
		point[3] = new Point(x, y + h);
	}

	@Override
	public double area() {
		return h * w;
	}

	@Override
	public double perimeter() {
		return (h + w) * 2;
	}

	@Override
	public double distanceTo(Shape other) { return 0; }

	@Override
	public void move(double dx, double dy) {
		for(int i=0; i<point.length; ++i) {
			point[i].move(dx, dy);
		}
	}

	@Override
	public void rotate(double da) {
		double rad = Math.toRadians(da);
	    double cosA = Math.cos(rad);
	    double sinA = Math.sin(rad);

	    double centerX = (point[0].getX() + point[2].getX()) / 2;
	    double centerY = (point[0].getY() + point[2].getY()) / 2;

	    for (int i = 0; i < point.length; i++) {
	        double x = point[i].getX();
	        double y = point[i].getY();
	        
	        double newX = centerX + (x - centerX) * cosA - (y - centerY) * sinA;
	        double newY = centerY + (x - centerX) * sinA + (y - centerY) * cosA;
	        
	        point[i] = new Point(newX, newY);
	    }
	}

	@Override
	public void zoom(double dr) {
		double centerX = (point[0].getX() + point[2].getX()) / 2;
	    double centerY = (point[0].getY() + point[2].getY()) / 2;
	    
	    w *= dr;
	    h *= dr;

	    point[0] = new Point(centerX - w / 2, centerY - h / 2);
	    point[1] = new Point(centerX + w / 2, centerY - h / 2);
	    point[2] = new Point(centerX + w / 2, centerY + h / 2);
	    point[3] = new Point(centerX - w / 2, centerY + h / 2);
	}

	@Override
	public String toString() {
		return "Rectangle [point=" + Arrays.toString(point) + ", w=" + w + ", h=" + h + "]";
	}
}
