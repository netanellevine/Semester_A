package OldTests;

import java.util.Arrays;

public class Test2_2020_SemesterB_FirstChance {

	public static void main(String[] args) {
		// question 1
		System.out.println(decimal2Binary(14));

		// question 2
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 }, { 6, 5, 1, 2, 3 }, { 7, 6, 5, 1, 2 }, { 8, 7, 6, 5, 1 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(sameNumbers(arr));

		// question 3
		int[] b = { 5, 1, 2, 3, 2, 1, 2, 1, 2 };
		int[] a = { 2, 1, 2 };
		System.out.println(isIn2(a, b));
	}

	// question 1
	public static String decimal2Binary(int num) {
		String bin = "";
		while (num != 0) {
			bin = num % 2 + bin;
			num = num / 2;
		}
		return bin;
	}

	// question 2
	/*
	 * if the alachson of the matrix has the samne numbers true
	 */
	public static boolean sameNumbers(int[][] mat) {
		for (int i = 1; i < mat.length - 1; i++) {
			for (int j = 1; j < mat[0].length - 1; j++) {
				if (i == j && mat[i][j] != mat[i - 1][j - 1]) {
					return false;
				}
				if (mat[i - 1][j] != mat[i][j + 1]) {
					return false;
				}
				if (mat[i][j - 1] != mat[i + 1][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// question 3
	/*
	 * how many times one array can be found in the other
	 */
	public static int isIn(int[] a, int[] b) {
		int count = 0;	
		for(int i = 0;i<b.length-a.length+1; i++) {
			if(b[i]==a[0]) {
				for (int j = 0; j < a.length; j++) {
					if(a[j]!=b[i+j]) {
						break;
					}
					if(j==a.length-1) {
						count++;
					}
				}
			}
		}
	return count;
	}

	// question 3
	public static int isIn2(int[] a, int[] b) {
		String small = Arrays.toString(a);
		small = small.replace("[", "");
		small = small.replace("]", "");
		String big = Arrays.toString(b);
		System.out.println(small);
		System.out.println(big);
		return countArrInArr(small, big);

	}

	public static int countArrInArr(String small, String big) {
		int count = 0;
		for (int i = 0; i < big.length() - small.length(); i++) {
			if (big.substring(i, i + small.length()).equals(small)) {
				count++;
			}
		}
		return count;

	}

}
