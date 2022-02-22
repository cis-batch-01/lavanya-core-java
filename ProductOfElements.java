package com.technocis.pf;

import java.util.Scanner;

public class ProductOfElements {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter no of elements");
	int noOfElement = scan.nextInt();
	
	int[] arrElement = new int[noOfElement];
	System.out.println("Enter the elements");
	for(int i=0;i<noOfElement;i++)
	{
		arrElement[i]=scan.nextInt();
		
	}
		int product=1;
		for(int i=0;i<noOfElement;i++)
		{
			product *= arrElement[i];
			
		}
		System.out.println("product is " + product);
}
}
