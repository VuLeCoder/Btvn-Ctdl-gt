package Bt4;

public class SoPhuc {
	private double a, b; // a thật, b ảo
	
	public SoPhuc() {
		a = 1;
		b = -1;
	}
	
	public SoPhuc(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public double getReal() {
		return a;
	}
	
	public double getImaginary() {
		return b;
	}
	
	@Override
	public String toString() {
		String ans = "";
		if(a > 0) {
			ans += String.format("%.2f", a);
		}
		
		if(b > 0) {
			if(a > 0) {
				ans += " + ";
			}
			ans += String.format("%.2fi", b);
		} else if (b < 0) {
			ans += String.format(" - %.2fi", Math.abs(b));
		}
		return ans;
	}

	public static SoPhuc tongSoPhuc(SoPhuc s1, SoPhuc s2) {
		return new SoPhuc(s1.getReal() + s2.getReal(), s1.getImaginary() + s2.getImaginary());
	}
	
	public static SoPhuc chiaSoPhucChoMotSo(SoPhuc s, double n) {
		return new SoPhuc(s.getReal() / n, s.getImaginary() / n);
	}
	
	public double modulus() {
		return Math.sqrt(a * a + b * b);
	}
}
