package OldTests;

import java.util.Arrays;

public class BenGurionTest1 {

	public static void main(String[] args) {
		int[] n= {4,5,9};
		System.out.println(count(n));
		
	}

	public static int count(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		if (sum % 2 != 0) {
			return 0;
		}
		return count(numbers, 0, 0);
	}

	private static int count(int[] numbers, int index, int sum) {
		int counter = 0;
		if (index == numbers.length) {
			if (sum == 0) {counter = 1;} 
			else {counter = 0;}
		} 
		else {
			counter = count(numbers, index + 1, sum - numbers[index]) + 
					count(numbers, index + 1, sum + numbers[index]);
		}
		return counter;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
