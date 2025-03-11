package Bt2;

import java.util.ArrayList;

public class Main {
	public static void main(String [] args) {
		ArrayList<Point_2D> arr = new ArrayList<>();
		arr.add(new Point_2D(3, 11));
		arr.add(new Point_2D(7, 22));
		arr.add(new Point_3D(2, 3, 1));
		arr.add(new Point_3D(23, 1, 2));

// ------------------------------------------------------------------------------------
		double distance2D = 0, distance3D = 0;
		Point_2D p1, p2;
		for(int i=0; i<arr.size(); ++i) {
			p1 = arr.get(i);
			
			for(int j=i+1; j<arr.size(); ++j) {
				p2 = arr.get(j);
				
				if(p1 instanceof Point_3D && p2 instanceof Point_3D) {
					distance3D += p1.distanceTo(p2);
				} else {
					if(p1 instanceof Point_3D || p2 instanceof Point_3D) {
						continue;
					}
					distance2D += p1.distanceTo(p2);
				}
			}
		}
		System.out.println("Tong khoang cach giua cac diem 2D : " + distance2D);
		System.out.println("Tong khoang cach giua cac diem 3D : " + distance3D);

// ------------------------------------------------------------------------------------
		int n = arr.size();
		for(int i=0; i<n; ++i) {
			arr.add(arr.get(i).symmetricAboutOrigin());
		}
		
		for(int i=0; i<arr.size(); ++i) {
			System.out.println(arr.get(i).toString());
		}
	}
}



