package pert6;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		System.out.print("Input sisi dan sisi 2: ");
		int sisi = sc.nextInt();			
		int sisi2 = sc.nextInt();
		
		Persegi persegi = new Persegi(sisi,sisi);	
		PersegiPanjang persegiPanjang = new PersegiPanjang(sisi, sisi2);

		System.out.println("Luas Persegi: " + persegi.hitLuas(sisi));
		System.out.println("Luas Persegi Panjang: " + persegiPanjang.hitLuas(sisi, sisi2));		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
