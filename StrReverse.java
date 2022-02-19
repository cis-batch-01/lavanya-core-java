import java.util.Scanner;

public class StrReverse {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a string"); //get user input
		String str=scan.nextLine();
		 

		  String rev="";
	      int length = str.length();           
	      for ( int i = length - 1; i >= 0; i-- )  
	      {
	         rev = rev + str.charAt(i);
	      }
	      
	      System.out.println(rev);
	      
	      if (str.equals(rev))  {
	         System.out.println("Given String is a palindrome.");  
	      
	      }else  
	      {
	    	  System.out.println("Given String is not a palindrome.");
	      }  
		}
}

	