import java.util.Scanner;

public class Factorial {
public static void main(String[] args) {
	
	 Scanner scan=new Scanner(System.in);
	 System.out.println("Enter the number = ");
	 int num=scan.nextInt();
	 int fact=1;				// multiply process so we are initializing as 1
	 							//5!  5x4x3x2x1 till 1 we are going to iterate
	 for(int i=1;i<=num;i++)   //i=1 when i=0 (5x4x3x2x1x0)then whole ans will become 0
	 {
		 fact=fact*i;
		 
	 }
	 System.out.println("Factorial of the given number is:"+fact );
			
}
}
