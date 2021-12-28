package ru.samsung.itschool;


import java.util.Scanner;

public class Fraction1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Введите первую дробь");
		int An=sc.nextInt();
		int Ad=sc.nextInt();
		System.out.println("Введите вторую дробь");
		int Bn=sc.nextInt();
		int Bd=sc.nextInt();
		
		// считаем первую скобку (приводим к общему знаменателю и складываем числитель)
		An=An + 3*Ad;
		// считаем вторую скобку (приводим к общему знаменателю и складываем числитель)
		Bn=3*Bn - Bd;
		Bd=3*Bd;
		// считаем деление скобок
		An=An*Bd;
		Ad=Ad*Bn;
		System.out.println("Результат:");
		// печатаем в десятичном виде 
		System.out.println(1.0*An/Ad);
		if(An/Ad == 0){
		// печатаем в обычном виде 
		System.out.println(An);
		System.out.println("---");
		System.out.println(Ad);
		}else{
		// печатаем правильную дробь
			System.out.println("   "+An%Ad);
			System.out.println(An/Ad+"-----");
			System.out.println("   "+Ad);
		}
		
		
	}

}