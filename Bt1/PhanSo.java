package Bt1;

import java.util.*;
import java.lang.Math;

public class PhanSo{
    private int numerator;   
    private int denominator; 

    public PhanSo() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public PhanSo(int numerator, int denominator) {
        if (denominator == 0) {
//            throw new IllegalArgumentException("Mẫu số không thể là 0");
            System.out.println("Mau so khong the la 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Getters
    public int getNumerator() {
    	return numerator;
    }
    
    public int getDenominator() {
    	return denominator;
    }

    // Setters
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("Mau so khong the la 0");
            System.exit(0);
        }
        this.denominator = denominator;
        simplify();
    }

    // Rút gọn phân số
    private void simplify() {
        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= g;
        denominator /= g;
        
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Tìm ước số chung lớn nhất (GCD)
    private int gcd(int a, int b) {
    	int tmp;
        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    // Cộng hai phân số
    public PhanSo cong(PhanSo other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new PhanSo(num, den);
    }

    // Trừ hai phân số
    public PhanSo tru(PhanSo other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new PhanSo(num, den);
    }

    // Nhân hai phân số
    public PhanSo nhan(PhanSo other) {
        return new PhanSo(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    // Chia hai phân số
    public PhanSo chia(PhanSo other) {
        if (other.numerator == 0) {
//            throw new ArithmeticException("Không thể chia cho 0");
            System.out.println("Khong the chia cho 0");
            System.exit(0);
        }
        return new PhanSo(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    // So sánh hai phân số
    public int soSanh(PhanSo other) {
        return Integer.compare(this.numerator * other.denominator, other.numerator * this.denominator);
    }

    // Kiểm tra phân số có phải số nguyên không
    public boolean isInt() {
        return numerator % denominator == 0;
    }

    // Chuỗi biểu diễn của phân số
    @Override
    public String toString() {
        return denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator;
    }
    
    public double toDouble() {
        return (double) numerator / denominator;
    }

}