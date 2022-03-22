package programmingFundamentals.discount;

import java.util.Arrays;
import java.util.Scanner;

public class OddorEven {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of elements");
		int noOfElements = Integer.parseInt(scan.nextLine());

		System.out.println("enter the numbers");

		int element[] = new int[noOfElements];
		for (int i = 0; i < element.length; i++) {
			element[i] = Integer.parseInt(scan.nextLine());
		}
		System.out.println(Arrays.toString(element));
		int sumOfOdd = 0;
		int sumOfEven = 0;
		for (int i = 0; i < element.length; i++) {
			if (element[i] % 2 != 0) {
				sumOfOdd = sumOfOdd + element[i];
			} else {
				sumOfEven = sumOfEven + element[i];
			}
		}
		System.out.println("Sum of odd numbers: " + sumOfOdd);
		System.out.println("Sum of even numbers: " + sumOfEven);
	}
}
