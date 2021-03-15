package OldTests;

import java.util.Arrays;

public class Test3_2020_SemesterA_SecondChance {

	public static void main(String[] args) {
		// question 1
		System.out.println(semi2(30));
		// question 2
		System.out.println(findMaxNum2("12as35g6&&8754hggh875"));

	}

	// question 1
	public static boolean semi(int n) {
		int count = 0;
		int[] num = SieveOfEratosthenes(n / 2 + 1);
		for (int i = 0; i < num.length; i++) {
			int temp = n;
			while (temp % num[i] == 0) {
				count++;
				temp /= num[i];
			}
		}
		return (count == 2);
	}

	/*
	 * This function calculates all the prime number in the range of a N number
	 * using the Sieve Of Eratosthenes algorihtm
	 */
	public static int[] SieveOfEratosthenes(int num) {
		boolean[] arr = new boolean[num];
		int k = 0;
		for (int z = 2; z < arr.length; z++) {
			arr[z] = true;
		}
		for (int i = 2; i < Math.sqrt(arr.length); i++) {
			if (arr[i]) {
				k = 2 * i;
			}
			while (k < arr.length) {
				arr[k] = false;
				k += i;
			}
		}
		int sumOfTrue = 0;
		int[] newArr = new int[arr.length];
		for (int i = 2, j = 0; i < arr.length; i++) {
			if (arr[i]) {
				sumOfTrue++;
				newArr[j] = i;
				j++;
			}
		}
		int[] allPrimeNumbers = new int[sumOfTrue];
		for (int i = 0; i < allPrimeNumbers.length; i++) {
			allPrimeNumbers[i] = newArr[i];
		}
		return allPrimeNumbers;
	}

	// question 1
	public static boolean semi2(int n) {
		for (int i = 2; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (isPrime(i) && isPrime(j) && i * j == n) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// question 2
	public static int findMaxNum(String str) {
		String newStr = "";
		int max = -1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > 47 && str.charAt(i) < 58) {
				newStr += str.charAt(i);
			} else {
				if (newStr != "") {
					int temp = Integer.parseInt(newStr);
					if (max < temp) {
						max = Integer.parseInt(newStr);
						newStr = "";
					}
				}
			}
		}
		return max;
	}

	// question 2
	public static int findMaxNum2(String str) {
		String[] a = str.split("[^0-9]+");
		int max = -1;
		for (int i = 0; i < a.length; i++) {
			int temp = Integer.parseInt(a[i]);
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}
}
