package Bt2;

public class Point_3D extends Point_2D{
	private double z = 0;
	
	public Point_3D(double x, double y, double z) {
		super(x, y);
		super.check = 3;
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
	
	@Override
	public double distanceTo(Point_2D point) {
		
		if(point instanceof Point_3D) {
			Point_3D p = (Point_3D)point;
			
			return Math.sqrt((this.getX() - p.getX()) * (this.getX() - p.getX()) + 
					(this.getY() - p.getY()) * (this.getY() - p.getY()) + 
					(this.z - p.getZ()) * (this.z - p.getZ()));
		}
		return 0;
		
//		if(point instanceof Point_3D) {
//			Point_3D p = (Point_3D)point;
//			return Math.sqrt((this.getX() - p.getX()) * (this.getX() - p.getX()) + 
//					(this.getY() - p.getY()) * (this.getY() - p.getY()) + 
//					(this.z - p.getZ()) * (this.z - p.getZ()));
//		}
//		
//		return 0;
//		return super.distanceTo(point);
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
