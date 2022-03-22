package programmingFundamentals.discount;

import java.util.Scanner;

public class FinalDiscount {

	public static void calculateSbiDiscount(double initialPrice) {

		double discount = (initialPrice * 10 / 100);
		double totalPrice = initialPrice - discount;
		System.out.println("Your final price is " + String.format("%.2f", totalPrice) + " You saved "
				+ String.format("%.2f", discount));
	}

	public static void calculateIciciDiscount(double initialPrice) {
		double discount = (initialPrice * 5 / 100);
		double totalPrice = initialPrice - discount;
		System.out.println("Your final price is " + String.format("%.2f", totalPrice) + " You saved "
				+ String.format("%.2f", discount));
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the product price");
		Double initialPrice = Double.parseDouble(scan.nextLine());
		double discount = 0;
		double totalPrice = 0;
		System.out.println("1.SBI Credit offer 10% \n2.ICICI Credit offer 5%");
		int choice = Integer.parseInt(scan.nextLine());
		switch (choice) {
		case 1:
			calculateSbiDiscount(initialPrice);
			break;
		case 2:
			calculateIciciDiscount(initialPrice);
			break;
		}
//		System.out.println("Your final price is " + String.format("%.2f", totalPrice) + " You saved "
//				+ String.format("%.2f", discount));
	}

}
