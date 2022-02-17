import java.util.Scanner;

public class GreatMain {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
   
	System.out.println("Enter number1");
	int n1 = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter number2");
	int n2 = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter number3");
	int n3 = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter number4");
	int n4 = Integer.parseInt(scan.nextLine());
	
	if((n1>n2)&&(n1>n3)&&(n1>n4)) {
		System.out.println("n1 is greater");
			
	}
	else if((n2>n1)&&(n2>n3)&&(n2>n4))
	{
		System.out.println("n2 is greater");
	}
	else if((n3>n1)&&(n3>n2)&&(n3>n4)) {
		System.out.println("n3 is greater");
	}
	else if((n4>n1)&&(n4>n2)&&(n4>n3)) {
		System.out.println("n4 is greater");
	}
	else {
		System.out.println();
	}
	}

	
	}


