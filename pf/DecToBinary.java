package programmingFundamentals.discount;

import java.util.Scanner;

public class DecToBinary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = Integer.parseInt(scan.nextLine());
		if (num <= 0) {
			System.out.println("Please enter positive values");
		} else {
			System.out.println(Integer.toBinaryString(num));
		}
	}
}
