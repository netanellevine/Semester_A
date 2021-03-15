package OldTests;

import java.util.Arrays;

public class Test6_20219_SemesterB_FirstChance {

	public static void main(String[] args) {
		String str = "123045607890";
		System.out.println(Arrays.toString(str.split("[^1-9]+")));
		System.out.println(sorDigits(3412672));
		System.out.println(isSymmetricX("abcwercba", 3));
		int[][] a = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				int n = a[i][j];
				System.out.print(n + " ");
			}
			System.out.println();
		}
		switchDiags(a);
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				int n = a[i][j];
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	// question 1
	public static long sorDigits(long num) {
		String str = String.valueOf(num);
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		String newStr = new String(ch);
		long newNum = Long.valueOf(newStr);
		return newNum;
	}

	// question 2
	public static boolean isSymmetricX(String str, int x) {
		int leng = str.length() - 1;
		if (x == 0) {
			return true;
		}
		if (x >= str.length()) {
			return false;
		}
		if (str.charAt(0) == str.charAt(leng)) {
			return (isSymmetricX(str.substring(1, leng), x - 1));
		}
		return false;
	}

	public static void switchDiags(int[][] arr) {
		int l = arr.length - 1;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp = arr[i][l - i];
			arr[i][l - i] = arr[i][i];
			arr[i][i] = temp;
		}
	}

	
	
}
