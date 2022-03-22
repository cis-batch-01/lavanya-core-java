package programmingFundamentals.discount;

import java.util.Scanner;

public class PatternPrinting {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the char");
		char value = scan.nextLine().charAt(0);
		System.out.println("enter the no. of times to print");
		int noOfTime = Integer.parseInt(scan.nextLine());

		for (int i = 0; i <= noOfTime; i++) {

			for (int j = 1; j <= i; j++) {
				// System.out.print(value + " ");
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}
}
