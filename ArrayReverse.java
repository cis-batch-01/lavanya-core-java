import java.util.Scanner;

public class ArrayReverse {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of Array Elements");
		int noOfArray = Integer.parseInt(scan.nextLine());
		
		int intArray[] = new int[noOfArray];
		System.out.println("Enter array values:");
		for(int i=0; i<intArray.length; i++)
		{
			intArray[i] = Integer.parseInt(scan.nextLine());
		}
		
		for(int i=intArray.length-1; i>=0;i--)   // l=intArray.length-1 because reverse operation
		{
		 System.out.print(intArray[i]);
		}
	}
}
