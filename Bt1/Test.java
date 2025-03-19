package Bt1;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
        ArrayList<PhanSo> fractions = new ArrayList<>();
        fractions.add(new PhanSo(1, 2));
        fractions.add(new PhanSo(3, 4));
        fractions.add(new PhanSo(5, 2));
        fractions.add(new PhanSo(7, 3));
        fractions.add(new PhanSo(4, 1));
        fractions.add(new PhanSo(100, 1));

        // Tìm phân số lớn nhất
        PhanSo maxFraction = fractions.get(0);
        for(PhanSo frac : fractions) {
        	if(maxFraction.soSanh(frac) < 0) {
        		maxFraction = frac;
        	}
        }
        System.out.println("Phân số lớn nhất: " + maxFraction);

        // Tính tổng tất cả các phân số
        PhanSo sum = new PhanSo(0, 1);
        for (PhanSo frac : fractions) {
            sum = sum.cong(frac);
        }
        System.out.println("Tổng các phân số: " + sum);

        // Đếm số phân số không phải số nguyên
        int cnt = 0;
        for(PhanSo frac : fractions) {
        	if(!frac.isInt()) {
        		cnt++;
        	}
        }
        System.out.println("Số phân số không phải số nguyên : " + cnt);

    }
}
