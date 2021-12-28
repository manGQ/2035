package ru.samsung.itschool;

public class Test {

	public static void main(String[] args) {
		Fraction A = new Fraction();
		Fraction B = new Fraction();
		A.nextFraction();
		B.nextFraction();
		A.add(3);
		B.substract(new Fraction(1,3));
		A.divide(B);
		A.print();
	}

}