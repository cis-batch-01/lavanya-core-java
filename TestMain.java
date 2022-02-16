import java.util.Scanner;

public class TestMain {
	
 public static void main(String[] args) {
 
	Scanner scan= new Scanner(System.in);
	
	System.out.println("Enter tamil Mark:");
	int tamil = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter english Mark:");
	int english = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter maths Mark:");
	int maths = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter science Mark:");
	int science = Integer.parseInt(scan.nextLine());
	
	System.out.println("Enter social Mark:");
	int social = Integer.parseInt(scan.nextLine());
	
	Student student1 = new Student(tamil, english, maths, science, social);
	
	int total = student1.calTotal(tamil, english, maths, science, social);
	System.out.println("Total mark obtained: " + total);
}
}
 

