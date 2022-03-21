package programmingFundamentals.discount;

import java.util.Scanner;

public class DiscountMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the product price");
		Double initialPrice = Double.parseDouble(scan.nextLine());

		System.out.println("1.SBI Credit offer 10% \n2.ICICI Credit offer 5%");
		int choice = Integer.parseInt(scan.nextLine());
		switch (choice) {
		case 1:
			// double discount1 = ((10 * 100)/initialPrice)*initialPrice;
			double discount1 = (initialPrice * 10 / 100);
			double totalPrice1 = initialPrice - discount1;
			System.out.println("Your final price is " + String.format("%.4f", totalPrice1) + " You saved "
					+ String.format("%.4f", discount1));
			// System.out.println(discount1);
			break;
		case 2:
			double discount2 = (initialPrice * 5 / 100);
			double totalPrice2 = initialPrice - discount2;
			System.out.println("Your final price is " + String.format("%.4f", totalPrice2) + " You saved " + "%.4f");
			break;
		}
	}

}
