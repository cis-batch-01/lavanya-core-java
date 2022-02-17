import java.util.Scanner;

public class NumMain {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter num1:");
	int num1 = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter num2:");
	int num2 = Integer.parseInt(scan.nextLine());
	
	
		if (num1 > num2) {
			System.out.println("num1 is greater");
		}
		else {
			System.out.println("num2 is greater");
		}
		
	
}
}
