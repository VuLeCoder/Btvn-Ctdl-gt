package Bt4;

import java.util.ArrayList;

public class Test {
	public static void main(String []args) {
		ArrayList<SoPhuc> arr = new ArrayList<>();
		arr.add(new SoPhuc());
		arr.add(new SoPhuc(1, 0));
		arr.add(new SoPhuc(3, 4));
		arr.add(new SoPhuc(9, 8));
		arr.add(new SoPhuc(10, 10));
		arr.add(new SoPhuc(0, 10));
		
// --------------------------------------------------------------------
		for(int i=0; i<arr.size(); ++i) {
			System.out.println(arr.get(i));
		}
		System.out.println();
		
// --------------------------------------------------------------------		
		SoPhuc s = new SoPhuc(0, 0);
		for(int i=0; i<arr.size(); ++i) {
			s = SoPhuc.tongSoPhuc(s, arr.get(i));
		}
		s = SoPhuc.chiaSoPhucChoMotSo(s, arr.size());
		System.out.print("Trung binh cong cac so phuc : ");
		System.out.println(s);
		System.out.println();
		
// --------------------------------------------------------------------
		int maxPos = 0;
		for(int i=1; i<arr.size(); ++i) {
			if(arr.get(maxPos).modulus() < arr.get(i).modulus()) {
				maxPos = i;
			}
		}
		System.out.print("So phuc co modulus lon nhat la : ");
		System.out.println(arr.get(maxPos));
		System.out.println();

// --------------------------------------------------------------------
		int cnt = 0;
		for(int i=1; i<arr.size(); ++i) {
			if(arr.get(maxPos).getImaginary() == 0) {
				cnt++;
			}
		}
		System.out.print("So so phuc khong co phan ao la : ");
		System.out.println(cnt);
	}
}
