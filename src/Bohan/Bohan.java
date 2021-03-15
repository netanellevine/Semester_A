package Bohan;

/**
 * This class represents a skeleton for the mid-term of Intro2CS course (Ariel
 * U. CS). Please implement the static functions below.
 */

public class Bohan {
	public static String myID = "312512619"; // Netanel Levine

	public static String[] stringArr2Set(String[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					a[i] = "null";
					break;
				}
			}
			if (a[i] == "null") {
				count++;
			}
		}
		String[] arr = new String[(a.length) - count];
		for (int j = 0; j < arr.length; j++) {
			for (int i = j; i < a.length; i++) {
				if (a[i] != "null") {
					arr[i] = a[i];
					break;
				}
			}

		}
		return arr;
	}

	
	public static int maxMonotoneIncArr(double[] a) {
		int max = 1, len = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1])
				len++;
			else {
				if (max < len) {
					max = len;
				}
				len = 1;
			}
		}
		if (max < len) {
			return len;
		} else {
			return max;
		}
	}

	public static int sumOf2() {
		int num1=(int)((Math.random()*6)+1);
		int num2=(int)((Math.random()*6)+1);
		int sum= num1 +num2 ;
		return sum;
	}

	public static double evenSumProb() {
		return -1;
	}

	public static int intersectionSetSize(int[][] a, int[][] b) {
		return -1;
	}
}
