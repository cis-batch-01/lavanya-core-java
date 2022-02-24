import java.util.Scanner;

public class LeepYear {
	public static void main(String[] args) {
		int year;
		System.out.println("Enter an Year :");
		Scanner scan = new Scanner(System.in);
		year = scan.nextInt();

//		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
//			System.out.println("Given is a leap year");
//		else
//			System.out.println("Given year is not a leap year");
		
		
		
		String result;    //ternary condition so result will be true or false 
		result= (year%4==0 && year%100!=0)?"leap year":(year%400==0)?"leap":"not a leap year";
		
		
		System.out.println("Given year is "+result);

	}
}


/* normal years %4==0  		ex: 1997,1998,2021
	century years %4==0 && %400==0   ex.1900,1700,1600
	
	years%100!=0 not leap year
	*/