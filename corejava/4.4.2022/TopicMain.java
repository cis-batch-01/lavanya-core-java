package corejava.workout.ropomodel;

import java.util.Scanner;

public class TopicMain {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		char option ='n';
		do {
			System.out.println(
					"1.get all topics \n2.get a particular topic \n3.add a topic\n4.remove a topic \n5.update a topic");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue (y/n)");
			option = scan.nextLine().charAt(0);
		} while (option == 'y');

	}
}
