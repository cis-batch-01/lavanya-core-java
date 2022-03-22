package programmingFundamentals.discount;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfGreatestNo {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of elements");
		int noOfElements = Integer.parseInt(scan.nextLine());
		int element[] = new int[noOfElements];   //to store user given values in memory
		System.out.println("Enter the numbers");

		for (int i = 0; i < noOfElements; i++) {				// user given values one by one store in array
			element[i] = Integer.parseInt(scan.nextLine());
		
		}
		int sum=0;
		System.out.println(Arrays.toString(element));
		Arrays.sort(element);
		for(int i=element.length-1;i>=element.length-3;i--)
		{
			System.out.println(element[i]);
			sum=sum+element[i];
			
		}
		System.out.println("Sum of largest 3 numbers is "+sum);
	
	}
	
}
