package com.technocis.corejava;

import java.util.Scanner;

public class MovieMain {
public static void main(String[] args) {
	
	Scanner scan= new Scanner(System.in);
	System.out.println(("Enter movie 1 detail"));
	String movie1 = scan.nextLine();
	System.out.println(("Enter movie 2 detail"));
	String movie2 = scan.nextLine();
	
	String[] movies1= movie1.split(",");
	String mName=movies1[0];
	double boxoffice=Double.parseDouble(movies1[1]);
	double budget=Double.parseDouble(movies1[2]);
	double rating=Double.parseDouble(movies1[3]);
	Movie mov1=new Movie(mName, boxoffice, budget, rating);
	System.out.println("movie 1:");
	System.out.println(movie1);
	
	String[] movies2= movie1.split(",");
	 mName=movies2[0];;
	 boxoffice=Double.parseDouble(movies2[1]);
	 budget=Double.parseDouble(movies2[2]);
	 rating=Double.parseDouble(movies2[3]);
	 Movie mov2=new Movie(mName, boxoffice, budget, rating);
	System.out.println("movie 2:");
	System.out.println(movie2);
	
	System.out.println(mov1.equals(mov2)?"movie 1 and movie 2 are same":"movie 1 and movie 2 are different");
}
}
