package arraysample;

import java.util.Scanner;

public class SumOfOdd {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the no. of elements");
	int noOfElement = Integer.parseInt(scan.nextLine());
	System.out.println("enter the nos");
	
	
		int[] element = new int[noOfElement];
		
		for(int i=0; i<element.length; i++)
		{
			element[i]=Integer.parseInt(scan.nextLine());
			
		}
		int sum=0;
	for(int i=0;i<element.length; i++)
	{
		//if(i%2 !=0)   		  //"odd index" will be added
		if(element[i]%2 !=0)      // "odd elements" will be added
		{
		sum += element[i];
		
		}
	}
	System.out.print("sum is" +sum);
}
}
