package com.technocis.corejava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CastMain {
	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of cast:");
		int noOfCast = Integer.parseInt(scan.nextLine());
		List<Cast> castList = new ArrayList<Cast>();
		for (int i = 0; i < noOfCast; i++) {
			System.out.println("enter details");
			String detail = scan.nextLine();
			Cast cast = Cast.createCast(detail);
			castList.add(cast);
		}
		System.out.println(castList);

		System.out.println("enter a search type \n1.Nationality \n2.DOB");
		int choice = Integer.parseInt(scan.nextLine());

		switch (choice) {
		case 1:
			System.out.println("Enter the nationality");
			String nationality = scan.nextLine();
			CastBO castBO = new CastBO();
			List<Cast> resList = castBO.FindCast(castList, nationality);
			System.out.println(resList);
			break;
		case 2:
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("Enter the DOB");
			Date DOB = sdf.parse(scan.nextLine());
			CastBO castBO1 = new CastBO();
			List<Cast> resList1 =castBO1.FindCast(castList, DOB);
			System.out.println(resList1);
			break;
		default:
			System.out.println("Invalid input");

		}

	}
}
