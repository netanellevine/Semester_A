package OldTests;

import java.util.Arrays;

public class Test1_2020_SemesterB_SecondChance {

	public static void main(String[] args) {
		System.out.println(Binary2Dec("10101011100"));
		int[] a = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,35,37,39,41,43,45,47,49,51};
		int[] b = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,78,79,80};
		int[] c = InterLace(a, b);
		System.out.println(Arrays.toString(c));
	}

	// question 1.
	public static int Binary2Dec(String str) {
		int dec = 0;
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '1' || ch == '0') {
				dec += (Integer.parseInt(String.valueOf(ch)) * Math.pow(2, str.length() - 1 - i));
			} else {
				return -1;
			}
		}
		return dec;
	}

	// question 3 
	/*
	 * input: two int arrays. output:  one arrray of the both 
	 */
	public static int[] InterLace(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int n = (Math.min(a.length, b.length));
		int j = 0, k = 0;
		for (int i = 0; i < n * 2; i++) {
			if (i % 2 == 0) {
				c[i] = a[j++];
			} 
			else {
				c[i] = b[k++];
			}
		}
		j = b.length;
		k = a.length;
		if (a.length > b.length) {
			for (int i = n * 2; i < c.length; i++) {
				c[i] = a[j++];
			}
		} 
		else {
			for (int i = n * 2; i < c.length; i++) {
				c[i] = b[k++];
			}
		}
		return c;
	}

	 //question 3.
	public static int[] InterLace2(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length) {
			c[k++]=a[i++];
			c[k++]=b[j++];
		}
		while(i<a.length) {
			c[k++]=a[i++];
		}
		while(j<b.length) {
			c[k++]=b[j++];
		}
		return c;
	}
	
	
	
	
}
