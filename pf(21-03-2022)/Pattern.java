package programmingFundamentals.discount;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter the char");
		char value = scan.nextLine().charAt(0);
		System.out.println("enter the no. of time to print");
		int num = Integer.parseInt(scan.nextLine());

		for (int i = 1; i <num; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		for (int i = num; i >=1; i--) {
			for (int j = 1; j <=i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
