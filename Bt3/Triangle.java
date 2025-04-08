package Bt3;

public class Triangle implements Shape, Center {
//    private double x1, y1, x2, y2, x3, y3;
    private Point[] point;

    public Triangle(Point A, Point B, Point C) {
    	point = new Point[3];
    	point[0] = A;
    	point[1] = B;
    	point[2] = C;
    }

    private double sideLength(Point A, Point B) {
        return Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2));
    }

    @Override
    public double area() {
        double a = sideLength(point[0], point[1]);
        double b = sideLength(point[1], point[2]);
        double c = sideLength(point[0], point[2]);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return sideLength(point[0], point[1]) + sideLength(point[1], point[2]) + sideLength(point[0], point[2]);
    }

    @Override
    public double distanceTo(Shape other) {
        return 0;
    }

    @Override
    public void move(double dx, double dy) {
        for(int i=0; i<3; ++i) {
        	point[i].move(dx, dy);
        }
    }

    @Override
    public void rotate(double angle) {
        double rad = Math.toRadians(angle);
        
        Point p = (Point)getCenter();
        double midX = p.getX(), midY = p.getY();
        
        double newX1 = midX + (point[0].getX() - midX) * Math.cos(rad) - (point[0].getY() - midY) * Math.sin(rad);
        double newY1 = midY + (point[0].getX() - midX) * Math.sin(rad) + (point[0].getY() - midY) * Math.cos(rad);
        point[0].setX(newX1);
        point[0].setY(newY1);
        
        double newX2 = midX + (point[1].getX() - midX) * Math.cos(rad) - (point[1].getY() - midY) * Math.sin(rad);
        double newY2 = midY + (point[1].getX() - midX) * Math.sin(rad) + (point[1].getX() - midY) * Math.cos(rad);
        point[1].setX(newX2);
        point[1].setY(newY2);
        
        double newX3 = midX + (point[2].getX() - midX) * Math.cos(rad) - (point[2].getY() - midY) * Math.sin(rad);
        double newY3 = midY + (point[2].getX() - midX) * Math.sin(rad) + (point[2].getY() - midY) * Math.cos(rad);
        point[2].setX(newX3);
        point[2].setY(newY3);
    }

    @Override
    public void zoom(double ratio) {
//        double midX = (point[0]. + x2 + x3) / 3;
//        double midY = (y1 + y2 + y3) / 3;
//        this.point[0].g = midX + (point[0].g - midX) * ratio;
//        this.y1 = midY + (y1 - midY) * ratio;
//        this.x2 = midX + (x2 - midX) * ratio;
//        this.y2 = midY + (y2 - midY) * ratio;
//        this.x3 = midX + (x3 - midX) * ratio;
//        this.y3 = midY + (y3 - midY) * ratio;
    }

    @Override
    public String toString() {
		return null;
//        return "Triangle[(" + point[0].g + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")]";
    }

	@Override
	public Shape getCenter() {
		return null;
//		double midX = (point[0].g + x2 + x3) / 3;
//        double midY = (y1 + y2 + y3) / 3;
//        return new Point(midX, midY);
	}

	@Override
	public Shape getBoundary() {
		return null;
//		double maxX = Math.max(x2, point[0].g); maxX = Math.max(maxX, x3);
//		double maxY = Math.max(y1, y2); maxY = Math.max(maxY, y3);
//		
//		double minX = Math.min(x2, point[0].g); minX = Math.min(minX, x3);
//		double minY = Math.min(y1, y2); minY = Math.min(minY, y3);
		
//		double w = maxX - minY, h = maxY - minY;
//		maxX -= w / 2;
//		maxY -= h / 2;
//		return new Rectangle(maxX, maxY, w, h);
	}
}