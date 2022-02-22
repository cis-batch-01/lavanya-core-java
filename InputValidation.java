package com.technocis.pf;

import java.util.Scanner;

public class InputValidation {
	
	public static void main(String[] args) {
		int num;
		do
		{
			
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a number");
		num =scan.nextInt();
		if(num<=0)
		{
		System.out.println("Enter number greater than 0");
		}
		}
		while(num<=0);
		
	}
	
}
