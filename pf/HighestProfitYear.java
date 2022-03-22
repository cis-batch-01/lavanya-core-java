package programmingFundamentals.discount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HighestProfitYear {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("enter the no. of elements in even no. to store year and amount");
			int noOfElements = Integer.parseInt(br.readLine());
			if (noOfElements < 0) {
				System.out.println("please provide positive values");
				System.exit(0);
			} else {
				int noOfElementsArray[] = new int[noOfElements];
				System.out.println("Enter the year and amount one by one");
				for (int index = 0; index < noOfElements; index++) {
					// int values=Integer.parseInt(br.readLine());
					// noOfElementsArray[index]=values;
					noOfElementsArray[index] = Integer.parseInt(br.readLine());
					if (noOfElementsArray[index] < 0) {
						System.out.println("please provide positive values");
						System.exit(0);
					}
				}
				System.out.println(Arrays.toString(noOfElementsArray));

				int max = noOfElementsArray[0];
				int resIndex = -1;
				for (int index = 0; index < noOfElements; index++) {
					if (max < noOfElementsArray[index]) {
						max = noOfElementsArray[index];
						resIndex = index;
					}
				}
				System.out.println("The maximum value is: " + max);
				if (resIndex > 0) {
					System.out.println("Highest profit year is: " + noOfElementsArray[resIndex - 1]);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
