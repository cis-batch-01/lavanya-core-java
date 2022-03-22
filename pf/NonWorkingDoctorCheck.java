package programmingFundamentals.discount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NonWorkingDoctorCheck {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Enter the no. of doctors");
			int noOfDoctors = Integer.parseInt(br.readLine());
			int total[] = new int[noOfDoctors];

			System.out.println("Enter the id of doctors");
			for (int index = 0; index < noOfDoctors; index++) {
				total[index] = Integer.parseInt(br.readLine());
			}
			System.out.println("Total number of doctor's id list: "+Arrays.toString(total));

			System.out.println("Enter the no of working doctors");
			int noOfWorkingDoctors = Integer.parseInt(br.readLine());
			int workingDoctorsArray[] = new int[noOfWorkingDoctors];
			System.out.println("enter the working doctor's id");
			for (int index = 0; index < noOfWorkingDoctors; index++) {
				// int[] workingDoctors=;
				workingDoctorsArray[index] = Integer.parseInt(br.readLine());
			}
			System.out.println("Working Doctors id list: "+Arrays.toString(workingDoctorsArray));

			int nonWorkingDoctorArray[] = new int[noOfDoctors];

			int flag = 0;
			for (int outer = 0; outer < total.length; outer++) {

				for (int inner = 0; inner < workingDoctorsArray.length; inner++) {
					if (total[outer] == workingDoctorsArray[inner]) {
						flag = 0;
						break;
					} else {
						flag = 1;
					}
				}
				if (flag == 1) {
					nonWorkingDoctorArray[outer] = total[outer];
				}
			}
			System.out.println("Non working Doctors id list: "+Arrays.toString(nonWorkingDoctorArray));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
