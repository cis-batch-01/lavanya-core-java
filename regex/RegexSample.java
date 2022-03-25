package com.technocis.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSample {

	public static void main(String[] args) {
//		//Manual method
//		String name="lavanya";  	//lavanya
//		Pattern pattern=Pattern.compile("[A-Z]{1}[a-z]{2,}");
//		Matcher matcher=pattern.matcher(name);
//		System.out.println(matcher.matches());

		// user input method

//		Scanner scan = new Scanner(System.in);
//		String firstName = null;
//		do {
//			System.out.println("Enter your first name: ");
//			firstName = scan.nextLine();
//			System.out.println(Validator.firstNameValidate(firstName) ? "Valid" : "Invalid");
//		} while (!Validator.firstNameValidate(firstName));
//		String lastName = null;
//		do {
//			System.out.println("Enter your last name: ");
//			lastName = scan.nextLine();
//			System.out.println(Validator.lastNameValidate(lastName) ? "Valid" : "Invalid");
//		} while (!Validator.lastNameValidate(lastName));
//		String email = null;
//		do {
//			System.out.println("Enter your email: ");
//			email = scan.nextLine();
//			System.out.println(Validator.emailValidate(email) ? "Valid" : "Invalid");
//		} while (!Validator.emailValidate(email));
//		String password=null;
//		do {
//		System.out.println("Enter your password: ");
//		password = scan.nextLine();
//		System.out.println(Validator.passwordValidate(password) ? "Valid" : "Invalid");
//		}while (!Validator.passwordValidate(password));
//		String phone=null;
//		do {
//		System.out.println("Enter your phone number: ");
//		phone=scan.nextLine();
//		System.out.println(Validator.phoneNoValidate(phone)?"Valid":"Invalid");
//		}while(!Validator.phoneNoValidate(phone));

		Librarian librarian = null;
		LibrarianValidator.librarianValidation(librarian);

	}
}
