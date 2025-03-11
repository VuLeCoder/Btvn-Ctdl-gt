package Bt2;

public class Point_3D extends Point_2D{
	private double z = 0;
	
	public Point_3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "Point_3D [x=" + this.getX() + ", y=" + this.getY() + ", z=" + z + "]";
	}

	public double distanceTo(Point_3D point) {
		return Math.sqrt((this.getX() - point.getX()) * (this.getX() - point.getX()) + 
				(this.getY() - point.getY()) * (this.getY() - point.getY()) + 
				(this.z - point.getZ()) * (this.z - point.getZ()));
	}
	
	@Override
	public Point_3D symmetricAboutOrigin() {
		return new Point_3D(- this.getX(), - this.getY(), - this.z);
	}
	
	public void move(double dx, double dy, double dz) {
		super.move(dx, dy);
		this.z += dz;
	}
}
