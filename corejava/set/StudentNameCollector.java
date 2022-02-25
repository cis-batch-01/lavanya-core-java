package com.technocis.corejava.set;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StudentNameCollector {
	public static void main(String[] args) {
		Set<String> newSet = new TreeSet<String>();
		Scanner scan = new Scanner(System.in);
		char choice = 'n';
		do {

			System.out.println("Enter the student name: ");
			String studentName = scan.nextLine();
			newSet.add(studentName);          // to store no. of student name  // if skipped, only the last data will be stored
			System.out.println("Do you want to continue (y/n)");
			choice = scan.nextLine().charAt(0);
		} while (choice == 'y');

		System.out.println(newSet);
		
	}
}
