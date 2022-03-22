package programmingFundamentals.discount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NonWorkingDoctor {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the no. of Doctors");
//		int noOfDoctors = Integer.parseInt(scan.nextLine());
//	 
//		int total[]=new int[noOfDoctors];
//		System.out.println("Enter the id of doctors");
//		for(int id=0;id<noOfDoctors;id++)
//		{
//			total[id]=Integer.parseInt(scan.nextLine());
//		}
//		System.out.println(Arrays.toString(total));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the no. of doctors");
			int noOfDoctors = Integer.parseInt(br.readLine());
			List<Integer> doctorList = new ArrayList<Integer>();

			System.out.println("Enter the doctor id's one by one");

			for (int index = 0; index < noOfDoctors; index++) {
				// int num=Integer.parseInt(br.readLine());
				// doctorList.add(num);
				doctorList.add(Integer.parseInt(br.readLine()));
			}
			System.out.println("doctor id list" + doctorList);
			
			System.out.println("Enter the no. of working doctors");
			int workingDoctor=Integer.parseInt(br.readLine());
	///////////		List<Integer>
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
