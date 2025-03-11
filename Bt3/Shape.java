package Bt3;

public interface Shape {
	double area();
	double perimeter();
	double distanceTo(Shape other);
	
	void move(double dx, double dy);
	void rotate(double da);
	void zoom(double dr);
}