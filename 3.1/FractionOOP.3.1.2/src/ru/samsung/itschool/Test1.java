package ru.samsung.itschool;

public class Test1 {
	public static void main(String[] args) {
		Fraction A[] = new Fraction[5];
		for (int i = 0; i < A.length; i++) {
			A[i] = new Fraction();
			A[i].nextFraction();
		}
		Fraction rez1 = new Fraction(0, 1);
		Fraction rez2 = new Fraction(1, 1);
		for (int i = 0; i < A.length; i++) {
			rez1.add(A[i]);
			rez2.multiply(A[i]);
		}
		System.out.println("Сумма");
		rez1.print();
		System.out.println("Произведение");
		rez2.print();
	}
}