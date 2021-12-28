package ru.samsung.itschool;

import java.util.Scanner;

public class Fraction {
	private int numerator;
	private int denomenator=1;

	public void add(Fraction fraction) {
		numerator = numerator * fraction.denomenator + fraction.numerator * denomenator;
		denomenator = denomenator * fraction.denomenator;
		reduce();
	}

	public void add(int n) {
		add(new Fraction(n, 1));
	}

	public void substract(Fraction fraction) {
		numerator = numerator * fraction.denomenator - fraction.numerator * denomenator;
		denomenator = denomenator * fraction.denomenator;
		reduce();
	}

	public void substract(int n) {
		substract(new Fraction(n, 1));
	}

	public void multiply(Fraction fraction) {
		numerator = numerator * fraction.numerator;
		denomenator = denomenator * fraction.denomenator;
		reduce();
	}

	public void multiply(int n) {
		multiply(new Fraction(n, 1));
	}

	public void divide(Fraction fraction) {
		if (fraction.numerator == 0) {
			System.out.println("На эту дробь делить нельзя!");
			return;
		}
		multiply(new Fraction(fraction.denomenator, fraction.numerator));
	}

	public void divide(int n) {
		divide(new Fraction(n, 1));
	}

	public void nextFraction() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		if (d == 0) {
			System.out.println("Знаменатель не может быть нулевым!Повторите ввод:");
			return;
		}
		numerator=n;
		denomenator=d;
		reduce();
	}
	
	Fraction(){
	}
	
	Fraction(int numerator, int denomenator) {
		if (denomenator == 0) {
			System.out.println("Знаменатель не может быть нулевым!");
			return;
		}
		this.numerator = numerator;
		this.denomenator = denomenator;
		reduce();
	}

	public String toString(){
		return (numerator*denomenator<0?"-":" ")+Math.abs(numerator)+"/"+Math.abs(denomenator);
	}
	
	public void print() {
		if(numerator % denomenator == 0){
			System.out.println(numerator/denomenator);
			return;
		}
		if (numerator / denomenator == 0) {
			System.out.println("    " + Math.abs(numerator));
			System.out.println((numerator*denomenator<0?"-":" ")+" ---- или "+1.0 * numerator / denomenator);
			System.out.println("    " + Math.abs(denomenator));
		} else {
			System.out.println("    " + Math.abs(numerator % denomenator));
			System.out.println((numerator*denomenator<0?"-":" ")+numerator / denomenator + "---- или "+1.0 * numerator / denomenator);
			System.out.println("    " + Math.abs(denomenator));
		}
	}

	private int getGCD(int a, int b) { return b==0 ? a : getGCD(b, a%b); }

	private void reduce(){
		int t=getGCD(numerator,denomenator);
		numerator/=t;
		denomenator/=t;
	}
	

}