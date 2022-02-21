package arraysample;

import java.util.Scanner;

public class ArrayDemoMain {
public static void main(String[] args) {
	
	Scanner scan= new Scanner(System.in);
	System.out.println("Enter no of element");
	int num=Integer.parseInt(scan.nextLine());
	
	String[] str=new String[num];
	
	for(int i=0; i<num;i++)
	{
		str[i]=scan.nextLine();
		
	}
	System.out.println("Enter the element to match");
	String name = scan.nextLine();
	int resIndex=0;
	for(int i=0;i<num;i++)
	{
		if(name.equals(str[i]))
		{
		resIndex=i;
		break;
		}
	}
	System.out.println("The matched String is at  " + resIndex);
}
}
