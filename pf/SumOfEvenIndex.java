package programmingFundamentals.discount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfEvenIndex {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Enter the no. of elements");
			int noOfElements = Integer.parseInt(br.readLine());
			if (noOfElements < 0) {
				System.out.println("Please provide positive value");
			} else {
				int noOfElementsArray[] = new int[noOfElements];
				System.out.println("Enter the numbers");
				for (int index = 0; index < noOfElements; index++) {

					noOfElementsArray[index] = Integer.parseInt(br.readLine());
				}
				System.out.println(Arrays.toString(noOfElementsArray));
				int sum = 0;
				for (int index = 0; index < noOfElementsArray.length; index++) {
					if (index % 2 == 0) {
						sum = sum + noOfElementsArray[index];
					}
				}
				System.out.println("Sum of even index: " + sum);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
