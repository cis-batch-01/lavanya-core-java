import java.util.Scanner;

public class ArrayMain {
	
	
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter no of Array Elements");
	int intArray = Integer.parseInt(scan.nextLine());
	
	int intArray1[] = new int[intArray];
	System.out.println("Enter Array values:");
	for(int i=0; i<intArray1.length; i++)
	{
		
		intArray1[i] = Integer.parseInt(scan.nextLine());
	}

	int total=0;
	for(int i=0; i<intArray1.length; i++)
	{
		total += intArray1[i];
		
	}
	int average = total/intArray1.length;
	System.out.println("average is: " + average);
}
}
