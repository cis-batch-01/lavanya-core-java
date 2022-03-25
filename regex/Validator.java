package com.technocis.regex;

import java.util.regex.Pattern;


public class Validator {

	public static boolean firstNameValidate(String firstName) {
		return Pattern.matches("[A-Z]{1}[a-z]{2,}", firstName);
	}

	public static boolean lastNameValidate(String lastName) {
		return Pattern.matches("[A-Z]{1}[a-z]{2,}", lastName);
	}

	public static boolean phoneNoValidate(String phoneNo) {
		return Pattern.matches("[6789]{1}[0-9]{9}", phoneNo);
	}

	public static boolean emailValidate(String email) {
		return Pattern.matches("[a-z0-9_-]+[@][a-z]+[.][a-z]{2,3}", email);
	}

	public static boolean passwordValidate(String password) {
		return Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\-_!@#$%^&*]).{8,}", password);
	}

	
}