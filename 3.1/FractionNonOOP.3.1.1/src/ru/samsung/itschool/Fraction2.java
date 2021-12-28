package ru.samsung.itschool;

import java.util.Scanner;

public class Fraction2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите дроби:");
		int n[] = new int[5];
		int d[] = new int[5];
		for (int i = 0; i < n.length; i++) {
			System.out.println("==============");
			n[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		int rez1n = 0;
		int rez1d = 1;
		int rez2n = 1;
		int rez2d = 1;
		for (int i = 0; i < n.length; i++) {
			rez1n = rez1n * d[i] + rez1d * n[i];
			rez1d = rez1d * d[i];
			rez2n = rez2n * n[i];
			rez2d = rez2d * d[i];
		}
		System.out.println("Результат 1:");
		// печатаем в десятичном виде
		System.out.println(1.0 * rez1n / rez1d);
		if (rez1n / rez1d == 0) {
			// печатаем в обычном виде
			System.out.println(rez1n);
			System.out.println("---");
			System.out.println(rez1d);
		} else {
			// печатаем правильную дробь
			System.out.println("   " + rez1n % rez1d);
			System.out.println(rez1n / rez1d + "-----");
			System.out.println("   " + rez1d);
		}
		System.out.println("Результат 2:");
		// печатаем в десятичном виде
		System.out.println(1.0 * rez2n / rez2d);
		if (rez2n / rez2d == 0) {
			// печатаем в обычном виде
			System.out.println(rez2n);
			System.out.println("---");
			System.out.println(rez2d);
		} else {
			// печатаем правильную дробь
			System.out.println("   " + rez2n % rez2d);
			System.out.println(rez2n / rez2d + "-----");
			System.out.println("   " + rez2d);
		}
	}

}