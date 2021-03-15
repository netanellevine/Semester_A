package HomeWork;

import java.util.Arrays;

public class LongestSortInArray {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 3, 5, 7, 8, 9, 1, 2 };
		int[] arr2 = ArraySorting.randomArray(15, 10);
		System.out.println("arr2 ------> " + Arrays.toString(arr2));
		int maxSum = 1, sum = 1;
		for (int j = 1; j < arr2.length; j++) {
			if (arr2[j] >= arr2[j - 1]) {
				sum++;	}
			else {
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum = 1;
			}
		}
		System.out.println(maxSum);
	}
}
